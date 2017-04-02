
import java.util.ArrayList;
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
        // creates a variable called input that holds an integer
        int input = 0;
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            // checks input integer value
            if (input < 1 || input > 6) {
                System.out.println("Invalid input, please try again.");
                return waitForInt(prompt);
            } else {
                return input;
            }
        } else {
            String badInput = scanner.next();
            System.out.println(badInput);
            System.out.println("This is not an integer.");
            return waitForInt(prompt);
        }
    }


    public void listAnimals(ArrayList<Animal> animals){
        for(int i = 0; i < animals.size(); i++){
            Animal animal = animals.get(i);
            System.out.printf("%s) %s \t\t %s\n", (i+1), animal.getName(), animal.getSpecies());
        }
    }

    // Gives the option to make Breed optional
    public String waitForString(String prompt, boolean required){
        System.out.printf(prompt);

        String input = scanner.next();
        System.out.println(input);

        if(required == true && input.isEmpty()){
            System.out.println("This field must be filled!\n");
            return waitForString(prompt, required);
        } else {
            return input;
        }
    }


    public Animal createAnimal(){
        MenuService menu = new MenuService(scanner);
        System.out.println("\n-- Create Animal --\n \nPlease answer the following questions.\n");

        String name = menu.waitForString("\nAnimal name: ", true);
        String species = menu.waitForString("\nSpecies: ", true);
        String breed = menu.waitForString("\nBreed (optional): ", false);
        String description = menu.waitForString("\nDescription: ", true);

        Animal animal = new Animal(name,species,breed,description);

        System.out.println("Success: The animal has been created!");
        return animal;
    }


    public void viewAnimal(ArrayList<Animal> animals){
        System.out.println("\n-- View an Animal --\n");

        System.out.println(animals.get(waitForInt("What is the numeric ID of the animal you want to view? ") - 1));

    }


}
