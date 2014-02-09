package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import acciones.Accion;
import acciones.AccionConectar;

import excepciones.AccesoException;

import java.sql.SQLException;

public class ControlIMedicPrinc extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
        ServletContext context=getServletContext();
             
        String accion= request.getParameter("accion");
        
        Accion ejecutar=null;     
        
        if(accion.compareTo("conectar")==0)
        {
            ejecutar=new AccionConectar();
        }
             
        ejecutar.setRequest(request);
        ejecutar.setReponse(response);
        ejecutar.setContext(context);
        ejecutar.setSession(session);    
         
        try
        {
            ejecutar.inicio();
        }
        catch(ServletException e)
        {
            request.setAttribute("javax.servlet.jsp.jspException",e);
            String s=request.getContextPath();
            RequestDispatcher envPet;
            if(accion.compareTo("conectar")==0){
                envPet=getServletContext().getRequestDispatcher("/errores/errorlogin.jsp");
            }else{
                envPet=getServletContext().getRequestDispatcher("/errores/error.jsp"); 
            };
          envPet.forward(request,response);
        } catch (AccesoException e) {
            request.setAttribute("javax.servlet.jsp.jspException",e);
            String s=request.getContextPath();
            RequestDispatcher envPet;
            if(accion.compareTo("conectar")==0){
                envPet=getServletContext().getRequestDispatcher("/errores/errorlogin.jsp");
            }else{
                envPet=getServletContext().getRequestDispatcher("/errores/error.jsp"); 
            };
            envPet.forward(request,response);
        } catch (SQLException e) {
            request.setAttribute("javax.servlet.jsp.jspException",e);
            String s=request.getContextPath();
            RequestDispatcher envPet;
            if(accion.compareTo("conectar")==0){
                envPet=getServletContext().getRequestDispatcher("/errores/errorlogin.jsp");
            }else{
                envPet=getServletContext().getRequestDispatcher("/errores/error.jsp"); 
            };
            envPet.forward(request,response);
        }
    }
}
