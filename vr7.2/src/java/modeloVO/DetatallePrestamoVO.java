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
public class DetatallePrestamoVO {

    public DetatallePrestamoVO(){
}

    String id_detalle, num_prestamo ,cantidad,Serial,Estado;

    public DetatallePrestamoVO(String id_detalle, String Estado) {
        this.id_detalle = id_detalle;
        this.Estado = Estado;
    }
      public DetatallePrestamoVO(String id_detalle) {
        this.id_detalle = id_detalle;
    }
   
    public DetatallePrestamoVO(String id_detalle,String num_prestamo, String cantidad , String Serial, String Estado) {
        this.id_detalle = id_detalle;
        this.num_prestamo = num_prestamo;
        this.cantidad = cantidad;
        this.Serial = Serial;
        this.Estado = Estado;
    }

    public String getNum_prestamo() {
        return num_prestamo;
    }

    public void setNum_prestamo(String num_prestamo) {
        this.num_prestamo = num_prestamo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

  public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }
    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    }
  
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}
