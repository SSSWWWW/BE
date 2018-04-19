/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import entidades.EspecializacionIncluidaOferente;
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

@WebServlet(name = "Oferente", urlPatterns = {"/LoginOf", "/Logout" , "/agregarOferente" , "/agregarCaracteristicaOferente" , "/listarCaracteristicasOferente"})
public class Oferente extends HttpServlet {

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

entidades.Oferente oferente = new entidades.Oferente();
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
	request.getRequestDispatcher("Error.jsp").
                forward( request, response);
      }		
    }
    
    
    
     protected void doagregarCaracteristicaOferente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
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
        
        
        }
    
    protected void doregistroOferenteAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        HttpSession s =  request.getSession( true);
//<editor-fold defaultstate="collapsed" desc="...">
        String nombre   = request.getParameter("nombre");
        String primerapellido   = request.getParameter("primerapellido");
        String segundoapellido   = request.getParameter("segundoapellido");
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
    
    
    
    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("principal.jsp").forward( request, response);          
    }    
}
