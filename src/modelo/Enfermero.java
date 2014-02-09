package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Enfermero extends Personal {
    
    private String nColeg;
    private String especialidad;
    private Enfermero supervisor;
    
    public Enfermero(String idPers, String dni, String nombre, String apell1, String apell2, int telef, String nomusuario, String nColeg, String especialidad) {
        super(idPers, dni, nombre, apell1, apell2, telef, nomusuario);
        this.nColeg=nColeg;
        this.especialidad=especialidad;
    };
    
    public Enfermero(ResultSet rs) throws SQLException {
        super(rs.getString("idPers"), rs.getString("dni"), rs.getString("nombre"), rs.getString("apell1"), rs.getString("apell2"), rs.getInt("telef"), rs.getString("nomusuario"));
        this.nColeg=rs.getString("ncoleg");
        this.especialidad=rs.getString("especialidad");
        
    };
    
    public void setNColeg(String nColeg){
        this.nColeg=nColeg;  
    };
    
    public void setEspecialidad(String especialidad){
        this.especialidad=especialidad;  
    };
    
    public void setSupervisor(Enfermero supervisor){
        this.supervisor=supervisor;  
    };
    
    public String getNColeg(){
        return nColeg;  
    };
    
    public String getEspecialidad(){
        return especialidad;  
    };
    
    public Enfermero getSupervisor(){
        return supervisor;  
    };
    
    public String mostrarDatosUsuarioWeb(){
        String datos="<table align='center'>"+
            "<tr><td>Profesional: " + getApell1() + " " + getApell2() + ", " + getNombre() + "</td></tr>" +
            "<tr><td>DNI: " + getDni() + "</td><td>Nº Colegiado/a: " + getNColeg() + "</td></tr>" +
            "</table>";
        return datos;  
    };
}
