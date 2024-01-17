package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a list of shopping items:");

        String item = "";
        boolean itemListComplete = false;

        ArrayList<Item> itemList = new ArrayList<>();

        do {
            item = scanner.nextLine();

            if (item.isEmpty()) {
                itemListComplete = true;
                continue;
            }

            String[] itemInfo;
            itemInfo = item.split(",");

            // Get item info and create item object
            try {
                if (itemInfo.length > 3) throw new Exception("Item info too long.");
                String name = "";
                String category = "";
                float price = 0.0f;

                Item itemObj;
                if (itemInfo.length == 1) {
                    price = Float.parseFloat(itemInfo[0]);
                    itemObj = new Item(price);
                } else if (itemInfo.length == 2) {
                    name = itemInfo[0].substring(0, itemInfo[0].length());
                    price = Float.parseFloat(itemInfo[1]);
                    itemObj = new Item(name, price);
                } else {
                    name = itemInfo[0].substring(0, itemInfo[0].length());
                    category = itemInfo[1].substring(0, itemInfo[1].length());
                    category = category.trim();

                    price = Float.parseFloat(itemInfo[2]);
                    itemObj = new Item(name, category, price);
                }
                itemList.add(itemObj);

            } catch (Exception e) {
                System.out.println("Please enter valid item info. Error: " + e.getMessage());
                continue;
            }

        } while (!itemListComplete);


        for (Item itemObj : itemList) {
            //System.out.println(itemObj);
        }

        float totalSum = 0.0f;
        HashMap<String, Float> categories = new HashMap<>();

        for (Item itemObj : itemList) {
            String category = itemObj.getCategory();
            float categorySum = categories.getOrDefault(category, 0.0f);
            categorySum += itemObj.getPrice();
            categories.put(category, categorySum);
            totalSum += itemObj.getPrice();
        }

        for (String k : categories.keySet()) {
            System.out.println( "Total " + k + ": " + categories.get(k));
            for (Item i : itemList) {
                if (i.getCategory().equals(k)) {
                    System.out.println("    " + i);
                }
            }
        }
        System.out.println("Total all categories: " + totalSum);
    }
}
/* Test statement
Bananas, Food, 2
Cornflakes, Food, 7
Shampoo, Cosmetics, 10
Toothbrush, Cosmetics, 5
*/
