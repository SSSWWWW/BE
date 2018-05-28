<%-- 
    Document   : datosAdministrador
    Created on : Mar 26, 2018, 12:21:45 PM
    Author     : pc
--%>

<%@page import="entidades.Oferente"%>
<%@page import="entidades.Empresa"%>
<%@page import="entidades.Especializacion"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="logica.model"%>
<%@page import="entidades.Caracteristicas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entidades.Administrador" %>
<!DOCTYPE html>
<html>
<head>
 <title>Administrador</title>
 <link href="css/principal.css" rel="stylesheet" type="text/css"/> 
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:useBean id="administrador" scope="session" type="Administrador" />
<div class = "datOf" >
    
  
</div>
<div class = "salir" style="position:fixed ; top:0%; right:0%;">
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
<input type='hidden' placeholder='%' name='porcentaje'> <input type='hidden' placeholder='3' name='porcentaje' value="+nn+">";
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
        
   
         <script type="text/javascript"> 
                     function addEs(formName){
                     
                     
                    var form = document.querySelector(formName),
                   elements = form.elements,
                     i;
    
                   for (i = 0; i < elements.length; i += 1) {
                      
                       elements[i].submit();
                     }
                     
                /*    var elements = document.getElementById(formName).submit();
                     for (var i = 0; i < elements.length; i++) {
                      
                        elements[i].submit();
                      
                       } */
                   }
                       
                
                </script>
       
             
             
           
         
      <div class = "datOf" style=" float:left; display:inline-block; vertical-align:top; ">
          
         
           <h1 style="text-align: left; font-size: 150%;">Agregar caracteristicas </h1>
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
             
             
            <form action="agregarEspecialidad"  name="espef" id="espef" method="post" style="margin-left: 40px;" >

                <div id="especilidadInput">
                <input type="text" placeholder="3 - Especialidad" name="especialidad">
                <input type="hidden" placeholder="%" name="porcentaje">
                 <input class="formfield" type="hidden" id="areaenespecialidad" name="areaenespecialidad"  placeholder="3 - area "><br> 
                </div>
                <input type="button" value="+" onClick="addInput1('especilidadInput');">
                
                
                
                <!--input type="button" value="Agregar" onClick="addEs('espef');"-->
                
                 <input class="formfield"  type="submit" value="Agregar">
             </form>
              
              
              <%  List<Caracteristicas> cc = model.instance().getAllCaracteristicas(); %>
                  
                  <h1 style="text-align: left; font-size: 150%;">Caracteristicas registradas </h1>


    
     
                  <div style="overflow-x: auto; width:250px; height: 389px;">

 <table>
    
       <% for(Caracteristicas sc : cc){ %>
     <ul>
              <li>
                  
                <a> <%= sc.getNombreCaracteristica()  %> </a>
 
                <ul>
                     
                     <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                    <% for(Area_Trabajo artr : at){ %>
                 <li>
 
                     <a> &#160;&#160;<%= artr.getNombreAreaTrabajo()  %> </a>
         
                     <ul>
                          <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                      <% for(Especializacion esp : es){ %>
                     
                       <li>
 
                           <a> &#160; &#160; <input type="checkbox" name="names" value="<%= esp.getIdespecializacion()  %>"/> <%= esp.getNombreEspecializacion() %> &#160;&#160;&#160</a>

                       </li>

                       <% } %>
                     </ul><br><br>
 
                 </li>
                 
                    <% } %>

                </ul>

              </li>
 
            </ul><br>
     
              <% } %>
 </table>
              
              
      </div>
 
      </div>
 
          <div class="container" style="display:inline-block; width:300px; height: 540px; ">
  <form action="listarEmpresas" method="get" class = "formoferente">
  
 
   
 
<input type="submit"  value="Ver Empresas" >

 </form>
  
  
         <div id="body" >   
        <div id="listar" class="area" style="width:50%;">   
            
            <jsp:useBean id="empresasLista" scope="request" type="List<Empresa>" class="java.util.ArrayList"/>
            
              <div style="overflow-x: auto; width:250px; height: 389px;">

            <table style="overflow-x: auto; width:250px; height: 389px;" class="tablecarac table-bordered table-sm">
              
              <thead  style="background-color: slateblue"><tr><td>Nombre Empresa</td></tr></thead>
              <tbody style="height: 250px;">
                <% for(Empresa s: empresasLista){ %>
                <tr><td  onClick="editar('<%= s.getNombreEmp() %>' , '<%= s.getIdEmp() %>' );"  id="idpues" value="<%= s.getIdEmp() %>"  ><%= s.getNombreEmp() %>
                    <img  onclick="document.getElementById('modalborrar').style.display='block'"  src='images/edit.png'  class='icon'  style="width:auto;">
                    
                    </td>

                     </tr>
               <% } %> 
            </tbody>
            </table>
              </div>
      </div>
    </div>
  
  
          </div>
  
                <div class="container" style="display:inline-block; width:300px; height: 540px; ">
  <form action="listarOferentes" method="get" class = "formoferente">
  
 
   
 
