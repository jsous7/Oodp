package Models;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class CountryRepository {
    
    String table = "country";
    
    public void save(EntityCountry country) throws IllegalArgumentException, IllegalAccessException, Exception{
        //String arrays required by the Dao
        String[] dataKeys = new String[30];
        String[] dataValues = new String[30];
              
        //Extract key:value pair from the attributes of the entity 'country' and populate the string 
        Class<? extends Object> c1 = country.getClass();
        Field[] fields = c1.getDeclaredFields();
        Field [] attributesKeys =  EntityCountry.class.getDeclaredFields();
        int i = 0;
        for (Field key : attributesKeys) {
            String keys = key.getName();
            dataKeys[i] = keys.substring(0,1).toUpperCase() + keys.substring(1);
            String values = key.get(country).toString();
            dataValues[i] = values.substring(0,1).toUpperCase() + values.substring(1);
            i++;
        }
        
        //Remove the null values from the string arrays (snipet based on stackoverflow)
        dataValues = Arrays.stream(dataValues)
            .filter(new_string -> (new_string != null && new_string.length() > 0))
            .toArray(String[]::new);
        
        dataKeys = Arrays.stream(dataKeys)
            .filter(new_string -> (new_string != null && new_string.length() > 0))
            .toArray(String[]::new);
        
        //Calls Dao Passsing the required data for dynamic construction of the query
        Dao daoLayer = new Dao();
        daoLayer.insert(this.table, dataKeys, dataValues);
    }

    public EntityCountry findByCode(String code) throws Exception{
        Dao daoLayer = new Dao();
        ResultSet rs = null;
        
        try {
            rs = daoLayer.selectByField(this.table, "Code", code);
        } catch (Exception e) {
            throw new Exception("Error while executing query: " + e.getMessage());
        }
        
        EntityCountry entityCountry = new EntityCountry();
        
        if (rs.next()){
            entityCountry.setCode(rs.getString(1));
            entityCountry.setName(rs.getString(2));
            entityCountry.setContinent(rs.getString(3));
            float surfaceAreaFloat = Float.parseFloat(rs.getString(4));
            entityCountry.setSurfaceArea(surfaceAreaFloat);
            entityCountry.setHeadOfState(rs.getString(5));
        } else {
            throw new Exception("Country not found");
        }
  
        return entityCountry;
    }
    
    public EntityCountry findByName(String name) throws Exception{
        Dao daoLayer = new Dao();
        ResultSet rs = null;
        
        try {
            rs = daoLayer.selectByField(this.table, "Name", name);
        } catch (Exception e) {
            throw new Exception("Error while executing query: " + e.getMessage());
        }
        
        EntityCountry entityCountry = new EntityCountry();
        
        if (rs.next()){
            entityCountry.setCode(rs.getString(1));
            entityCountry.setName(rs.getString(2));
            entityCountry.setContinent(rs.getString(3));
            float surfaceAreaFloat = Float.parseFloat(rs.getString(4));
            entityCountry.setSurfaceArea(surfaceAreaFloat);
            entityCountry.setHeadOfState(rs.getString(5));
        } else {
            throw new Exception("Country not found");
        }
  
        return entityCountry;
    }
    
    public ArrayList<EntityCountry> listAll() throws Exception{
        Dao daoLayer = new Dao();
        ResultSet rs = null;
        
        EntityCountry entityCountry = new EntityCountry();
        ArrayList<EntityCountry> countries = new ArrayList<EntityCountry>();
        
        try {
            rs = daoLayer.selectAll(this.table);
        } catch (Exception e) {
            throw new Exception("Error while executing query: " + e.getMessage());
        }
        
        if (rs.next()){
            while (rs.next()) {
                entityCountry.setCode(rs.getString(1));
                entityCountry.setName(rs.getString(2));
                entityCountry.setContinent(rs.getString(3));
                float surfaceAreaFloat = Float.parseFloat(rs.getString(4));
                entityCountry.setSurfaceArea(surfaceAreaFloat);
                entityCountry.setHeadOfState(rs.getString(5));
                
                countries.add(entityCountry);
            }
        } else {
            throw new Exception("No countries found!");
        }
    
        return countries;
    }
}
