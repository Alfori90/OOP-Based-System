package ItemSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BagsDriver {
    public static List<Bags> bagsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Integer mainMenuOption = 0;


    public static void main(String[] args) {

        while (mainMenuOption != 5) {
            showMainMenu();
            mainMenuOption = scanner.nextInt();
            if (mainMenuOption == 1) {
                addItem();
            } else if (mainMenuOption == 2) {
                editItem();
            } else if (mainMenuOption == 3) {
                removeItem();
            } else if (mainMenuOption == 4) {
                displayItems();
            } else {
                System.out.println("Exit");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("===== Item Management Menu =====");
        System.out.println("""
                1. Add a New Item
                2. Edit an Existing Item
                3. Remove an Item
                4. Display All Items
                5. Exit
                """);
        System.out.println("==============================");
        System.out.println("Please enter your choice:");

    }

    public static void addItem() {
        Bags newBag = new Bags();

        System.out.print("Enter Bag ID: ");
        newBag.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter Bag Price: ");
        newBag.setPrice(scanner.nextFloat());
        scanner.nextLine();
        System.out.print("Enter Bag Size: ");
        newBag.setSize(scanner.nextLine());
        System.out.print("Enter Bag brand: ");
        newBag.setBrand(scanner.nextLine());
//        scanner.nextLine();
        bagsList.add(newBag);
        System.out.println("Bag added successfully");

    }

    public static void editItem() {
        System.out.print("Enter Bag ID to edit:");
        int bagId = scanner.nextInt();
        if (bagId < 0) {
            System.out.println("Invalid input");
        } else if (checkIfBagIdExists(bagId)) {
            for (Bags bag : bagsList) {
                if (bag.getId() == bagId) {
                    System.out.print("Enter new Price: ");
                    Float newPrice = scanner.nextFloat();
                    bag.setPrice(newPrice);
                    scanner.nextLine();

                    System.out.print("Enter new Size: ");
                    String newSize = scanner.nextLine();
                    bag.setSize(newSize);

                    System.out.print("Enter new brand: ");
                    String newBrand = scanner.nextLine();
                    bag.setBrand(newBrand);

                    System.out.println("Bag updated successfully");
                }
            }
        } else {
            System.out.println("Bag not found");
        }
    }

    public static void removeItem() {
        System.out.print("Enter Bag ID to remove:");
        int bagId = scanner.nextInt();
        scanner.nextLine();
        if (checkIfBagIdExists(bagId)) {
            bagsList.removeIf(b -> b.getId().equals(bagId));
            System.out.println("Bag Removed successfully");
        } else {
            System.out.println("Bag not found");
        }
    }

    public static void displayItems() {
        System.out.println("Display All Bags:");
        for (Bags bags : bagsList) {
            System.out.println("Bag ID:" + bags.getId());
            System.out.println("Bag Price:" + bags.getPrice() + "OMR");
            System.out.println("Bag Size:" + bags.getSize());
            System.out.println("Bag Brand:" + bags.getBrand());
            System.out.println("==============================");

        }
    }

    private static boolean checkIfBagIdExists(int bagId) {
        for (Bags bags : bagsList) {
            if (bags.getId() == bagId) {
                return true;
            }
        }
        return false;
    }

}


