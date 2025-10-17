/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelo.Permisos;
import servicio.PermisoServicioLocal;

/**
 *
 * @author gacev
 */
@Named(value = "permisosBean")
@SessionScoped
public class PermisosBean implements Serializable {

    @EJB
    private PermisoServicioLocal permisoServicio;
    
    private List<Permisos> listaPermisos;

    /**
     * Creates a new instance of PermisosBean
     */
    public PermisosBean() {
        
    }

    public List<Permisos> getListaPermisos() {        
        listaPermisos = permisoServicio.buscarCarreras("pdivision");
        return listaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {        
        this.listaPermisos = listaPermisos;
    }
    
}
