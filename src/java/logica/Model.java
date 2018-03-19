/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dao.datos.Dao;
import entidades.Aplicado;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Model {
    
     private final Dao dao;
     
      private static Model uniqueInstance;
      
         public static Model instance() throws ClassNotFoundException, SQLException, IOException{
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }
    private Model() throws ClassNotFoundException, SQLException, IOException{
       
         dao = new Dao();
    }
    
    
    
    
    
    /********************************* APLICADO********************************/
    
    public void deleteAplicado(Aplicado p) throws Exception{
        dao.AplicadoDelete(p);
    }

     public void addAplicado(Aplicado p) throws Exception{
        dao.AplicadoAdd(p);
    }
     
      public void getAplicado(String id1, int id2) throws Exception{
        dao.AplicadoGet(id1, id2);
    }
      
       public void getAllAplicado() throws Exception{
        dao.AplicadoGetAll();
    }



    
    
    
}
