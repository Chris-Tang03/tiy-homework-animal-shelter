import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Animal> animals;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("[\n]");

        MenuService menu = new MenuService(scanner);


    }

    public ArrayList<Animal> getAnimals() {

        return animals;
    }
}