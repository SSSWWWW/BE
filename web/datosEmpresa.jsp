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

        
        
        <script src="js/jquery.js"></script>
        <script>
            $(document).ready(function(){
                document.getElementById("nombrePuesto").value = localStorage.getItem("item1");
                document.getElementById("descripcionPuesto").value = localStorage.getItem("item2");
                document.getElementById("salarioPuesto").value = localStorage.getItem("item3");
               
               
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("item1",document.getElementById("nombrePuesto").value);
                 localStorage.setItem("item2",document.getElementById("descripcionPuesto").value);
                 localStorage.setItem("item3",document.getElementById("salarioPuesto").value);
                
                
               
            });

        </script>
        
        
        
        <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
        
         <form action="agregarPuesto" method="post" class="fem">
                      <legend>Agregar nuevo puesto</legend>
           <input class="formfield" type="text" name="nombrePuesto" id="nombrePuesto" placeholder="Nombre " required><br>
           <input class="formfield" type="text" id="descripcionPuesto" name="descripcionPuesto" placeholder="Descripcion" required><br>
           <input class="formfield" type="number" id="salarioPuesto" name="salarioPuesto" placeholder="Salario" required><br>
          
            
              
              
             <select name="caracteristicas" id="caracteristicas">
                 
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
               
           <input class="formfield" type="hidden" id="aux" name="aux" placeholder="Porcentaje caracteristica" required>   
   
              <select style="display: none;" name="id" id="id">
             <option value="<%= empresa.getIdEmp() %>"><%= empresa.getIdEmp() %></option>

                  </select>

               
              <input class="formfield" type="number" name="porcentaje" placeholder="Porcentaje caracteristica" required><br>    
               
               
               
        
            

           
           
           
           
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
