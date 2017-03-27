import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadAnimals();
        //Reads the whole line and waits for user input
        scanner.useDelimiter("[\n]");

        MenuService menu = new MenuService(scanner);



        while(true){
            int action = menu.promptForMainMenu();

            if(action == menu.LIST_ANIMALS){
                menu.listAnimals(animals);

            } else if(action == menu.CREATE_ANIMAL){
                System.out.println("\n-- Create Animal --\n \nPlease answer the following questions.\n");
                String name = menu.waitForString("\nAnimal name: ", true);
                String species = menu.waitForString("\nSpecies: ", true);
                String breed = menu.waitForString("\nBreed (optional): ", false);
                String description = menu.waitForString("\nDescription: ", true);

                animals.add(new Animal(name, species, breed, description));
                System.out.println("\nSuccess: The animal has been created!");

            } else if(action == menu.VIEW_ANIMAL_DETAILS){
                System.out.println("\n-- View an Animal --\n");

                //Since this is using the array index, it's going from 0-4, hence -1 is used when to get the index wanted
                Animal animal = animals.get(menu.waitForInt("What is the numeric ID of the animal you want to view? ") - 1);
                menu.viewAnimalDetails(animal);

            } else if(action == menu.EDIT_ANIMAL) {
                System.out.println("\n-- Edit Animal --\n");
                int index = menu.waitForInt("What is the numeric ID of the animal you want to delete? ");

                Animal animal = animals.get(index - 1);

                menu.editAnimal(animal);


            } else if(action == menu.DELETE_ANIMALS){
                System.out.println("\n-- Delete an Animal --\n");

                int index = menu.waitForInt("What is the numeric ID of the animal you want to delete? ");

                //get animal
                Animal animal = animals.get(index - 1);

                //display details
                menu.viewAnimalDetails(animal);

                //prompt if you're sure you want to delete an animal
                if(menu.deleteYesNo("\nAre you sure you want to delete this animal? ")){
                    animals.remove(index);
                    System.out.println("\nSuccess: The animal has been deleted!\n");
                }


            } else if(action == menu.QUIT){
                System.out.println("Application stopped.");
                break;
            } else{
                System.out.println("Sorry, invalid input. Please try again.");
            }
        }
    }

    private static void loadAnimals(){
        animals.add(new Animal("Zare", "Dog", "", "black"));
        animals.add(new Animal("Zulu", "Cat", "", "white"));
        animals.add(new Animal("Tony", "Fish", "", "gray"));
        animals.add(new Animal("Mojo", "Monkey", "", "golden"));



    }
}
