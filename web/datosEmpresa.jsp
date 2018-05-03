<%-- 
    Document   : datosEmpresa
    Created on : Mar 24, 2018, 10:07:24 AM
    Author     : pc
--%>

<%@page import="entidades.Puestos"%>
<%@page import="entidades.Oferente"%>
<%@page import="entidades.Especializacion"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entidades.Empresa" %>
<%@ page import="entidades.Caracteristicas" %>

<!DOCTYPE html>
<html>
<head>
 <title>Empresa</title>
 <link href="css/principal.css" rel="stylesheet" type="text/css"/>  
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color: silver;">
    
    
<jsp:useBean id="empresa" scope="session" type="Empresa" />




<div class = "datOf" style=" float:left; display:inline-block; vertical-align:top; ">
    
   <div style="left: 0px; width: 270px; top: 40px; " >
       <table style="  vertical-align:top;    left: 0px;
    position: absolute;
    top: 40px;
    width: 270px;" class="table table-sm table-dark">

        
        <tr><td>Empresa</td></tr><br><br>
        <tr><td><%=empresa.getNombreEmp() %></td></tr><br><br>
        <tr><td><%=empresa.getDescripcionEmp() %></td></tr><br><br>
        <tr><td><%=empresa.getCorreoEmp() %></td></tr>
        <tr><td><%=empresa.getTelefono() %></td></tr>
        <div class = "map" style="  width: 270px; height: 100px;top: 80px; "  >
            <div id = "map" style="  width: 270px; height: 100px; top: 80px; "></div>
        </div><br>
    </table>
    
      
    
   </div>
        
        
  <br>
    
    
    
 <style>          
          #map { 
            height: 100px;    
            width: 270px;            
          }          
        </style> 
        

