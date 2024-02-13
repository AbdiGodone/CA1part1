package app;

import utils.DynamicArrayList;
import java.util.Scanner;
/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {
        DynamicArrayList myShop = new DynamicArrayList(10);
        Scanner sc = new Scanner(System.in);
        int number = 0;

        System.out.println("how many entries you would like to add to your shopping list");
        int entries = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i <entries ; i++) {
            System.out.println("Enter your shopping list");
            String shoppingList = sc.nextLine();
            myShop.add(shoppingList);

        }
        display(myShop);
       while(number!= 7){
           System.out.println("Menu\n" + "1-add entry to your shopping list \n" +
                   "2-delete an entry from your shopping list \n" +
                   "3-Find an index of an entry in your shopping list\n" +
                   "4-Replace an entry from your shopping list \n" +
                   "5-clear entries from your shopping list\n" +
                   "6-display shopping list \n" +
                   "7-exit program");


           number = sc.nextInt();
           sc.nextLine();

          switch (number){
              case 1:
                  System.out.println("add entry to your shopping list ");
                  String add = sc.nextLine();
                  myShop.add(add);
                  break;

              case 2:
                  System.out.println("remove entry from your shopping list");
                  String element = sc.next();

                  myShop.remove(element);
                  break;

              case 3:
                  System.out.println("find the index of the entries");
                  String indexOf = sc.nextLine();
                  int index= myShop.indexOf(indexOf);
                  if (index>=0){
                      System.out.println("the entry's index is " +index);
                  }
                  else {
                      System.out.println("the entry you entered is not found ");
                  }

                  break;

                  case 4:
                      System.out.println("the position in which you want to add ");
                      int position= sc.nextInt();
                      sc.nextLine();
                      System.out.println("enter the entry you want to add");
                      String set= sc.nextLine();
                      myShop.set(position, set);

                  break;

              case 5:
                  myShop.clear();
                  break;

              case 6:
                  display(myShop);

                  break;
              case 7:
                  System.out.println("exited program");


          }
       }

    }
    public static void display(DynamicArrayList text){
        for (int i = 0; i < text.size(); i++) {
            System.out.println("your shopping list is " +text.get(i));
            if (text.size() == 0){
                System.out.println("your shopping list is Empty");
            }
        }

    }



}
