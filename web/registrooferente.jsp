<%-- 
    Document   : registrooferente
    Created on : Mar 17, 2018, 1:31:33 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" href = "css/registrooferente.css">
   
  <head >
  
    <title>Registro oferente</title>
  </head>
  
  <body>
  
      
        <%
    if(null!=request.getAttribute("error"))
    {
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
      
       <h1>REGISTRO OFERENTES</h1>
  
 <div class = "divform">
  <form action="agregarOferente" method="get" class = "formoferente">
  
  <input type="text" placeholder = "Nombre" name="nombre" value="${param.nombre}"><br>
   <br>
  <input type="text" placeholder = "Primer apellido" name="primerapellido" value="${param.primerapellido}"><br>
   <br>
   <input type="text" placeholder = "Segundo apellido" name="segundopellido" value="${param.segundopellido}"><br>
   <br>
  <input type="email" placeholder = "e-mail" name="email" value="${param.email}"><br>
  <br>
  <input type="text" placeholder = "cedula" name="cedula" value="${param.cedula}"><br>
 <br>
 <input type="text" placeholder = "numero celular" name="celular" value="${param.celular}"><br>
   <br>
   <input type="text" placeholder = "Nacionalidad" name="nacionalidad" value="${param.nacionalidad}"><br>
   <br>
  <input type="password" placeholder = "contrasena" name="contrasena" value="${param.contrasena}"><br>
  <br>
  
  <select name="provincia">
  <option value="heredia">Heredia</option>
  <option value="alajuela">Alajuela</option>
  <option value="sanjose">San Jose</option>
  <option value="cartago">Cartago</option>
  <option value="limon">Limon</option>
  <option value="puntarenas">Puntarenas</option>
  <option value="guanacaste">Guanacaste</option>
</select>
<input type="submit" value="Continuar" >
</form><br><br></div>
	  

	  
      <a href = "principal.jsp" target = "_self">Regresar</a>
  
     
  </body>
</html>