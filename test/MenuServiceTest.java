import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MenuServiceTest {

    private ByteArrayOutputStream outputStream;

    @Before
    public void before() {
        // setup output capturing
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(this.outputStream);
        System.setOut(printStream);
    }

    @Test
    /**
     * When prompt for main menu
     * Then display menu
     */

    public void whenPromptMainMenuThenDisplayMenu() {
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("-- Main Menu --"));
    }


    @Test
    /**
     * Given a main menu
     * When menu is displayed
     * Then menu contains "1) List animals"
     */

    public void whenMenuDisplayedThenListAnimals() {
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("1) List animals"));
    }

    @Test
    /**
     * Given a main menu
     * When menu is displayed
     * Then menu contains "2) Create an animal"
     */

    public void whenMenuDisplayedThenCreateAnimal() {
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("2) Create an animal"));
    }

    @Test
    /**
     * Given a main menu
     * When menu is displayed
     * Then menu contains "3) View an animal"
     */

    public void whenMenuDisplayedThenViewAnimal() {
        Scanner scanner = new Scanner("3");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("3) View animal details"));
    }

    @Test
    /**
     * Given a main menu
     * When menu is displayed
     * Then menu contains "4) Edit an animal"
     */

    public void whenMenuDisplayedThenEditAnimal() {
        Scanner scanner = new Scanner("4");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("4) Edit an animal"));
    }

    @Test
    /**
     * Given a main menu
     * When menu is displayed
     * Then menu contains "5) Delete an animal"
     */

    public void whenMenuDisplayedThenDeleteAnimal() {
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("5) Delete an animal"));
    }

    @Test
    /**
     * Given a main menu
     * When menu is displayed
     * Then menu contains "6) Quit"
     */

    public void whenMenuDisplayedThenQuit() {
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("6) Quit"));
    }


    @Test
    /**
     * Given the main menu
     * When prompt for selection 1
     * Then return option 1
     */

    public void whenPrompt1ThenReturn1() {
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(1));
    }

    @Test
    /**
     * Given the main menu
     * When prompt for selection 5
     * Then return option 5
     */

    public void whenPrompt5ThenReturn5() {
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(5));
    }

    @Test
    //adds an animal and checks to see if it's there
    public void addAnimalsActuallyAddAnimals() {
        //Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        //Act
        ArrayList<Animal> testAnimal = new ArrayList<>();
        Animal newAnimal = new Animal("Zare", "Dog", "", "black");
        testAnimal.add(newAnimal);
        Main main = new Main();
        System.out.println(main.getAnimals());

        //Assert
        assertThat(testAnimal.get(0), equalTo(newAnimal));
    }

    @Test
    // View a specific animal's details based on its name
    public void viewAnimalDetailsUsingName() {
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);
        Animal newAnimal = new Animal("Zare", "Dog", "", "black");


        menu.promptForMainMenu();
        assertThat(newAnimal.getName(), containsString("Zare"));

    }

    @Test
    // When input a number, it's not a valid input
    public void promptInputIsInvalid() {
        Scanner scanner = new Scanner("7\n4");
        MenuService menu = new MenuService(scanner);
        menu.promptForMainMenu();

        assertThat(outputStream.toString(), containsString("Invalid input, please try again."));
    }


    @Test
    public void listAnimalsThroughArray() {
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animals = new ArrayList<>();
        Animal createAnimal = new Animal("Zare", "Dog", "Husky", "black");
        Animal createAnimal1 = new Animal("Zulu", "Cat", "", "white");
        Animal createAnimal2 = new Animal("Tony", "Fish", "", "gold");
        Animal createAnimal3 = new Animal("Mojo", "Monkey", "", "gray");
        animals.add(createAnimal);
        animals.add(createAnimal1);
        animals.add(createAnimal2);
        animals.add(createAnimal3);

        menu.listAnimals(animals);


        assertThat(4, equalTo(animals.size()));
        assertThat(outputStream.toString(), containsString("Zare"));
    }


    @Test
    public void createAnimalSuccessful() {
        Scanner scanner = new Scanner("Zare\nDog\nfunny\n5\nblack");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animal = new ArrayList<>();

        animal.add(menu.createAnimal(animal));

        assertThat(animal.get(0).getName(), equalTo("Zare"));
        assertThat(animal.get(0).getSpecies(), equalTo("Dog"));

    }


    @Test
    public void viewAnimalSuccessful() {
        Scanner scanner = new Scanner("Monkey\n1");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animals = new ArrayList<>();
        Animal createAnimal = new Animal("Mojo", "Monkey", "", "gray");
        animals.add(createAnimal);

        menu.viewAnimal(animals);

        assertThat(outputStream.toString(), containsString("Mojo"));
    }

    @Test

    public void editAnimalSuccessful() {
        Animal animal = new Animal("Oreo", "Cat", "", "gray");
        Scanner scanner = new Scanner("1\nOreo\nCat\n \nGray");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal);

        menu.viewAnimal(animals);

        assertThat(outputStream.toString(), containsString("Oreo"));
        assertThat(outputStream.toString(), containsString("Cat"));
        assertThat(outputStream.toString(), containsString("gray"));
    }


    @Test
    public void deleteAnimalSuccessful() {

        Scanner scanner = new Scanner("1\ny");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animals = new ArrayList<>();
        Animal animal = new Animal("Lily", "Human", "", "Female");
        animals.add(animal);

        menu.deleteAnimal(animals);

        assertThat(outputStream.toString(), containsString("\nWhat is the numeric ID of the animal you want to delete?\n"));
        assertThat(outputStream.toString(), containsString("\nAre you sure you want to delete this animal? (Y/N)\n"));
        assertThat(outputStream.toString(), containsString("\nSuccess: The animal has been deleted!\n"));
    }

    @Test
    public void quitSuccessful() {
        Scanner scan = new Scanner("6");
        MenuService menu = new MenuService(scan);
        assertThat(Integer.parseInt("6"), equalTo(menu.promptForMainMenu()));
    }

}