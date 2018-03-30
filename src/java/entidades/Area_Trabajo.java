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
public class Area_Trabajo {
    
    String nombreCaracteristica;
    String nombreAreaTrabajo;
    int idareatrabajo;

    public Area_Trabajo(String nombreCaracteristica, String nombreAreaTrabajo, int idareatrabajo) {
        this.nombreCaracteristica = nombreCaracteristica;
        this.nombreAreaTrabajo = nombreAreaTrabajo;
        this.idareatrabajo = idareatrabajo;
    }

    public int getIdareatrabajo() {
        return idareatrabajo;
    }

    public void setIdareatrabajo(int idareatrabajo) {
        this.idareatrabajo = idareatrabajo;
    }

    
   
    public Area_Trabajo() {
    }

    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    public String getNombreAreaTrabajo() {
        return nombreAreaTrabajo;
    }

    public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
        this.nombreAreaTrabajo = nombreAreaTrabajo;
    }
    
    
    
}
