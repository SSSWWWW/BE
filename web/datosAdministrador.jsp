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
          var nn = document.getElementById('areatrabajo').value;
          newdiv1.innerHTML = " <input type='text'placeholder='3 - especialidad' name='especilidad'> \n\
<input type='number' placeholder='%' name='porcentaje'> <input type='text' placeholder='3' name='porcentaje' value="+nn+">";
          document.getElementById(divName).appendChild(newdiv1);
          

          
     }
}

            </script>
             <script src="/wp-includes/js/addInput.js" language="Javascript" type="text/javascript"></script>
            
             
                 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js" type="text/javascript"></script>
        <script type="text/javascript"> 
       
       $(function(){
    var $caracteristica = $('#caracteristica');
    var $caracteristicaenarea = $('#caracteristicaenarea');
    function onChange() {
        $caracteristicaenarea.val($caracteristica.val());
    };
    $('#caracteristica')
        .change(onChange)
        .keyup(onChange);
});
      
            
        </script>
        
          <script type="text/javascript"> 
       
       $(function(){
    var $areatrabajo = $('#areatrabajo');
    var $areaenespecialidad = $('#areaenespecialidad');
    function onChange() {
        $areaenespecialidad.val($areatrabajo.val());
    };
    $('#areatrabajo')
        .change(onChange)
        .keyup(onChange);
});
      
            
        </script>
        
        
     
        
        <script src="js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                document.getElementById("caracteristica").value = localStorage.getItem("item1");
                
               
               
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("item1",document.getElementById("caracteristica").value);
                
                
               
            });

        </script>
        
        
        <script src="js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                document.getElementById("caracteristicaenarea").value = localStorage.getItem("item3");
                
               
               
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("item3",document.getElementById("caracteristicaenarea").value);
                
                
               
            });

        </script>
        
        
         <script src="js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                document.getElementById("areatrabajo").value = localStorage.getItem("item2");
                
               
               
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("item2",document.getElementById("areatrabajo").value);
                
                
               
            });

        </script>
        
          <script src="js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                document.getElementById("areaenespecialidad").value = localStorage.getItem("item5");
                
               
               
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("item5",document.getElementById("areaenespecialidad").value);
                
                
               
            });

        </script>
        
   
        
       
             
             
             <h1 class="ac"> Agregar caracteristicas </h1>
         
      
              <!--button id="copy">copy</button-->
            <form id="form1" action="agregarCaracteristica" method="post"  onsubmit="alert('Caracteristica agregada!')">
                <input class="formfield" type="text"  name="caracteristica" id="caracteristica"  placeholder="1 - caracteristica "   required><br>
         
                 <input id="copy1" class="formfield"  type="submit" value="Agregar"> 
            </form>
            
              
              
            <form id="form2" action="agregarAreaTrabajo" method="post" style="margin-left: 20px;"  onsubmit="alert('Area de trabajo agregada!')">
            
               <div id="dynamicInput">
                 <input type="text" placeholder="2 - area de trabajo" name="areatrabajo"  id="areatrabajo">
                 <input class="formfield" type="hidden" id="caracteristicaenarea" name="caracteristicaenarea"  placeholder="1 - caracteristica "><br>   
               </div>
     
                <input class="formfield"  type="submit" value="Agregar">
            </form>
             
             
            <form action="AgregarEspecialidad" method="post" style="margin-left: 40px;" >

                <div id="especilidadInput">
                <input type="text" placeholder="3 - Especialidad" name="especialidad">
                <input type="number" placeholder="%" name="porcentaje">
                 <input class="formfield" type="text" id="areaenespecialidad" name="areaenespecialidad"  placeholder="3 - area "><br> 
                </div>
                <input type="button" value="+" onClick="addInput1('especilidadInput');">
                 <input class="formfield"  type="submit" value="Agregar">
             </form>
            
               
            
            
             <a href = "principal.jsp" target = "_self">Regresar</a></center>
            
</body>
</html>