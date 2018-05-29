/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.datos;

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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import logica.model;




/**
 *
 * @author pc
 */
public class Dao {
    
      RelDatabase db= new RelDatabase();;
    
    public Dao() throws ClassNotFoundException, SQLException, IOException{
        db= new RelDatabase();
        
    }
    
    
      private Aplicado aplicado(ResultSet rs){
        try {
            Aplicado ec= new Aplicado();
          
                ec.setFechaAplicacion(rs.getDate("fechaAplicacion"));
                ec.setIdOferente(rs.getString("idOferente"));
                ec.setIdPuestos(rs.getInt("idPuestos"));
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
      
              
              
                 public void AplicadoDelete(Aplicado p) throws Exception{
        String sql="delete from bolsaempleo.Aplicado where cedulaOferente='%s' and idPuesto='%s' ";
        sql = String.format(sql,p.getIdOferente(), p.getIdPuestos());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("puesto buscado inexistente");
        }
    }
    
        
      public void AplicadoAdd(Aplicado p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.Aplicado (fechaAplicacion , cedulaOferente , idPuesto ) "+
                "values(? ,? ,? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setDate(1, p.getFechaAplicacion());
        preparedStmt.setString (2, p.getIdOferente());
        preparedStmt.setInt(3, p.getIdPuestos());
        
      
       preparedStmt.execute();
       
    }
      
      
        public Aplicado AplicadoGet(String codigo, int codigo2) throws Exception{
        String sql="select * from aplicado where cedulaOferente='%s' and idPuesto='%s'";
        sql = String.format(sql,codigo, codigo2);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return aplicado(rs);
        }
        else{
            throw new Exception ("aplicacion no Existe");
            
        }
    }
        
