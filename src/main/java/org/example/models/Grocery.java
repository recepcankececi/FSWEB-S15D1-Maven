package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("0 - Quit");
            System.out.println("1 - Add item(s)");
            System.out.println("2 - Remove item(s)");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter item(s) to add: ");
                    addItems(scanner.nextLine());
                    printSorted();
                    break;
                case 2:
                    System.out.print("Enter item(s) to remove: ");
                    removeItems(scanner.nextLine());
                    printSorted();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Grocery List: " + groceryList);
    }
}
