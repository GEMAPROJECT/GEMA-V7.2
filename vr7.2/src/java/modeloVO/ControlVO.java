/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;


public class ControlVO {
    
    
    String id_control_profesor , Estado, descripcion , id_detalle,id_empleado,id_profesor,serial,Estado_prestamo,id_estudiante, id_curso,nombre_estudiante,nombre_producto;
    
    public ControlVO(String Estado, String descripcion, String id_profesor, String serial, String id_estudiante, String id_curso, String nombre_estudiante, String nombre_producto) {
        this.Estado = Estado;
        this.descripcion = descripcion;
        this.id_profesor = id_profesor;
        this.serial = serial;
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
        this.nombre_estudiante = nombre_estudiante;
        this.nombre_producto = nombre_producto;
    }

    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
     
     
     public ControlVO (){
     }

    public ControlVO(String id_control_profesor, String Estado, String descripcion, String Estado_prestamo) {
        this.id_control_profesor = id_control_profesor;
        this.Estado = Estado;
        this.descripcion = descripcion;
        this.Estado_prestamo = Estado_prestamo;
    }

    public String getId_control_profesor() {
        return id_control_profesor;
    }

    public void setId_control_profesor(String id_control_profesor) {
        this.id_control_profesor = id_control_profesor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado_prestamo() {
        return Estado_prestamo;
    }

    public void setEstado_prestamo(String Estado_prestamo) {
        this.Estado_prestamo = Estado_prestamo;
    }
       
    
}
