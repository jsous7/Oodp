package Models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class Db {
    private static String dsn = "jdbc:mysql://localhost:3306/country";
    private static String username = "root";
    private static String password = "123456";
    
    private static Connection dbInstance = null;
    
    public static Connection getInstance() throws Exception{
        if (dbInstance == null){
            try {
                Class.forName("com.mysql.jdbc.Driver"); 
                dbInstance = DriverManager.getConnection(dsn, username, password);
            } catch(Exception e) {
                throw new Exception("Error on connecting to DB: " + e.getMessage());
            }
        }
        
        return dbInstance;
    }
}
