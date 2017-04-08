import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalRepositoryTest {

    private Connection conn;
    private String jdbcUrl = "jdbc:h2/mem/animal";
    private AnimalRepository animalRepo;


    @Before
    public void before(String jdbcUrl) throws SQLException{
        conn = DriverManager.getConnection(jdbcUrl);
        Statement stmt = conn.createStatement();

        stmt.execute("CREATE TABLE animals(" +
                "animalId SERIAL PRIMARY KEY NOT NULL" +
                "name VARCHAR(20) NOT NULL" +
                "species VARCHAR (20) NOT NULL" +
                "breed VARCHAR (20) NULL" +
                "description VARCHAR (50) NOT NULL);" +

                "CREATE UNIQUE INDEX animalId_uindex ON animals(animalId)");

        stmt.execute("INSERT INTO animals(" +
                "animalId," +
                "name" +
                "species" +
                "breed" +
                "description)" +

                "VALUES (" + "1" + "Nosey" + "Koala" + "" + "white gray pudgy)");


        stmt.execute("INSERT INTO animals(" +
                "animalId," +
                "name" +
                "species" +
                "breed" +
                "description)" +

                "VALUES (" + "2" + "Shady" + "Monkey" + "Macaque" + "red)");
    }
}
