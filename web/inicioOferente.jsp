<%-- 
    Document   : inicioOferente
    Created on : Mar 20, 2018, 4:09:36 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
   

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel = "stylesheet" href = "css/registroempresa.css">
   

   <head >
    <title>Inicio Oferente</title>
  </head>

  
       <body> 
      <h1>Inicio Oferente</h1>
  
    <form action="LoginOf" method="post">
           <input class="formfield" type="text" name="correoOferente" placeholder="Usuario" required><br>
           <input class="formfield" type="password" name="clave" placeholder="Clave" required><br>
           <input class="formfield"  type="submit" value="Ingresar">
       </form>
      
      
      
       <center>
      <a href = "principal.jsp" target = "_self">Regresar</a></center>
  
     
  </body>
</html>
