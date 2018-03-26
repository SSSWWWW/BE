<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Google Map</title>
       
    <body>
              <script type="text/javascript"> 
        
        var counter = 1;
var limit = 3;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Entry " + (counter + 1) + " <br><input type='text' name='myInputs[]'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
            </script>
            
  <script src="/wp-includes/js/addInput.js" language="Javascript" type="text/javascript"></script>
<form method="POST">
     <div id="dynamicInput">
          Entry 1<br><input type="text" name="myInputs[]">
     </div>
     <input type="button" value="Add another text input" onClick="addInput('dynamicInput');">
</form>
            
    </body>    
</html>