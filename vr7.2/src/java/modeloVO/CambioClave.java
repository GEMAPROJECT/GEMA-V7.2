/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author MAKKMA
 */
public class CambioClave {
    
    String usuId, usuPassword;

    public CambioClave(String usuId, String usuPassword) {
        this.usuId = usuId;
        this.usuPassword = usuPassword;
    }
    
     public CambioClave() {

    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }
    
    
}
