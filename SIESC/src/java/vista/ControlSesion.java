/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import modelo.Estudiante;
import modelo.Usuario;

/**
 *
 * @author gacev
 */
@Named(value = "controlSesion")
@SessionScoped
public class ControlSesion implements Serializable {

    /**
     * Creates a new instance of ControlSesion
     * 
     */
    private String mensaje;
    public ControlSesion() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void verificarSesion(){
        try{
            FacesContext contexto = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) contexto.getExternalContext().getSessionMap().get("usuario");
            if(us==null){
                contexto.getExternalContext().redirect("/SIESC/faces/index.xhtml");
                mensaje = "Usuario o contraseña inválidos";
            }
        }catch(Exception e){
            
        }
    }
    
    public void verificarEstudiante(){
        try{            
            FacesContext contexto = FacesContext.getCurrentInstance();
            Estudiante usE = (Estudiante) contexto.getExternalContext().getSessionMap().get("estudiante");
            if(usE==null){
                contexto.getExternalContext().redirect("/SIESC/faces/index.xhtml");
                mensaje = "Usuario o contraseña inválidos";
            }
        }catch(Exception e){
            
        }
    }
    
}
