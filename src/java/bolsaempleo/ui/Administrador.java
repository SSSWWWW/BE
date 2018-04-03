/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import entidades.Area_Trabajo;
import entidades.Caracteristicas;
import entidades.Especializacion;
import entidades.EspecializacionIncluida;
import entidades.Puestos;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Administrador", urlPatterns = { "/LoginAd", "/LogoutAd" , "/agregarAdministrador" , "/agregarCaracteristica" , "/agregarAreaTrabajo", "/agregarEspecialidad", "/listarPuestos" , "/buscarPuestos"})
public class Administrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
    switch(request.getServletPath()){
        case "/LoginAd":
            this.doLogin(request,response);
            break;
        case "/LogoutAd":
            this.doLogout(request,response);
            break;
        case "/agregarAdministrador":
            this.doregistroAdministradorAgregar(request,response);
            break;    
            
        case "/agregarCaracteristica":
            this.doAgregarCaracteristica(request,response);
            break;    
            
        case "/agregarAreaTrabajo":
            this.doAgregarAreaTrabajo(request,response);
            break;    
            
        case "/agregarEspecialidad":
            this.doAgregarEspecialidad(request,response);
            break;    
            
        case "/listarPuestos":
            this.dolistarPuestos(request,response);
            break;  
            
        case "/buscarPuestos":
            this.buscarPuestos(request,response);
            break;     
            
            
    }
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
        
        String nombre   = request.getParameter("caracteristica");
        
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

    protected void doLogin(HttpServletRequest request, 
            
            
        HttpServletResponse response) throws ServletException, IOException {
      try{
          
          System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
String identificacion   = request.getParameter("correoAdmin");
String clave   = request.getParameter("clave");

entidades.Administrador admin = new entidades.Administrador();
admin.setNombreAdmin(identificacion);
admin.setClave(clave);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
       admin = model.instance().getAdministrador(admin);
	s.setAttribute("administrador",admin);
	request.getRequestDispatcher("datosAdministrador.jsp").
                forward( request, response);
      }
      catch(Exception e){	
	request.setAttribute("error","Credenciales incorrectas..");
	request.getRequestDispatcher("Error.jsp").
                forward( request, response);
      }		
    }
    
    
    protected void doregistroAdministradorAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String nombre   = request.getParameter("nombreAdmin");
        
        String contrasena   = request.getParameter("claveAdministrador");
        
        

         entidades.Administrador admin = new entidades.Administrador();
         admin.setClave(contrasena);
         admin.setNombreAdmin(nombre);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addAdministrador(admin);
	s.setAttribute("administrador",admin);
	request.getRequestDispatcher("datosAdministrador.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }
        
        
        }
    
    
     protected void doAgregarCaracteristica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String nombre   = request.getParameter("caracteristica");
        

         Caracteristicas car = new Caracteristicas();
         car.setNombreCaracteristica(nombre);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addCaracteristicas(car);
	s.setAttribute("caracteristicas",car);
	request.getRequestDispatcher("datosAdministrador.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }
        
        
        }
    
     
     
      protected void doAgregarAreaTrabajo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String areatrabajo   = request.getParameter("areatrabajo");
        String caracteristica2   = request.getParameter("caracteristicaenarea");
        

         Area_Trabajo ar = new Area_Trabajo();
         ar.setNombreAreaTrabajo(areatrabajo);
         ar.setNombreCaracteristica(caracteristica2);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addArea_Trabajo(ar);
	s.setAttribute("areatrabajo",ar);
	request.getRequestDispatcher("datosAdministrador.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }
        
        
        }
      
      
      
         protected void doAgregarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="..."> 
        String especialidad   = request.getParameter("especialidad");
        String porcentaje   = request.getParameter("porcentaje");
        String areaEspecialidad   = request.getParameter("areaenespecialidad");
        
       // int porcen = Integer.parseInt(porcentaje);

       int porcen = 0;
       
         Especializacion es = new Especializacion();
         es.setNombreEspecializacion(especialidad);
         es.setNombresAreaTrabajo(areaEspecialidad);
         es.setProcentajeEspecializacion(porcen);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addEspecializacion(es);
	s.setAttribute("especializacion",es);
	request.getRequestDispatcher("datosAdministrador.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }
        
        
        }
         
         protected void dolistarPuestos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
                List<Puestos> puestos = model.instance().getAllPuestos();
		request.setAttribute("listarP", puestos);
                request.getRequestDispatcher("pruebas.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }		
	}  
         
           protected void buscarPuestos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            
            String clrs[] = request.getParameterValues("names");
            
            List<EspecializacionIncluida> ei = model.instance().getEspecializacionIncluidaID(clrs);
            
            List<Puestos> puestos = model.instance().getPuestosPorID(ei);
            
            
		request.setAttribute("buscarPuestos", puestos);
                request.getRequestDispatcher("principal.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("principal.jsp").forward( request, response);
          }		
	}  
         
    
    
    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("principal.jsp").forward( request, response);          
    }    
}
