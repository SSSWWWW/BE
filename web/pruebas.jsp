<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>


<%@page import="java.util.Iterator"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Caracteristicas"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Google Map</title>
        
       
    <body>
      
     
         
          
    <table>
          <caption>SUGERENCIAS</caption>
          <thead><tr><td>No.</td><td>Titulo</td><td>Texto</td><td>Puntaje</td></tr></thead>
           <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
          <tbody style="height: 250px;">
            <% for(Caracteristicas s: c){ %>
                 <tr><td><%=s.getNombreCaracteristica() %></td><td>
           <% } %>
        </tbody>
        </table>
        
        
        <select name = "caracteristica">
               <% for(Caracteristicas sc : c){ %>
               <option> <%= sc.getNombreCaracteristica() %> </option>
           <% } %>
           </select>
        
      
 <select name = "caracteristica">
             <jsp:useBean id="caracteristicasLista" scope="request" type="List<Caracteristicas>" class="java.util.ArrayList"/>
               <% for(Caracteristicas cc : caracteristicasLista){ %>
               <option> <%= cc.getNombreCaracteristica() %> </option>
           <% } %>
           </select>
        
        
        

           
    </body>    
</html>