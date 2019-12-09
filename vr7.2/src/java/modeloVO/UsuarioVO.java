/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioVO {

    String usuId, usuLogin, usuPassword,usuRol,estado,ingreso;

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

    public UsuarioVO(String usuLogin, String usuPassword) {
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }
      public void setusuRol(String usuRol) {
        this.usuRol = usuRol;
    }

    public UsuarioVO() {

    }

    public UsuarioVO(String usuId, String usuLogin, String usuPassword, String usuRol,String estado,String ingreso) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
        this.usuRol = usuRol;
        this.estado = estado;
        this.ingreso = ingreso;
    }
     public UsuarioVO(String usuId, String usuLogin, String usuPassword) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;  
    }

    public UsuarioVO(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuId() {
        return usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }
    
    public String getusuRol() {
        return usuRol;
    }
}
