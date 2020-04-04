/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juliana.cct.oodp;

import java.io.IOException;
import static juliana.cct.oodp.EntryPoint.bufferedReader;

/**
 *
 * @author julia
 */
class Helper {
    public static void pause() throws IOException{
        System.out.println("Press any key to continue...");
        bufferedReader.readLine();
    }
}
