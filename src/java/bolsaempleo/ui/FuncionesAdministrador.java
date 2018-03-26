/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import entidades.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.model;

/**
 *
 * @author Escinf
 */
@WebServlet(name = "LoginAd", urlPatterns = {"/LoginAd", "/LogoutAd" , "/agregarAdministrador"})
public class FuncionesAdministrador extends HttpServlet {
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

Administrador admin = new Administrador();
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
        
        

         Administrador admin = new Administrador();
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
    
    
    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("principal.jsp").forward( request, response);          
    }    
}
