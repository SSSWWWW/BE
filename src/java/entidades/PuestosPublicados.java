package entidades;
// Generated Mar 5, 2018 4:14:29 PM by Hibernate Tools 4.3.1



/**
 * PuestosPublicados generated by hbm2java
 */
public class PuestosPublicados  implements java.io.Serializable {



     private int idEmpresa;
     private int idPuestos;
     private Boolean estadoPuesto;

    public PuestosPublicados() {
    }

    public PuestosPublicados(int idEmpresa, int idPuestos, Boolean estadoPuesto) {
        this.idEmpresa = idEmpresa;
        this.idPuestos = idPuestos;
        this.estadoPuesto = estadoPuesto;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdPuestos() {
        return idPuestos;
    }

    public void setIdPuestos(int idPuestos) {
        this.idPuestos = idPuestos;
    }

    public Boolean getEstadoPuesto() {
        return estadoPuesto;
    }

    public void setEstadoPuesto(Boolean estadoPuesto) {
        this.estadoPuesto = estadoPuesto;
    }

    



}


