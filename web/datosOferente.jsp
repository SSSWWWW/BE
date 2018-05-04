<%-- 
    Document   : datosOferente
    Created on : Mar 21, 2018, 9:37:00 AM
    Author     : pc
--%>

<%@page import="entidades.EspecializacionIncluidaOferente"%>
<%@page import="entidades.Especializacion"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="logica.model"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Caracteristicas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entidades.Oferente" %>
<!DOCTYPE html>
<html>
    
<head>
 <title>Oferente</title>
  <link href="css/datosEmpresa.css" rel="stylesheet" type="text/css"/>  
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
</head>

<jsp:useBean id="oferente" scope="session" type="Oferente" />

<div style= 'background-image:  url("images/wallpaper.jpg"); height: 100px; width: 2300px; border: 1px solid black;' > 
    
    
    
</div>

<div class = "datOf" style=" float:left; display:inline-block; vertical-align:top; ">

<div class = "datOf" >
    
    <div style="left: 0px; width: 270px; top: 40px; " >  
    <table class="table">
    <thead class="thead-dark">
       
        
        <tr><td><%=oferente.getNombreOferente()%> <%=oferente.getPrimerApellido() %></td></tr><br><br>
        <tr><td><%=oferente.getCedulaOferente()%></td></tr>
        <tr><td><%=oferente.getCorreoOferente() %></td></tr>
        <tr><td><%=oferente.getCelular() %></td></tr>
        <tr><td><%=oferente.getNacionalidad() %></td></tr>
        <tr><td><%=oferente.getUbicacion() %></td></tr>
        
        
         <%  List<Caracteristicas> c = model.instance().getAllCaracteristicas(); %>
        
       <br>  
        
            
    </table>
    <br>
  
 </div>
         
      
         
         
</div>
         
         
         
         
         
         <form   method="POST" id="formoferente" class="fem" >
                      <legend id="leg" >Agregar caracteristicas</legend>
           
                      <input class="formfield" type="hidden" id="cedulaOferente" name="cedulaOferente" value="<%= oferente.getCedulaOferente() %>">
            
              
              
             <select name="caracteristicas" id="caracteristicas">
                 
              <option value="" selected>Caracteristicas</option>
                 
                <% for(Caracteristicas sc : c){ %>
                
                <option > <%= sc.getNombreCaracteristica()%></option>
                        
                        <% List<Area_Trabajo> at = model.instance().getArea_Trabajo( sc.getNombreCaracteristica());%>
                        <% for(Area_Trabajo artr : at){ %>
                        <option >&#160; <%= artr.getNombreAreaTrabajo()  %></option>
                      <% List<Especializacion> es = model.instance().getEspecializacion(artr.getNombreAreaTrabajo());%>
                       <% for(Especializacion esp : es){ %>
                       <option id="nombreesp" value="<%= esp.getIdespecializacion() %>">&#160;&#160;&#160; <%= esp.getNombreEspecializacion() %></option>
                        
                       
                 <% } %>
                                
               <% } %>
               
           <% } %>
               </select><br>
               
   

           

               
              <input id="porcentaj" class="formfield" type="number" name="porcentaje" value="${param.porcentaje}" placeholder="Porcentaje caracteristica" required><br>    
              
           
           <input onclick="add(); actualizarlista();" id="ag" type="submit" value="Agregar Caracteristica">
           </form><br><br>
              
              
         
                   
        <%
    if(null!=request.getAttribute("error"))
    {
       out.println("Se ha dado el siguiente error... " + request.getAttribute("error") + "...Intente de nuevo"); 
    }
%>
       

 <form method="POST" action="upload" enctype="multipart/form-data" onsubmit="alert('Curriculum agregado!')">
             <legend>Subir curriculum (formato .pdf)</legend>
           <input type="file" value="<%= oferente.getCedulaOferente() %>" name="file" id="file" /> <br/>
            Buscar:
            
            <input type="hidden"  name="cedula" value="<%= oferente.getCedulaOferente() %>">
            <input type="hidden" value="C:\Users\pc\GlassFish_Server\glassfish\domains\domain1\applications\__internal\BolsaEmpleo" name="destination"/>
            <input type="submit" value="Subir" name="upload" id="upload" />
        </form>


</div>

 <div class="container" style="display:inline-block; width:350px; height: 540px; ">

<form action="listarCaracteristicasOferente" method="get" class = "formoferente" >
  
  <input type="hidden"  name="cedula" value="<%= oferente.getCedulaOferente() %>"><br>
   
 
 <button style="background-color: slateblue; font-weight: bold"type="submit">Ver caracteristicas</button>

  </form>

    <script type="text/javascript" src="js/ajax.js"></script> 
