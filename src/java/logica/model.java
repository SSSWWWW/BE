/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
 
import dao.datos.Dao;
import entidades.Administrador;
import entidades.Aplicado;
import entidades.AreaTrabajoIncluidas;
import entidades.Area_Trabajo;
import entidades.Caracteristicas;
import entidades.CaracteristicasIncluidos;
import entidades.Empresa;
import entidades.Especializacion;
import entidades.EspecializacionIncluida;
import entidades.EspecializacionIncluidaOferente;
import entidades.Habilidades;
import entidades.HabilidadesIncluidas;
import entidades.Oferente;
import entidades.Puestos;
import entidades.PuestosPublicados;
import entidades.Servicios;
import entidades.ServiciosPublicados;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

 /**
  *
  * @author pc
  */
public class model {
    
     private  Dao dao;
     
      private static model uniqueInstance;
      
         public static model instance() throws ClassNotFoundException, IOException, SQLException {
        if (uniqueInstance == null){
            uniqueInstance = new model();
        }
        return uniqueInstance;
        
        
    }    private model() throws ClassNotFoundException, SQLException, IOException{
       
         dao = new Dao();
    }
    
    
    
    
    
       /*********************Servicio********************************/
    
      public void updateServicios(Servicios p) throws Exception{
                    dao.ServiciosUpdate(p);
       }

        public void deleteServicios(Servicios p) throws Exception{

            dao.ServiciosDelete(p);
       }

         public void addServicios(Servicios p) throws Exception{
           dao.ServiciosAdd(p);
       }

          public Servicios getServicios(String id1) throws Exception{
           return dao.ServicioGet(id1);
       }

           public Collection<Servicios> getAllServicios() throws Exception{
            return  dao.ServiciosGetAll();
    
           }
    
    
    /**************************************************************/
           
           
                 public void updateAdministrador(Administrador p) throws Exception{

                    dao.AdministradorUpdate(p);
       }

        public void deleteAdministrador(Administrador p) throws Exception{

            dao.AdministradorDelete(p);
       }

         public void addAdministrador(Administrador p) throws Exception{
           dao.AdministradorAdd(p);
       }

          public Administrador getAdministrador(Administrador p) throws Exception{
           return dao.AdministradorGet(p);
       }

           public Collection<Administrador> getAllAdministrador() throws Exception{
            return  dao.AdministradorGetAll();
   
           }
           
    
    
    /*********************Oferente********************************/
    
           public void updateOferente(Oferente p) throws Exception{

                    dao.OferenteUpdate(p);
       }

        public void deleteOferente(Oferente p) throws Exception{

            dao.OferenteDelete(p);
       }

         public void addOferente(Oferente p) throws Exception{
           dao.OferenteAdd(p);
       }

          public Oferente getOferente(Oferente p) throws Exception{
           return dao.OferenteGet(p);
       }

           public List<Oferente> getAllOferente() throws Exception{
            return  dao.OferenteGetAll();
   
           }
    
           
            public List<Oferente> getOferentePorID(List<EspecializacionIncluidaOferente> p) throws Exception{
           return dao.EspecializacionToGetOferente(p);
       }
   
    
    
     /*********************Habilidades********************************/
    
   
    public void updateHabilidades(Habilidades p) throws Exception{

                    dao.HabilidadesUpdate(p);
       }

        public void deleteHabilidades(Habilidades p) throws Exception{

            dao.HabilidadesDelete(p);
       }

         public void addHabilidades(Habilidades p) throws Exception{
           dao.HabilidadesAdd(p);
       }

          public Habilidades getHabilidades(String id1) throws Exception{
           return dao.HabilidadesGet(id1);
       }

           public Collection<Habilidades> getAllHabilidades() throws Exception{
            return  dao.HabilidadesGetAll();
       }
    
    
    
          /*********************Empresa********************************/
    
    
              public void updateEmpresa(Empresa p) throws Exception{

                    dao.EmpresaUpdate(p);
       }

        public void deleteEmpresa(Empresa p) throws Exception{

            dao.EmpresaDelete(p);
       }

         public void addEmpresa(Empresa p) throws Exception{
           dao.EmpresaAdd(p);
       }

          public Empresa getEmpresa(Empresa emp) throws Exception{
           return dao.EmpresaGet(emp);
       }
          
           public Empresa getEmpresa1(String a) throws Exception{
           return dao.EmpresaGet1(a);
       }

