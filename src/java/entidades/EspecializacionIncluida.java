/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author pc
 */
public class EspecializacionIncluida {
    
    
    int idPuesto;
    int idespecializacion;
    int porcentajeEspecializacion;
    int idEmp;
    
    String nombreEspecializacion;

    public EspecializacionIncluida() {
    }

    public EspecializacionIncluida(int idespecializacion) {
        this.idespecializacion = idespecializacion;
    }

    public EspecializacionIncluida(int idespecializacion, int porcentajeEspecializacion) {
        this.idespecializacion = idespecializacion;
        this.porcentajeEspecializacion = porcentajeEspecializacion;
    }

    
    
    
    
    public EspecializacionIncluida(int idPuesto, int idespecializacion, int porcentajeEspecializacion, int idEmp) {
        this.idPuesto = idPuesto;
        this.idespecializacion = idespecializacion;
        this.porcentajeEspecializacion = porcentajeEspecializacion;
        this.idEmp = idEmp;
    }

    public EspecializacionIncluida( String nombreEspecializacion, int porcentajeEspecializacion) {
        this.porcentajeEspecializacion = porcentajeEspecializacion;
        this.nombreEspecializacion = nombreEspecializacion;
    }
    
    

    public String getNombreEspecializacion() {
        return nombreEspecializacion;
    }

    public void setNombreEspecializacion(String nombreEspecializacion) {
        this.nombreEspecializacion = nombreEspecializacion;
    }

    
    
    
    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdespecializacion() {
        return idespecializacion;
    }

    public void setIdespecializacion(int idespecializacion) {
        this.idespecializacion = idespecializacion;
    }

    public int getPorcentajeEspecializacion() {
        return porcentajeEspecializacion;
    }

    public void setPorcentajeEspecializacion(int porcentajeEspecializacion) {
        this.porcentajeEspecializacion = porcentajeEspecializacion;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    
  
    
    
    
}
