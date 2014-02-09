package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Personal {
    private String idpers;
    private String dni;
    private String nombre;
    private String apell1;
    private String apell2;
    private int telef;
    private String nomusuario;
    
    public Personal(String idpers, String dni, String nombre, String apell1, String apell2, int telef, String nomusuario){
        this.idpers=idpers;
        this.dni=dni;
        this.nombre=nombre;
        this.apell1=apell1;
        this.apell2=apell2;
        this.telef=telef;
        this.nomusuario=nomusuario;
    };
    
    public Personal(ResultSet rs) throws SQLException {
        this.idpers=rs.getString("idpers");
        this.dni=rs.getString("dni");
        this.nombre=rs.getString("nombre");
        this.apell1=rs.getString("apell1");
        this.apell2=rs.getString("apell2");
        this.telef=rs.getInt("telef");
        this.nomusuario=rs.getString("nomusuario");
    };
    
    public void setIdpers(String idpers){
        this.idpers=idpers;  
    };
    
    public void setDni(String dni){
        this.dni=dni;  
    };
    
    public void setNombre(String nombre){
        this.nombre=nombre;  
    };
    
    public void setApell1(String apell1){
        this.apell1=apell1;  
    };
    
    public void setApell2(String apell2){
        this.apell2=apell2;  
    };
    
    public void setTelef(int telef){
        this.telef=telef;  
    };
    
    public void setNomusuario(String nomusuario){
        this.nomusuario=nomusuario;  
    };
    
    public String getIdpers(){
        return this.idpers;  
    };
    
    public String getDni(){
        return this.dni;  
    };
    
    public String getNombre(){
        return this.nombre;  
    };
    
    public String getApell1(){
        return this.apell1;  
    };
    
    public String getApell2(){
        return this.apell2;  
    };
    
    public int getTelef(){
        return this.telef;  
    };
    
    public String getNomusuario(){
        return this.nomusuario;  
    };
    
    public String mostrarDatosUsuarioWeb(){
        String datos="<table align='center'>"+
            "<tr><td>Profesional: " + getApell1() + " " + getApell2() + ", " + getNombre() + "</td></tr>" +
            "<tr><td>DNI: " + getDni() + "</td></tr>" +
            "</table>";
        return datos;  
    };
}