           public List<Empresa> getAllEmpresa() throws Exception{
            return  dao.EmpresaGetAll();
       }
    
    
    
        
    
    
    /*********************PUESTOS********************************/
    
    
             public void updatePuestos(Puestos p) throws Exception{

                    dao.PuestosUpdate(p);
       }

        public void deletePuestos(Puestos p) throws Exception{

            dao.PuestosDelete(p);
       }

         public void addPuestos(Puestos p) throws Exception{
           dao.PuestosAdd(p);
       }

          public Puestos getPuestos(Puestos p) throws Exception{
           return dao.PuestosGet(p);
       }
          
           public List<Puestos> getAllPuestos1(String p) throws Exception{
           return dao.PuestosGetAll1(p);
       }
          
           public List<Puestos> getPuestosPorID(List<EspecializacionIncluida> p) throws Exception{
           return dao.EspecializacionToGetPuesto1(p);
       }
           
         
          

           public List<Puestos> getAllPuestos() throws Exception{
            return  dao.PuestosGetAll();
       }
    
    
    
    
    
    
     /*********************CARACTERISTICAS********************************/
    
    

                public void updateCaracteristicas(Caracteristicas p) throws Exception{

                    dao.CaracteristicasUpdate(p);
       }

        public void deleteCaracteristicas(Caracteristicas p) throws Exception{

            dao.CaracteristicasDelete(p);
       }

         public void addCaracteristicas(Caracteristicas p) throws Exception{
           dao.CaracteristicasAdd(p);
       }

          public Caracteristicas getCaracteristicas(Caracteristicas p) throws Exception{
           return dao.CaracteristicasGet(p);
       }

           public List<Caracteristicas> getAllCaracteristicas() throws Exception{
            return  dao.CaracteristicasGetAll();
       }
           
            /*********************CARACTERISTICAS INCLUIDOS********************************/
           
           
        public void deleteCaracteristicasIncluidos(CaracteristicasIncluidos p) throws Exception{

            dao.CaracteristicasIncluidosDelete(p);
       }

         public void addCaracteristicasIncluidos(CaracteristicasIncluidos p) throws Exception{
           dao.CaracteristicasIncluidosAdd(p);
       }

          public Caracteristicas getCaracteristicasIncluidos(String p) throws Exception{
           return dao.CaracteristicasIncluidosGet(p);
       }

           public List<CaracteristicasIncluidos> getAllCaracteristicasIncluidos() throws Exception{
            return  dao.CaracteristicasIncluidosGetAll();
       }
    
    
       /****************** AREA TRABAJO ****************************************/    
           
              public void updateArea_Trabajo(Area_Trabajo p) throws Exception{

                    dao.Area_TrabajoUpdate(p);
       }

        public void deleteArea_Trabajo(Area_Trabajo p) throws Exception{

            dao.Area_TrabajoDelete(p);
       }

         public void addArea_Trabajo(Area_Trabajo p) throws Exception{
           dao.Area_TrabajoAdd(p);
       }

          public List<Area_Trabajo> getArea_Trabajo(String p) throws Exception{
           return dao.Area_TrabajoGet(p);
       }

           public List<Area_Trabajo> getAllArea_Trabajo() throws Exception{
            return  dao.Area_TrabajoGetAll();
       }
           
           
     /**************AREA TRABAJO INCLUIDAS*******************/
           
            

        public void deleteAreaTrabajoIncluidas(AreaTrabajoIncluidas p) throws Exception{

            dao.AreaTrabajoIncluidasDelete(p);
       }

         public void addAreaTrabajoIncluidas(AreaTrabajoIncluidas p) throws Exception{
           dao.AreaTrabajoIncluidasAdd(p);
       }

          public List<AreaTrabajoIncluidas> getAreaTrabajoIncluidas(AreaTrabajoIncluidas p) throws Exception{
           return dao.AreaTrabajoIncluidasGet(p);
       }

           public List<AreaTrabajoIncluidas> getAllAreaTrabajoIncluidas() throws Exception{
            return  dao.AreaTrabajoIncluidasGetAll();
       }
           
           
           
           
       /****************** ESPECIALIZACION
     * @param p ****************************************/    
           
              public void updateEspecializacion(Especializacion p) throws Exception{

                    dao.EspecializacionUpdate(p);
       }

        public void deleteEspecializacion(Especializacion p) throws Exception{

            dao.EspecializacionDelete(p);
       }

