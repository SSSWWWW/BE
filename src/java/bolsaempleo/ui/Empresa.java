/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import entidades.AreaTrabajoIncluidas;
import entidades.Caracteristicas;
import entidades.CaracteristicasIncluidos;
import entidades.Especializacion;
import entidades.EspecializacionIncluida;
import entidades.Puestos;
import entidades.PuestosPublicados;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.model;

/**
 *
 * @author pc
 */

    @WebServlet(name = "Empresa", urlPatterns = {"/LoginEm", "/LogoutEm" , "/agregarEmpresa" , 
    "/listarCaracteristicas", "/agregarPuesto" , "/listarPuestosEmp" , "/editarpuesto"})
public class Empresa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
    switch(request.getServletPath()){
        case "/LoginEm":
            this.doLogin(request,response);
            break;
        case "/LogoutEm":
            this.doLogout(request,response);
            break;
        case "/agregarEmpresa":
            this.doregistroagregarEmpresa(request,response);
            break;    
            
        case "/listarCaracteristicas":
            this.dolistarCaracteristicas(request,response);
            break;   
            
        case "/agregarPuesto":
            this.doagregarPuesto(request,response);
            break; 
            
            case "/listarPuestosEmp":
            this.dolistarPuestosEmp(request,response);
            break; 
            
             case "/editarpuesto":
            this.doeditarpuesto(request,response);
            break; 
            
            
            
    }
  }

    protected void doLogin(HttpServletRequest request, 
            
            
        HttpServletResponse response) throws ServletException, IOException {
      try{
          
          System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
String identificacion   = request.getParameter("correoEmpresa");
String clave   = request.getParameter("clave");

entidades.Empresa empresa = new entidades.Empresa();
empresa.setCorreoEmp(identificacion);
empresa.setClave(clave);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
       empresa = model.instance().getEmpresa(empresa);
	s.setAttribute("empresa",empresa);
	request.getRequestDispatcher("datosEmpresa.jsp").
                forward( request, response);
      }
      catch(Exception e){	
	request.setAttribute("error","Credenciales incorrectas..");
	request.getRequestDispatcher("Error.jsp").
                forward( request, response);
      }		
    }
    
    
    protected void doregistroagregarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String nombre   = request.getParameter("nombreempresa");
        
        String email   = request.getParameter("email");
        String telefono   = request.getParameter("telefono");
        String descripcion   = request.getParameter("descripcion");
        String contrasena   = request.getParameter("contrasena");
        String latitud   = request.getParameter("latitud");
        String longitud = request.getParameter("longitud");
        

         entidades.Empresa empresa = new entidades.Empresa();
         empresa.setNombreEmp(nombre);
         empresa.setClave(contrasena);
         empresa.setCorreoEmp(email);
         empresa.setDescripcionEmp(descripcion);
         empresa.setTelefono(telefono);
         empresa.setLatitud(latitud);
         empresa.setLongitud(longitud);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addEmpresa(empresa);
	s.setAttribute("empresa",empresa);
	request.getRequestDispatcher("datosEmpresa.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("registroempresa.jsp").forward( request, response);
          }
        
        
        }
    
    
    
   protected void doagregarPuesto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String nombrePuesto   = request.getParameter("nombrePuesto");
        
        String descripcionPuesto   = request.getParameter("descripcionPuesto");
        String salarioPuesto   = request.getParameter("salarioPuesto");
        String nombreempresa =  request.getParameter("nombreempresa");
        String  caracteristica = request.getParameter("aux");
        String  porcentaje = request.getParameter("porcentaje");
        String ide = request.getParameter("id");
        String estado = request.getParameter("estado");
        
        int idem = Integer.parseInt(ide);
        
       boolean est = true;
       
       if(estado.equals("true")){
       
           est = true;
       }
       
       if(estado.equals("false")){
       
           est = false;
       }
               
            
        
        String com = nombreempresa + " - " +descripcionPuesto;
        
     
        
        Especializacion ei = new Especializacion();
        
        
        ei = model.instance().getEspecializacionId(caracteristica);
        int carac = ei.getIdespecializacion();
        
      
       // String areatrabajo = request.getParameter("areatrabajo");
       // int artr = Integer.parseInt(areatrabajo);
       // String especializacion = request.getParameter("especializacion");
        //int esp = Integer.parseInt(especializacion);
        
       float salpu = Float.parseFloat(salarioPuesto);
       int porcen = Integer.parseInt(porcentaje);
        
        Puestos puesto = new Puestos(); 
        
        puesto.setDescripcionPuesto(com);
        puesto.setEstado(est);
        puesto.setNombrePuesto(nombrePuesto);
        puesto.setSalario(salpu);
  
        
        EspecializacionIncluida esi = new EspecializacionIncluida();
        
     
         
        
        
     //   AreaTrabajoIncluidas ati = new AreaTrabajoIncluidas();
     //   ati.setIdareatrabajo(artr);
        
      //  EspecializacionIncluida ei = new EspecializacionIncluida();
     //   ei.setIdespecializacion(esp);
        

