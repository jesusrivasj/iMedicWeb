package acciones;


import excepciones.AccesoException;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class Accion 
{
  public HttpServletRequest request;
  public  HttpServletResponse response;
  public  HttpSession session;
  public  ServletContext context;
  
   public abstract void inicio()throws ServletException, IOException, AccesoException, SQLException;
    

  public void irAPagina(String pagina,HttpServletResponse response, HttpServletRequest request)  
    throws ServletException,IOException
  {
    RequestDispatcher envPet=context.getRequestDispatcher(pagina);   
    envPet.forward(request,response);
  }
  
  public void setReponse(HttpServletResponse response)
  {
    this.response=response;
  }
  
  public void setSession(HttpSession session)
  {
    this.session=session;
  }
 
  
  public void setRequest(HttpServletRequest request)
  {
    this.request=request;
  }
  public void setContext(ServletContext context)
  {
    this.context=context;
  }
  
}