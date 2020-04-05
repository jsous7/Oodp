/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class CountryRepository {
    
    public void save(EntityCountry country) throws IllegalArgumentException, IllegalAccessException{
        //String arrays required by the Dao
        String[] dataKeys = new String[30];
        String[] dataValues = new String[30];
              
        //Extract key:value pair from the attributes of the entity 'country' and populate the string 
        Class<? extends Object> c1 = country.getClass();
        Field[] fields = c1.getDeclaredFields();
        Field [] attributesKeys =  EntityCountry.class.getDeclaredFields();
        int i = 0;
        for (Field key : attributesKeys) {
            dataKeys[i] = key.getName();
            dataValues[i] = key.get(country).toString();
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
        daoLayer.insert("country", dataKeys, dataValues);
    }
    
//    public ArrayList listAll(){
//
//    } 
//    
//    public EntityCountry findByCode(String code){
//        
//    }
//    
//    public EntityCountry findByName(String name){
//        
//    }
}
