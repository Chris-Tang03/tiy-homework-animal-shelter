import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("[\n]");

        MenuService menu = new MenuService(scanner);

        while(true){
            int action = menu.promptForMainMenu();

            if(action == menu.LIST_ANIMALS){
                menu.listAnimals(animals);

            } else if(action == menu.CREATE_ANIMAL) {
                animals.add(menu.createAnimal());

            } else if(action == menu.VIEW_ANIMAL_DETAILS){
                menu.viewAnimal(animals);

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



    public ArrayList<Animal> getAnimals() {

        return animals;
    }


}