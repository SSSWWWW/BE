<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Incorrecto</title>
  <link href="css/style.css" rel="stylesheet" type="text/css"/>  
</head>
<body>
    <div> <img src="images/footer.jpg" alt=""> </div>
    <jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String" />
    <div class="area" style="width:70%">   
        <div style="color:red; font-size: 30px;"> <%=error%></div>
        <div style="color:red; font-size: 30px;"> Intente <a href="principal.jsp"> ingresar</a> de nuevo</div>
   </div>
</body>
</html>
