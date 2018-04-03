<%-- 
    Document   : principal
    Created on : Mar 17, 2018, 1:26:37 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entidades.Puestos"%>
<%@page import="entidades.Especializacion"%>
<%@page import="java.util.Iterator"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>

<%@page import="entidades.Area_Trabajo"%>
<%@page import="entidades.Caracteristicas"%>

<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" href = "css/principal.css">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
<%@ include file="Header.jsp" %>
  <head>
    <title>Bolsa Empleo</title>
    
   
  </head>
  
  
  
  <body>
      
       
      
      <h1><a href="principal.jsp"> Bolsa Empleo </a></h1>
        
        <div class="reg" style="text-align: left">
          
          
          
            <ul>
              <li>
                <a href="#">Registro</a>
                
                <ul>
                 <li><a href="registroempresa.jsp">Registro empresa</a></li>
                  <li><a href="registrooferente.jsp">Registro oferente</a></li>
                </ul>
              </li>
            </ul>
          
           <ul>
              <li>
                <a href="#">Inicio</a>
                <ul>
                 <li><a href="inicioEmpresa.jsp">Inicio empresa</a></li>
                  <li><a href="inicioOferente.jsp">Inicio oferente</a></li>
                </ul>
              </li>
            </ul>
          
          
             </div><br><br>
      
    
          
             <div class="container" style="height: 100px; right:40px;">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 100px; right:40px; text-align: center;">
    <!-- Indicators -->
   

     <%  List<Puestos> c = model.instance().getAllPuestos(); %>    
        
      
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" style="height: 100px; right:40px;">

        
         <% for(Puestos s: c){ %>
      <div class="item active" style="height: 100px; right:40px;" >
          
           <div class="box">
               <h1 style="font-size: 90%;"><%= s.getNombrePuesto()%></h1>
               <p style="font-size: 70%;"> <%=s.getDescripcionPuesto() %> </p>
               <p style="font-size: 70%;"> ₡ <%=s.getSalario() %> </p>
              
</div>
         
      
        
          
      </div>
      <% } %>
        
     
    

      <div class="item">
         
        <div class="carousel-caption">
          
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div><br><br><br>
    
          
<%  List<Caracteristicas> cc = model.instance().getAllCaracteristicas(); %>

<h1 style="text-align: left; font-size: 150%;">Buscar Empleo </h1>

<form style="float: left;" class = "formempresa"  action="buscarPuestos" method="get">
    
     
    
 <table>
     <% for(Caracteristicas sc : cc){ %>
     
     <tr>
   <td><%= sc.getNombreCaracteristica()  %></td>
  </tr>
  <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
  
   <% for(Area_Trabajo artr : at){ %>
   <tr>
    <td>&#160;&#160;&#160;<%= artr.getNombreAreaTrabajo()  %></td>
   </tr>
   
       <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
        <% for(Especializacion esp : es){ %>
        <tr>
    <td>&#160; &#160; &#160;<input type="checkbox" name="names" value="<%= esp.getIdespecializacion()  %>"/>&#160; <%= esp.getNombreEspecializacion() %></td>
   </tr>
  
         <% } %>
      <% } %>
    <% } %>
     
 
 </table>
<input type="submit" value="Buscar puesto">
</form>

  <div id="body" style="margin: 0 auto; width:85%; display: inline-block; margin-left:20px;">   
        <div id="listar" class="area" style="width:50%;">   
            <br>
            <jsp:useBean id="buscarPuestos" scope="request" type="List<Puestos>" class="java.util.ArrayList"/>
            <table class="grid">
              
              <thead><tr><td>Nombre</td><td>Descripcion</td><td>Salario</td></tr></thead>
              <tbody style="height: 250px;">
                <% for(Puestos s: buscarPuestos){ %>
                     <tr><td><%= s.getNombrePuesto() %></td><td><%= s.getDescripcionPuesto() %></td>
                     <td><%= s.getSalario() %></td></tr><br>
               <% } %>
            </tbody>
            </table>
      </div>
    </div>
    

              
              <!--a href = "registroempresa.html" target = "_self">Registro empresa</a><br><br>
              <a href = "registrooferente.html" target = "_self">Registro oferente</a><br><br></div><br>
		   
		   <!--a href="registrooferente.html" target="frame" >Registro Oferente</a>
		   <a href="registroempresa.html" target="frame" >Registro Empresa</a>
		   <iframe name="frame"> </iframe-->
         
	

     
  </body>
  
          
</html>