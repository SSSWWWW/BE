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
public class AreaTrabajoIncluidas {
    
    int idPuesto;
    int idareatrabajo;

    public AreaTrabajoIncluidas() {
    }

    public AreaTrabajoIncluidas(int idPuesto, int idareatrabajo) {
        this.idPuesto = idPuesto;
        this.idareatrabajo = idareatrabajo;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdareatrabajo() {
        return idareatrabajo;
    }

    public void setIdareatrabajo(int idareatrabajo) {
        this.idareatrabajo = idareatrabajo;
    }
    
    
    
    
}
