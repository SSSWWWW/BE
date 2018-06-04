<%-- 
    Document   : Header
    Created on : Mar 25, 2018, 3:42:51 PM
    Author     : pc
--%>
<%@page import="entidades.Empresa"%>
<%@page import="entidades.Oferente"%>
<% Empresa empresa= (Empresa) session.getAttribute("empresa");%>
<% Oferente oferente= (Oferente) session.getAttribute("oferente");%>

 <link href="css/principal.css" rel="stylesheet" type="text/css"/>  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
 <nav class="navbar navbar-default">  
  
     <style>
         
 

ul li:hover {}
ul li:hover ul {display: block;}
ul li ul {

  width: 150px;
  display: none;
}
ul li ul li { 
  background: white; 

}
ul li ul li a {display:block !important;} 
ul li ul li:hover {}


ul.menu{list-style: circle; padding:0; }
ul.menu li a {text-decoration: none;}
ul.menuitem{display: none; list-style: none; padding:0; padding-left:10px;}
ul.menuitem li a {text-decoration: none;}
ul.menu:hover li ul.menuitem{display: block} 
         
         
         </style>
     
     
     
<div class ="salir" id="header" style=" margin: 0; padding: 0; border: 0; outline: 0; ">
      <ul class="menu" style="  display: inline;  margin: 0; padding: 0;" >
            
            
            
            <% if (empresa!=null){%>
              <li><a href="datosEmpresa.jsp" style = "display: inline-block; font-family : Impact, Charcoal, sans-serif;"><%=empresa.getIdEmp() %>-<%=empresa.getNombreEmp() %></a>
                <ul class="menuitem" > <li> <a href="Logout" style = "position: absolute; font-family : Impact, Charcoal, sans-serif;  display: inline;  margin: 0; padding: 0;">Salir</a></li> </ul>
              </li>
              
            <% }%>
            
            <% if (oferente!=null){%>
              <li><a href="datosOferente.jsp" style = "display: inline-block; font-family : Impact, Charcoal, sans-serif;" ><%=oferente.getCedulaOferente() %>-<%=oferente.getNombreOferente() %></a>
                <ul class="menuitem" > <li> <a href="Logout" style = " position: absolute;  font-family : Impact, Charcoal, sans-serif; display: inline;  margin: 0; padding: 0;">Salir</a></li> </ul>
              </li>
            <% }%>
            
            
            <% if(empresa==null && oferente==null) {%>

             
                  <ul style="display: inline;  margin: 0; padding: 0;">
              <li style="display: inline-block;"  >
                <a href="#" style="color:slateblue;"> <span class="glyphicon glyphicon-user"></span> &nbsp; </a>
                
                <ul style="position: absolute;" >
                 <li><a href="registroempresa.jsp" >  Registro empresa</a></li>
                  <li><a href="registrooferente.jsp">Registro oferente</a></li>
                </ul>
              </li>
            </ul>
          
           <ul style="display: inline;  margin: 0; padding: 0;">
              <li style="display: inline-block;">
                <a href="#" style="color:slateblue;"><span class="glyphicon glyphicon-log-in"></span></a>
                <ul style="position: absolute;" >
                 <li><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;" >Inicio empresa</a></li>
                  <li><a onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Inicio oferente</a></li>
                </ul>
              </li>
            </ul>
             
          
            <% }%>
          
              
        </ul>
    
</div>
        
 </nav>