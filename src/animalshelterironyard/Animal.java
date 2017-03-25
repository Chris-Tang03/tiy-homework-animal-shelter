package animalshelterironyard;


import java.util.ArrayList;

public class Animal {
    ArrayList<String> animalList;
    String name;
    String species;
    String breed;
    String Description;

    //Species variable and make it get selection


    public Animal(){
        animalList = new ArrayList<>();
        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Monkey");

    }

    public ArrayList<String> getAnimalList() {
        return animalList;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getDescription() {
        return Description;
    }

    private class Dog {

    }
}
