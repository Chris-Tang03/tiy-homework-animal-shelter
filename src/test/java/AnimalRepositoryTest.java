import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalRepositoryTest {

    private Connection conn;
    private String url = "jdbc:h2/mem/animal";
    private Statement statement = null;
    AnimalRepositoryTest(String jdbcURL) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcURL);
    }


    @Before
    public void before(){

    }
}
