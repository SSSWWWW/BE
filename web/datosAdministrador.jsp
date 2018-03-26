<%-- 
    Document   : datosAdministrador
    Created on : Mar 26, 2018, 12:21:45 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entidades.Administrador" %>
<!DOCTYPE html>
<html>
<head>
 <title>Administrador</title>
 <link href="css/registrooferente.css" rel="stylesheet" type="text/css"/>  
</head>
<body>
<jsp:useBean id="administrador" scope="session" type="Administrador" />
<div class = "datOf" >
    
    <div class="area" >   
    <table class="grid">
        <caption>Administrador</caption>
        
        <tr><td><%=administrador.getNombreAdmin()%></td></tr><br><br>
        
            
    </table>
    <br>
  
 </div>
</div>
<div class = "salir" >
    <ul class="menu">
        <li><a href="#"><%=administrador.getNombreAdmin()%><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
</div>
            
            <script type="text/javascript"> 
         
                 
        var counter = 1;
var limit = 6;



function addInput1(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv1 = document.createElement('div');
          newdiv1.innerHTML = " <input type='text'placeholder='3 - especialidad' name='especilidad[]'>";
          document.getElementById(divName).appendChild(newdiv1);
          

          
     }
}

            </script>
             <script src="/wp-includes/js/addInput.js" language="Javascript" type="text/javascript"></script>
            
             <h1 class="ac"> Agregar caracteristicas </h1>
         
       <form action="AgregarCaracteristica" method="post">
           <input class="formfield" type="text" name="caracteristica" placeholder="1 - caracteristica " required><br>
       <input class="formfield"  type="submit" value="Agregar"> 
       </form>
            
               <form action="AgregarAreaTrabajo" method="post" style="margin-left: 20px;">
     
           
           
           <div id="dynamicInput">
          <input type="text" placeholder="2 - area de trabajo" name="myInputs[]">
     </div>
     
      <input class="formfield"  type="submit" value="Agregar">
       </form>
             
             
              <form action="AgregarEspecialidad" method="post" style="margin-left: 40px;">
     
           
           
           <div id="especilidadInput">
          <input type="text" placeholder="3 - Especialidad" name="especialidad[]">
     </div>
     <input type="button" value="+" onClick="addInput1('especilidadInput');">
      <input class="formfield"  type="submit" value="Agregar">
       </form>
            
               
            
            
             <a href = "principal.jsp" target = "_self">Regresar</a></center>
            
</body>
</html>