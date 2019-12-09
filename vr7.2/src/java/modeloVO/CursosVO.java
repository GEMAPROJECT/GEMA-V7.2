/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author HP
 */
public class CursosVO {
    
    String idCurso,idprofesor,Es_id;

    public CursosVO(String Es_id) {
        this.Es_id = Es_id;
      
    }

     public CursosVO(String idCurso, String idprofesor) {
        this.idCurso = idCurso;
        this.idprofesor = idprofesor;
    }
   
   
     public CursosVO(){
  
   }
  
    public String getEs_id() {
        return Es_id;
    }

    public void setEs_id(String Es_id) {
        this.Es_id = Es_id;
    }
   
 
    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
    }
    
    
    
    
}
