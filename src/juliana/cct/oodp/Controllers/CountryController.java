/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliana.cct.oodp.Controllers;

import Models.CountryRepository;
import Models.EntityCountry;
import java.util.ArrayList;
import java.util.HashMap;
import juliana.cct.oodp.InputValidator;

/**
 * Controller in a MVC context is responsible for all business logic
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class CountryController {
    
    public static void createCountry(HashMap countryData) throws Exception{
        //Get the input data coming from the view (EntryPoint)
        String code = countryData.get("code").toString();
        String name = countryData.get("name").toString();
        String continent = countryData.get("continent").toString();
        String surfaceArea = countryData.get("surface_area").toString();
        String headOfState = countryData.get("head_of_state").toString();
        
        //Validate the data
        code = InputValidator.validateString(code);
        code = InputValidator.validateSizeThree(code);
        name = InputValidator.validateString(name);
        continent = InputValidator.validateString(continent);
        headOfState = InputValidator.validateString(headOfState);
        try {
            InputValidator.validateNumber(surfaceArea);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        float surfaceAreaFloat = Float.parseFloat(surfaceArea);

        //Populate the entity country with the validated data
        EntityCountry country = new EntityCountry();
        country.setCode(code);
        country.setName(name);
        country.setContinent(continent);
        country.setSurface_area(surfaceAreaFloat);
        country.setHead_of_state(headOfState);
        
        //Calls the repository to prepare the query for the DAO and save the entity on the DB
        CountryRepository repository = new CountryRepository();
        repository.save(country);
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
