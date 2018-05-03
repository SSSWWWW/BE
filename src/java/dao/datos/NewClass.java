/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.datos;

import entidades.Administrador;
import entidades.Area_Trabajo;
import entidades.Caracteristicas;
import entidades.CaracteristicasIncluidos;
import entidades.Empresa;
import entidades.Especializacion;
import entidades.EspecializacionIncluida;
import entidades.EspecializacionIncluidaOferente;
import entidades.Oferente;
import entidades.Puestos;
import java.sql.SQLException;
import java.util.List;
import logica.model;

/**
 *
 * @author pc
 */
public class NewClass {
    
    
      public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
          
          Dao d;
          
          d = new Dao();
          
          model m;
      
   
          
          
          List<Empresa> emp = model.instance().getAllEmpresa();
          
          for(Empresa e : emp){
          
          System.out.println(e.getNombreEmp());
          
          
          }
          
    /*      float sal = 700000;
        
          Puestos p1 = new Puestos();
          Puestos p2 = new Puestos();
        p1.setDescripcionPuesto("Implementar, dar soporte y gestionar a las bases de datos corporativas, garantizando la seguridad de estas, planeando e implementando planes de contingencia.");
        p1.setEstado(true);
        p1.setIdPuesto(3);
        p1.setNombrePuesto("Administrador de BD");
        p1.setSalario(sal);
         model.instance().updatePuestos(p1);
          
      //  System.out.println("nombre " + p2.getNombrePuesto());
          
      /*    
          String clrs[] = {"29" , "30"};
          
         List<EspecializacionIncluida> ei = model.instance().getEspecializacionIncluidaID(clrs);
          
          for(EspecializacionIncluida car : ei){
          
               
                System.out.println("id empresa " + car.getIdEmp());
               
               }
          
          
           List<Puestos> puestos = model.instance().getPuestosPorID(ei);
          
          for(Puestos ca : puestos){
          
               System.out.println(ca.getNombrePuesto());
               System.out.println(ca.getIdPuesto());
               
               
               }
          
          
          
    /*      String a = "402130856";
          
          List<EspecializacionIncluidaOferente> pues = model.instance().getespecializacionyPorcentaje(a);
          
          for(EspecializacionIncluidaOferente p : pues){
          
              System.out.println(p.getNombreEspecializacion() + p.getPorcentajeEspecializacion());
          
          }
          
          
          
        /*  
   
          String q = String.valueOf(120);
          EspecializacionIncluida a = model.instance().getEspecializacionIncluida1(q); 
          
              String w = String.valueOf(a.getIdEmp()); Empresa emp = model.instance().getEmpresa1(w); 
              
              System.out.println(emp.getNombreEmp()); */
          
  /*    String clrs[] = {"28" , "32"};
          
          List<EspecializacionIncluida> ei = model.instance().getEspecializacionIncluidaID(clrs);
          
          for(EspecializacionIncluida car : ei){
          
               System.out.println("id puesto " + car.getIdPuesto());
                System.out.println("id empresa " + car.getIdEmp());
               
               }
          
          List<Puestos> p = model.instance().getPuestosPorID(ei);
          
          for(Puestos ca : p){
          
               System.out.println(ca.getNombrePuesto());
               
               }
          
          
   /*       String  caracteristica = "SQL";
      
     
        
        Especializacion ei = new Especializacion();
        
        
        ei = model.instance().getEspecializacionId(caracteristica);
        int carac = ei.getIdespecializacion();
        
        System.out.println(carac);
        
        EspecializacionIncluida esi = new EspecializacionIncluida();
        
        esi.setIdPuesto(19);
        esi.setIdespecializacion(carac);
        esi.setPorcentajeEspecializacion(55);
        
        model.instance().addEspecializacionIncluida(esi);
        
          
      /*    Puestos p = new Puestos();
          
          p.setNombrePuesto("Administrador de BD");
          
          
          p = model.instance().getPuestos(p);
          
          System.out.println(p.getIdPuesto());
          
  /*        Caracteristicas c = new Caracteristicas();
          
          c.setNombreCaracteristica("Programacion");
          
          
          List<Especializacion> at = model.instance().getEspecializacion("backend");
          
          for(Especializacion car : at){
          
               System.out.println(car.getNombreEspecializacion());
               
               }
          
         // model.instance().getAllCaracteristicas();
          
         // List<Caracteristicas> c = model.instance().getAllCaracteristicas();
          
          //for(Caracteristicas car : c){
          
            //    System.out.println(car.getNombreCaracteristica());
          
          //}
          
       //   Administrador admin = new Administrador();
          
         // admin.setNombreAdmin("admin");
          //admin.setClave("admin");
          
         //model.instance().addAdministrador(admin);
          
         
 //        Administrador admin = new Administrador();
//admin.setNombreAdmin("admin");
//admin.setClave("admin");

//admin = model.instance().getAdministrador(admin);

//System.out.println(admin.getNombreAdmin());


         
         /* Oferente of = new Oferente();
          
          of.setCorreoOferente("sjwg14@gmail.com");
          of.setClave("stefan");
          
          of = model.instance().getOferente(of);
          
          System.out.println(of.getNombreOferente());*/
          
      //   Empresa empresa = new Empresa();
//empresa.setCorreoEmp("rh@walmart.com");
//empresa.setClave("walmart");
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
  //    empresa = model.instance().getEmpresa(empresa); 
       
    //  System.out.println(empresa.getCorreoEmp());
          
        // Oferente of = new Oferente("juan" ,"23333333", "Juan" , "Perez" , "Zeledon" , "83737373" , "CR" , "jpz@hmail.com" , "HER" );
          
      // Oferente of = new Oferente("343426666", "Jon" , "Paz" , "Zel" , "45323455" , "CR" , "ccc@hmail.com" , "CAR" );
         
     // Oferente of = new Oferente("mar" ,"554533243", "Mar" , "Martines" , "Zeca" , "65435643" , "CR" , "mar55@hmail.com" , "HER" );
      
      //Oferente of1 = new Oferente();
      
      //of1.setCedulaOferente("5545332432");
      
        //d.OferenteAdd(of);
        //d.OferenteDelete(of);
          
       //of1 = model.instance().getOferente(of1);
        //m.getOferente(of);
          //d.OferenteGet(of);
          
        System.out.println("Hello World!"); // Display the string.
    }
    
}
