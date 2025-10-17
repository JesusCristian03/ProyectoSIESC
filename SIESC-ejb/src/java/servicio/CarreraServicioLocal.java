/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import modelo.Carrera;

/**
 *
 * @author gacev
 */
@Local
public interface CarreraServicioLocal {

    List<Carrera> buscarTodos();

    void insertar(Carrera carrera);

    void modificar(Carrera carrera);

    void eliminar(Carrera carrera);

    Carrera buscarPorId(Integer reticula);
    List<Carrera> obtenerCarreraPor2(String nombrecarrera, Date fechaFinalizacion);
    
}
