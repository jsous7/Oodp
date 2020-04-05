/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
class Dao {
    public void insert(String table, String[] dataKeys, String[] dataValues){
        System.out.println(table);
        
        for (String element : dataKeys){
            System.out.println(element);
        }
        
        for (String element : dataValues){
            System.out.println(element);
        }
        
        System.exit(0);
        //        String query = "insert into country('code', 'name')values('bra', 'Brazil')";  
    }
}
