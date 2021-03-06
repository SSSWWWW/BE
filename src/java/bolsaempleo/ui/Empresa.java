/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsaempleo.ui;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import entidades.AreaTrabajoIncluidas;
import entidades.Caracteristicas;
import entidades.CaracteristicasIncluidos;
import entidades.Especializacion;
import entidades.EspecializacionIncluida;
import entidades.EspecializacionIncluidaOferente;
import entidades.Oferente;
import entidades.Puestos;
import entidades.PuestosPublicados;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
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
    "/listarCaracteristicas", "/agregarPuesto" , "/listarPuestosEmp" , "/listarPuestosEmp1"     ,"/editarpuesto", "/listarPuestosNP" , "/deletePuesto" , "/subirUrl" , "/buscarOf" , "/agregarCar"})
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
            
            
            case "/agregarCar":
            this.doagregarCar(request,response);
            break; 
            
            
            
            case "/listarPuestosEmp":
            this.dolistarPuestosEmp(request,response);
            break; 
            
            
             case "/listarPuestosEmp1":
            this.dolistarPuestosEmp1(request,response);
            break; 
            
             case "/editarpuesto":
            this.doeditarpuesto(request,response);
            break; 
            
            
            case "/listarPuestosNP":
            this.dolistarPuestosNP(request,response);
            break; 
            
             case "/deletePuesto":
            this.dodeletePuesto(request,response);
            break; 
            
            
              case "/subirUrl":
            this.dosubirUrl(request,response);
            break; 
            
            case "/buscarOf":
            this.buscarOf(request,response);
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
	request.getRequestDispatcher("principal.jsp").
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
	request.getRequestDispatcher("principal.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("registroempresa.jsp").forward( request, response);
                System.out.println(error);
                
          }
        
        
        }
    
    
            
            
   protected void doagregarCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{
                 System.out.println("en do Login");
        
//<editor-fold defaultstate="collapsed" desc="...">
        
        String ideem = request.getParameter("idEmp");
        String idepuesto = request.getParameter("idpues");
        String idesp = request.getParameter("caracteristicas");
        String porcen = request.getParameter("porcentaje");
        
        int idem = Integer.parseInt(ideem);
        int ip = Integer.parseInt(idepuesto);
        int iesp = Integer.parseInt(idesp);
        int por = Integer.parseInt(porcen);
        

        EspecializacionIncluida esi = new EspecializacionIncluida();
        
  
        esi.setIdEmp(idem);
        esi.setIdPuesto(ip);
        esi.setIdespecializacion(iesp);
        esi.setPorcentajeEspecializacion(por);


        model.instance().addEspecializacionIncluida(esi);
        
	request.getRequestDispatcher("datosEmpresa.jsp").
                forward( request, response);
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
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
       
       
       
       
       
           protected void buscarOf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
             System.out.println("AFUERA NP");
             
           try{
               
           
               
               System.out.println("ADENTRO NP");
               
               String puesto = request.getParameter("puestoA");
               
               System.out.println("IDPUESTO : " + puesto);
               
            
               
                List<EspecializacionIncluida> esppor = model.instance().idEspecializacionIncluida(puesto);
                
                
                
            List<EspecializacionIncluidaOferente> ei = model.instance().getEspecializacionIDOferente1(esppor);
            
            List<Oferente> oferente = model.instance().getOferentePorID(ei);
            response.setContentType("application/json; charset=UTF-8");
             Gson gson=new Gson(); 
            
            Type listType = new TypeToken<ArrayList<Oferente>>(){}.getType();
         
           String json = gson.toJson(oferente);
           
           List<EspecializacionIncluida> espeIn = new Gson().fromJson(json, listType);
                OutputStream outputStream= response.getOutputStream();
                
                
               outputStream.write(gson.toJson(espeIn).getBytes());
              outputStream.flush();
                 
           //  request.setAttribute("listarPuestosNP", ei);
             //   request.getRequestDispatcher("principal.jsp").forward( request, response);
             
             
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }		
	}  
       
       
       
       
       
       
       
         protected void dolistarPuestosNP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
             System.out.println("AFUERA NP");
             
           try{
               
           
               
               System.out.println("ADENTRO NP");
               
               String puesto = request.getParameter("puestoA");
               
               System.out.println("IDPUESTO : " + puesto);
              
               
               
          
        
        System.out.println("---pues 1 " + puesto);
        
      int idp = Integer.valueOf(puesto);
      
      System.out.println("---pues 2 " + idp);
        
      String idpu = String.valueOf(idp);
     
 PuestosPublicados pp = model.instance().getPuestosPublicados(idpu);
              
              int idEmp = pp.getIdEmpresa();
              
              System.out.println("id emp " + idEmp);
          
            
              
              String ie = String.valueOf(idEmp);
             List<EspecializacionIncluida> ei = model.instance().getAllEspecializacionIncluidaNP(ie , idpu );
		 for(EspecializacionIncluida car : ei){
          
               
                System.out.println("nombre especializacion " + car.getNombreEspecializacion());
                System.out.println("porcentaje " + car.getPorcentajeEspecializacion());
               
               }
            response.setContentType("application/json; charset=UTF-8");
             Gson gson=new Gson(); 
            
            Type listType = new TypeToken<ArrayList<EspecializacionIncluida>>(){}.getType();
         
           String json = gson.toJson(ei);
           
           List<EspecializacionIncluida> espeIn = new Gson().fromJson(json, listType);
                OutputStream outputStream= response.getOutputStream();
                
                
               outputStream.write(gson.toJson(espeIn).getBytes());
              outputStream.flush();
                 
           //  request.setAttribute("listarPuestosNP", ei);
             //   request.getRequestDispatcher("principal.jsp").forward( request, response);
             
             
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("principal.jsp").forward( request, response);
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
        
        
      protected void dolistarPuestosEmp1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               String idEmp   = request.getParameter("idEmp");
               
               System.out.println("EN DOLISTAR " + idEmp);
               
                BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Empresa empresaId = gson.fromJson(reader, Empresa.class);
                
        System.out.println("EN DOLISTAR 2 " + empresaId);
        
          System.out.println("ADENTRO NP");
               
               String empI = request.getParameter("empresaA");
               
               System.out.println("EN DOLISTAR 3 : " + empI);
        
                List<Puestos> puestos = model.instance().getAllPuestos1(empI);
				
				 response.setContentType("application/json; charset=UTF-8");
            
            
            Type listType = new TypeToken<ArrayList<Puestos>>(){}.getType();
         
           String json = gson.toJson(puestos);
		   
		     List<Puestos> espeIn = new Gson().fromJson(json, listType);
                OutputStream outputStream= response.getOutputStream();
                
                
               outputStream.write(gson.toJson(espeIn).getBytes());
              outputStream.flush();
				
		
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("Error.jsp").forward( request, response);
          }		
	} 
        
        
         protected void dodeletePuesto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               String idEmp   = request.getParameter("idPues");
                
                model.instance().deletePuestos(idEmp);
                //request.setAttribute("idEmp", puestos);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
		
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }		
	}  
        
        
         
         
         protected void dosubirUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               String idEmp   = request.getParameter("idEmp");
               String url =  request.getParameter("url");
                
                model.instance().subirUrlEmpresa(idEmp, url);
                //request.setAttribute("idEmp", puestos);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
		
          }
          catch(Exception e){
                String error = e.getMessage(); 	
                request.setAttribute("error",error);
                request.getRequestDispatcher("datosEmpresa.jsp").forward( request, response);
          }		
	}  
         
        
        
           protected void doeditarpuesto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           try{
               
               System.out.println("EN EDITAR PUESTO");
                
//<editor-fold defaultstate="collapsed" desc="...">
        String nombrePuesto   = request.getParameter("nombPues");
        String idPuesto = request.getParameter("idP");
        String descripcionPuesto   = request.getParameter("descri");
        String salarioPuesto   = request.getParameter("salPu");
       
      
        String estado = request.getParameter("estad");
        
     System.out.println("PUESTO EDITAR Nombre " + nombrePuesto + " id : " + idPuesto + " descripcion: " + descripcionPuesto + " salario:  " +salarioPuesto + " estado : "+ estado);

        
       int idpu = Integer.parseInt(idPuesto);
       float salarioPu = Float.parseFloat(salarioPuesto);
       
        
       boolean est = true;
       
       if(estado.equals("true")){
       
           est = true;
       }
       
       if(estado.equals("false")){
       
           est = false;
       }
       
       System.out.println("PUESTO EDITAR " + descripcionPuesto + " " + est + " " + idpu + " " +nombrePuesto + " "+ salarioPu);
       
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

