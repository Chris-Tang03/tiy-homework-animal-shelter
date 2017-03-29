import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MenuServiceTest {

    ByteArrayOutputStream outputStream;

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

    public void whenPromptMainMenuThenDisplayMenu(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService (scanner);

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

    public void whenMenuDisplayedThenListAnimals (){
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

    public void whenMenuDisplayedThenCreateAnimal (){
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

    public void whenMenuDisplayedThenViewAnimal (){
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

    public void whenMenuDisplayedThenEditAnimal (){
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

    public void whenMenuDisplayedThenDeleteAnimal (){
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

    public void whenMenuDisplayedThenQuit (){
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

    public void whenPrompt1ThenReturn1(){
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

    public void whenPrompt5ThenReturn5(){
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(5));
    }


}
