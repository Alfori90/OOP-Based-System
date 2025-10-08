import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BagService {
    private static List<Bags> bagsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

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
