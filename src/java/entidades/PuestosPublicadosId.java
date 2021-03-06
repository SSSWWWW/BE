package entidades;
// Generated Mar 5, 2018 4:14:29 PM by Hibernate Tools 4.3.1



/**
 * PuestosPublicadosId generated by hbm2java
 */
public class PuestosPublicadosId  implements java.io.Serializable {


     private int idPuesto;
     private int idEmp;

    public PuestosPublicadosId() {
    }

    public PuestosPublicadosId(int idPuesto, int idEmp) {
       this.idPuesto = idPuesto;
       this.idEmp = idEmp;
    }
   
    public int getIdPuesto() {
        return this.idPuesto;
    }
    
    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }
    public int getIdEmp() {
        return this.idEmp;
    }
    
    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PuestosPublicadosId) ) return false;
		 PuestosPublicadosId castOther = ( PuestosPublicadosId ) other; 
         
		 return (this.getIdPuesto()==castOther.getIdPuesto())
 && (this.getIdEmp()==castOther.getIdEmp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPuesto();
         result = 37 * result + this.getIdEmp();
         return result;
   }   


}


