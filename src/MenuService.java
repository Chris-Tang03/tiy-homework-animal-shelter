
import java.util.Scanner;


public class MenuService {

    public static final int LIST_ANIMALS = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_ANIMAL_DETAILS = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMALS = 5;
    public static final int QUIT = 6;

    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptForMainMenu() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit\n");

        return waitForInt("Please choose an option:");
    }


    public int waitForInt(String prompt) {
        System.out.println(prompt);

        if (!scanner.hasNextInt()) {

            System.out.printf("'%s' is not a valid number. Please try again.\n", scanner.next());

            return waitForInt(prompt);
        } else {
            return scanner.nextInt();
        }
    }


}
