<%-- 
    Document   : datosOferente
    Created on : Mar 21, 2018, 9:37:00 AM
    Author     : pc
--%>

<%@page import="entidades.EspecializacionIncluidaOferente"%>
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
  <link href="css/datosEmpresa.css" rel="stylesheet" type="text/css"/>  
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
</head>
<body style="background-color: silver;">
<jsp:useBean id="oferente" scope="session" type="Oferente" />


<div class = "datOf" style=" float:left; display:inline-block; vertical-align:top; ">

<div class = "datOf" >
    
    <div style="left: 0px; width: 270px; top: 40px; " >  
    <table class="table table-sm table-dark">
       
        
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
           </form><br><br>
              
              
         
                   
        <%
    if(null!=request.getAttribute("error"))
    {
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
       

 <form method="POST" action="upload" enctype="multipart/form-data" onsubmit="alert('Curriculum agregado!')">
             <legend>Subir curriculum (formato .pdf)</legend>
           <input type="file" value="<%= oferente.getCedulaOferente() %>" name="file" id="file" /> <br/>
            Buscar:
            
            <input type="hidden"  name="cedula" value="<%= oferente.getCedulaOferente() %>">
            <input type="hidden" value="C:\Users\pc\GlassFish_Server\glassfish\domains\domain1\applications\__internal\BolsaEmpleo" name="destination"/>
            <input type="submit" value="Subir" name="upload" id="upload" />
        </form>


</div>

 <div class="container" style="display:inline-block; width:200px; height: 540px; ">

<form action="listarCaracteristicasOferente" method="get" class = "formoferente" >
  
  <input type="hidden"  name="cedula" value="<%= oferente.getCedulaOferente() %>"><br>
   
 
<input type="submit" value="Ver caracteristicas registradas" >
  </form>
  
  
   
  
      <div id="body" >   
        <div id="listar" class="area" style="width:50%;">   
            
            <jsp:useBean id="listarCaracteristicasOferente" scope="request" type="List<EspecializacionIncluidaOferente>" class="java.util.ArrayList"/>
            
              <div style="overflow-x: auto; width:250px; height: 189px;">

            <table style="overflow-x: auto; width:250px; height: 189px;" class="table table-sm table-dark">
              
              <thead><tr><td>Caracteristica</td><td>Porcentaje</td></tr></thead>
              <tbody style="height: 100px;">
                <% for(EspecializacionIncluidaOferente s: listarCaracteristicasOferente){ %>
                     <tr><td><%= s.getNombreEspecializacion() %></td><td><%= s.getPorcentajeEspecializacion() %></td>
                     </tr>
               <% } %>
            </tbody>
            </table>
          
            
              </div>
      </div>
    </div>  
  
    </div>
            



<div class = "salir" style="position:fixed ; top:0%; right:0%;" >
    <ul class="menu">
        <li><a href="#"><%=oferente.getCedulaOferente() %>-<%=oferente.getNombreOferente() %><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
</div>
            
             <a href = "principal.jsp" target = "_self" style="position: fixed;top: 0%;left: 0%;">Regresar</a></center>
            
</body>
</html>
