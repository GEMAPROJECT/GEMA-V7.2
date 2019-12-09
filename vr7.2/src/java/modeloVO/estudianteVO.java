/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author aguir
 */
public class estudianteVO {
    String id_estudiante, Nombre_estudiante, apellidos_studiante, id_curso, estado;
    
    public estudianteVO(){
    }

    public estudianteVO(String id_estudainte, String Nombre_estudiante, String apelldios_studiante, String id_curso, String estado) {
        this.id_estudiante = id_estudainte;
        this.Nombre_estudiante = Nombre_estudiante;
        this.apellidos_studiante = apelldios_studiante;
        this.id_curso = id_curso;
        this.estado = estado;
    }
    
      /*-------------Get y Set de ID estudiante-----------*/
    public String getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(String id_estudainte) {
        this.id_estudiante = id_estudainte;
    }
          /*-------------Get y Set de Nombre estudiante-----------*/

    public String getNombre_estudiante() {
        return Nombre_estudiante;
    }

    public void setNombre_estudiante(String Nombre_estudiante) {
        this.Nombre_estudiante = Nombre_estudiante;
    }
    
    /*-------------Get y Set de Apellidos estudiante-----------*/
    
        public String getApellidos_studiante() {
        return apellidos_studiante;
    }

    public void setApellidos_studiante(String apellidos_studiante) {
        this.apellidos_studiante = apellidos_studiante;
    }


   
    /*-------------Get y Set de ID_curso del estudiante-----------*/

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }
    
      /*-------------Get y Set del estado del estudiante-----------*/
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
