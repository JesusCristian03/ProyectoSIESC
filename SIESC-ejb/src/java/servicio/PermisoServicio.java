/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.PermisosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Permisos;

/**
 *
 * @author gacev
 */
@Stateless
public class PermisoServicio implements PermisoServicioLocal {

    @EJB
    private PermisosFacadeLocal permisosFacade;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertar(Permisos permiso) {
        permisosFacade.create(permiso);
    }

    @Override
    public void modificar(Permisos permiso) {
        permisosFacade.edit(permiso);
    }

    @Override
    public Permisos buscarPorId(Integer idPermiso) {
        return permisosFacade.find(idPermiso);
    }

    @Override
    public List<Permisos> buscarTodos() {
        return permisosFacade.findAll();
    }

    @Override
    public List<Permisos> buscarCarreras(String usuario) {
        System.out.println("Entra al servicio");
        return permisosFacade.buscarCarreras(usuario);
    }
    
    
}
