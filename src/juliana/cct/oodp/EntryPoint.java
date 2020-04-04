/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliana.cct.oodp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.println("5.Update country");
        System.out.println("6.Delete country");
        System.out.println("7.Exit");
    }

    private static void mainLogic(String option) throws IOException {
        switch (option) {
            case "1":
                //TODO
                break;
            case "2":
                System.out.println("Option selected!");
                System.out.println("Press any key to continue...");
                bufferedReader.readLine();
                break;
            case "3":
                //TODO
                break;
            case "4":
                //TODO
                break;
            case "5":
                //TODO
                break;
            case "6":
                //TODO
                break;
            case "7":
                stopLoop = true;
                break;
            default:
                System.out.println("\"" + option + "\" Is an invalid option ");
                break;
        }
    }
}
