/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliana.cct.oodp;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class InputValidator {
    public static String validateString(String string){
        
        return string.trim().toLowerCase();
    }
    
    public static String validateSizeThree(String string){
        if (string.length() <= 3) {
            return string;
        }
        
        return string.substring(0, 3);
    }
    
    public static void validateNumber(String string) throws Exception{
        if (!string.matches("[0-9]+")) {
            throw new Exception("The string is not a number");
        }
    }
}
