<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>


<%@page import="entidades.Especializacion"%>
<%@page import="java.util.Iterator"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="entidades.Caracteristicas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Google Map</title>
        
       
    <body>
        
        
         <script src="js/jquery.js"></script>
        <script>
           
           $(document).ready(function() {

    $('#example tr').click(function() {
        var href = $(this).find("a").attr("href");
        if(href) {
            window.location = href;
        }
    });

});
           
        </script>
        
      
   <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
    
   

   <table class="grid" id="example">
              <caption>Caracteristicas requeridas para puesto</caption>
              
              <tbody style="height: 250px;">
                <% for(Caracteristicas sc : c){ %>
              <input type="radio"> <%= sc.getNombreCaracteristica()%><br>
                        
                        <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                        <% for(Area_Trabajo artr : at){ %>
                <input type="radio" style="margin-left: 9px;"> <%= artr.getNombreAreaTrabajo()  %><br>
                      <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                       <% for(Especializacion esp : es){ %>
                        
                        <input type="radio" style="margin-left: 18px;"> <%= esp.getNombreEspecializacion()  %><br>
                 <% } %>
                                
               <% } %>
               
           <% } %>
               
            </tbody>
            </table>

               
                  
           
                   <script type="text/javascript">

   function changeFunc() {
       
        
    var selectBox = document.getElementById("selectcarac");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    window.location.replace("datosEmpresa.jsp?selectedValue="+selectedValue);
     
  
   }

  </script>
           
  
      <% String carac   = request.getParameter("selectedValue");
         
            List<Area_Trabajo> at = model.instance().getArea_Trabajo(carac); 
         
         %>
           
              <form action="AgregarPuesto" method="post" class="fem">
                      <legend>Agregar nuevo puesto</legend>
           <input class="formfield" type="text" name="nombrePuesto" placeholder="Nombre " required><br>
           <input class="formfield" type="text" name="descripcionPuesto" placeholder="Descripcion" required><br>
           <input class="formfield" type="text" name="salarioPuesto" placeholder="Salario" required><br>
         
           <select name = "selectcarac" id="selectcarac" onchange="changeFunc();">
               <option> </option>
               <% for(Caracteristicas sc : c){ %>
               <option  id="caracf" name="caracf" value="<%= sc.getNombreCaracteristica()%>"> <%= sc.getNombreCaracteristica()%> </option>
           <% } %>
           </select><br>
           
           <select name = "areatrabajo">
             <option disabled selected value> Area </option>
               <% for(Area_Trabajo artr : at){ %>
               <option> <%= artr.getNombreAreaTrabajo() %> </option>
           <% } %>
           </select><br>
           
               
               
    </body>    
</html>