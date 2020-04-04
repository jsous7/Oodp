/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliana.cct.oodp;

/**
 *
 * @author julia
 */
public class EntryPoint {

    public static void main(String[] args) {
        displayMenu();

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

}
