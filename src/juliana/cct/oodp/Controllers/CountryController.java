package juliana.cct.oodp.Controllers;

import Models.CountryRepository;
import Models.EntityCountry;
import java.util.ArrayList;
import java.util.HashMap;
import juliana.cct.oodp.InputValidator;

/**
 * Controller in a MVC context is responsible for all business logic returning to the view only what is necessary to display the data
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class CountryController {
    
    /**
     * Business Logic to Create a country
     * @param countryData
     * @throws Exception 
     */
    public static void createCountry(HashMap countryData) throws Exception{
        //Get the input data coming from the view (EntryPoint)
        String code = countryData.get("code").toString();
        String name = countryData.get("name").toString();
        String continent = countryData.get("continent").toString();
        String surfaceArea = countryData.get("surfaceArea").toString();
        String headOfState = countryData.get("headOfState").toString();
        
        //Validate the data
        code = InputValidator.validateString(code);
        code = InputValidator.validateSizeThree(code);
        name = InputValidator.validateString(name);
        continent = InputValidator.validateString(continent);
        headOfState = InputValidator.validateString(headOfState);
        try {
            InputValidator.validateNumber(surfaceArea);
        }catch (Exception e) {
            throw new Exception("'Surface area' requires a number, you typed \"" + surfaceArea + "\", original error: " + e.getMessage());
        }
        float surfaceAreaFloat = Float.parseFloat(surfaceArea);

        //Populate the entity country with the validated data
        EntityCountry country = new EntityCountry();
        country.setCode(code);
        country.setName(name);
        country.setContinent(continent);
        country.setSurfaceArea(surfaceAreaFloat);
        country.setHeadOfState(headOfState);

        //Calls the repository to prepare the query for the DAO and save the entity on the DB
        CountryRepository repository = new CountryRepository();
        repository.save(country);
    }
    
    /**
     * Business logic to list all countries
     * @return
     * @throws Exception 
     */
    public static ArrayList listAll() throws Exception{
        //Only redirects the call from the view to the model once there is no busines logic required here nor any type of validation
        CountryRepository repository = new CountryRepository();
        
        return repository.listAll();
    } 
    
    /**
     * Business Logic to find a country by code
     * @param code
     * @return
     * @throws Exception 
     */
    public static HashMap findByCode(String code) throws Exception{
        code = InputValidator.validateString(code);
        
        CountryRepository repository = new CountryRepository();
        EntityCountry entityCountry = repository.findByCode(code);
        
        HashMap<String, String> countryData = new HashMap<>();
        if (entityCountry != null){
            countryData.put("code", entityCountry.getCode());
            countryData.put("name", entityCountry.getName());
            countryData.put("continent", entityCountry.getContinent());
            countryData.put("surfaceArea", entityCountry.getSurfaceArea().toString());
            countryData.put("headOfState", entityCountry.getHeadOfState());
        }
  
        return countryData;
    }
    
    /**
     * Business Logic to find a country by name
     * @param name
     * @return
     * @throws Exception 
     */
    public static HashMap findByName(String name) throws Exception{
        name = InputValidator.validateString(name);
        
        CountryRepository repository = new CountryRepository();
        EntityCountry entityCountry = repository.findByName(name);
        
        HashMap<String, String> countryData = new HashMap<>();
        if (entityCountry != null){
            countryData.put("code", entityCountry.getCode());
            countryData.put("name", entityCountry.getName());
            countryData.put("continent", entityCountry.getContinent());
            countryData.put("surfaceArea", entityCountry.getSurfaceArea().toString());
            countryData.put("headOfState", entityCountry.getHeadOfState());
        }
  
        return countryData;
    }
}
