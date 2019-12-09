
package modeloVO;


public class PrestamosVO {
     String num_prestamo,id_epleado,id_profesor,fecha_pres,fecha_devo_pres,id_Hora_Entrega,id_hora_devolucion,estado,Serial,Obsevacion,Estado_pre,id_detalle;

    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getObsevacion() {
        return Obsevacion;
    }

    public void setObsevacion(String Obsevacion) {
        this.Obsevacion = Obsevacion;
    }

    public String getEstado_pre() {
        return Estado_pre;
    }

    public void setEstado_pre(String Estado_pre) {
        this.Estado_pre = Estado_pre;
    }

    public PrestamosVO(String Serial, String Obsevacion, String Estado_pre) {
        this.Serial = Serial;
        this.Obsevacion = Obsevacion;
        this.Estado_pre = Estado_pre;
    }

    public PrestamosVO(String num_prestamo, String estado) {
        this.num_prestamo = num_prestamo;
        this.estado = estado;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }
    

    public PrestamosVO(String num_prestamo, String id_epleado, String id_profesor, String fecha_pres, String fecha_devo_pres, String Serial, String id_detalle) {
        this.num_prestamo = num_prestamo;
        this.id_epleado = id_epleado;
        this.id_profesor = id_profesor;
        this.fecha_pres = fecha_pres;
        this.fecha_devo_pres = fecha_devo_pres; 
        this.Serial = Serial;
        this.id_detalle = id_detalle;
    }

    public PrestamosVO(String num_prestamo,String id_epleado, String id_profesor, String fecha_pres, String fecha_devo_pres, String id_Hora_Entrega, String id_hora_devolucion, String estado) {
        this.num_prestamo = num_prestamo;
        this.id_epleado = id_epleado;
        this.id_profesor = id_profesor;    
        this.fecha_pres = fecha_pres;
        this.fecha_devo_pres = fecha_devo_pres;
        this.id_Hora_Entrega = id_Hora_Entrega;
        this.id_hora_devolucion = id_hora_devolucion;
        this.estado = estado;

    }
   
     public PrestamosVO(){
    }
    public String getId_epleado() {
        return id_epleado;
    }

    public void setId_epleado(String id_epleado) {
        this.id_epleado = id_epleado;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_pres() {
        return fecha_pres;
    }

    public void setFecha_pres(String fecha_pres) {
        this.fecha_pres = fecha_pres;
    }

    public String getFecha_devo_pres() {
        return fecha_devo_pres;
    }

    public void setFecha_devo_pres(String fecha_devo_pres) {
        this.fecha_devo_pres = fecha_devo_pres;
    }

    public String getNum_prestamo() {
        return num_prestamo;
    }

    public void setNum_prestamo(String num_prestamo) {
        this.num_prestamo = num_prestamo;
    }

    public String getId_Hora_Entrega() {
        return id_Hora_Entrega;
    }

    public void setId_Hora_Entrega(String id_Hora_Entrega) {
        this.id_Hora_Entrega = id_Hora_Entrega;
    }

    public String getId_hora_devolucion() {
        return id_hora_devolucion;
    }

    public void setId_hora_devolucion(String id_hora_devolucion) {
        this.id_hora_devolucion = id_hora_devolucion;
    }

   
      
   
       
  
    
}
