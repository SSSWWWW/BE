<%-- 
    Document   : registroempresa
    Created on : Mar 17, 2018, 1:30:57 PM
    Author     : pc

AIzaSyBrXs6HgONS-8MYrHKdnSFs3VQBbt5EYaA
--%>



<%@page import="entidades.Especializacion"%>
<%@page import="entidades.Area_Trabajo"%>
<%@page import="logica.model"%>
<%@page import="entidades.Caracteristicas"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>

<HTML>
  <HEAD>
    <TITLE>Verifying User Data</TITLE>
    <SCRIPT LANGUAGE="JavaScript">

        function checker()
        {
            var regExp1 = '/^(\d{1,2})\/(\d{1,2})\/(\d{2})$/' ;
            var result1 = document.form1.text1.value.match(regExp1);
            if (result1 == null || <*any other input doesnt satisfy the required format*>) {
                alert("Sorry, that's not a valid date.");
                document.form1.text1.focus(); // or document.<formname>.<element_name>.focus();
                return;
            } else {
                document.form1.action="<NextPage.jsp>" ;
                document.form1.method="GET"; // or "POST"
                document.form1.submit();

            }
        }

    </SCRIPT>
</HEAD>

<BODY>
    <H1>Verifying User Data</H1>
    <FORM NAME="form1"  >
        Please enter a date:
        <INPUT TYPE="TEXT" NAME="value1">
        <INPUT TYPE="<sometype>" NAME="value2">
        <INPUT TYPE="<sometype>" NAME="value3">
        ..
        ..
        <INPUT TYPE="button" onclick="checker()">
</html>