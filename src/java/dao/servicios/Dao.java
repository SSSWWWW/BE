/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicios;

import entidades.Oferente;
import entidades.Servicios;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;




/**
 *
 * @author pc
 */
public class Dao {
    
      RelDatabase db= new RelDatabase();;
    
    public Dao() throws ClassNotFoundException, SQLException, IOException{
        db= new RelDatabase();
        
    }
    
      public Oferente OferenteGet(String codigo) throws Exception{
        String sql="select * from oferente where cedulaOferente='%s'";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return oferente(rs);
        }
        else{
            throw new Exception ("Oferente no Existe");
            
        }
    }
      
       public Collection<Oferente> OferenteGetAll(){
        Vector<Oferente> estados=new Vector<Oferente>();
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
        String sql="insert into bolsaempleo.oferente (cedulaOferente , nombreOferente , primerApellido , segundoApellido , celular, nacionalidad, correoOferente, ubicacion  ) "+
                "values(? ,? ,? ,? ,?, ?, ?, ?)";
        //db.cnx = DriverManager.getConnection("jdbc:mysql://localhost/"+"bolsaempleo" , "root" , "root");
        db.getConnection();
        PreparedStatement preparedStmt = db.cnx.prepareStatement(sql);
        System.out.println("despues de prepared" );
        preparedStmt.setString (1, p.getCedulaOferente());
        preparedStmt.setString (2, p.getNombreOferente());
        preparedStmt.setString (3, p.getPrimerApellido());
        preparedStmt.setString (4, p.getSegundoApellido());
        preparedStmt.setString (5, p.getCelular());
        preparedStmt.setString (6, p.getNacionalidad());
        preparedStmt.setString (7, p.getCorreoOferente());
        preparedStmt.setString (8, p.getUbicacion());
        
      
      
       preparedStmt.execute();
       
    }
        
         public void OferenteDelete(Oferente p) throws Exception{
        String sql="delete from bolsaempleo.oferente where cedulaOferente='%s'";
        sql = String.format(sql,p.getCedulaOferente());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Oferente no existe");
        }
    }
         
          public void OferenteUpdate(Oferente p) throws Exception{
        String sql="update bolsaempleo.oferente set  nombreOferente='%s', primerApellido='%s' , segundoApellido='%s' , celular='%s', nacionalidad='%s' , correoOferente='%s' , ubicacion='%s'"   +
                "where cedulaOferente='%s'";
        sql=String.format(sql,p.getNombreOferente(),
                p.getPrimerApellido(),p.getSegundoApellido(),p.getCelular() , p.getNacionalidad(), p.getCorreoOferente(), p.getUbicacion());
        
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
                p.getSalarioEsperado(),p.getDescripcionDescripcion());
        
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
