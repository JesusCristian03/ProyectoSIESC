/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Local;
import modelo.Permisos;

/**
 *
 * @author gacev
 */
@Local
public interface PermisoServicioLocal {

    void insertar(Permisos permiso);

    void modificar(Permisos permiso);

    Permisos buscarPorId(Integer idPermiso);

    List<Permisos> buscarTodos();

    List<Permisos> buscarCarreras(String usuario);
    
}