            public Collection<Aplicado> AplicadoGetAll(){
        Vector<Aplicado> estados=new Vector<Aplicado>();
        try {
            String sql="select * from Aplicado";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(aplicado(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    
    
    
    /********************************************************************/
      
    
     private PuestosPublicados puestosPublicados(ResultSet rs){
        try {
            PuestosPublicados ec= new PuestosPublicados();
          
                ec.setIdEmpresa(rs.getInt("idEmp"));
                ec.setEstadoPuesto(rs.getBoolean("estadoPuesto"));
                ec.setIdPuestos(rs.getInt("idPuesto"));
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
              public void PuestosPublicadosUpdate(PuestosPublicados p) throws Exception{
        String sql="update bolsaempleo.puestos_publicados set estadoPuesto='%s'"   +
                "where idEmp='%s' and idPuesto='%s'";
        sql=String.format(sql,p.getEstadoPuesto(),
                p.getIdEmpresa(),p.getIdPuestos());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("puesto buscado inexistente");
        }
    }
              
              
                 public void PuestosPublicadosDelete(PuestosPublicados p) throws Exception{
        String sql="delete from bolsaempleo.puestos_publicados where idEmp='%s' and idPuesto='%s' ";
        sql = String.format(sql,p.getIdEmpresa(), p.getIdPuestos());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("puesto buscado inexistente");
        }
    }
    
        
      public void PuestosPublicadosAdd(PuestosPublicados p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert ignore into bolsaempleo.puestos_publicados (idEmp , idPuesto , estadoPuesto ) "+
                "values(? ,? ,? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getIdEmpresa());
        preparedStmt.setInt (2, p.getIdPuestos());
        preparedStmt.setBoolean(3, p.getEstadoPuesto());
        
      
       preparedStmt.execute();
       
    }
      
      
        public PuestosPublicados PuestosPublicadosGet(String codigo2) throws Exception{
        
               db.getConnection();
               
               System.out.println("DAO PuestosPublicadosGet " + codigo2);
            String sql="select * from puestos_publicados where  idPuesto='%s'";
        sql = String.format(sql, codigo2);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return puestosPublicados(rs);
        }
        else{
            throw new Exception ("puesto no Existe");
            
        }
    }
        
            public List<PuestosPublicados> PuestosPublicadosGetAll(){
        List<PuestosPublicados> estados=new ArrayList();
        try {
            String sql="select * from puestos_publicados";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(puestosPublicados(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /*********************************************************************/
    
    
      private CaracteristicasIncluidos caracteristicasIncluidos(ResultSet rs){
        try {
            CaracteristicasIncluidos ec= new CaracteristicasIncluidos();
          
              
                ec.setIdCaracteristicas(rs.getInt("idCaracteriticas"));
                ec.setIdPuestos(rs.getInt("idPuesto"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
      
              
              
                 public void CaracteristicasIncluidosDelete(CaracteristicasIncluidos p) throws Exception{
        String sql="delete from bolsaempleo.caracteristicas_incluidas where idPuesto='%s' and idCaracteristicas='%s'";
        sql = String.format(sql,p.getIdPuestos(), p.getIdCaracteristicas());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("caracteristica no ha sido incluida");
        }
    }
    
        
      public void CaracteristicasIncluidosAdd(CaracteristicasIncluidos p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.CARACTERISTICAS_INCLUIDAS (idPuesto , idCaracteriticas) "+
                "values(? ,?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getIdPuestos());
        preparedStmt.setInt (2, p.getIdCaracteristicas());
   
        
      
       preparedStmt.execute();
       
    }
      
      
        public Caracteristicas CaracteristicasIncluidosGet(String p ) throws Exception{
        
            
            db.getConnection();
            String sql="select * from CARACTERISTICAS where nombreCaracteristica='%s'";
        sql = String.format(sql,p);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return caracteristicas(rs);
        }
        
        if(p.isEmpty()){
        
            throw new Exception ( "string vacio " );
           
        }
        
        else{ 
            throw new Exception ( "servicio no ha sido publicado " + p);
            
        }
    }
        
            public List<CaracteristicasIncluidos> CaracteristicasIncluidosGetAll(){
        List<CaracteristicasIncluidos> estados=new ArrayList();
        try {
            String sql="select * from CARACTERISTICAS_INCLUIDAS";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(caracteristicasIncluidos(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    /*********************************************************************/
            
    
      private AreaTrabajoIncluidas AreaTrabajoIncluidas(ResultSet rs){
        try {
            AreaTrabajoIncluidas ec= new AreaTrabajoIncluidas();
          
              
                ec.setIdPuesto(rs.getInt("idPuesto"));
                ec.setIdareatrabajo(rs.getInt("idareatrabajo"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
      
              
              
                 public void AreaTrabajoIncluidasDelete(AreaTrabajoIncluidas p) throws Exception{
        String sql="delete from bolsaempleo.caracteristicas_incluidas where idPuesto='%s' and idCaracteristica='%s'";
      //  sql = String.format(sql,p.getidPuestos(), p.getIdCaracteristicaIn());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("caracteristica no ha sido incluida");
        }
    }
    
        
      public void AreaTrabajoIncluidasAdd(AreaTrabajoIncluidas p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.AREATRABAJO_INCLUIDAS (idPuesto , idareatrabajo) "+
                "values(? ,? ,? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getIdPuesto());
        preparedStmt.setInt (2, p.getIdareatrabajo());
   
        
      
       preparedStmt.execute();
       
    }
      
   
        
        
                public List<AreaTrabajoIncluidas> AreaTrabajoIncluidasGet(AreaTrabajoIncluidas p) throws Exception{
        
        
        
           db.getConnection();
        List<AreaTrabajoIncluidas> estados=new ArrayList<>();
        try {
           
          String sql="select * from bolsaempleo.AREATRABAJO_INCLUIDAS where idPuesto='%s' and idareatrabajo='%s'";
            sql = String.format(sql,p.getIdPuesto(),p.getIdareatrabajo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(AreaTrabajoIncluidas(rs));
            }
        } catch (SQLException ex) { }
        return estados;    
        
        
    }
        
        
        
            public List<AreaTrabajoIncluidas> AreaTrabajoIncluidasGetAll(){
        List<AreaTrabajoIncluidas> estados=new ArrayList();
        try {
            String sql="select * from caracteristicas_incluidos";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(AreaTrabajoIncluidas(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
            
    
    
    
    
    
    
    
    /************************************************************************/
    
     private HabilidadesIncluidas habilidadesIncluidas(ResultSet rs){
        try {
            HabilidadesIncluidas ec= new HabilidadesIncluidas();
          
                ec.setFechaInclusion(rs.getDate("fechaInclusion"));
                ec.setIdHabilidad(rs.getInt("idHabilidad"));
                ec.setServicios(rs.getInt("idServicio"));
       
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
      
              
              
                 public void HabilidadesIncluidasDelete(HabilidadesIncluidas p) throws Exception{
        String sql="delete from bolsaempleo.habilidades_incluidas where idServicio='%s' and idHabilidad='%s'";
        sql = String.format(sql,p.getidServicios(), p.getIdHabilidad());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("habilidad no ha sido incluida");
        }
    }
    
        
      public void HabilidadesIncluidasAdd(HabilidadesIncluidas p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.habilidades_incluidas (idServicio , idHabilidad , fecha_Inclusion ) "+
                "values(? ,? ,? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getidServicios());
        preparedStmt.setInt (2, p.getIdHabilidad());
        preparedStmt.setDate(3, p.getFechaInclusion());
        
      
       preparedStmt.execute();
       
    }
      
      
        public HabilidadesIncluidas HabilidadesIncluidasGet(String codigo, int codigo2) throws Exception{
        String sql="select * from habilidades_incluidas where idServicio='%s' and idHabilidad='%s'";
        sql = String.format(sql,codigo,codigo2);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return habilidadesIncluidas(rs);
        }
        else{
            throw new Exception ("habilidad no ha sido incluida");
            
        }
    }
        
            public Collection<HabilidadesIncluidas> HabilidadesIncluidasGetAll(){
        Vector<HabilidadesIncluidas> estados=new Vector<HabilidadesIncluidas>();
        try {
            String sql="select * from habilidades_incluidas";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(habilidadesIncluidas(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    
    
    
    
    
    
    
    /**********************************************************************/
    
      private ServiciosPublicados serviciosPublicados(ResultSet rs){
        try {
            ServiciosPublicados ec= new ServiciosPublicados();
          
                ec.setCedulaOferente(rs.getString("cedulaOferente"));
                ec.setEstadoServicio(rs.getBoolean("estadoServicios"));
                ec.setIdServicio(rs.getInt("idServicio"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
              public void ServiciosPublicadosUpdate(ServiciosPublicados p) throws Exception{
        String sql="update bolsaempleo.servios_publicados set estadoServicio='%s'"   +
                "where cedulaOferente='%s' and idServicio='%s'";
        sql=String.format(sql,p.getEstadoServicio(),
                p.getCedulaOferente(),p.getIdServicio());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("servicio no ha sido publicado");
        }
    }
              
              
                 public void ServiciosPublicadosDelete(ServiciosPublicados p) throws Exception{
        String sql="delete from bolsaempleo.servios_publicados where cedulaOferente='%s' and idServicio='%s'";
        sql = String.format(sql,p.getCedulaOferente(), p.getIdServicio());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("servicio no ha sido publicado");
        }
    }
    
        
      public void ServiciosPublicadosAdd(ServiciosPublicados p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.servios_publicados (cedulaOferente , idServicio , estadoServicio ) "+
                "values(? ,? ,? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString(1, p.getCedulaOferente());
        preparedStmt.setInt (2, p.getIdServicio());
        preparedStmt.setBoolean(3, p.getEstadoServicio());
        
      
       preparedStmt.execute();
       
    }
      
      
        public ServiciosPublicados ServiciosPublicadosGet(String codigo, int codigo2) throws Exception{
        String sql="select * from servios_publicados where cedulaOferente='%s' and idServicio='%s'";
        sql = String.format(sql,codigo,codigo2);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return serviciosPublicados(rs);
        }
        else{
            throw new Exception ("servicio no ha sido publicado");
            
        }
    }
        
            public Collection<ServiciosPublicados> ServiciosPublicadosGetAll(){
        Vector<ServiciosPublicados> estados=new Vector<ServiciosPublicados>();
        try {
            String sql="select * from servios_publicados";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(serviciosPublicados(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    
    
    
    /*********************************************************************/
    
    
    
    
     private Caracteristicas caracteristicas(ResultSet rs){
        try {
            Caracteristicas ec= new Caracteristicas();
          
                ec.setNombreCaracteristica(rs.getString("nombreCaracteristica"));
                ec.setIdCaracteristicas(rs.getInt("idCaracteriticas"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
              public void CaracteristicasUpdate(Caracteristicas p) throws Exception{
        String sql="update bolsaempleo.caracteristicas set nombreCaracteristica='%s'"   +
                "where nombreCaracteristica='%s'";
        sql=String.format(sql,p.getNombreCaracteristica());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("caracteristica no existe");
        }
    }
              
              
                 public void CaracteristicasDelete(Caracteristicas p) throws Exception{
        String sql="delete from bolsaempleo.caracteristicas where nombreCaracteristica='%s'";
        sql = String.format(sql,p.getNombreCaracteristica());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("caracteristica no existe");
        }
    }
    
        
      public void CaracteristicasAdd(Caracteristicas p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.caracteristicas (nombreCaracteristica) "+
                "values(?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString(1, p.getNombreCaracteristica());
      
        
      
       preparedStmt.execute();
       
    }
      
      
        public Caracteristicas CaracteristicasGet(Caracteristicas p) throws Exception{
        String sql="select distinct caracteristicas.nombreCaracteristica, caracteristicas.idCaracteriticas from caracteristicas where nombreCaracteristica='%s'";
        sql = String.format(sql,p.getNombreCaracteristica());
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return caracteristicas(rs);
        }
        else{
            throw new Exception ("caracteristica no Existe");
            
        }
    }
        
            public List<Caracteristicas> CaracteristicasGetAll(){
                
                db.getConnection();
        List<Caracteristicas> estados=new ArrayList<>();
        try {
            String sql="select * from caracteristicas";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(caracteristicas(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    
    /**********************************************************************/
    
    
            
            
    
    
    
     private Area_Trabajo areatrabajo(ResultSet rs){
        try {
            Area_Trabajo ec= new Area_Trabajo();
          
                ec.setNombreCaracteristica(rs.getString("nombreCaracteristica"));
                ec.setNombreAreaTrabajo(rs.getString("nombreAreaTrabajo"));
                ec.setIdareatrabajo(rs.getInt("idareatrabajo"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
              public void Area_TrabajoUpdate(Area_Trabajo p) throws Exception{
        String sql="update bolsaempleo.Area_Trabajo set nombreCaracteristica='%s' , nombreAreaTrabajo='%s'"  +
                "where nombreAreaTrabajo='%s'";
        sql=String.format(sql,p.getNombreCaracteristica(), p.getNombreAreaTrabajo());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("area trabajo no existe");
        }
    }
              
              
                 public void Area_TrabajoDelete(Area_Trabajo p) throws Exception{
        String sql="delete from bolsaempleo.Area_Trabajo where nombreAreaTrabajo='%s'";
        sql = String.format(sql,p.getNombreAreaTrabajo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("area trabajo no existe");
        }
    }
    
        
      public void Area_TrabajoAdd(Area_Trabajo p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.Area_Trabajo (nombreCaracteristica, nombreAreaTrabajo) "+
                "values(?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString(1, p.getNombreCaracteristica());
        preparedStmt.setString(2, p.getNombreAreaTrabajo());
      
        
      
       preparedStmt.execute();
       
    }
      
      
        public List<Area_Trabajo> Area_TrabajoGet(String p) throws Exception{
        
        
        
           db.getConnection();
        List<Area_Trabajo> estados=new ArrayList<>();
        try {
           
            String sql="select area_trabajo.nombreCaracteristica, area_trabajo.nombreAreaTrabajo, area_trabajo.idareatrabajo from "+
                    " area_trabajo "+
                    "where area_trabajo.nombreCaracteristica ='%s'";
            sql = String.format(sql,p);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(areatrabajo(rs));
            }
        } catch (SQLException ex) { }
        return estados;    
        
        
    }
        
            public List<Area_Trabajo> Area_TrabajoGetAll(){
                db.getConnection();
        List<Area_Trabajo> estados=new ArrayList<>();
        try {
            String sql="select * from Area_Trabajo";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(areatrabajo(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
       /****************************************************************/     
            
              private Especializacion especializacion(ResultSet rs){
        try {
            Especializacion ec= new Especializacion();
          
                ec.setNombreEspecializacion(rs.getString("nombreEspecializacion"));
                ec.setNombresAreaTrabajo(rs.getString("nombreAreaTrabajo"));
                ec.setProcentajeEspecializacion(rs.getInt("porcentajeEspecializacion"));
                ec.setIdespecializacion(rs.getInt("idespecializacion"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
              public void EspecializacionUpdate(Especializacion p) throws Exception{
        String sql="update bolsaempleo.Especializacion set  nombreEspecializacion='%s' , porcentajeEspecializacion='%s'"  +
                "where nombreEspecializacion='%s'";
        sql=String.format(sql,p.getNombreEspecializacion(), p.getProcentajeEspecializacion(), p.getNombreEspecializacion());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("especializacion no existe");
        }
    }
              
              
                 public void EspecializacionDelete(Especializacion p) throws Exception{
        String sql="delete from bolsaempleo.Especializacion where nombreEspecializacion='%s'";
        sql = String.format(sql,p.getNombreEspecializacion());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("especializacion no existe");
        }
    }
    
        
      public void EspecializacionAdd(Especializacion p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.Especializacion (nombreAreaTrabajo, nombreEspecializacion, porcentajeEspecializacion) "+
                "values(?, ?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString(1, p.getNombresAreaTrabajo());
        preparedStmt.setString(2, p.getNombreEspecializacion());
        preparedStmt.setInt(3, p.getProcentajeEspecializacion());
      
        
      
       preparedStmt.execute();
       
    }
      
      
         public List<Especializacion> EspecializacionGet(String p) throws Exception{
        
        
        
           db.getConnection();
        List<Especializacion> estados=new ArrayList<>();
        try {
           
            String sql="select especializacion.nombreAreaTrabajo, especializacion.nombreEspecializacion, especializacion.porcentajeEspecializacion, especializacion.idespecializacion from "+
                    "  especializacion "+
                    "where especializacion.nombreareatrabajo ='%s'";
            sql = String.format(sql,p);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(especializacion(rs));
            }
        } catch (SQLException ex) { }
        return estados;    
        
        
    }
         
     
         
         
         
         
         
         
             public Especializacion EspecializacionGetId(String p) throws Exception{
        
        
        
           db.getConnection();
        Especializacion estados=new Especializacion();
        try {
           
            String sql="select * from "+
                    "  especializacion "+
                    "where especializacion.nombreEspecializacion ='%s'";
            sql = String.format(sql,p);
            ResultSet rs =  db.executeQuery(sql);
            if (rs.next()) {
            return especializacion(rs);
        }
        } catch (SQLException ex) { }
        return estados;    
        
        
    }
         
        
            public List<Especializacion> EspecializacionGetAll(){
                
                  db.getConnection();
       List<Especializacion> estados=new ArrayList<>();
        try {
            String sql="select * from Especializacion";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(especializacion(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
            
            
      /*****************************************************************/
            
            
                 private EspecializacionIncluidaOferente EspecializacionIncluidaOferente(ResultSet rs){
        try {
            EspecializacionIncluidaOferente ec= new EspecializacionIncluidaOferente();
          
                ec.setCedulaOferente(rs.getString("cedulaOferente"));
                ec.setIdespecializacion(rs.getInt("idespecializacion"));
                ec.setPorcentajeEspecializacion(rs.getInt("porcentajeEspecializacion"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
                 
                            private EspecializacionIncluidaOferente EspecializacionIncluidaOferente1(ResultSet rs){
        try {
            EspecializacionIncluidaOferente ec= new EspecializacionIncluidaOferente();
          
                ec.setPorcentajeEspecializacion(rs.getInt("porcentajeEspecializacion"));
                ec.setNombreEspecializacion(rs.getString("nombreEspecializacion"));
                ec.setIdespecializacion(rs.getInt("idespecializacion"));
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
                 
                 
                  public void EspecializacionIncluidaOferenteAdd(EspecializacionIncluidaOferente p) throws Exception{
           
            
         
          System.out.println("en oferenteAdd");
        
          String sql="insert into bolsaempleo.ESPECIALIZACION_INCLUIDASOFERENTE (cedulaOferente, idespecializacion, porcentajeEspecializacion) "+
                "values(?, ?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString(1, p.getCedulaOferente());
        preparedStmt.setInt(2, p.getIdespecializacion());
        preparedStmt.setInt(3, p.getPorcentajeEspecializacion());
        
      
      preparedStmt.execute();
      
      }
                 
            
                     public List<EspecializacionIncluidaOferente> caracteristicasPorcentaje(String a){
                System.out.println("DESDE DAO a: " + a);
              db.getConnection();    
        List<EspecializacionIncluidaOferente> estados=new ArrayList<>();
        try {
            String sql="select especializacion_incluidasoferente.porcentajeespecializacion, especializacion.nombreEspecializacion  , especializacion_incluidasoferente.idespecializacion "
                    + " from especializacion, especializacion_incluidasoferente "
                    + " where especializacion.idespecializacion = especializacion_incluidasoferente.idespecializacion and especializacion_incluidasoferente.cedulaoferente = '%s'";
             sql = String.format(sql, a);
             System.out.println("SQL " + sql);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(EspecializacionIncluidaOferente1(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
                  
            
            
    
     /*******************************************************************/
            
                 
              private EspecializacionIncluida EspecializacionIncluida(ResultSet rs){
        try {
            EspecializacionIncluida ec= new EspecializacionIncluida();
          
                ec.setIdPuesto(rs.getInt("idPuesto"));
                 ec.setIdEmp(rs.getInt("idEmp"));
                ec.setIdespecializacion(rs.getInt("idespecializacion"));
                ec.setPorcentajeEspecializacion(rs.getInt("porcentajeEspecializacion"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
              
              
                  private EspecializacionIncluida EspecializacionIncluida1(ResultSet rs){
        try {
            EspecializacionIncluida ec= new EspecializacionIncluida();
          
                ec.setNombreEspecializacion(rs.getString("nombreEspecializacion"));
                ec.setPorcentajeEspecializacion(rs.getInt("porcentajeEspecializacion"));
                
               
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
                  
                  
            public List<EspecializacionIncluida> EspecializacionIncluidaGetNP(String p , String ip) throws Exception{
        
                System.out.println("DAO " + " p " + p + " ip" + ip );
        
        
           db.getConnection();
        List<EspecializacionIncluida> estados=new ArrayList<>();
        try {
           
            String sql="select especializacion.nombreespecializacion, especializacion_incluidas.porcentajeespecializacion  "+
                    "   from especializacion, especializacion_incluidas "+
                    "where  especializacion.idespecializacion= especializacion_incluidas.idespecializacion "
                    + " and especializacion_incluidas.idemp ='%s' and especializacion_incluidas.idPuesto ='%s' ;";
            sql = String.format(sql,p ,ip);
           System.out.println(sql);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                System.out.println("AGREGA ESPECIALIZACION");
                estados.add(EspecializacionIncluida1(rs));
            }
        } catch (SQLException ex) { }
        return estados;    
        
        
    }         
                  
     
        
              
              
                 public void EspecializacionIncluidaDelete(EspecializacionIncluida p) throws Exception{
        String sql="delete from bolsaempleo.ESPECIALIZACION_INCLUIDAS where idespecializacion='%s'";
        sql = String.format(sql,p.getIdespecializacion());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("especializacion no existe");
        }
    }
    
        
      public void EspecializacionIncluidaAdd(EspecializacionIncluida p) throws Exception{
           
            
         
          System.out.println("en oferenteAdd");
        
          String sql="insert into bolsaempleo.ESPECIALIZACION_INCLUIDAS (idPuesto, idespecializacion, porcentajeEspecializacion, idEmp) "+
                "values(?, ?, ?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getIdPuesto());
        preparedStmt.setInt(2, p.getIdespecializacion());
        preparedStmt.setInt(3, p.getPorcentajeEspecializacion());
        preparedStmt.setInt(4, p.getIdEmp());
      
      preparedStmt.execute();
      
      }
       
    

      
         public List<EspecializacionIncluida> EspecializacionIncluidaGet(EspecializacionIncluida p) throws Exception{
        
        
        
           db.getConnection();
        List<EspecializacionIncluida> estados=new ArrayList<>();
        try {
           
            String sql="select ESPECIALIZACION_INCLUIDAS.idPuesto, ESPECIALIZACION_INCLUIDAS.idespecializacion from "+
                    "  ESPECIALIZACION_INCLUIDAS "+
                    "where ESPECIALIZACION_INCLUIDAS.idPuesto ='%s' and ESPECIALIZACION_INCLUIDAS.idespecializacion='%s'";
            sql = String.format(sql,p.getIdPuesto(), p.getIdespecializacion());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(EspecializacionIncluida(rs));
            }
        } catch (SQLException ex) { }
        return estados;    
        
        
    }
         
         
             public EspecializacionIncluida EspecializacionIncluidaGet1(String a) throws Exception{
            
            
         
            
        db.getConnection();    
        String sql="select * from especializacion_incluidas where idPuesto='%s'";
        sql = String.format(sql, a);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return EspecializacionIncluida(rs);
        }
        else{
            throw new Exception ("Empresa no Existe");
            
        }
    }
         
         
         
              public List<EspecializacionIncluida> EspecializacionIdPuesto(String cl[] , String por[] , String lat, String lon, String rad) throws Exception{
        
        EspecializacionIncluida esin = new EspecializacionIncluida();
        
        double lonaux = Double.valueOf(lon);
        double lo = lonaux - 0.030;
       lonaux = lonaux + 0.030;
       
       double lataux = Double.valueOf(lat);
       double la = lataux - 0.20;
       
       
       lataux = lataux + 0.20;
        
       double radi = Integer.valueOf(rad);
       
    // radi = radi * 1.5;
       
       System.out.println("Latitud a " + lat);
        System.out.println("Longitud " + lon);
        
           db.getConnection();
        List<EspecializacionIncluida> estados = new ArrayList<>();
        try {
           
            
            if(por.length > 0){
            
                System.out.println("porcentaje vacio");
                
              List<Empresa> listEmp = model.instance().getAllEmpresa();
                
                 for(int i=0; i<cl.length; i++){
          /*  String sql="select ESPECIALIZACION_INCLUIDAS.idPuesto, ESPECIALIZACION_INCLUIDAS.idespecializacion, ESPECIALIZACION_INCLUIDAS.porcentajeEspecializacion, ESPECIALIZACION_INCLUIDAS.idEmp  from"+
                    "  ESPECIALIZACION_INCLUIDAS "+
                   
                     "where ESPECIALIZACION_INCLUIDAS.idespecializacion ='%s' and ESPECIALIZACION_INCLUIDAS.porcentajeEspecializacion ='%s'";
          
                    
                     
                     */
          
          
          for(int j = 0 ; j < listEmp.size() ; j++){
          
          String sql="select ESPECIALIZACION_INCLUIDAS.idPuesto, ESPECIALIZACION_INCLUIDAS.idespecializacion, ESPECIALIZACION_INCLUIDAS.porcentajeEspecializacion, ESPECIALIZACION_INCLUIDAS.idEmp, "
                   +
" ROUND(6371*ASIN(SQRT(POWER(SIN((%s - abs(%s)) * pi()/180 / 2), 2) + \n" +
" COS(abs(%s) * pi() / 180) * COS(%s * pi()/180) * POWER(SIN((%s - %s)*pi()/180 / 2),2))) - 10)\n" +
"\n" +
" as 'distance'  from"+
                    "  ESPECIALIZACION_INCLUIDAS , empresa  "+
                    " where ESPECIALIZACION_INCLUIDAS.idEmp = empresa.idEmp and ESPECIALIZACION_INCLUIDAS.idespecializacion ='%s' and ESPECIALIZACION_INCLUIDAS.porcentajeEspecializacion ='%s' " +
                   "  HAVING distance < %s \n" +
"ORDER BY distance;";
          
          System.out.println("SQL SOLO " + sql);
            sql = String.format(sql, lonaux , listEmp.get(j).getLongitud(),  lonaux ,  listEmp.get(j).getLongitud() , lataux, listEmp.get(j).getLatitud(),  cl[i] , por[i]  , radi);
            
            System.out.println(sql);  
            ResultSet rs =  db.executeQuery(sql);
              if (rs.next() == false) {
            esin.setIdEmp(0);
            esin.setIdPuesto(0);
            esin.setIdespecializacion(0);
            esin.setPorcentajeEspecializacion(0);
                
            estados.add(esin);
            } else {
                
                do{
                
                    estados.add(EspecializacionIncluida(rs));
                
                }while(rs.next());
                
            }}}
     
        return estados;    
                

            
            } else {
            
            for(int i=0; i<cl.length; i++){
            String sql="select ESPECIALIZACION_INCLUIDAS.idPuesto, ESPECIALIZACION_INCLUIDAS.idespecializacion, ESPECIALIZACION_INCLUIDAS.porcentajeEspecializacion, ESPECIALIZACION_INCLUIDAS.idEmp  from"+
                    "  ESPECIALIZACION_INCLUIDAS "+
                    "where ESPECIALIZACION_INCLUIDAS.idespecializacion ='%s' and ESPECIALIZACION_INCLUIDAS.porcentajeEspecializacion ='%s'";
            
            
            sql = String.format(sql,cl[i] , por[i]);
            ResultSet rs =  db.executeQuery(sql);
              if (rs.next() == false) {
            esin.setIdEmp(0);
            esin.setIdPuesto(0);
            esin.setIdespecializacion(0);
            esin.setPorcentajeEspecializacion(0);
                
            estados.add(esin);
            } else {
                
                do{
                
                    estados.add(EspecializacionIncluida(rs));
                
                }while(rs.next());
                
            }}
        }} catch (SQLException ex) { }
        return estados;    
        
        
    }
              
              
                   public List<EspecializacionIncluidaOferente> EspecializacionIdOferente(String cl[], String por[]) throws Exception{
        
        EspecializacionIncluidaOferente eio = new EspecializacionIncluidaOferente();
        
           db.getConnection();
        List<EspecializacionIncluidaOferente> estados = new ArrayList<>();
        try {
           
            for(int i=0; i<cl.length; i++){
            String sql="select distinct ESPECIALIZACION_INCLUIDASOFERENTE.CEDULAOFERENTE, ESPECIALIZACION_INCLUIDASOFERENTE.idespecializacion, ESPECIALIZACION_INCLUIDASOFERENTE.porcentajeEspecializacion  from"+
                    "  ESPECIALIZACION_INCLUIDASOFERENTE "+
                    "where ESPECIALIZACION_INCLUIDASOFERENTE.idespecializacion ='%s' and ESPECIALIZACION_INCLUIDASOFERENTE.porcentajeespecializacion ='%s'  ";
            sql = String.format(sql,cl[i], por[i]);
            ResultSet rs =  db.executeQuery(sql);
            
         /*   if(rs.next() == false){
            
            eio.setCedulaOferente("00");
            eio.setIdespecializacion(00);
            eio.setPorcentajeEspecializacion(00);
                
            estados.add(eio);
            
            }
            
            while (rs.next()) {
                estados.add(EspecializacionIncluidaOferente(rs));
            }*/
            
            if (rs.next() == false) {
            eio.setCedulaOferente("00");
            eio.setIdespecializacion(00);
            eio.setPorcentajeEspecializacion(00);
                
            estados.add(eio);
            } else {
                
                do{
                
                    estados.add(EspecializacionIncluidaOferente(rs));
                
                }while(rs.next());
                
            }}
        } catch (SQLException ex) { }
        return estados;    
        
        
    } 
              
              
              
              
              
       public List<Puestos> EspecializacionToGetPuesto(List<EspecializacionIncluida> ei) throws Exception{
        
        
        
           db.getConnection();
        List<Puestos> estados = new ArrayList<>();
        
        try {
           
            
            for(int i=0; i<ei.size(); i++){
            String sql="select puestos.nombrePuesto, puestos.salario, puestos.descripcionPuesto, puestos.estado, puestos.idPuesto from"+
                    "  puestos "+
                    "where puestos.idPuesto  ='%s'";
            sql = String.format(sql,ei.get(i).getIdPuesto());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(puestos(rs));
            }}
        } catch (SQLException ex) { }
        return estados;    
        
        
    }
              
         
      public List<Puestos> EspecializacionToGetPuesto1(List<EspecializacionIncluida> ei) throws Exception{
        
        
        
           db.getConnection();
           
      
           
        List<Puestos> estados = new ArrayList<>();
        
        List<String> ls = new ArrayList<>();
        
        List<String> pues = new ArrayList<>();
        
        
        for(int i = 0 ; i < ei.size(); i++){
        
            ls.add(String.valueOf(ei.get(i).getIdespecializacion()));
        
            
        }
        
        long cantidadEspecializaciones = ls.stream().distinct().count();
        
        System.out.println("cantidad especializaciones  " + cantidadEspecializaciones );
        
       
        
        int idpues = ei.get(0).getIdPuesto();
        
         System.out.println("idpues " + idpues );
        
        
        int cont = 0;
        
        for(int i = 0 ; i < ei.size(); i++){
            
            idpues = ei.get(i).getIdPuesto();
            cont = 0;
       
            for(int j = i ; j < ei.size() ; j++){
            
                System.out.println("idpues == ei.get(j).getIdPuesto() " + idpues + " " + ei.get(j).getIdPuesto());

                if(idpues == ei.get(j).getIdPuesto()){
              
                    cont++;
                 
                    System.out.println("aumenta contador " + cont);
                    
                    
                      if(cont == cantidadEspecializaciones){
                 
                System.out.println("cont == cantidadEspecializaciones " + cont + " == " + cantidadEspecializaciones);
                System.out.println("AGREGA " + ei.get(j).getIdPuesto());
                    
                   
                    pues.add(String.valueOf(ei.get(i).getIdPuesto()));
                  
               
                } 
                    
                    
                }
                
                
                
                
                 
            }
            
           
           
        }
        
         try {
           
          
            
            for(int i=0; i<pues.size(); i++){
            String sql="select empresa.latitud, empresa.longitud, empresa.urllogo, puestos.nombrePuesto, puestos.salario, puestos.descripcionPuesto, puestos.estado, puestos.idPuesto from"+
                    "  puestos , empresa, puestos_publicados "+
                    "where puestos.idPuesto  ='%s' and puestos.estado = '1' and puestos.idPuesto = puestos_publicados.idPuesto and empresa.idEmp = puestos_publicados.idEmp ";
            sql = String.format(sql,pues.get(i));
            ResultSet rs =  db.executeQuery(sql);
             while (rs.next()) {
                estados.add(puestos1(rs));
            }}
        }catch (SQLException ex) { }
        return estados;    
        
        
        
        
    }    
       
       
       
       
       public List<Oferente> EspecializacionToGetOferente(List<EspecializacionIncluidaOferente> ei) throws Exception{
        
        
        
           db.getConnection();
           
      
           
        List<Oferente> estados = new ArrayList<>();
        
        List<String> ls = new ArrayList<>();
        
        List<String> pues = new ArrayList<>();
        
        
        for(int i = 0 ; i < ei.size(); i++){
        
            ls.add(String.valueOf(ei.get(i).getIdespecializacion()));
        
            
        }
        
        long cantidadEspecializaciones = ls.stream().distinct().count();
        
        System.out.println("cantidad especializaciones  " + cantidadEspecializaciones );
        
        if(cantidadEspecializaciones > 1){ 
        
        String cedOf = ei.get(0).getCedulaOferente();
        
         System.out.println("cedula oferente " + cedOf );
        
        
        int cont = 0;
        
        for(int i = 0 ; i < ei.size(); i++){
            
            cedOf = ei.get(i).getCedulaOferente();
       
            for(int j = i ; j < ei.size() ; j++){
            
                
                System.out.println("cedOf.equals(ei.get(j).getCedulaOferente) " + cedOf + " " + ei.get(j).getCedulaOferente());
                if(cedOf.equals(ei.get(j).getCedulaOferente())){
                
                    cont++;
                    
                }
                 
            }
            
            System.out.println(" cont == cantidadEspecializaciones " + cont + " == " + cantidadEspecializaciones);
             if(cont == cantidadEspecializaciones){
                    
                    pues.add(ei.get(i).getCedulaOferente());
               
                } else {
                    
                    cedOf = ei.get(i).getCedulaOferente();
                    cont = 0;
               
                }
           
        }
        
         try {
           
             System.out.println("PUESTOS");
             
             for(int i =0 ; i < pues.size() ; i++){
             
                 System.out.println("puesto " + pues.get(i));
             
             }
            
            
            for(int i=0; i<pues.size(); i++){
           String sql="select *from oferente"+
                   " where oferente.cedulaOferente = '%s'";
            sql = String.format(sql,pues.get(i));
            System.out.println("query " + sql);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                
                estados.add(oferente(rs));
            }}
        }catch (SQLException ex) { }
        return estados;    
        
        } else {
        
        
           try {
           
            
            for(int i=0; i<ei.size(); i++){
            String sql="select *from oferente "+
                    " where oferente.cedulaoferente  ='%s'";
            sql = String.format(sql,ei.get(i).getCedulaOferente());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(oferente(rs));
            }}
        } catch (SQLException ex) { }
        return estados;    
        
        
        }
        
        
        
    }    
       
       
         
        
            public List<EspecializacionIncluida> EspecializacionIncluidaGetAll(){
                
                  db.getConnection();
       List<EspecializacionIncluida> estados=new ArrayList<>();
        try {
            String sql="select * from ESPECIALIZACION_INCLUIDAS";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(EspecializacionIncluida(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
            
            
            
            
            
            
            
            
   /*********************************************************************/ 
    private Puestos puestos2(ResultSet rs){
        try {
            Puestos ec= new Puestos();
          
                ec.setDescripcionPuesto(rs.getString("descripcionPuesto"));
                ec.setIdPuesto(rs.getInt("idPuesto"));
                ec.setNombrePuesto(rs.getString("nombrePuesto"));
                ec.setSalario(rs.getFloat("salario"));
                ec.setEstado(rs.getBoolean("estado"));
                ec.setNombreEmpresa(rs.getString("urllogo"));
                
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
            
            
            private Puestos puestos(ResultSet rs){
        try {
            Puestos ec= new Puestos();
          
                ec.setDescripcionPuesto(rs.getString("descripcionPuesto"));
                ec.setIdPuesto(rs.getInt("idPuesto"));
                ec.setNombrePuesto(rs.getString("nombrePuesto"));
                ec.setSalario(rs.getFloat("salario"));
                ec.setEstado(rs.getBoolean("estado"));
                
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    private Puestos puestos1(ResultSet rs){
        try {
            Puestos ec= new Puestos();
          
                ec.setDescripcionPuesto(rs.getString("descripcionPuesto"));
                ec.setIdPuesto(rs.getInt("idPuesto"));
                ec.setNombrePuesto(rs.getString("nombrePuesto"));
                ec.setSalario(rs.getFloat("salario"));
                ec.setEstado(rs.getBoolean("estado"));
                ec.setLatitud(rs.getString("latitud"));
                ec.setLongitud(rs.getString("longitud"));
                ec.setUrlEmpresa(rs.getString("urllogo"));
                
                
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
    
     
              public void PuestosUpdate(Puestos p) throws Exception{
        
                  try
  {
                  db.getConnection();
                  
                   String sql="update puestos set  salario= ? , estado=? "   +
                " where idPuesto=?";
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setFloat(1, p.getSalario());
        preparedStmt.setBoolean (2, p.isEstado());
        preparedStmt.setInt (3, p.getIdPuesto());
       
        preparedStmt.execute();
    
        System.out.println("salario " + p.getSalario());
        System.out.println("estado " + p.isEstado());
        System.out.println("id " + p.getIdPuesto());
        
        sql=String.format(sql,p.getSalario(),p.isEstado(), p.getIdPuesto());
  }   
        catch (SQLException se)
  {
    // log the exception
    throw new Exception("puestos no existe" );
  }
        
    }
              
              
         public void EspecializacionOferenteUpdate(EspecializacionIncluidaOferente p) throws Exception{
        
                  try
  {
                  db.getConnection();
                  
                   String sql="update especializacion_incluidasoferente set porcentajeEspecializacion= ? "   +
                " where cedulaOferente=? and idEspecializacion=?";
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setFloat(1, p.getPorcentajeEspecializacion());
        preparedStmt.setString (2, p.getCedulaOferente());
        preparedStmt.setInt (3, p.getIdespecializacion());
        
       
        preparedStmt.execute();
    
     //   System.out.println("salario " + p.getSalario());
       // System.out.println("estado " + p.isEstado());
       // System.out.println("id " + p.getIdPuesto());
        
       // sql=String.format(sql,p.getSalario(),p.isEstado(), p.getIdPuesto());
  }   
        catch (SQLException se)
  {
    // log the exception
    throw new Exception("puestos no existe" );
  }
        
    }          
              
              
              
              
              
                 public void PuestosDelete(String p) throws Exception{
        String sql="update bolsaempleo.puestos set puestos.estado='3' where idPuesto='%s'";
        sql = String.format(sql, p );
        
        System.out.println("PUESTO DELETE " + sql);
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("puesto no existe");
        }
    }
    
        
      public void PuestosAdd(Puestos p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert ignore into bolsaempleo.puestos (nombrePuesto , salario , descripcionPuesto , estado ) "+
                "values(? ,? ,? ,?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString(1, p.getNombrePuesto());
        preparedStmt.setFloat (2, p.getSalario());
        preparedStmt.setString (3, p.getDescripcionPuesto());
        preparedStmt.setBoolean(4, p.isEstado());
      
       preparedStmt.execute();
       
    }
      
      
   
      
        public Puestos PuestosGet(Puestos p) throws Exception{
            
            System.out.println("DESDE PUESTOS GET");
            System.out.println("PUESTO id " + p.getIdPuesto() );
           System.out.println("PUESTO nombre " + p.getNombrePuesto() );
         System.out.println("PUESTO descripcion " + p.getDescripcionPuesto() );


            
             db.getConnection();
        String sql="select * from puestos where nombrePuesto='%s' and descripcionPuesto='%s'";
        sql = String.format(sql, p.getNombrePuesto(),p.getDescripcionPuesto());
        ResultSet rs =  db.executeQuery(sql);
          if (rs.next() == false) {
              
                     float a = (float) 0.000;
                        Puestos pe = new Puestos();
                        pe.setNombrePuesto("v");
                        pe.setDescripcionPuesto("");
       
                         pe.setEstado(false);
                        pe.setIdPuesto(0);
                        pe.setSalario(a);
            return pe;
            
            } else {
                
                do{
                    
                    return puestos(rs);
                
                
                }while(rs.next());
                
            }
        
     
    }
        
        
        
         public Puestos PuestosGetByID(EspecializacionIncluida p) throws Exception{
            
             db.getConnection();
        String sql="select * from puestos where idPuesto='%s'";
        sql = String.format(sql, p.getIdPuesto());
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return puestos(rs);
        }
        else{
           float a = (float) 0.000;
                        Puestos pe = new Puestos();
                        pe.setNombrePuesto("v");
                        pe.setDescripcionPuesto("");
                        pe.setEstado(false);
                        pe.setIdPuesto(0);
                        pe.setSalario(a);
            return pe;
            
        }
    }
        
        
        
            public List<Puestos> PuestosGetAll(){
                
                
             
                
                
              db.getConnection();    
        List<Puestos> estados=new ArrayList<>();
        try {
            String sql="select puestos.descripcionPuesto, puestos.idPuesto, puestos.nombrePuesto, puestos.salario, puestos.estado, empresa.urllogo from puestos,\n" +
"empresa, puestos_publicados where puestos.idPuesto = puestos_publicados.idPuesto and empresa.idEmp = puestos_publicados.idEmp  and \n" +
"puestos.estado = 1 order by puestos.idpuesto desc limit 5;";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(puestos2(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
             public List<Puestos> PuestosGetAll1(String a){
                
              db.getConnection();    
        List<Puestos> estados=new ArrayList<>();
        try {
            String sql="select distinct * from puestos inner join puestos_publicados where puestos.idpuesto "
                    + " = puestos_publicados.idpuesto and puestos_publicados.idemp = '%s'";
             sql = String.format(sql, a);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(puestos(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
    
    
    
    /***********************************************************************/
     
     private Empresa empresa(ResultSet rs){
         
         
      
         
         
        try {
            Empresa ec= new Empresa();
          
                ec.setCorreoEmp(rs.getString("correoEmp"));
                ec.setDescripcionEmp(rs.getString("descripcionEmp"));
                ec.setFechaRegistro(rs.getDate("fechaRegistro"));
                ec.setNombreEmp(rs.getString("nombreEmp"));
                ec.setTelefono(rs.getString("telefonoEmp"));
                ec.setClave(rs.getString("clave"));
                ec.setLatitud(rs.getString("latitud"));
                ec.setLongitud(rs.getString("longitud"));
                ec.setIdEmp(rs.getInt("idEmp"));
                ec.setEstado(rs.getBoolean("estado"));
                ec.setUrlllogo(rs.getString("urllogo"));
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
     
              public void EmpresaUpdate(Empresa p) throws Exception{
        String sql="update bolsaempleo.empresa set clave='%s', nombreEmp='%s', telefonoEmp='%s' , latitud='%s', longitud='%s', descripcionEmp='%s', correoEmp='%s'"   +
                "where idEmp='%s'";
        sql=String.format(sql,p.getClave(), p.getNombreEmp(),
                p.getTelefono(),p.getLatitud(),p.getLongitud(), p.getDescripcionEmp(),p.getCorreoEmp(), p.getIdEmp());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("empresa no existe");
        }
    }
              
              
                 public void EmpresaDelete(Empresa p) throws Exception{
        String sql="delete from bolsaempleo.empresa where idEmp='%s'";
        sql = String.format(sql,p.getIdEmp());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("empresa no existe");
        }
    }
    
        
      public void EmpresaAdd(Empresa p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.empresa (clave, nombreEmp , latitud , longitud, descripcionEmp, correoEmp, telefonoEmp, estado ) "+
                "values(?, ? ,? ,? ,? ,? ,?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        
        preparedStmt.setString(1, p.getClave());
        preparedStmt.setString(2, p.getNombreEmp());
        
        preparedStmt.setString (3, p.getLatitud());
        preparedStmt.setString (4, p.getLongitud());
        preparedStmt.setString (5, p.getDescripcionEmp());
        preparedStmt.setString (6, p.getCorreoEmp());
        preparedStmt.setString (7, p.getTelefono());
        preparedStmt.setBoolean(8, false);
        
        
                
      
       preparedStmt.execute();
       
    }
      
      
        public Empresa EmpresaGet(Empresa emp) throws Exception{
            
            
            /*    db.getConnection();
          String sql="select * from oferente where correoOferente='%s'";
        sql = String.format(sql, of.getCorreoOferente());
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            System.out.println("retorna oferente");
            return oferente(rs);
        }
        else{
            throw new Exception ("Oferente no Existe");
            
        }*/
            
        db.getConnection();    
        String sql="select * from empresa where correoEmp='%s' and clave = '%s' and estado = '1'";
        sql = String.format(sql, emp.getCorreoEmp(), emp.getClave());
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return empresa(rs);
        }
        else{
            throw new Exception ("Empresa no Existe");
            
        }
    }
        
        
        
        public Empresa EmpresaGet1(String a) throws Exception{
            
            
         
            
        db.getConnection();    
        String sql="select ignore * from empresa where idEmp='%s'";
        sql = String.format(sql, a);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return empresa(rs);
        }
        else{
            throw new Exception ("Empresa no Existe");
            
        }
    }
        
        
          public void OferenteActivar(String a) throws Exception{
           
       db.getConnection();    
        String sql="update oferente set oferente.estado = '1' where cedulaOferente='%s'";
        sql = String.format(sql, a);
        
        System.out.println("Oferente ACTIVAR " + sql);
        
           int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("no se pudo activar oferente");
        }
    }
        
        
        
        public void EmpresaActivar(String a) throws Exception{
           
       db.getConnection();    
        String sql="update empresa set empresa.estado = '1' where idEmp='%s'";
        sql = String.format(sql, a);
        
        System.out.println("EMPRESA ACTIVAR " + sql);
        
           int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("habilidad no existe");
        }
    }
        
        
         public void EmpresaUrl(String a, String url) throws Exception{
            
       db.getConnection();    
        String sql="update empresa set empresa.urllogo = '%s' where idEmp='%s'";
        sql = String.format(sql, url , a);
        
        System.out.println("EMPRESA ACTIVAR " + sql);
        
           int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("habilidad no existe");
        }
    }
        
        
        
        
        
        
        
                public List<Empresa> EmpresaGetAll(){
                    
           db.getConnection();          
        List<Empresa> estados=new ArrayList();
        try {
            String sql="select *from empresa";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(empresa(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
    
     
    
    
    
    /********************************************************************/
    
                public void HabilidadesUpdate(Habilidades p) throws Exception{
        String sql="update bolsaempleo.habilidades set  nombreHabilidad='%s', areaTrabajo='%s' , especializacion='%s'"   +
                "where idHabilidad='%s'";
        sql=String.format(sql,p.getNombreHabilidad(),
                p.getAreaTrabajo(),p.getEspecializacion(), p.getIdHabilidad());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("habilidad no existe");
        }
    }
    
          public void HabilidadesDelete(Habilidades p) throws Exception{
        String sql="delete from bolsaempleo.habilidades where idHabilidad='%s'";
        sql = String.format(sql,p.getIdHabilidad());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Habilidad no existe");
        }
    }
    
      public void HabilidadesAdd(Habilidades p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.habilidades (idHabilidad , nombreHabilidad , areaTrabajo , especializacion ) "+
                "values(? ,? ,? ,?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getIdHabilidad());
        preparedStmt.setString (2, p.getNombreHabilidad());
        preparedStmt.setString (3, p.getAreaTrabajo());
        preparedStmt.setString (4, p.getEspecializacion());
      
       preparedStmt.execute();
       
    }
    
    public Habilidades HabilidadesGet(String codigo) throws Exception{
        
        
        
        String sql="select * from habilidades where idHabilidad='%s'";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return habilidades(rs);
        }
        else{
            throw new Exception ("Habilidad no Existe");
            
        }
    }
    
      public Collection<Habilidades> HabilidadesGetAll(){
        Vector<Habilidades> estados=new Vector<Habilidades>();
        try {
            String sql="select * from habilidades";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(habilidades(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
       
    
    
     private Habilidades habilidades(ResultSet rs){
        try {
            Habilidades ec= new Habilidades();
          
                ec.setAreaTrabajo(rs.getString("areaTrabajo"));
                ec.setEspecializacion(rs.getString("especializacion"));
                ec.setIdHabilidad(rs.getInt("idHabilidad"));
                ec.setNombreHabilidad(rs.getString("nombreHabilidad"));
        
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    /**
     * @param of
     * @return
     * @throws java.lang.Exception *************************************************************************/
    
      public Oferente OferenteGet(Oferente of) throws Exception{
        
          
          db.getConnection();
          String sql="select * from oferente where correoOferente='%s' and clave='%s'  and  estado = '1'";
        sql = String.format(sql, of.getCorreoOferente(), of.getClave());
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            System.out.println("retorna oferente");
            return oferente(rs);
        }
        else{
            throw new Exception ("Oferente no Existe");
            
        }
        
     /*  db.getConnection();
        String sql="select * from "+
                    "oferente of "+
                    "where of.cedulaOferente='%s'";
            sql=String.format(sql,of.getCedulaOferente());
            ResultSet rs =  db.executeQuery(sql);
             rs.next();
            return oferente(rs);
        */
        
        
    }
      
       public List<Oferente> OferenteGetAll(){
           
           db.getConnection();
        List<Oferente> estados=new ArrayList<>();
        try {
            String sql="select * from oferente";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(oferente(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
       
       
        public void OferenteAdd(Oferente p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.oferente (clave, cedulaOferente , nombreOferente , primerApellido , segundoApellido , celular, nacionalidad, correoOferente, ubicacion, estado  ) "+
                "values(?, ? ,? ,? ,? ,?, ?, ?, ?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString (1, p.getClave());
        preparedStmt.setString (2, p.getCedulaOferente());
        preparedStmt.setString (3, p.getNombreOferente());
        preparedStmt.setString (4, p.getPrimerApellido());
        preparedStmt.setString (5, p.getSegundoApellido());
        preparedStmt.setString (6, p.getCelular());
        preparedStmt.setString (7, p.getNacionalidad());
        preparedStmt.setString (8, p.getCorreoOferente());
        preparedStmt.setString (9, p.getUbicacion());
        preparedStmt.setBoolean(10, false);
        
        
      
      
       preparedStmt.execute();
       
    }
        
         public void OferenteDelete(Oferente p) throws Exception{
        String sql="delete from bolsaempleo.oferente where cedulaOferente='%s'";
        sql = String.format(sql,p.getCedulaOferente());
        db.getConnection();
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Oferente no existe");
        }
    }
         
          public void OferenteUpdate(Oferente p) throws Exception{
        String sql="update bolsaempleo.oferente set clave='%s', nombreOferente='%s', primerApellido='%s' , segundoApellido='%s' , celular='%s', nacionalidad='%s' , correoOferente='%s' , ubicacion='%s'"   +
                "where cedulaOferente='%s'";
        sql=String.format(sql, p.getClave(), p.getNombreOferente(),
                p.getPrimerApellido(),p.getSegundoApellido(),p.getCelular() , p.getNacionalidad(), p.getCorreoOferente(), p.getUbicacion(), p.getCedulaOferente());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Oferente no existe");
        }
    }
      
    
      
        private Oferente oferente(ResultSet rs){
        try {
            Oferente ec= new Oferente();
            
         
          
                ec.setCedulaOferente(rs.getString("cedulaOferente"));
                ec.setPrimerApellido(rs.getString("primerApellido"));
                ec.setNombreOferente(rs.getString("nombreOferente"));
                ec.setSegundoApellido(rs.getString("segundoApellido"));
                ec.setNacionalidad(rs.getString("nacionalidad"));
                ec.setCorreoOferente(rs.getString("correoOferente"));
                ec.setUbicacion(rs.getString("ubicacion"));
                ec.setClave(rs.getString("clave"));
                ec.setCelular(rs.getString("celular"));
                ec.setEstado(rs.getBoolean("estado"));
                   
            
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
        
        
     /**********************************************************************/
        
            public Administrador AdministradorGet(Administrador of) throws Exception{
        
          
          db.getConnection();
          String sql="select * from administrador where nombreAdmin='%s'";
        sql = String.format(sql, of.getNombreAdmin());
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            System.out.println("retorna oferente");
            return administrador(rs);
        }
        else{
            throw new Exception ("Administrador no Existe");
            
        }
        
            }
      
       public Collection<Administrador> AdministradorGetAll(){
        Vector<Administrador> estados=new Vector<Administrador>();
        try {
            String sql="select * from administrador";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(administrador(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
       
       
        public void AdministradorAdd(Administrador p) throws Exception{
           
            
            System.out.println("en oferenteAdd");
        String sql="insert into bolsaempleo.administrador (claveAdministrador, nombreAdmin ) "+
                "values(?, ? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString (1, p.getClave());
        preparedStmt.setString (2, p.getNombreAdmin());
        
        
      
      
       preparedStmt.execute();
       
    }
        
         public void AdministradorDelete(Administrador p) throws Exception{
        String sql="delete from bolsaempleo.administrador where nombreAdministrador='%s'";
        sql = String.format(sql,p.getNombreAdmin());
        db.getConnection();
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
    }
         
          public void AdministradorUpdate(Administrador p) throws Exception{
        String sql="update bolsaempleo.administrador set clave='%s'"   +
                "where nombreAdministrador='%s'";
        sql=String.format(sql, p.getClave());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
    }
      
    
      
        private Administrador administrador(ResultSet rs){
        try {
            Administrador ec= new Administrador();
          
                ec.setClave(rs.getString("claveAdministrador"));
                ec.setNombreAdmin(rs.getString("nombreAdmin"));
              
                   
            
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
        
        
        
        
        
        
        
        
        
        
        
  /*************************************************************************************************************************/      
        
         public Servicios ServicioGet(String codigo) throws Exception{
        String sql="select * from servicios  where idServicio='%s'";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return servicios(rs);
        }
        else{
            throw new Exception ("Servicio no Existe");
            
        }
    }
         
         
         public Collection<Servicios> ServiciosGetAll(){
        Vector<Servicios> estados=new Vector<Servicios>();
        try {
            String sql="select * from servicios";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                estados.add(servicios(rs));
            }
        } catch (SQLException ex) { }
        return estados;        
    }
         
         
            public void ServiciosAdd(Servicios p) throws Exception{
           
            
            System.out.println("en ServiciosAdd");
        String sql="insert into bolsaempleo.servicios (idServicio , nombreServicio , salarioEsperado , descripcionDescripcion ) "+
                "values(? ,? ,? ,? )";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setInt(1, p.getIdServicio());
        preparedStmt.setString (2, p.getNombreServicio());
        preparedStmt.setFloat(3, p.getSalarioEsperado());
        preparedStmt.setString (4, p.getDescripcionDescripcion());
      
        
      
      
       preparedStmt.execute();
       
    }
            
            
                public void ServiciosDelete(Servicios p) throws Exception{
        String sql="delete from bolsaempleo.servicios where idServicio='%s'";
        sql = String.format(sql,p.getIdServicio());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Servicio no existe");
        }
    }
                
                 public void ServiciosUpdate(Servicios p) throws Exception{
        String sql="update bolsaempleo.servicios set  nombreServicio='%s' , salarioEsperado='%s' , descripcionDescripcion='%s'"   +
                "where idServicio='%s'";
        sql=String.format(sql,p.getNombreServicio(),
                p.getSalarioEsperado(),p.getDescripcionDescripcion(), p.getIdServicio());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Servicio no existe");
        }
    }
      
        
          private Servicios servicios(ResultSet rs){
        try {
            Servicios ec= new Servicios();
          
                ec.setDescripcionDescripcion(rs.getString("descripcion"));
                ec.setNombreServicio(rs.getString("nombreServicio"));
                ec.setSalarioEsperado(rs.getFloat("salarioEsperado"));
                ec.setIdServicio(rs.getInt("idServicio"));
               
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
      
    
    
}
