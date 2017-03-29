import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("[\n]");

        MenuService menu = new MenuService(scanner);
    }


}