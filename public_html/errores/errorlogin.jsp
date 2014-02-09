<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.io.*"%>
<%@ page isErrorPage="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    </head>
    <body>
        <h1><center>Errorrrrrrr accesooooooo</center></h1>
        <% 
        PrintWriter pw =new PrintWriter(out);
        exception.printStackTrace(pw);
        %>
    </body>
</html>