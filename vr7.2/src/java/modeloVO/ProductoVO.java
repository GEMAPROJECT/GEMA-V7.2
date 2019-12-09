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
public class ProductoVO {
     String idProducto, nombre, tipoProducto, serial, observacion, cantidad, estado,id_detalle;

    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    } 
    public ProductoVO(String serial) {
        this.serial = serial;
    }

    public ProductoVO(String idProducto, String nombre, String cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

      public ProductoVO() {    
    }  
      
    public ProductoVO(String idProducto, String nombre, String tipoProducto, String serial, String observacion, String cantidad, String estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.serial = serial;
        this.observacion = observacion;
        this.cantidad = cantidad;
        this.estado = estado;
    }
  public ProductoVO(String idProducto, String nombre, String tipoProducto, String serial, String observacion, String cantidad, String estado,String id_detalle) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.serial = serial;
        this.observacion = observacion;
        this.cantidad = cantidad;
        this.estado = estado;
        this.id_detalle = id_detalle;
    }
   
    /////////////////////GET Y SET DE ID DEL PRODUCTO/////////////

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }  
    
    /////////////////////GET Y SET DE NOMBRE/////////////
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /////////////////////GET Y SET DE TIPO DE PRODUCTO/////////////
    

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    
    /////////////////////GET Y SET DE SERIAL/////////////

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    /////////////////////GET Y SET DE OBSERVACION/////////////
    
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    /////////////////////GET Y SET DE CANTIDAD/////////////
    
    
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
     
    /////////////////////GET Y SET DE ESTADO/////////////
        public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
