<%-- 
    Document   : datosEmpresa
    Created on : Mar 24, 2018, 10:07:24 AM
    Author     : pc
--%>

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
 <title>Oferente</title>
 <link href="css/registrooferente.css" rel="stylesheet" type="text/css"/>  
</head>
<body>
    
    
<jsp:useBean id="empresa" scope="session" type="Empresa" />




<div class = "datOf" >
    
   
    <table class="grid">
        <caption>Empresa</caption>
        
        <tr><td><%=empresa.getNombreEmp() %></td></tr><br><br>
        <tr><td><%=empresa.getDescripcionEmp() %></td></tr><br><br>
        <tr><td><%=empresa.getCorreoEmp() %></td></tr>
        <tr><td><%=empresa.getTelefono() %></td></tr>
       
       
    </table>
        
        
        </div>
        
       
        
    <br>
    
    
    
 <style>          
          #map { 
            height: 150px;    
            width: 180px;            
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
        
        <div class = "map" >
            <div id = "map" ></div>
        </div><br>
        
        
        <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
        
         <form action="AgregarPuesto" method="post" class="fem">
                      <legend>Agregar nuevo puesto</legend>
           <input class="formfield" type="text" name="nombrePuesto" placeholder="Nombre " required><br>
           <input class="formfield" type="text" name="descripcionPuesto" placeholder="Descripcion" required><br>
           <input class="formfield" type="text" name="salarioPuesto" placeholder="Salario" required><br>
          
            <table class="grid" id="example">
              
              
              <tbody style="height: 250px;">
                <% for(Caracteristicas sc : c){ %>
              <input type="radio"> <%= sc.getNombreCaracteristica()%><br>
                        
                        <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                        <% for(Area_Trabajo artr : at){ %>
                <input type="radio" style="margin-left: 12px;"> <%= artr.getNombreAreaTrabajo()  %><br>
                      <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                       <% for(Especializacion esp : es){ %>
                        
                        <input type="radio" style="margin-left: 24px;"> <%= esp.getNombreEspecializacion()  %><br>
                 <% } %>
                                
               <% } %>
               
           <% } %>
               
            </tbody>
            </table>

           
           
           
           
           <input class="formfield"  type="submit" value="Agregar Puesto">
           </form>
           
           
       

             
            
<div class = "salir" >
    <ul class="menu">
        <li><a href="#"><%=empresa.getIdEmp() %>-<%=empresa.getNombreEmp() %><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
           
         
            
</div>
            
             <a href = "principal.jsp" target = "_self">Regresar</a></center>
            
</body>
</html>
