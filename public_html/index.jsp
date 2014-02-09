<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
      <link rel="stylesheet" media="screen" href="styles/login.css" type="text/css"/>
      <title>Index - iMedic</title>
  </head>
  <body>
    <div id="margenmain">
    </div>
    <div id="main">
      <form name="acceso" action="<%=request.getContextPath()%>/imedicweb?accion=conectar" method="post">
        <p class="camposlogin">
          Usuario: <input type="text" name="usuario"/>
        </p>
        <p class="camposlogin">
          Contraseña: <input type="password" name="password"/>
        </p>
        <p class="camposlogin" id="enviar">
          <input type="submit" value="Acceder"/>
        </p>
      </form>
    </div>
  </body>
</html>