<%-- 
    Document   : principal
    Created on : Mar 17, 2018, 1:26:37 PM
    Author     : pc
--%>

<%@page import="entidades.EspecializacionIncluida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entidades.Puestos"%>
<%@page import="entidades.Especializacion"%>
<%@page import="java.util.Iterator"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>

<%@page import="entidades.Area_Trabajo"%>
<%@page import="entidades.Caracteristicas"%>

<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" href = "css/principal.css">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@ include file="Header.jsp" %>

    <title>Bolsa Empleo</title>
    
    <style>          
          #map { 
            height: 300px;    
            width: 600px;            
          }          
        </style>   

  
  
  
  <body>
      
   
             <div  class="container" style="  width: 100%; height:100%; margin:0; display: flex; flex-direction: column;  ">
                 
                    <div class="reg" style="  text-align: left; background: slateblue; flex-grow: 1; display: flex;">
          
         
          
            <ul>
              <li>
                <a href="#" style="color:white;">Registro &nbsp; </a>
                
                <ul>
                 <li><a href="registroempresa.jsp">Registro empresa</a></li>
                  <li><a href="registrooferente.jsp">Registro oferente</a></li>
                </ul>
              </li>
            </ul>
          
           <ul>
              <li>
                <a href="#" style="color:white;">Inicio</a>
                <ul>
                 <li><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;" >Inicio empresa</a></li>
                  <li><a onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Inicio oferente</a></li>
                </ul>
              </li>
            </ul>
          
          
             </div>
                 
                 
                 
                                   <h1 style="text-align: center; font-size:5vw; "><a href="principal.jsp" style="font-weight: bold;" > Bolsa Empleo </a></h1>

   
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style=" text-align: center; flex-grow: 1;">
    <!-- Indicators -->
    
    

     <%  List<Puestos> c = model.instance().getAllPuestos(); %>    
     
   
      
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" style="height: 120px; right:40px; ">

        
         <% for(Puestos s: c){ %>
      <div class="item active" style="height: 120px; right:40px; " >
          
           <div class="box">
               <h1 style="font-size: 90%;"><%= s.getNombrePuesto()%></h1>
               <p style="font-size: 70%;"> <%=s.getDescripcionPuesto() %> </p>
               <p style="font-size: 70%;"> ₡ <%=s.getSalario() %> </p>
              
</div>
         
      
        
          
      </div>
      <% } %>
        
     
    

      <div class="item">
         
        <div class="carousel-caption">
          
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div><br><br><br>
    
          
<%  List<Caracteristicas> cc = model.instance().getAllCaracteristicas(); %>

<div id="wrapper">

 <div style=" float:left; display:inline-block;   width: 400px;"> 

<h1 style="text-align: left; font-size: 150%;">Buscar Empleo </h1>

<form style="float: left;" class = "formempresa"  action="buscarPuestos" method="get">
    
     
 
 <table style="font-size: 10px;">
    
       <% for(Caracteristicas sc : cc){ %>
     <ul>
              <li>
                  
                <a style="font-size: 10px;"> <%= sc.getNombreCaracteristica()  %> </a>
 
                <ul>
                     
                     <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                    <% for(Area_Trabajo artr : at){ %>
                 <li>
 
                     <a > &#160;&#160;<%= artr.getNombreAreaTrabajo()  %> </a>
         
                     <ul>
                          <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                      <% for(Especializacion esp : es){ %>
                     
                       <li>
 
                           <a > &#160; &#160; <input  type="checkbox" name="names" value="<%= esp.getIdespecializacion()  %>"/> <%= esp.getNombreEspecializacion() %>&#160;&#160;&#160</a>
                          
                           
                       <a> &#160; &#160;    <span style="position:relative;">
                       <input  disabled="disabled" type="number" min="1" max="100" id="porcentaj"  name="porcentaje"   >
                       <div style="position:absolute; left:0; right:0; top:0; bottom:0; cursor: pointer;" ></div>
                        </span> &#160;&#160;&#160</a>
                           
                           
                       </li>

                       <% } %>
                     </ul>
 
                 </li>
                 
                    <% } %>

                </ul>

              </li>
 
            </ul>
     
              <% } %>
 </table>
 </div>
 
 
  <input type="hidden" id="longclicked"  name="longitud" value="${param.longitud}">
  
  <input type="hidden" id="latclicked"  name="latitud" value="${param.latitud}">
  
   

   

