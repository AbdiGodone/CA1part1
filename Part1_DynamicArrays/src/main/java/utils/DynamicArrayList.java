package utils;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {

    private final int maxInitialSize = 1000;
    private final int minInitialSize = 5;

    protected int num_elements;
    protected int initialSize;

    private String[] array;


    public DynamicArrayList() {
    }

    /**
     *
     */
    public DynamicArrayList(int initialSize){
        if (initialSize>0 && initialSize <=maxInitialSize){
            this.initialSize = initialSize;
        } else if (initialSize> maxInitialSize) {
            this.initialSize = maxInitialSize;
        } else  {
            this.initialSize = minInitialSize;

        }

        array = new String[initialSize];
    }



    /**
     *
     * @param pos the position being searched in the array
     * @return the index position
     */
    public String get(int pos){
        if (pos < 0 || pos>=array.length ){
            throw new IndexOutOfBoundsException("position given not in the array");
        }

        return array[pos];
    }

    /**
     *
     * @param text the String to be found
     * @return the index in which the string was found
     */
    public int indexOf(String text){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(text)){
              return i;
            }

        }
        //indicating that the string cannot be found in the array
        return -1;
    }

    /**
     * this method gets a String parameter and adds it to my array, returns nothing
     * @param text the text to be added to my array
     */
    public void add(String text){
        if (num_elements == array.length){
                Grow(array);
        }
        array[num_elements] = text;
        num_elements++;
    }

    /**
     * this method returns the size of my array
     * @return the size of my array
     */
    public int size(){
        return num_elements;
    }


    /**
     *this method takes in two parameters a string called st and it overwrites the string in that position provided, the position is validated
     * @param text the new string to be added
     * @param position the position in which it will be added
     */
   public String set(int position, String text){
       if (position<0 || position >= array.length){
           throw new IndexOutOfBoundsException();
       }
       String previousValue= array[position];

       array[position] = text;


       return previousValue;
    }

    /**
     * this method checks if the string passed in the parameter is in the array if it's in the array it does shift delete
     * @param text the text to be removed
     * @return boolean false if unsuccessful and true if successful
     */
    public boolean remove(String text){
        boolean deleted = false;
        if (text == null){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < num_elements; i++) {
            if (text.equals(array[i])){
                for (int j = i; j < num_elements - 1; j++) {
                    array[j] = array[j + 1];
                }
                num_elements--;
                deleted = true;
            }


        }
return deleted;
    }


    /**
     * this method sets my numOfElements back to 0
     */
    public void clear(){

        num_elements = 0;
    }


    /**
     * this method grows my array everytime that it reaches the array length, and it grows by 1000 every time
     * @param text the array which will be passed when called
     */
    public void Grow(String[] text) {
        String[] newArray = new String[array.length + maxInitialSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}
