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

    public EspecializacionIncluida() {
    }

    public EspecializacionIncluida(int idPuesto, int idespecializacion, int porcentajeEspecializacion) {
        this.idPuesto = idPuesto;
        this.idespecializacion = idespecializacion;
        this.porcentajeEspecializacion = porcentajeEspecializacion;
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

  
    
    
    
}
