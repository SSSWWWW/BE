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
<div class ="salir" id="header" style=" margin: 0; padding: 0; border: 0; outline: 0; ">
    
   
    
    
        <ul class="menu" >
            
            
            
            <% if (empresa!=null){%>
              <li><a href="datosEmpresa.jsp" style = "font-family : Impact, Charcoal, sans-serif;"><%=empresa.getIdEmp() %>-<%=empresa.getNombreEmp() %></a>
                <ul class="menuitem" > <li> <a href="Logout" style = "font-family : Impact, Charcoal, sans-serif;">Salir</a></li> </ul>
              </li>
              
            <% }%>
            
            <% if (oferente!=null){%>
              <li><a href="datosOferente.jsp" style = "font-family : Impact, Charcoal, sans-serif;" ><%=oferente.getCedulaOferente() %>-<%=oferente.getNombreOferente() %></a>
                <ul class="menuitem" > <li> <a href="Logout" style = "font-family : Impact, Charcoal, sans-serif;">Salir</a></li> </ul>
              </li>
            <% }%>
            
            
            <% if(empresa==null && oferente==null) {%>

             
                  <ul>
              <li>
                <a href="#" style="color:slateblue;">Registro &nbsp; </a>
                
                <ul>
                 <li><a href="registroempresa.jsp">Registro empresa</a></li>
                  <li><a href="registrooferente.jsp">Registro oferente</a></li>
                </ul>
              </li>
            </ul>
          
           <ul>
              <li>
                <a href="#" style="color:slateblue;">Inicio</a>
                <ul>
                 <li><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;" >Inicio empresa</a></li>
                  <li><a onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Inicio oferente</a></li>
                </ul>
              </li>
            </ul>
            
            
            
            
            <% }%>
            
            
            
            
            
 
              
        </ul>
    
</div>
        
