package animalshelterironyard;

import java.util.Scanner;

public class MenuService {
    private Scanner scanner;

    public MenuService(Scanner scanner){
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


    public int waitForInt(String prompt){
        // display the prompt to the user
        System.out.println(prompt);

        // check if the next input is an int.
        if(!scanner.hasNextInt()){
            // if the next input is not an int, read it as a string to show in an error message
            String badInput = scanner.next();

            // show an error message
            System.out.printf("'%s' is not a valid number. Please try again.\n", badInput);

            // recursively prompt the user again
            return waitForInt(prompt);
        } else {
            // return the int the user provided
            return scanner.nextInt();
        }

    }


//    Create an animal


//    public Animal promptToCreateAnimal(Animal animal) {
//        scanner = new Scanner(System.in);
//        String nameAnimal = scanner.nextLine();
//        System.out.println("\n-- Create an Animal --\n" +
//                "\nWhat would you like to name the animal?\n" + "\nAnimal name: ");
//
//
//
//
//    }


}
