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
 
              
        </ul>
    
</div>
        
