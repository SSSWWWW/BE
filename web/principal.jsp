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

  <style>          
          #map1 { 
            height: 100px;    
            width: 270px;            
          }          
        </style> 
  
  
  <body>
      
   
            
                 
   <h1 style=" text-align: center; font-size:5vw; "><a href="principal.jsp" style="font-weight: bold;" > Bolsa Empleo </a></h1>

   
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style=" text-align: center; flex-grow: 1;">
    <!-- Indicators -->
    
    

     <%  List<Puestos> c = model.instance().getAllPuestos(); %>    
     
   
      
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" style="height: 120px; right:40px; ">

        
         <% for(Puestos s: c){ %>
      <div class="item active" style="height: 120px; right:40px; " >
          
           <div  class="box" onClick="mostrarPuesto('<%= s.getNombrePuesto() %>' , '<%= s.getDescripcionPuesto() %>' , '<%= s.getSalario() %>' , '<%= s.getIdPuesto() %>' , '<%= s.getLongitud() %>' , '<%= s.getLatitud() %>' , '<%= s.getNombreEmpresa() %>' );"  >
              
               <div class="carousel-item">
               <img onclick="document.getElementById('modalpuesto').style.display='block'" style= " max-height:20%; max-width:20%;" src="<%= s.getNombreEmpresa() %>" >
               </div>
               <a  id="nopu"  ><%= s.getNombrePuesto()%></a>
             
               
              
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
     
   

 <div style=" float:left; display:inline-block;   width: 400px; "> 
     
     <form  class = "formempresa"  action="buscarPuestos" method="get">
  
         <% for(Caracteristicas sc : cc){ %>
  
<ul class="tree" id="tree">
  <li><a ><%= sc.getNombreCaracteristica()  %></a>
    <ul>
        <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
        <% for(Area_Trabajo artr : at){ %>
      <li><a><%= artr.getNombreAreaTrabajo()  %></a>
        <ul>
            <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
            <% for(Especializacion esp : es){ %>
          <li><a> &#160; &#160; <input type="checkbox" name="names" value="<%= esp.getIdespecializacion()  %>"/> <%= esp.getNombreEspecializacion() %></li>
          
          <a><span style="position:relative;">
                       <input  disabled="disabled" type="number" min="1" max="100" id="porcentaj"  name="porcentaje"   >
                       <div style="position:absolute; left:0; right:0; top:0; bottom:0; cursor: pointer;" ></div>
                        </span> &#160;&#160;&#160</a>
          
        <% } %>
                     </ul>
 
                 </li>
                 
                    <% } %>

                </ul>

              </li>
 
            </ul>
     
              <% } %>
 </table>
              
              
      
 <script>


var tree = document.querySelectorAll('ul.tree a:not(:last-child)');
for(var i = 0; i < tree.length; i++){
    tree[i].addEventListener('click', function(e) {
        var parent = e.target.parentElement;
        var classList = parent.classList;
        if(classList.contains("open")) {
            classList.remove('open');
            var opensubs = parent.querySelectorAll(':scope .open');
            for(var i = 0; i < opensubs.length; i++){
                opensubs[i].classList.remove('open');
            }
        } else {
            classList.add('open');
        }
    });
}

</script>


<style>
    
 ul.tree li {
    list-style-type: none;
    position: relative;
   
}

ul.tree li ul {
    display: none;
}

ul.tree li.open > ul {
    display: block;
}
   
    
    </style>
  
 
 
 
  <input type="hidden" id="longclicked"  name="longitud" value="${param.longitud}">
  
  <input type="hidden" id="latclicked"  name="latitud" value="${param.latitud}">
  
  
 
   

   

<script type="text/javascript">
        var map , map1;
        
        function initMap() { 
            
            
           
            
            
            var latitude = 10; // YOUR LATITUDE VALUE
            var longitude = -84; // YOUR LONGITUDE VALUE
            
        
       
            
            var myLatLng = {lat: latitude, lng: longitude};
           
            
            map = new google.maps.Map(document.getElementById('map'), {
              center: myLatLng,
              zoom: 8.2,
              disableDoubleClickZoom: true, // disable the default map zoom on double click
            });
            
             map1 = new google.maps.Map(document.getElementById('map1'), {
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
            
            var circle = new google.maps.Circle({
            map: map,
             radius: 5000,    //  in metres
             fillColor: '#AA0000'
             });
              circle.bindTo('center', marker, 'position');
            
            google.maps.event.addDomListener(
   document.getElementById('circle_radius'), 'change', function() {
       circle.setRadius(document.getElementById('circle_radius').value * 1000);
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
        
        
        
        function mostrarPuesto(nombrePuesto , descripcion, salario, idpuesto, lat , lon, nombreemp ){
    
    
    
    document.getElementById("nombrePues").value = nombrePuesto;
    $("#desPues").val(descripcion);
    $("#sal").val(salario);
    $("#idEmp").val(idpuesto);
    $("#modalim").attr('src', nombreemp);
    
    puestos = idpuesto;
    
        $.ajax({type: "POST", 
                  url:"listarPuestosNP", 
                  data: {puestoA: puestos},
                  dataType:"json",
                   
                    success: function(obj){
                  
     
                                   
                   for(var i=0;i<obj.length;i++)
                   {  
                       
                    var input = document.createElement('div');
                    input.id = "nuDiv";
                   
                    var carac = obj[i].nombreEspecializacion;
                   
                    var porcen = obj[i].porcentajeEspecializacion;
                    
                   
          
          input.innerHTML = " <table> <tr> <td style=' padding-right: 80px; text-align: center;'> &#160;&#160;&#160;"  +carac+"</td> <td style=' padding-right: 80px; text-align: center;'>"+porcen+"</td> <tr> </table>";
          document.getElementById("caracDiv").appendChild(input);   
                    
                    
               
            
            
                       
               //      window.alert(obj[i].nombreEspecializacion + " " + obj[i].porcentajeEspecializacion);
                   }
                   },
                  error: function(status){
                         window.alert("Error");
                    }                    
                });         
                
                
             
   
    
    
}
        
        
        //this can now be called from anywhere
function placeMarker(location) {
  var marker2 = new google.maps.Marker({
    position: location,
   
    map: map1
    
 
    
  });
}
        
        
        
           function mostrarPuesto1(nombrePuesto , descripcion, salario, idpuesto, lat, lon, nombreem ){
    
    
    
    document.getElementById("nombrePues1").value = nombrePuesto;
    $("#desPues1").val(descripcion);
    $("#sal1").val(salario);
    $("#idEmp1").val(idpuesto);
    $("#modali").attr('src', nombreem);
    
    puestos = idpuesto;
    
        $.ajax({type: "POST", 
                  url:"listarPuestosNP", 
                  data: {puestoA: puestos},
                  dataType:"json",
                   
                    success: function(obj){
                  
     
                                   
                   for(var i=0;i<obj.length;i++)
                   {  
                       
                    var input = document.createElement('div');
                    input.id = "nuDiv";
                   
                    var carac = obj[i].nombreEspecializacion;
                   
                    var porcen = obj[i].porcentajeEspecializacion;
                    
                   
          
          input.innerHTML = " <table> <tr> <td style=' padding-right: 80px; text-align: center;'> &#160;&#160;&#160;"  +carac+"</td> <td style=' padding-right: 80px; text-align: center;'>"+porcen+"</td> <tr> </table>";
          document.getElementById("caracDiv1").appendChild(input);   
                    
       var la= lat;
       var lo = lon;
           
                 
                  
                var latlng = new google.maps.LatLng(lat, lon);
                  
             //    window.alert("lat " + myLatLng.lat + " lon " + myLatLng.lng);
             
             placeMarker(latlng);   
             map1.setCenter(latlng);
       
                  
               
                       
               //      window.alert(obj[i].nombreEspecializacion + " " + obj[i].porcentajeEspecializacion);
                   }
                   },
                  error: function(status){
                         window.alert("Error");
                    }                    
                });         
                
                
    
    
}
        
        
        
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA&callback=initMap"
        async defer></script>
        
       
    
       
        
       
        <div class = "map" style="margin: 0 0 110 302px;   ">
            <h1 style="display: inline-block;">Localizacion</h1>
            <input  style="width:60px; height: 60px;  -webkit-border-radius: 65px;-moz-border-radius: 65px; border-radius: 65px; " class="formfield" type="text" name="circle_radius" id="circle_radius">
         
            <div id = "map" ></div>
        </div>
</div>
  
   <div id="body" style="margin: 0 auto; width:85%;  margin-left:720px; top:200px; ">   
        <div id="listar" class="area" style="width:50%;">   
            <br>
            <jsp:useBean id="buscarPuestos" scope="request" type="List<Puestos>" class="java.util.ArrayList"/>
            <table class="table">
              
              <thead style='background: slateblue; color: white;' ><tr><td>Nombre</td><td>Descripcion</td><td>Salario</td></tr></thead>
              <tbody   style="height: 250px;">
                  <% 
                      int con =0;
                      for(Puestos s: buscarPuestos){ %>
                     
                      <% con++; if(con < 2) { %>
                     <tr onClick="mostrarPuesto1('<%= s.getNombrePuesto() %>' , '<%= s.getDescripcionPuesto() %>' , '<%= s.getSalario() %>' , '<%= s.getIdPuesto() %>' , ' <%= s.getLongitud() %>' , '<%= s.getLatitud() %>', '<%= s.getUrlEmpresa() %>' );"  ><td onclick="document.getElementById('modalpuesto1').style.display='block'"  ><%= s.getNombrePuesto() %></td><td><%= s.getDescripcionPuesto() %></td>
                     <td><%= s.getSalario()  %>  </td><td id="lonpu" value="<%= s.getLatitud()  %>" ></td> <td id="latpu" value="<%= s.getLongitud()  %>"></td>  </tr><br>
             
              
             <% } %>
             
              <% } %>
            </tbody>
            </table>
            
            <div id="out"></div>
            
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
           
       <button style='background: slateblue;' type="submit">Ingresar</button>
      
    </div>
      
            <%
    if(null!=request.getAttribute("error"))
    {
       
        
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>

    
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
        
      <button style='background: slateblue;' type="submit">Ingresar</button>
      
    </div>

      
              <%
    if(null!=request.getAttribute("error"))
    {
       
        
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
    
  </form>
</div>                  
           
                   
                   
                   
  <div id="modalpuesto" class="modal" >
  
  <form class="modal-content animate"  method="post" >
    <div class="imgcontainer">
      <span onclick="cerrarModalPuesto();" class="close" title="Close Modal">&times;</span>
  
    </div>

    <div class="container" >
        
        <img  style= " max-height:20%; max-width:20%;" id="modalim" src="" >
      
     <input class="formfield" type="text" name="nombrePues" id="nombrePues" style="width:200px;"><br>

     <input class="formfield" type="text" name="desPues" id="desPues">
     
     <input class="formfield" type="text" name="sal" id="sal">
     

     <div id="caracDiv"> 
         
        
         <table style="border-spacing: 10px; border-collapse: separate; ">
             <tr>
              <div id="caracDiv">   
             <th>Caracteristica</th>
             <th>Porcentaje</th>
             </tr>
         
         </table>
               
     </div>
        
     
      
    </div>

    
  </form>
</div>           
                   
                   
                   
                   
                   
      
      
      
  <div id="modalpuesto1" class="modal" >
  
  <form class="modal-content animate"  method="post" >
    <div class="imgcontainer">
      <span onclick="cerrarModalPuesto();" class="close" title="Close Modal">&times;</span>
       <img  style= " max-height:20%; max-width:20%;" id="modali" src="" >
    </div>

    <div class="container" >
      
     <input class="formfield" type="text" name="nombrePues1" id="nombrePues1">

     <input class="formfield" type="text" name="desPues1" id="desPues1">
     
     <input class="formfield" type="text" name="sal1" id="sal1">
     

     <div id="caracDiv1"> 
         
        
         <table style="border-spacing: 10px; border-collapse: separate; ">
             <tr>
              <div id="caracDiv1">   
             <th>Caracteristica</th>
             <th>Porcentaje</th>
             </tr>
         
         </table>
               
     </div>
             
             
               <div class = "map1" style="margin: 0 0 0 302px;  ">
            
         
            <div id = "map1" ></div>
        </div>
             
             
     
 
            
    </div>

    
  </form>
</div>               
            
                   
            
       

        
        
        
        
     
        
        
        
                      

<script>
// Get the modal
var modal = document.getElementById('id01');

var modal1 = document.getElementById('id02');

var modalpuesto = document.getElementById('modalpuesto');

var modalpuesto1 = document.getElementById('modalpuesto1');

var np = document.getElementById('nopu');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal ) {
        modal.style.display = "none";
    }
    
    
    if (event.target == modal1 ) {
        modal1.style.display = "none";
    }
    
    if (event.target == modalpuesto ) {
        
         
        modalpuesto.style.display = "none";
    }
    
    
      if (event.target == modalpuesto1 ) {
        
         
        modalpuesto1.style.display = "none";
    }
    
   // $("#nombrePues").val(np);
	
    
}








function cerrarModalPuesto(){
    
    
    document.getElementById('modalpuesto').style.display='none';
    $('#nuDiv').remove();
     window.location.reload(false); 
}


 function CloseMe()
         {
             
             window.location.reload(false); 
           //  window.opener.location.reload();
         //    window.close();
         }
        
         
         
         
         
         
      
         
         
            

</script>         
                   
                   
                   

     
  </body>
  
          
</html>