         public void addEspecializacion(Especializacion p) throws Exception{
           dao.EspecializacionAdd(p);
       }

          public List<Especializacion> getEspecializacion(String p) throws Exception{
           return dao.EspecializacionGet(p);
       }
          
          public Especializacion getEspecializacionId(String p) throws Exception{
           return dao.EspecializacionGetId(p);
       }

           public List<Especializacion> getAllEspecializacion() throws Exception{
            return  dao.EspecializacionGetAll();
       }
    
       /******************* ESPECIALIZACION INCLUIDA*****************************/    
           
            public void addEspecializacionIncluidaOferente(EspecializacionIncluidaOferente p) throws Exception{
           dao.EspecializacionIncluidaOferenteAdd(p);
       }
            
             public void EspecializacionOferenteUpdate(EspecializacionIncluidaOferente p) throws Exception{
           dao.EspecializacionOferenteUpdate(p);
       }
            
            public List<EspecializacionIncluidaOferente> getespecializacionyPorcentaje(String p) throws Exception{
           return dao.caracteristicasPorcentaje(p);
       }
            
         public List<EspecializacionIncluidaOferente> getEspecializacionIDOferente(String[] cl) throws Exception{
            return  dao.EspecializacionIdOferente(cl);
       }    
           
         
           
           
       /******************* ESPECIALIZACION INCLUIDA*****************************/    
    
              

        public void deleteEspecializacionIncluida(EspecializacionIncluida p) throws Exception{

            dao.EspecializacionIncluidaDelete(p);
       }

         public void addEspecializacionIncluida(EspecializacionIncluida p) throws Exception{
           dao.EspecializacionIncluidaAdd(p);
       }

          public List<EspecializacionIncluida> getEspecializacionIncluida(EspecializacionIncluida p) throws Exception{
           return dao.EspecializacionIncluidaGet(p);
       }

           public List<EspecializacionIncluida> getAllEspecializacionIncluida() throws Exception{
            return  dao.EspecializacionIncluidaGetAll();
       }
           
             public List<EspecializacionIncluida> getAllEspecializacionIncluidaNP(String p, String ip) throws Exception{
            return  dao.EspecializacionIncluidaGetNP(p , ip);
       }
           
           
           
            public List<EspecializacionIncluida> getEspecializacionIncluidaID(String[] cl , String [] por , String lat , String lon) throws Exception{
            return  dao.EspecializacionIdPuesto(cl , por , lat , lon);
       }
           
           public EspecializacionIncluida getEspecializacionIncluida1(String p) throws Exception{
           return dao.EspecializacionIncluidaGet1(p);
       }
           
           
           
    
      /*********************SERVICIOS PUBLICADOS********************************/
    
         public void updateServiciosPublicados(ServiciosPublicados p) throws Exception{
        dao.ServiciosPublicadosUpdate(p);
    }
    
     public void deleteServiciosPublicados(ServiciosPublicados p) throws Exception{
        dao.ServiciosPublicadosDelete(p);
    }

      public void addServiciosPublicados(ServiciosPublicados p) throws Exception{
        dao.ServiciosPublicadosAdd(p);
    }
      
       public ServiciosPublicados getServiciosPublicados(String id1, int id2) throws Exception{
        return dao.ServiciosPublicadosGet(id1, id2);
    }
       
        public Collection<ServiciosPublicados> getAllServiciosPublicados() throws Exception{
        return  dao.ServiciosPublicadosGetAll();
    }    
    
    
    
    
      /*********************HABILIDADES INCLUIDAS********************************/
    
    
        public void deleteHabilidadesIncluidas(HabilidadesIncluidas p) throws Exception{
        dao.HabilidadesIncluidasDelete(p);
    }

      public void addHabilidadesIncluidas(HabilidadesIncluidas p) throws Exception{
        dao.HabilidadesIncluidasAdd(p);
    }
      
       public HabilidadesIncluidas getHabilidadesIncluidas(String id1, int id2) throws Exception{
        return dao.HabilidadesIncluidasGet(id1, id2);
    }
       
        public Collection<HabilidadesIncluidas> getAllHabilidadesIncluidas() throws Exception{
         return  dao.HabilidadesIncluidasGetAll();
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
      
       public PuestosPublicados getPuestosPublicados(String id2) throws Exception{
        return dao.PuestosPublicadosGet( id2);
    }
       
        public List<PuestosPublicados> getAllPuestosPublicados() throws Exception{
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
