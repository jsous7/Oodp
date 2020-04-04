/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliana.cct.oodp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.HashMap;
import javax.tools.*;

/**
 *
 * @author julia
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
    
    private static void displayMenu() {
        System.out.println("Select one option:\n");
        System.out.println("1.Create a country");
        System.out.println("2.Show all countries");
        System.out.println("3.Show country details by name");
        System.out.println("4.Show country details by code");
        System.out.println("5.Exit");
    }

    private static void mainLogic(String option) throws IOException {
        switch (option) {
            case "1":
                if(createCountry()){
                    System.out.println("Contry created successfully!");
                }
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
    
    private static boolean createCountry() throws IOException{
        System.out.println("Type three characters for country code:");
        String code = bufferedReader.readLine();
        System.out.println("Type country name:");
        String name = bufferedReader.readLine();
        
        boolean stopLoop = false;
        String continent = "";
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
                    continent = Continents.ASIAN.toString();
                    stopLoop = true;
                    break;
                case "2" :
                    continent = Continents.EUROPE.toString();
                    stopLoop = true;
                    break;
                case "3" :
                    continent = Continents.NORTH_AMERICA.toString();
                    stopLoop = true;
                    break; 
                case "4" :
                    continent = Continents.AFRICA.toString();
                    stopLoop = true;
                    break;
                case "5" :
                    continent = Continents.OCEANIA.toString();
                    stopLoop = true;
                    break;
                case "6" :
                    continent = Continents.ANTARCTICA.toString();
                    stopLoop = true;
                    break;
                case "7":
                    continent = Continents.SOUTH_AMERICA.toString();
                    stopLoop = true;
                    break;
                case "8" :
                    continent = Continents.CENTRAL_AMERICA.toString();
                    stopLoop = true;
                    break;
                default:
                    System.out.println("Invalid Option, Try Again");
                    Helper.pause();
                    break;
            }
        }

        System.out.println("Type the surface area");
        String surfaceArea = bufferedReader.readLine();
        System.out.println("Type the head of state");
        String headOfState = bufferedReader.readLine();
        
        HashMap<String, String> countryData = new HashMap<String, String>();
        countryData.put("code", code);
        countryData.put("name", name);
        countryData.put("continent", continent);
        countryData.put("surface_area", surfaceArea);
        countryData.put("head_of_state", headOfState);
        
        //TODO: send the hashmap to the controller.
        //CountryController countryController = new CountryController(countryData);
               
        Helper.pause();
        return true;
    }
}