<script type="text/javascript">
        var map;
        
        function initMap() {                            
            var latitude = 10; // YOUR LATITUDE VALUE
            var longitude = -84; // YOUR LONGITUDE VALUE
            
             // Create the search box and link it to the UI element.
       
            
            var myLatLng = {lat: latitude, lng: longitude};
            
            map = new google.maps.Map(document.getElementById('map'), {
              center: myLatLng,
              zoom: 8.2,
              disableDoubleClickZoom: true, // disable the default map zoom on double click
            });
            
            // Update lat/long value of div when anywhere in the map is clicked    
            google.maps.event.addListener(map,'dragend',function(event) {                
                 document.getElementById('latclicked').value = event.latLng.lat();
                  document.getElementById('longclicked').value =  event.latLng.lng();
            });
            
            // Update lat/long value of div when you move the mouse over the map
            google.maps.event.addListener(map,'mousemove',function(event) {
                document.getElementById('latmoved').innerHTML = event.latLng.lat();
                document.getElementById('longmoved').innerHTML = event.latLng.lng();
            });
                    
            var marker = new google.maps.Marker({
              position: myLatLng,
              map: map,
              draggable: true,
              //title: 'Hello World'
              
              // setting latitude & longitude as title of the marker
              // title is shown when you hover over the marker
              title: latitude + ', ' + longitude 
            });    
            
            // Update lat/long value of div when the marker is clicked
            marker.addListener('dragend', function(event) {              
               document.getElementById('latclicked').value = event.latLng.lat();
                  document.getElementById('longclicked').value =  event.latLng.lng();
            });
            
            // Create new marker on double click event on the map
            google.maps.event.addListener(map,'dragend',function(event) {
                var marker = new google.maps.Marker({
                  position: event.latLng, 
                  map: map, 
                  title: event.latLng.lat()+', '+event.latLng.lng()
                });
                
                // Update lat/long value of div when the marker is clicked
                marker.addListener('dragend', function() {
                  document.getElementById('latclicked').value = event.latLng.lat();
                  document.getElementById('longclicked').value =  event.latLng.lng();
                });            
            });
            
     

            
            // Create new marker on single click event on the map
            /*google.maps.event.addListener(map,'click',function(event) {
                var marker = new google.maps.Marker({
                  position: event.latLng, 
                  map: map, 
                  title: event.latLng.lat()+', '+event.latLng.lng()
                });                
            });*/
        }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA&callback=initMap"
        async defer></script>
        
        
       
        
       
        <div class = "map" style="margin: 0 0 0 302px;  ">
            <h1>Localizacion</h1>
            <div id = "map" ></div>
        </div>
</div>
 
 

<button style = "background-color: slateblue;   width: 100%;  color: white; padding: 14px 20px;" type="submit">Buscar puesto</button>

</form>
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
 <script>
     
$("div").click(function (evt) {
    $(this).ready().prev("input[disabled]").prop("disabled", false).focus();
});
     
 </script>    

  <div id="body" style="margin: 0 auto; width:85%; display: inline-block; margin-left:20px;">   
        <div id="listar" class="area" style="width:50%;">   
            <br>
            <jsp:useBean id="buscarPuestos" scope="request" type="List<Puestos>" class="java.util.ArrayList"/>
            <table class="table table-striped">
              
              <thead><tr><td>Nombre</td><td>Descripcion</td><td>Salario</td></tr></thead>
              <tbody style="height: 250px;">
                <% for(Puestos s: buscarPuestos){ %>
                     <tr><td><%= s.getNombrePuesto() %></td><td><%= s.getDescripcionPuesto() %></td>
                     <td><%= s.getSalario()  %></td></tr><br>
               <% } %>
            </tbody>
            </table>
      </div>
    </div>
    

              
              <!--a href = "registroempresa.html" target = "_self">Registro empresa</a><br><br>
              <a href = "registrooferente.html" target = "_self">Registro oferente</a><br><br></div><br>
		   
		   <!--a href="registrooferente.html" target="frame" >Registro Oferente</a>
		   <a href="registroempresa.html" target="frame" >Registro Empresa</a>
		   <iframe name="frame"> </iframe-->
         
	
    

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="LoginEm" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
       <img src='images/empresa.png' alt="Avatar" class="avatar">
    </div>

    <div class="container">
      
      <input class="formfield" type="text" name="correoEmpresa" placeholder="Usuario" required><br>
       <input class="formfield" type="password" name="clave" placeholder="Clave" required><br>
           
       <button type="submit">Ingresar</button>
      
    </div>

    
  </form>
</div>
                   
  
 
 <div id="id02" class="modal">
  
  <form class="modal-content animate" action="LoginOf" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
       <img src='images/login.jpg' alt="Avatar" class="avatar">
    </div>

    <div class="container">
      
     <input class="formfield" type="text" name="correoOferente" placeholder="Usuario" required><br>

     
      <input class="formfield" type="password" name="clave" placeholder="Clave" required><br>
        
      <button type="submit">Ingresar</button>
      
    </div>

    
  </form>
</div>                  
                   
                   
                   
                   

<script>
// Get the modal
var modal = document.getElementById('id01');

var modal1 = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal ) {
        modal.style.display = "none";
    }
    
    
    if (event.target == modal1 ) {
        modal1.style.display = "none";
    }
    
}
</script>         
                   
                   
                   

     
  </body>
  
          
</html>