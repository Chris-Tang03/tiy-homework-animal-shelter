package animalshelterironyard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Make new animal class instance

        Animal animalList = new Animal();

        //User input (scanner) for MenuService class
        Scanner scan = new Scanner(System.in);
        MenuService menu = new MenuService(scan);

        //Prompt for Main Menu from MenuService (go to while loop)
        menu.promptForMainMenu();

        //Print out the Animal list option 1
        System.out.println(animalList.getAnimalList());

        // List selections to choose from
        while(true) {
            int action = menu.promptForMainMenu();
            Animal listAnimal = new Animal();

            if(action == 1){
                System.out.println(listAnimal.getAnimalList());
            } else if(action == 2){
                System.out.println();
            } else if(action == 3){

            } else if(action == 4){

            } else if(action == 5){

            } else{
                break;
            }
        }










    }

}
