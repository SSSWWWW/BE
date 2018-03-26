<%-- 
    Document   : inicioAdmin
    Created on : Mar 26, 2018, 11:38:33 AM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
   

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel = "stylesheet" href = "css/registroempresa.css">
   

   <head >
    <title>Inicio Administrador</title>
  </head>

  
       <body> 
      <h1>Inicio Administrador</h1>
  
    <form action="LoginAd" method="post">
           <input class="formfield" type="text" name="correoAdmin" placeholder="Usuario" required><br>
           <input class="formfield" type="password" name="clave" placeholder="Clave" required><br>
           <input class="formfield"  type="submit" value="Ingresar">
       </form>
      
      
      
       <center>
      <a href = "principal.jsp" target = "_self">Regresar</a></center>
  
     
  </body>
</html>