//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        Puestos p1 = new Puestos();
        model.instance().addPuestos(puesto);
        p1 = model.instance().getPuestos(puesto);
        int idpues = p1.getIdPuesto();
         esi.setIdespecializacion(carac);
        esi.setPorcentajeEspecializacion(porcen);
        esi.setIdPuesto(idpues);
        esi.setIdEmp(idem);
        //ati.setIdPuesto(idpues);
       // ei.setIdPuesto(idpues);
        model.instance().addEspecializacionIncluida(esi);
        //model.instance().addAreaTrabajoIncluidas(ati);
        //model.instance().addEspecializacionIncluida(ei);
        
        PuestosPublicados pp = new PuestosPublicados();
        pp.setIdEmpresa(idem);
        pp.setEstadoPuesto(est);
        pp.setIdPuestos(idpues);
        
        model.instance().addPuestosPublicados(pp);
        
        
	s.setAttribute("puesto",puesto);
	request.getRequestDispatcher("datosEmpresa.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }
        
        
        }
    
    
    
    
       protected void dolistarCaracteristicas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
                
                List<Caracteristicas> caracteristicas = model.instance().getAllCaracteristicas();
		request.setAttribute("caracteristicasLista",caracteristicas);
                request.getRequestDispatcher("pruebas.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }		
	}  
        
       
        protected void dolistarPuestosEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               String idEmp   = request.getParameter("idEmp");
                
                List<Puestos> puestos = model.instance().getAllPuestos1(idEmp);
		request.setAttribute("puestosListaEmp", puestos);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }		
	}  
        
        
        
           protected void doeditarpuesto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
                
//<editor-fold defaultstate="collapsed" desc="...">
        String nombrePuesto   = request.getParameter("nombrePuesto");
        String idPuesto = request.getParameter("idpu");
        String descripcionPuesto   = request.getParameter("descripcionPuesto");
        String salarioPuesto   = request.getParameter("salarioPuesto");
       
      
        String estado = request.getParameter("estado");
        
       int idpu = Integer.parseInt(idPuesto);
       float salarioPu = Float.parseFloat(salarioPuesto);
       
        
       boolean est = true;
       
       if(estado.equals("true")){
       
           est = true;
       }
       
       if(estado.equals("false")){
       
           est = false;
       }
       
       Puestos puestos = new Puestos();
       
       puestos.setDescripcionPuesto(descripcionPuesto);
       puestos.setEstado(est);
       puestos.setIdPuesto(idpu);
       puestos.setNombrePuesto(nombrePuesto);
       puestos.setSalario(salarioPu);
               
        model.instance().updatePuestos(puestos);
               
               
		request.setAttribute("puestos", puestos);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }		
	}
        
       
          protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("principal.jsp").forward( request, response);          
    }    
       
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String nombrePuesto   = request.getParameter("nombrePuesto");
        
        String descripcionPuesto   = request.getParameter("descripcionPuesto");
        String salarioPuesto   = request.getParameter("salarioPuesto");
        
        String  porcentaje = request.getParameter("porcentaje");
        
        String nombre   = request.getParameter("nombreempresa");
        
        String email   = request.getParameter("email");
        String telefono   = request.getParameter("telefono");
        String descripcion   = request.getParameter("descripcion");
        String contrasena   = request.getParameter("contrasena");
        String latitud   = request.getParameter("latitud");
        String longitud = request.getParameter("longitud");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

