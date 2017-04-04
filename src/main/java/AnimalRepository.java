import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AnimalRepository {
    private Connection conn;

    public AnimalRepository(String jdbcURL) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcURL);
    }

}
