import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) throws SQLException{
//        String jdbcUrl = "jdbc:h2/mem/animal";
//        AnimalRepository repository = new AnimalRepository(jdbcUrl);

        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("[\n]");

        MenuService menu = new MenuService(scanner);

        while (true) {
            int action = menu.promptForMainMenu();


            if (action == menu.LIST_ANIMALS) {
                menu.listAnimals(animals);

            } else if (action == menu.CREATE_ANIMAL) {
                menu.createAnimal(animals);

            } else if (action == menu.VIEW_ANIMAL_DETAILS) {
                menu.viewAnimal(animals);

            } else if (action == menu.EDIT_ANIMAL) {
                menu.editAnimal(animals);

            } else if (action == menu.DELETE_ANIMALS) {
                menu.deleteAnimal(animals);

            } else if (action == menu.QUIT) {
                menu.quit();

            } else {
                System.out.println("Sorry, invalid input. Please try again.");
            }
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}

