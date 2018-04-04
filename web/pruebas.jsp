<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>


<%@page import="entidades.Puestos"%>
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

<title>JSP Multiple Select Option</title>
</head>
<body>
<h4>Select the color/s you like from the drop down list</h4>

        <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>

<form>
    
     
    
 <table>
     <% for(Caracteristicas sc : c){ %>
     
     <tr>
   <td><input type="checkbox" name="names" value="<%= sc.getNombreCaracteristica()  %>"/><%= sc.getNombreCaracteristica()  %></td>
  </tr>
  <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
  
   <% for(Area_Trabajo artr : at){ %>
   <tr>
    <td>&#160;&#160;<input type="checkbox" name="names" value="<%= artr.getNombreAreaTrabajo()  %>"/>&#160;<%= artr.getNombreAreaTrabajo()  %></td>
   </tr>
   
       <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
        <% for(Especializacion esp : es){ %>
        <tr>
    <td>&#160; &#160; &#160;<input type="checkbox" name="names" value="<%= esp.getNombreEspecializacion()  %>"/>&#160; <%= esp.getNombreEspecializacion() %></td>
   </tr>
  
         <% } %>
      <% } %>
    <% } %>
     
 
 </table>
<p><input type="submit" value="submit"></p>
</form>

<% 
String clrs[] = request.getParameterValues("names");
if(clrs != null)
{
%>
<p><b>You have selected the following colors</b></p>
<ul>
<%
for(int i=0; i<clrs.length; i++)
{
%>
<li><%=clrs[i]%></li>
<%
}
%>
</ul>
<%
}
%>


 <jsp:useBean id="listarPuestos" scope="request" type="List<Puestos>" class="java.util.ArrayList" />
        <table class="grid">
          <caption>SUGERENCIAS</caption>
          <thead><tr><td>No.</td><td>Titulo</td><td>Texto</td><td>Puntaje</td></tr></thead>
          <tbody style="height: 250px;">
            <% for(Puestos s: listarPuestos){ %>
                 <tr><td><%=s.getDescripcionPuesto().toString() %></td><td><%=s.getNombrePuesto() %></td>
             </tr>
           <% } %>
        </tbody>
        </table>

</body>
</html>