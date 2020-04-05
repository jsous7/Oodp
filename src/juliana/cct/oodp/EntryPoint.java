package juliana.cct.oodp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import juliana.cct.oodp.Controllers.CountryController;

/**
 * Entry point, it is being used as a 'View' in the MVC context
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class EntryPoint {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static boolean stopLoop = false;

    public static void main(String[] args) throws IOException {
        while (!stopLoop) {
            displayMenu();
            String optionSelected = bufferedReader.readLine();
            mainLogic(optionSelected);
        }
    }
    
    /**
     * Method to print the menu
     */
    private static void displayMenu() {
        System.out.println("Select one option:\n");
        System.out.println("1.Create a country");
        System.out.println("2.Show all countries");
        System.out.println("3.Show country details by code");
        System.out.println("4.Show country details by name");
        System.out.println("5.Exit");
    }

    /**
     * Method to get the selected option from the menu and then, calls the suitable action
     * @param option
     * @throws IOException 
     */
    private static void mainLogic(String option) throws IOException {
        switch (option) {
            case "1":
                createCountry();
                break;
            case "2":
                System.out.println("Option selected!");
                Helper.pause();
                break;
            case "3":
                //TODO
                break;
            case "4":
                //TODO
                break;
            case "5":
                stopLoop = true;
                System.out.println("Application Exited");    
                break;                
            default:
                System.out.println("\"" + option + "\" Is an invalid option ");
                break;
        }
    }
    
    /**
     * Method to get the input data from the user
     * @throws IOException 
     */
    private static void createCountry() throws IOException{
        System.out.println("Type three characters for country code:");
        String code = bufferedReader.readLine();
        System.out.println("Type country name:");
        String name = bufferedReader.readLine();
        System.out.println("Type the surface area");
        String surfaceArea = bufferedReader.readLine();
        System.out.println("Type the head of state");
        String headOfState = bufferedReader.readLine();
        
        //Logic to show a menu with continent options to be selected
        boolean stopLoop = false;
        String continent = null;
        while(!stopLoop){
            System.out.println("Choose a continent:");
            Continents values[] = Continents.values();
            int i = 1;
            for(Continents continentValue : values){
                System.out.println(i + "." + continentValue);
                i++;    
            }
            String continentOption = bufferedReader.readLine();
            switch(continentOption){
                case "1" :
                    continent = "Asia";
                    stopLoop = true;
                    break;
                case "2" :
                    continent = "Europe";
                    stopLoop = true;
                    break;
                case "3" :
                    continent = "North America";
                    stopLoop = true;
                    break; 
                case "4" :
                    continent = "Africa";
                    stopLoop = true;
                    break;
                case "5" :
                    continent = "Oceania";
                    stopLoop = true;
                    break;
                case "6" :
                    continent = "Antarctica";
                    stopLoop = true;
                    break;
                case "7":
                    continent = "South America";
                    stopLoop = true;
                    break;
                default:
                    System.out.println("Invalid Option, try Again");
                    Helper.pause();
                    break;
            }
        }
        
        //Populate a HashMap with data inserted by the user
        HashMap<String, String> countryData = new HashMap<>();
        countryData.put("code", code);
        countryData.put("name", name);
        countryData.put("continent", continent);
        countryData.put("surfaceArea", surfaceArea);
        countryData.put("headOfState", headOfState);
        
        //Calls the controller action to create a new country based on the HasMap data
        try{
            CountryController.createCountry(countryData);
            System.out.println("\nCountry created successfully!");
        }catch (Exception e){
            System.out.println("\nAn error happened while trying to save a new country: " + e.getMessage());
        }
        
        Helper.pause();
    }
}