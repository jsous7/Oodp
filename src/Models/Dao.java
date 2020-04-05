package Models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
class Dao {
    
    private Connection db;

    Dao() throws Exception {
        try {
            this.db = Db.getInstance();
        } catch (Exception e) {
            throw new Exception("error on getting Db singleton instance: " + e.getMessage());
        }
    }
    
    public void insert(String table, String[] dataKeys, String[] dataValues) throws SQLException{
        String keys = "";
        String values = "";
        
        for (String element : dataKeys){
            keys = keys + element + ",";
        }
        keys = keys.substring(0, keys.length()-1);
        for (String element : dataValues){
            values = values + "\'" + element + "\'" + ",";
        }
        values = values.substring(0, values.length()-1);
        
        String query = "insert into " + table + "(" + keys + ")" + " values(" + values + ")";
        Statement stmt = db.createStatement();
        stmt.execute(query);
    }
}
