/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import entidades.Empresa;
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
@WebServlet(name = "LoginEm", urlPatterns = {"/LoginEm", "/LogoutEm" , "/agregarEmpresa"})
public class FuncionesEmpresa extends HttpServlet {
  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
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
String identificacion   = request.getParameter("correoEmpresa");
String clave   = request.getParameter("clave");

Empresa empresa = new Empresa();
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
        

         Empresa empresa = new Empresa();
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
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }
        
        
        }
    
    
    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("principal.jsp").forward( request, response);          
    }    
}