<input type="submit"  value="Ver Oferentes" >

 </form>
  
  
         <div id="body" >   
        <div id="listar" class="area" style="width:50%;">   
            
            <jsp:useBean id="oferentesLista" scope="request" type="List<Oferente>" class="java.util.ArrayList"/>
            
              <div style="overflow-x: auto; width:250px; height: 389px;">

            <table style="overflow-x: auto; width:250px; height: 389px;" class="tablecarac table-bordered table-sm">
              
              <thead  style="background-color: slateblue"><tr><td>Nombre Oferente</td></tr></thead>
              <tbody style="height: 250px;">
                <% for(Oferente s: oferentesLista){ %>
                <tr><td onClick="editarOf('<%= s.getNombreOferente() %>' , '<%= s.getCedulaOferente() %>' );"  id="idpues" value="<%= s.getCedulaOferente() %>"  ><%= s.getNombreOferente() %>
                    
                    <img  onclick="document.getElementById('modaloferente').style.display='block'"  src='images/edit.png'  class='icon'  style="width:auto;">
                    
                    </td>

                     </tr>
               <% } %> 
            </tbody>
            </table>
              </div>
      </div>
    </div>
  
  
          </div>   
              
            
         <script>
             
             
                var modalBorrar = document.getElementById('modalBorrar');
    
     var modaloferente = document.getElementById('modaloferente');
    
    window.onclick = function(event) {
   
    
  
    
     if (event.target == modalBorrar ) {
        
         
        modalBorrar.style.display = "none";
    }
    
    
      if (event.target == modaloferente ) {
        
         
        modaloferente.style.display = "none";
    }
    
    }
    
    function editar(nombreemp, idempresa ){
    
       
    
         // alert("You have reached the limit of adding  inputs " + idpuesto);
     //     document.getElementById("leg").innerHTML = "Editar puesto";
       //   document.getElementById("ag").value = "Editar";
           document.getElementById("nombEmp").value = nombreemp;
           document.getElementById("idEmp").value = idempresa;
        
           
           
    }
    
        function editarOf(nombreof, idof ){
    
       
    
         // alert("You have reached the limit of adding  inputs " + idpuesto);
     //     document.getElementById("leg").innerHTML = "Editar puesto";
       //   document.getElementById("ag").value = "Editar";
           document.getElementById("nombOf").value = nombreof;
           document.getElementById("idOf").value = idof;
        
           
           
    }
    
             
             
             </script>
            
            
            
            
             <div  id="modalborrar" class="modal">
  
  <form class="modal-content animate" action="activarEmpresa" method="POST">
    <div class="imgcontainer">
      <span onclick="document.getElementById('modalborrar').style.display='none'" class="close" title="Close Modal">&times;</span>
      
    </div>

    <div class="container">
      
     <input class="formfield" type="text" name="nombEmp" id="nombEmp" ><br>

     
     
     <input class="formfield" type="hidden" id="idEmp" name="idEmp"  ><br>
     
        
      <button type="submit">Activar</button>
      
    </div>

    
  </form>
</div>  
       
             
             
             
             
             
             
                   <div  id="modaloferente" class="modal">
  
  <form class="modal-content animate" action="activarOferente" method="POST">
    <div class="imgcontainer">
      <span onclick="document.getElementById('modaloferente').style.display='none'" class="close" title="Close Modal">&times;</span>
      
    </div>

    <div class="container">
      
     <input class="formfield" type="text" name="nombOf" id="nombOf" ><br>

     
     
     <input class="formfield" type="hidden" id="idOf" name="idOf"  ><br>
     
        
      <button type="submit">Activar</button>
      
    </div>

    
  </form>
</div>  
            
               
            
            
             <a href = "principal.jsp" target = "_self">Regresar</a></center>
            
</body>
</html>