<script type="text/javascript">
        var map;
        
        function initMap() {                            
            var latitude = <%=empresa.getLongitud() %>; // YOUR LATITUDE VALUE
            var longitude = <%=empresa.getLatitud() %>; // YOUR LONGITUDE VALUE
            
            var myLatLng = {lat: latitude, lng: longitude};
            
            map = new google.maps.Map(document.getElementById('map'), {
              center: myLatLng,
              zoom: 16,
              disableDoubleClickZoom: true, // disable the default map zoom on double click
            });
            
            // Update lat/long value of div when anywhere in the map is clicked    
            google.maps.event.addListener(map,'dragend',function(event) {                
                 document.getElementById('latclicked').value = event.latLng.lat();
                  document.getElementById('longclicked').value =  event.latLng.lng();
            });
            
            // Update lat/long value of div when you move the mouse over the map
            /*google.maps.event.addListener(map,'mousemove',function(event) {
                document.getElementById('latmoved').innerHTML = event.latLng.lat();
                document.getElementById('longmoved').innerHTML = event.latLng.lng();
            });*/
                    
            var marker = new google.maps.Marker({
              position: myLatLng,
              map: map,
              draggable: false,
              //title: 'Hello World'
              
              // setting latitude & longitude as title of the marker
              // title is shown when you hover over the marker
              title: latitude + ', ' + longitude 
            });    
            
         
        }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA&callback=initMap"
        async defer></script>
        
      
        
        
               <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js" type="text/javascript"></script>
        <script type="text/javascript"> 
       
       $(function(){
    var $caracteristica = $('#caracteristicas');
    var $caracteristicaenarea = $('#aux');
    function onChange() {
        $caracteristicaenarea.val($caracteristica.val());
    };
    $('#caracteristicas')
        .change(onChange)
        .keyup(onChange);
});



  </script>

        
 <style>::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
    color: grey;
    opacity: 1; /* Firefox */
} </style>
        
        
        
        <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
        
       <br>  <form action="agregarPuesto"  id="formpuesto"  method="POST" class="fem">
                      <legend id="leg" >Agregar nuevo puesto</legend>
           <input class="formfield" type="text" name="nombrePuesto" id="nombrePuesto" value="${param.nombrePuesto}" placeholder="Nombre Puesto" required ><br>
           <input class="formfield" type="text" id="descripcionPuesto" name="descripcionPuesto" value="${param.descripcionPuesto}" placeholder="Descripcion" required><br>
           <input class="formfield" type="number" id="salarioPuesto" name="salarioPuesto" value="${param.salarioPuesto}" placeholder="Salario" required><br>
          <input class="formfield" type="hidden" id="nombreempresa" name="nombreempresa" value="<%=empresa.getNombreEmp() %>" placeholder="Salario" required>
            
          <input class="formfield" type="hidden" id="idpu" name="idpu">

          
             <select name="estado" id="estado">
                 
               <option value="true">Estado</option>   
              <option value="true">Publico</option>
              <option value="false">Privado</option>
               </select><br>
              
              
             <select  name="caracteristicas" id="caracteristicas">
                 
              <option value="" selected>Caracteristicas</option>
                 
                <% for(Caracteristicas sc : c){ %>
                
                <option > <%= sc.getNombreCaracteristica()%></option>
                        
                        <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                        <% for(Area_Trabajo artr : at){ %>
                        <option >&#160; <%= artr.getNombreAreaTrabajo()  %></option>
                      <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                       <% for(Especializacion esp : es){ %>
                       <option value="<%= esp.getNombreEspecializacion() %>">&#160;&#160;&#160; <%= esp.getNombreEspecializacion() %></option>
                        
                 <% } %>
                                
               <% } %>
               
           <% } %>
               </select><br>
               
                 
           <input class="formfield" type="hidden" id="aux" name="aux" placeholder="Porcentaje caracteristica" >   
   

           
              <select style="display: none;" name="id" id="id">
             <option value="<%= empresa.getIdEmp() %>"><%= empresa.getIdEmp() %></option>

                  </select>

               
              <input class="formfield" type="number" name="porcentaje" value="${param.porcentaje}" placeholder="Porcentaje caracteristica" ><br>    
              
           
              
              
           <input id="ag" class="formfield" type="submit" value="Agregar Puesto">
           </form>
              
                     <%
    if(null!=request.getAttribute("error"))
    {
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
              
            </div>
              
              
              <div class="container" style="display:inline-block; width:200px; height: 540px; ">
  <form action="listarPuestosEmp" method="get" class = "formoferente">
  
  <input type="hidden"  name="idEmp" value="<%=empresa.getIdEmp() %>"><br>
   
 
<input type="submit"  value="Ver Puestos Publicados" >

 </form>



<script> 
    
    function editar(idpuesto , nombre , descripcion , salario , estado){
    
       
    
         // alert("You have reached the limit of adding  inputs " + idpuesto);
          document.getElementById("leg").innerHTML = "Editar puesto";
          document.getElementById("ag").value = "Editar";
           document.getElementById("nombrePuesto").value = nombre;
           document.getElementById("descripcionPuesto").value = descripcion;
            document.getElementById("salarioPuesto").value = salario;
            document.getElementById("estado").value = estado;
            
          document.getElementById("formpuesto").action = 'editarpuesto';
       
         
          
          
          document.getElementById("idpu").value = idpuesto;
   
}

 



   function actualizarpuesto(){
       
     
        
         puesto = {
	           nombrePuesto: document.getElementById("nombrePuesto").value,
			//sexo: document.querySelector("input[name='sexo']:checked").value
                    salario: document.getElementById("salarioPuesto").value,
                    descripcionPuesto: document.getElementById("descripcionPuesto").value,
                    estado: document.getElementById("estado").value
      };
          ajax({"method": "POST", 
                  "url":"listarPuestosEmp", 
                  "data": puesto,
                  "success": 
                    function(obj){
                      //  updateList(obj); 
                       // document.getElementById("formulario").reset();
                        window.alert("Actualizada");
                       
                        
                    },
                 
                 "error": function(status){
                         window.alert("Error actualizar");
                    }  
                                   
                });  
        
        
    }
    
    
</script>    


 
              
              
               <div id="body" >   
        <div id="listar" class="area" style="width:50%;">   
            
            <jsp:useBean id="puestosListaEmp" scope="request" type="List<Puestos>" class="java.util.ArrayList"/>
            
              <div style="overflow-x: auto; width:250px; height: 389px;">

            <table style="overflow-x: auto; width:250px; height: 389px;" class="table table-sm table-dark">
              
              <thead><tr><td>Nombre</td></tr></thead>
              <tbody style="height: 250px;">
                <% for(Puestos s: puestosListaEmp){ %>
                <tr><td id="idpues" value="<%= s.getIdPuesto()%>" onClick="editar('<%= s.getIdPuesto()%>' , '<%= s.getNombrePuesto() %>' , '<%=s.getDescripcionPuesto() %>' , '<%=s.getSalario() %>', '<%=s.isEstado() %>');" ><%= s.getNombrePuesto() %></td>

                     </tr>
               <% } %>
            </tbody>
            </table>
              </div>
      </div>
    </div>
              
              
              </div>
  
  
              <div class="container" style=" float:right; display:inline-block; width:700px; height: 540px;">
                  <%  List<Caracteristicas> cc = model.instance().getAllCaracteristicas(); %>
                  
                  <h1 style="text-align: left; font-size: 150%;">Buscar Oferente </h1>

<form style="float: left;" class = "formempresa"  action="buscarOferente" method="get">
    
     
    <div style="overflow-x: auto; width:250px; height: 89px;">
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
        <input class="formfield"  type="submit" value="Buscar Puesto">
</form>
                  
  <div id="body" style="margin: 0 auto; width:85%; display: inline-block; margin-left:20px;">   
        <div id="listar" class="area" style="width:50%;">   
            <br>
            <jsp:useBean id="buscarOferente" scope="request" type="List<Oferente>" class="java.util.ArrayList"/>
            <table class="table table-sm table-dark">
              
              <thead><tr><td>Nombre</td><td>Apellido</td><td>Correo</td><td>Ubicacion</td><td>Curriculum</td></tr></thead>
              <tbody style="height: 250px;">
                <% for(Oferente s: buscarOferente){ %>
                     <tr><td><%= s.getNombreOferente() %></td><td><%= s.getPrimerApellido() %></td>
                     <td><%= s.getCorreoOferente()  %></td><td><%= s.getUbicacion()  %></td></tr><br>
               <% } %>
            </tbody>
            </table>
      </div>
    </div>
                  
              </div>   
 
 
  
           
       

             
            
<div class = "salir" style="position:fixed ; top:0%; right:0%;">
    <ul class="menu">
        <li><a href="#"><%=empresa.getIdEmp() %>-<%=empresa.getNombreEmp() %><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
           
         
            
</div>
            
             <a href = "principal.jsp" target = "_self" style="position: fixed;top: 0%;left: 0%;">Regresar</a></center>
            
</body>
</html>