<script> 
    
    
    function actualizarlista(){
        
         espOf = {idespecializacion: document.getElementById("caracteristicas").value,
			porcentajeEspecializacion: document.getElementById("porcentaj").value,
			//sexo: document.querySelector("input[name='sexo']:checked").value
                        cedulaOferente: document.getElementById("cedulaOferente").value
      };
          ajax({"method": "POST", 
                  "url":"listarCaracteristicasOferente", 
                  "data": espOf,
                  "success": 
                    function(obj){
                      //  updateList(obj); 
                       // document.getElementById("formulario").reset();
                        window.alert("Caracteristica actualizada");
                       
                        
                    },
                 
                 "error": function(status){
                         window.alert("Error actualizar");
                    }  
                                   
                });  
        
        
    }
    
         function add(){
          
       //   var car = document.getElementById("nombreesp").value;
          
     //    window.alert("car " + car);
   
       espOf = {idespecializacion: document.getElementById("caracteristicas").value,
			porcentajeEspecializacion: document.getElementById("porcentaj").value,
			//sexo: document.querySelector("input[name='sexo']:checked").value
                        cedulaOferente: document.getElementById("cedulaOferente").value
      };
          //     window.alert("car " + espOf.cedulaOferente + " " + espOf.idespecializacion + " " + espOf.porcentajeEspecializacion);
                 
            ajax({"method": "POST", 
                  "url":"agregarCaracteristicaOferente", 
                  "data": espOf, 
                  "success": 
                    function(obj){
                      //  updateList(obj); 
                       // document.getElementById("formulario").reset();
                        window.alert("Caracteristica agregada");
                       
                        
                    },
                  "error": function(status){
                         window.alert("Error aqui");
                    }                    
                });         
  }  
    
    
    function editar(nombreesp , idesp , porcentaje){
    
       
    
         // alert("You have reached the limit of adding  inputs " + idpuesto);
          document.getElementById("leg").innerHTML = "Editar caracteristica";
          document.getElementById("ag").value = "Editar";
         //  document.getElementById("nombreesp").value = nombreesp;
           document.getElementById("porcentaj").value = porcentaje;
           document.getElementById("caracteristicas").value = idesp;
          //  document.getElementById("salarioPuesto").value = salario;
          //  document.getElementById("estado").value = estado;
            
          document.getElementById("formoferente").action = 'editarespecializacionOf';
       
      //    document.getElementById("idpu").value = idpuesto;
   
}


    
    
</script> 





  
  
   
  
      <div id="body" >   
        <div id="listar" class="area" style="width:50%;">   
            
            <jsp:useBean id="listarCaracteristicasOferente" scope="request" type="List<EspecializacionIncluidaOferente>" class="java.util.ArrayList"/>
            
              <div  style="overflow-x: auto; width:350px; height: 189px;">

             <table style="overflow-x: auto; width:350px; height: 189px;" class="tablecarac table-bordered table-sm"> 
              
              <thead style="background-color: slateblue"><tr><th>Caracteristica</th><th>Porcentaje</th></tr></thead>
              <tbody style="height: 100px;">
                <% for(EspecializacionIncluidaOferente s: listarCaracteristicasOferente){ %>
                     <tr><td id="idcarac" value="<%= s.getCedulaOferente() %>"   ><%= s.getNombreEspecializacion() %></td><td><%= s.getPorcentajeEspecializacion() %></td>
                     <td><img  src='images/edit.png'onClick="editar('<%= s.getNombreEspecializacion() %>' , '<%= s.getIdespecializacion() %>' , '<%= s.getPorcentajeEspecializacion() %>');" class='icon'></td>
                     </tr>
               <% } %>
            </tbody>
            </table>
          
            
              </div>
      </div>
    </div>  
  
    </div>
            



<div class = "salir" style="position:fixed ; top:0%; right:0%;" >
    <ul class="menu">
        <li><a href="#"><%=oferente.getCedulaOferente() %>-<%=oferente.getNombreOferente() %><img class="inline" src="images/down.png" alt=""></a>
            <ul class="menuitem" > <li> <a href="Logout">Salir</a></li> </ul>
        </li>
    </ul>
</div>
            
             <a href = "principal.jsp" target = "_self" style="position: fixed;top: 0%;left: 0%;">Regresar</a></center>
            
</body>
</html>
