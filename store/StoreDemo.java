
// package store;

import java.util.Scanner;

public class StoreDemo {

  // boolean method takes array items and string name
  public static boolean checkItem(Item[] items, String itemName) {
    for (Item item : items) {
      if (item.getItem().equals(itemName)) {
        return true;
      }
    }
    // returns a boolean
    return false;
  }

  // calculate sum of all items prices
  public static double getAverageItemPrice(Item[] items) {
    double sumTotal = 0;
    for (int i = 0; i < items.length; i++) {
      sumTotal = sumTotal + items[i].getItemPrice();
    }
    // returns a double
    return sumTotal / items.length;
  }

  // return item code searched through item name
  public static int getItemCode(Item[] items, String itemName) {

  }

  public static void main(String[] args) {

  }
}