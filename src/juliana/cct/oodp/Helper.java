package juliana.cct.oodp;

import java.io.IOException;
import static juliana.cct.oodp.EntryPoint.bufferedReader;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class Helper {
    public static void pause() throws IOException{
        System.out.println("\nPress any key to continue...\n");
        bufferedReader.readLine();
    }
}
