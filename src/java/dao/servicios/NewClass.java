/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicios;

import entidades.Oferente;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class NewClass {
    
    
      public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
          
          
          Dao d = new Dao();
          
          Oferente of = new Oferente("23333333", "Juan" , "Perez" , "Zeledon" , "83737373" , "Costarricense" , "jpz@hmail.com" , "Perez zeledon" );
          
          
        d.OferenteAdd(of);
          
          
          
        System.out.println("Hello World!"); // Display the string.
    }
    
}
