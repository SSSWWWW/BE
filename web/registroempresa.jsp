<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
   

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="initial-scale=1.0">


<link rel = "stylesheet" href = "css/registroempresa.css">
   

   <head >
    <title>Registro Empresa</title>
  </head>

  
       <body> 
      <h1>REGISTRO EMPRESA</h1>
      
  
           <%
    if(null!=request.getAttribute("error"))
    {
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
  
   <form class = "formempresa"  action="agregarEmpresa" method="get">
 <div class = "divempresa">
     
   
 

  <input type="text" placeholder = "Nombre" name="nombreempresa" value="${param.nombreempresa}"><br><br>
  
  <input type="email" placeholder = "e-mail" name="email" value="${param.email}"><br><br>
 
  <input type="password" placeholder = "password" name="contrasena" value="${param.contrasena}"><br><br>
  
  <input type="tel" placeholder = "telefono" name="telefono" value="${param.telefono}"><br><br>
   
  <input type="text" placeholder = "descripcion" name="descripcion" value="${param.descripcion}"><br><br>
  
  <input type="hidden" id="latclicked"  name="longitud" value="${param.longitud}"><br><br>
  
  <input type="hidden" id="longclicked"  name="latitud" value="${param.latitud}"><br><br>
  
    
  
  

  </form><br><br>

<head>

<h1>Localizacion</h1>

 <style>          
          #map { 
            height: 300px;    
            width: 600px;            
          }          
        </style> 
        

<script type="text/javascript">
        var map;
        
        function initMap() {                            
            var latitude = 10; // YOUR LATITUDE VALUE
            var longitude = -84; // YOUR LONGITUDE VALUE
            
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
            /*google.maps.event.addListener(map,'mousemove',function(event) {
                document.getElementById('latmoved').innerHTML = event.latLng.lat();
                document.getElementById('longmoved').innerHTML = event.latLng.lng();
            });*/
                    
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
        
        
       
        
        
        
        <div class = "map" style="padding:10px">
            <div id = "map" ></div>
        </div>

 
<input type="submit" value="Continuar" ></div>

	  
	  <center>
      <a href = "principal.jsp" target = "_self">Regresar</a></center>
  
     
  </body>
</html>
