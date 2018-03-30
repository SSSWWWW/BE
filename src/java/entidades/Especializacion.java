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
public class Especializacion {
    
    String nombresAreaTrabajo;
    String nombreEspecializacion;
    int procentajeEspecializacion;
    int idespecializacion;

    public Especializacion() {
    }

    public Especializacion(String nombresAreaTrabajo, String nombreEspecializacion, int procentajeEspecializacion, int idespecializacion) {
        this.nombresAreaTrabajo = nombresAreaTrabajo;
        this.nombreEspecializacion = nombreEspecializacion;
        this.procentajeEspecializacion = procentajeEspecializacion;
        this.idespecializacion = idespecializacion;
    }

    public String getNombresAreaTrabajo() {
        return nombresAreaTrabajo;
    }

    public void setNombresAreaTrabajo(String nombresAreaTrabajo) {
        this.nombresAreaTrabajo = nombresAreaTrabajo;
    }

    public String getNombreEspecializacion() {
        return nombreEspecializacion;
    }

    public void setNombreEspecializacion(String nombreEspecializacion) {
        this.nombreEspecializacion = nombreEspecializacion;
    }

    public int getProcentajeEspecializacion() {
        return procentajeEspecializacion;
    }

    public void setProcentajeEspecializacion(int procentajeEspecializacion) {
        this.procentajeEspecializacion = procentajeEspecializacion;
    }

    public int getIdespecializacion() {
        return idespecializacion;
    }

    public void setIdespecializacion(int idespecializacion) {
        this.idespecializacion = idespecializacion;
    }

    
    
    
    
    
}
