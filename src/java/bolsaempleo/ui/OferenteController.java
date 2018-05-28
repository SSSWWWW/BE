/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import entidades.EspecializacionIncluida;

import entidades.EspecializacionIncluidaOferente;
import entidades.Puestos;
import entidades.Oferente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

@WebServlet(name = "Oferente", urlPatterns = {"/LoginOf", "/Logout" , "/agregarOferente" , "/agregarCaracteristicaOferente" , "/listarCaracteristicasOferente" , "/buscarOferente", "/editarespecializacionOf" })
public class OferenteController extends HttpServlet {


      
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
        case "/LoginOf":
            this.doLogin(request,response);
            break;
        case "/Logout":
            this.doLogout(request,response);
            break;
        case "/agregarOferente":
            this.doregistroOferenteAgregar(request,response);
            break; 
            
        case "/agregarCaracteristicaOferente":
            this.doagregarCaracteristicaOferente(request,response);
            break;    
            
        case "/listarCaracteristicasOferente":
            this.dolistarCaracteristicasOferente(request,response);
            break;   
            
        case "/buscarOferente":
            this.dobuscarOferente(request,response);
            break; 
            
         case "/editarespecializacionOf":
            this.doeditarespecializacionOf(request,response);
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
        
        
        String nombre   = request.getParameter("nombre");
        String primerapellido   = request.getParameter("primerapellido");
        String segundoapellido   = request.getParameter("segundoapellido");
        String email   = request.getParameter("email");
        String celular   = request.getParameter("celular");
        String nacionalidad   = request.getParameter("nacionalidad");
        String contrasena   = request.getParameter("contrasena");
        String provincia   = request.getParameter("provincia");
        String cedula = request.getParameter("cedula");
        
        
        
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
String identificacion   = request.getParameter("correoOferente");
String clave   = request.getParameter("clave");

Oferente oferente = new Oferente();
oferente.setCorreoOferente(identificacion);
oferente.setClave(clave);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
       oferente = model.instance().getOferente(oferente);
	s.setAttribute("oferente",oferente);
	request.getRequestDispatcher("datosOferente.jsp").
                forward( request, response);
       
      }
      catch(Exception e){	
	request.setAttribute("error","Credenciales incorrectas..");
	request.getRequestDispatcher("principal.jsp").
                forward( request, response);
      }		
    }
    
    
    
     protected void doagregarCaracteristicaOferente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
         
         
         try{
           
  
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        EspecializacionIncluidaOferente espOf = gson.fromJson(reader, EspecializacionIncluidaOferente.class);
        PrintWriter out = response.getWriter();
         model.instance().addEspecializacionIncluidaOferente(espOf);
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(espOf));        
       response.setStatus(200); // ok with cont
      }
      catch(Exception e){	
        response.setStatus(401); //Bad request
    
  
    
      }
         
/*         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String caracteristicas   = request.getParameter("caracteristicas");
        String porcentaje   = request.getParameter("porcentaje");
        String cedulaOferente   = request.getParameter("cedulaOferente");
        
        int porcen = Integer.valueOf(porcentaje);
        int carac = Integer.valueOf(caracteristicas);
        
        entidades.EspecializacionIncluidaOferente oferenteCarac = new EspecializacionIncluidaOferente();
        
        oferenteCarac.setCedulaOferente(cedulaOferente);
        oferenteCarac.setIdespecializacion(carac);
        oferenteCarac.setPorcentajeEspecializacion(porcen);
        
        oferenteCarac.setCedulaOferente(cedulaOferente);

      
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addEspecializacionIncluidaOferente(oferenteCarac);
	s.setAttribute("oferenteCarac",oferenteCarac);
	request.getRequestDispatcher("datosOferente.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosOferente.jsp").forward( request, response);
          }
        
*/
        
        }
     
     
     
     protected void doeditarespecializacionOf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 
//<editor-fold defaultstate="collapsed" desc="...">
        String caracteristicas   = request.getParameter("carac");
        String porcentaje   = request.getParameter("porcen");
        String cedulaOferente   = request.getParameter("ced");
        
        int porcen = Integer.valueOf(porcentaje);
        int carac = Integer.valueOf(caracteristicas);
        
        EspecializacionIncluidaOferente oferenteCarac = new EspecializacionIncluidaOferente();
        
        oferenteCarac.setCedulaOferente(cedulaOferente);
        oferenteCarac.setIdespecializacion(carac);
        oferenteCarac.setPorcentajeEspecializacion(porcen);
        
        oferenteCarac.setCedulaOferente(cedulaOferente);

      
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().EspecializacionOferenteUpdate(oferenteCarac);
               
               
		request.setAttribute("oferenteCarac", oferenteCarac);
                request.getRequestDispatcher("datosOferente.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosOferente.jsp").forward( request, response);
          }
        
        
        }
     
    
    protected void doregistroOferenteAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         
           try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String nombre   = request.getParameter("nombre");
        String primerapellido   = request.getParameter("primerapellido");
        String segundoapellido   = request.getParameter("segundopellido");
        String email   = request.getParameter("email");
        String celular   = request.getParameter("celular");
        String nacionalidad   = request.getParameter("nacionalidad");
        String contrasena   = request.getParameter("contrasena");
        String provincia   = request.getParameter("provincia");
        String cedula = request.getParameter("cedula");
        

        entidades.Oferente oferente = new entidades.Oferente();
         oferente.setCedulaOferente(cedula);
         oferente.setCelular(celular);
         oferente.setClave(contrasena);
         oferente.setCorreoOferente(email);
         oferente.setNacionalidad(nacionalidad);
         oferente.setNombreOferente(nombre);
         oferente.setPrimerApellido(primerapellido);
         oferente.setSegundoApellido(segundoapellido);
         oferente.setUbicacion(provincia);
//oferente.setCedulaOferente("554533243");
//oferente.setClave("sss");
//</editor-fold>
        model.instance().addOferente(oferente);
	s.setAttribute("oferente",oferente);
	request.getRequestDispatcher("datosOferente.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("registrooferente.jsp").forward( request, response);
          }
        
        
        }
    
    
    
      protected void dolistarCaracteristicasOferente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               String idEmp   = request.getParameter("cedula");
                
                List<EspecializacionIncluidaOferente> puestos = model.instance().getespecializacionyPorcentaje(idEmp);
		request.setAttribute("listarCaracteristicasOferente", puestos);
                request.getRequestDispatcher("datosOferente.jsp").forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }		
	}  
    
      
          protected void dobuscarOferente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               String clrs[] = request.getParameterValues("names");
               
               String porcen[] = request.getParameterValues("porcentaje"); 
            
            List<EspecializacionIncluidaOferente> ei = model.instance().getEspecializacionIDOferente(clrs, porcen);
            
            List<Oferente> oferente = model.instance().getOferentePorID(ei);
            
            
            
            
		request.setAttribute("buscarOferente", oferente);
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
}
