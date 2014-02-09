package acciones;

import bd.AccesoBD;

import excepciones.AccesoException;

import java.io.IOException;

import java.io.PrintWriter;

import java.lang.reflect.Type;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import javax.servlet.ServletException;

import modelo.Enfermero;
import modelo.Personal;

public class AccionConectar extends Accion{

    public void inicio() throws ServletException, IOException, AccesoException, SQLException {
        
        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");
        AccesoBD conexion = new AccesoBD(user,pass);
        conexion.cambiarEsquema();
        ResultSet roles;
        roles = conexion.select("select * from session_roles");
        roles.next();
        String rol = roles.getString(1);
        Personal perfil=null;
        ResultSet usuario;
        switch(rol){
            case "ROL_ADMINISTRATIVO":
                usuario=conexion.select("select * from personal where nomusuario='" + user + "'");
                usuario.next();
                perfil=new Personal(usuario);
                break;
            case "ROL_ENFERMERIA":
                usuario=conexion.select("select idpers, dni, nombre, apell1, apell2, telef, nomusuario, ncoleg, especialidad from personal join enfermero on(idpers=idenfer) where nomusuario='enfermeria'");
                usuario.next();
                perfil=new Enfermero(usuario);
                break;
        };
        session.setAttribute("conexion",conexion);
        session.setAttribute("rol",rol);
        session.setAttribute("perfil",perfil);
        
       
        
        irAPagina("/bienvenido.jsp", response,request);
    };
};
