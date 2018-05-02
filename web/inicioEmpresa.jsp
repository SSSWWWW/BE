<%-- 
    Document   : inicioEmpresa
    Created on : Mar 20, 2018, 4:01:32 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
   

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel = "stylesheet" href = "css/forms.css">
   

   <head >
    <title>Inicio Empresa</title>
  </head>

  
       <body> 
    
  
    <form action="LoginEm" method="post">
        
          <div class="imgcontainer">
      <img src='images/empresa.png' alt="Avatar" class="avatar">
    </div>
        
       <div class="container">
            <label for="uname"><b>Empresa</b></label><br>
           <input class="formfield" type="text" name="correoEmpresa" placeholder="Usuario" required><br>
           <input class="formfield" type="password" name="clave" placeholder="Clave" required><br>
           
           <button type="submit">Ingresar</button>
           
       </div>
       </form>
  
       <center>
      <a href = "principal.jsp" target = "_self">Regresar</a></center>
     
  </body>
</html>
