package juliana.cct.oodp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String regex = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
        Pattern p = Pattern.compile(regex); 
        Matcher m = p.matcher(string);
        if(!(m.find() && m.group().equals(string))){
            throw new Exception("The string is not a valid number");
        }
    }
}