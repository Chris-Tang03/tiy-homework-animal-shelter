import java.sql.*;
import java.util.ArrayList;

public class AnimalRepository {
    private Connection conn;

    public AnimalRepository(String jdbcURL) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcURL);
    }


//    public ArrayList<Animal> listAnimal() throws SQLException {
//
//        ArrayList<Animal> animalList = new ArrayList<>();
//
//        Statement stmt = conn.createStatement();
//
//        ResultSet result = stmt.executeQuery("SELECT * FROM animal");
//        while(result.next()) {
//            Animal animal = new Animal(
//            result.getInt("animal_id"),
//            result.getString("name"),
//            result.getString("species"),
//            result.getString("breed"),
//            result.getString("description");
//            );
//            animalList.add(animal);
//        }
//
//        return animalList;
//    }


//    public void createAnimal(Animal animal) throws SQLException {
//        Statement stmt = conn.createStatement("INSERT INTO animal");
//
//
//    }
}
