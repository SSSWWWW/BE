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
public class EspecializacionIncluidaOferente {

    /**
     * @param args the command line arguments
     */
   
    String cedulaOferente;
    int idespecializacion;
    int porcentajeEspecializacion;
    
    String nombreEspecializacion;

    public EspecializacionIncluidaOferente() {
    }

    public EspecializacionIncluidaOferente(String cedulaOferente, int idespecializacion, int porcentajeEspecializacion) {
        this.cedulaOferente = cedulaOferente;
        this.idespecializacion = idespecializacion;
        this.porcentajeEspecializacion = porcentajeEspecializacion;
    }

    public EspecializacionIncluidaOferente(int porcentajeEspecializacion, String nombreEspecializacion, int id) {
        this.porcentajeEspecializacion = porcentajeEspecializacion;
        this.nombreEspecializacion = nombreEspecializacion;
        this.idespecializacion = id;
    }

    public String getNombreEspecializacion() {
        return nombreEspecializacion;
    }

    public void setNombreEspecializacion(String nombreEspecializacion) {
        this.nombreEspecializacion = nombreEspecializacion;
    }
    
    

    public String getCedulaOferente() {
        return cedulaOferente;
    }

    public void setCedulaOferente(String cedulaOferente) {
        this.cedulaOferente = cedulaOferente;
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
