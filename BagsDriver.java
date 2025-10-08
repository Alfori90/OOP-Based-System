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
                BagService.addItem();
            } else if (mainMenuOption == 2) {
                BagService.editItem();
            } else if (mainMenuOption == 3) {
                BagService.removeItem();
            } else if (mainMenuOption == 4) {
                BagService.displayItems();
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
}


