import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    //made a constant in all CAPS
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
        // display the prompt to the user
        System.out.println(prompt);

        // check if the next input is an int.
        if (!scanner.hasNextInt()) {

            // show an error message
            System.out.printf("'%s' is not a valid number. Please try again.\n", scanner.next());

            // recursively prompt the user again
            return waitForInt(prompt);
        } else {
            // return the int the user provided
            return scanner.nextInt();
        }
    }

    //boolean statement makes the breed optional
    public String waitForString(String prompt, boolean required){
        System.out.printf(prompt);

        //replaces scanner.next() to prevent each field to enter twice
        String input = scanner.next();

        if(required == true && input.isEmpty()){
            System.out.println("This field must be filled!\n");
            return waitForString(prompt, required);
        } else {
            return input;
        }
    }

    public void listAnimals(ArrayList<Animal> animals){
        for(int i = 0; i < animals.size(); i++){
            Animal animal = animals.get(i);
            System.out.printf("%s) %s \t\t %s\n", (i+1), animal.getName(), animal.getSpecies());
        }
    }

    public void viewAnimalDetails(Animal animal) {
        System.out.printf("Name: %s%n", animal.getName());
        System.out.printf("Species: %s%n", animal.getSpecies());
        System.out.printf("Breed: %s%n", animal.getBreed());
        System.out.printf("Description: %s%n", animal.getDescription());
    }
    public boolean deleteYesNo (String prompt){
        String input = waitForString(prompt, false);
        if(input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")){
            return true;
        } else if(input.toLowerCase().equals("no") || input.toLowerCase().equals("n")){
            return false;
        } else{
            System.out.println("Needs to be yes / (y) or no / (n)");
            return deleteYesNo(prompt);
        }
    }
    public Animal getAnimal(int index, ArrayList<Animal> animals){
        if(animals.size() < index && index >= 0) {
            return animals.get(index);
        } else{
            return getAnimal(waitForInt("Invalid ID. Please pick a different ID."), animals);
        }
    }
    public void editAnimal(Animal animal){
        String input = "";
        input = waitForString(String.format("Name [%s]", animal.getName()),false);
        if(!input.isEmpty()){
            animal.setName(input);
        }

        input = waitForString(String.format("Species [%s]", animal.getSpecies()), false);

        if(!input.isEmpty()){
            animal.setSpecies(input);
        }

        input = waitForString(String.format("Breed [%s]", animal.getBreed()), false);

        if(!input.isEmpty()){
            animal.setBreed(input);
        }

        input = waitForString(String.format("Description [%s]", animal.getDescription()), false);

        if(!input.isEmpty()){
            animal.setDescription(input);
        }
    }
}