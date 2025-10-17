/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import modelo.Estudiante;
import modelo.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import servicio.EstudianteServicioLocal;
import servicio.UsuarioServicioLocal;

/**
 *
 * @author gacev
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private EstudianteServicioLocal estudianteServicio;

    @EJB
    private UsuarioServicioLocal usuarioServicio;
    
    private Usuario user;
    private Estudiante estudianteLogin;
    private String usuario = "";
    private String contrasena = "";
    
    public LoginBean() {
        user = new Usuario();
        estudianteLogin = new Estudiante();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    //retorna la redireccion

    /**
     *
     * @return
     */
    public String login(){
        Usuario usr = null;
        
        String redireccion = null;
        
        user.setUsuario(usuario);
        String codificado = DigestUtils.sha256Hex(contrasena);
        user.setContrasena(codificado);
        //System.out.println("Codificando contraseña");
        
        try{    
           usr =  usuarioServicio.iniciaSesion(user);
           
           //System.out.println("Obteniendo el usuario");
           if(usr!=null){
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usr);
               System.out.println("redireccionar" + usr.getIdrol().getRuta());
               redireccion = "faces/" + usr.getIdrol().getRuta() + "/index.xhtml";
               
           }
            
        }catch(Exception e ){
            
        }
        
        
        
        
        return redireccion;
    }
    
    public String loginEstudiante(){
        Estudiante estudiante = null;
        
        String redireccion = null;
        //System.out.println("Entra a login"); 
        estudianteLogin.setNoDeControl(usuario);        
        estudianteLogin.setNip(Integer.parseInt(contrasena));
        //System.out.println("Entra a login");    
        try{    
           estudiante =  estudianteServicio.loginEstudiante(estudianteLogin);
           if(estudiante!=null){
               //System.out.println("Encontro ususario");
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("estudiante", estudiante);   
               
               redireccion = "faces/estudiante/index.xhtml";               
           }            
        }catch(Exception e ){
            
        }
        return redireccion;
    }    
}
