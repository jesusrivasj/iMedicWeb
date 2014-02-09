<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="modelo.Personal"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <link rel='stylesheet' media='screen' href='styles/main.css' type='text/css'/>
        <title>Menu principal - iMedic</title>
    </head>
    <body>
        <div id="perfil">
            <% 
                Personal perfil = (Personal) session.getAttribute("perfil");
                out.println(perfil.mostrarDatosUsuarioWeb());
            %>
        </div>
            <%
                for(int i=0;i<=50;i++){
                    out.println("<p>prueba</p>");  
                };
            %>
    </body>
</html>