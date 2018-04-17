<%-- 
    Document   : datosOferente
    Created on : Mar 21, 2018, 9:37:00 AM
    Author     : pc
--%>

<%@page import="entidades.Especializacion"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Caracteristicas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entidades.Oferente" %>
<!DOCTYPE html>
<html>
<head>
 <title>Oferente</title>
 <link href="css/registrooferente.css" rel="stylesheet" type="text/css"/>  
</head>
<body>
<jsp:useBean id="oferente" scope="session" type="Oferente" />
<div class = "datOf" >
    
    <div class="area" >   
    <table class="grid">
        <caption>Oferente</caption>
        
        <tr><td><%=oferente.getNombreOferente()%> <%=oferente.getPrimerApellido() %></td></tr><br><br>
        <tr><td><%=oferente.getCedulaOferente()%></td></tr>
        <tr><td><%=oferente.getCorreoOferente() %></td></tr>
        <tr><td><%=oferente.getCelular() %></td></tr>
        <tr><td><%=oferente.getNacionalidad() %></td></tr>
        <tr><td><%=oferente.getUbicacion() %></td></tr>
        
        
         <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
        
       <br>  
        
            
    </table>
    <br>
  
 </div>
         
</div>
         
         <form action="agregarCaracteristicaOferente" method="post" class="fem">
                      <legend>Agregar caracteristicas</legend>
           
                      <input class="formfield" type="hidden" id="cedulaOferente" name="cedulaOferente" value="<%= oferente.getCedulaOferente() %>">
            
              
              
             <select name="caracteristicas" id="caracteristicas">
                 
              <option value="" selected>Caracteristicas</option>
                 
                <% for(Caracteristicas sc : c){ %>
                
                <option > <%= sc.getNombreCaracteristica()%></option>
                        
                        <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                        <% for(Area_Trabajo artr : at){ %>
                        <option >&#160; <%= artr.getNombreAreaTrabajo()  %></option>
                      <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                       <% for(Especializacion esp : es){ %>
                       <option value="<%= esp.getIdespecializacion() %>">&#160;&#160;&#160; <%= esp.getNombreEspecializacion() %></option>
                        
                 <% } %>
                                
               <% } %>
               
           <% } %>
               </select><br>
               
   

           

               
              <input class="formfield" type="number" name="porcentaje" value="${param.porcentaje}" placeholder="Porcentaje caracteristica" required><br>    
              
           
           <input class="formfield"  type="submit" value="Agregar Caracteristica">
           </form>
         
                   
        <%
    if(null!=request.getAttribute("error"))
    {
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
         
<div class = "salir" >
    <ul class="menu">
        <li><a href="#"><%=oferente.getCedulaOferente() %>-<%=oferente.getNombreOferente() %><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
</div>
            
             <a href = "principal.jsp" target = "_self">Regresar</a></center>
            
</body>
</html>
