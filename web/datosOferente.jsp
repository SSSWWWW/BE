<%-- 
    Document   : datosOferente
    Created on : Mar 21, 2018, 9:37:00 AM
    Author     : pc
--%>

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
        <tr><td><%=oferente.getNacionalidad() %></td></tr>
        <tr><td><%=oferente.getUbicacion() %></td></tr>
            
    </table>
    <br>
  
 </div>
</div>
<div class = "salir" >
    <ul class="menu">
        <li><a href="#"><%=oferente.getCedulaOferente() %>-<%=oferente.getNombreOferente() %><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
</div>
</body>
</html>
