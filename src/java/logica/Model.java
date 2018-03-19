/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dao.datos.Dao;
import entidades.Aplicado;
import entidades.PuestosPublicados;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

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
    
    /************************PUESTOS PUBLICADOS********************************/
    
     public void updatePuestosPublicados(PuestosPublicados p) throws Exception{
        dao.PuestosPublicadosUpdate(p);
    }
    
     public void deletePuestosPublicados(PuestosPublicados p) throws Exception{
        dao.PuestosPublicadosDelete(p);
    }

      public void addPuestosPublicados(PuestosPublicados p) throws Exception{
        dao.PuestosPublicadosAdd(p);
    }
      
       public PuestosPublicados getPuestosPublicados(int id1, int id2) throws Exception{
        return dao.PuestosPublicadosGet(id1, id2);
    }
       
        public Collection<PuestosPublicados> getAllPuestosPublicados() throws Exception{
         return  dao.PuestosPublicadosGetAll();
    }
     
    
    /********************************* APLICADO********************************/
    
    public void deleteAplicado(Aplicado p) throws Exception{
        dao.AplicadoDelete(p);
    }

     public void addAplicado(Aplicado p) throws Exception{
        dao.AplicadoAdd(p);
    }
     
      public Aplicado getAplicado(String id1, int id2) throws Exception{
        return dao.AplicadoGet(id1, id2);
    }
      
       public Collection<Aplicado> getAllAplicado() throws Exception{
         return  dao.AplicadoGetAll();
    }



    
    
    
}
