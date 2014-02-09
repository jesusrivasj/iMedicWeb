package bd;
import excepciones.AccesoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccesoBD {
 
    private Connection conexion;
    private String user;
    private String pass;
  
    public AccesoBD (String user,String pass) throws AccesoException {
        String Url = "jdbc:oracle:thin:@localhost:1521:XE";
        this.user = user;
        this.pass = pass;
        try
        {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          conexion = DriverManager.getConnection(Url, this.user, this.pass);
        }catch(ClassNotFoundException e){
          throw new AccesoException("Error en la carga del driver");
        }catch(SQLException e2){
          throw new AccesoException("Error de conexión");
        };
    };
  
    public ResultSet select(String orden) throws AccesoException {
        ResultSet rs;
        try {
          Statement statement = conexion.createStatement();
          rs = statement.executeQuery(orden);
        }catch(SQLException e){
          throw new AccesoException("Error ejecutando la sentencia SQL SELECT");
        };
        return rs;
    };
  
    public void drop(String orden)throws AccesoException {
        try{
          Statement statement = conexion.createStatement();
          statement.executeUpdate(orden);
          statement.close();
        } catch(SQLException e){
          throw new AccesoException("Error ejecutando la sentencia SQL DROP");
        };
    };
  
    public void update(String orden)throws AccesoException {
        int i;
        try{
          Statement statement = conexion.createStatement();
          i = statement.executeUpdate(orden);
          statement.close();
          if(i != 1)
            throw new AccesoException("Error ejecutando la sentencia SQL UPDATE");
        } catch(SQLException e){
          throw new AccesoException("Error ejecutando la sentencia SQL UPDATE");
        };
    };

    public void insert(String orden) throws AccesoException {
        int i;
        try{
          Statement statement = conexion.createStatement();
          statement.executeUpdate(orden);
          statement.close();
        }catch(SQLException e){
          throw new AccesoException("Error ejecutando la sentencia SQL INSERT"+e.getMessage());
        };
    };
    
    public void delete(String orden)throws AccesoException {
        int i;
        try{
          Statement statement = conexion.createStatement();
          i = statement.executeUpdate(orden);
          statement.close();
          if(i != 1)
            throw new AccesoException("Error ejecutando la sentencia SQL DELETE");
        }catch(SQLException e){
          throw new AccesoException("Error ejecutando la sentencia SQL DELETE");
        };
    };
    
    public void cambiarEsquema() throws AccesoException {
        int i;
        try{
        Statement statement = conexion.createStatement();
        statement.executeUpdate("alter session set current_schema=ADMINIMEDIC");
        statement.close();
        }catch(SQLException e){
        throw new AccesoException("Error Al cambiar el esquema por defecto."+e.getMessage());
        };
    };
  
    public void close()throws AccesoException{
        try{
          conexion.close();
        }catch(SQLException e) {
          throw new AccesoException("Error cerrando la conexión a la Base de Datos");
        };
    };
};