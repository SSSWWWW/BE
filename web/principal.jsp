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
      
       
      
       <h1> Bolsa Empleo </h1>
        
        <div class="reg">
          
          
          
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
          
          
             </div><br>
      
    
          
             <div class="container" style="height: 200px; right:27px;"><br><br>
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 200px; right:27px;">
    <!-- Indicators -->
   

     <%  List<Puestos> c = model.instance().getAllPuestos(); %>    
        
      
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" style="height: 200px; right:27px;">

        
         <% for(Puestos s: c){ %>
      <div class="item active" style="height: 200px; right:27px;" >
          
           <table style="margin:5px;">
        <tr>
            <td>
                <h1><%= s.getNombrePuesto() %></h1>
                <p style="margin-left: auto; margin-right: auto; text-align: center" class="blocktext"> <%= s.getDescripcionPuesto() %></p>
                 <p>₡ <%= s.getSalario() %></p>
            </td>
           
           
            
        </tr>
    </table>
         
      
        
          
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
    
          
       
   <form class = "formbusvac" name="busqueda vacantes" action="22-html5-search-input.php" method="POST">
	<input type="search" placeholder = "Buscar vacantes" name="busquedavacante">
	<input type="submit" value="Buscar">
                </form>
          
              
              <!--a href = "registroempresa.html" target = "_self">Registro empresa</a><br><br>
              <a href = "registrooferente.html" target = "_self">Registro oferente</a><br><br></div><br>
		   
		   <!--a href="registrooferente.html" target="frame" >Registro Oferente</a>
		   <a href="registroempresa.html" target="frame" >Registro Empresa</a>
		   <iframe name="frame"> </iframe-->
         
	 

     
  </body>
</html>