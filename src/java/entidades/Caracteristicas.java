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
public class Caracteristicas {
    
    
    String nombreCaracteristica;
    int idCaracteristicas;

    public Caracteristicas(String nombreCaracteristica, int idCaracteristicas) {
        this.nombreCaracteristica = nombreCaracteristica;
        this.idCaracteristicas = idCaracteristicas;
    }

    public Caracteristicas() {
    }

    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    public int getIdCaracteristicas() {
        return idCaracteristicas;
    }

    public void setIdCaracteristicas(int idCaracteristicas) {
        this.idCaracteristicas = idCaracteristicas;
    }

 
    
    
}
