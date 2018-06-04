<%-- 
    Document   : registrooferente
    Created on : Mar 17, 2018, 1:31:33 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" href = "css/forms.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
     <title>Registro Oferente</title>

  
  <body>
  
      
                  <%
    if(null!=request.getAttribute("error"))
    
    {
              
       out.println("<h1>Usuario ya esta registrado...Intente de nuevo con otros datos</h1>"); 
    }
%>
      
     
  
 <div class = "divform">
  <form action="agregarOferente" method="get" class = "formoferente">
      
         <div class="imgcontainer">
      <img src='images/login.jpg' alt="Avatar" class="avatar">
    </div>
  
  <input type="text" placeholder = "Nombre" name="nombre" value="${param.nombre}" required>
   <br>
  <input type="text" placeholder = "Primer apellido" name="primerapellido" value="${param.primerapellido}" required>
   <br>
   <input type="text" placeholder = "Segundo apellido" name="segundopellido" value="${param.segundopellido}" required>
   <br>
  <input type="email" placeholder = "e-mail" name="email" value="${param.email}" required>
  <br>
  <input type="text" placeholder = "cedula" name="cedula" value="${param.cedula}" required>
 <br>
 <input type="text" placeholder = "numero celular" name="celular" value="${param.celular}" required>
   <br>
   <input type="text" placeholder = "Nacionalidad" name="nacionalidad" value="${param.nacionalidad}" required>
   <br>
  <input type="password" placeholder = "contrasena" name="contrasena" value="${param.contrasena}" required>
  <br>
  
  <select class="form-control" name="provincia">
  <option value="heredia">Heredia</option>
  <option value="alajuela">Alajuela</option>
  <option value="sanjose">San Jose</option>
  <option value="cartago">Cartago</option>
  <option value="limon">Limon</option>
  <option value="puntarenas">Puntarenas</option>
  <option value="guanacaste">Guanacaste</option>
</select><br><br>
<button type="submit">Registrar</button>
</form><br><br></div>
	  

	  
      <a href = "principal.jsp" target = "_self">Regresar</a>
  
     
  </body>
</html>