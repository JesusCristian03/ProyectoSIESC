/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.CarreraFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Carrera;

/**
 *
 * @author gacev
 */
@Stateless
public class CarreraServicio implements CarreraServicioLocal {

    @EJB
    private CarreraFacadeLocal carreraFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List<Carrera> buscarTodos() {
        return carreraFacade.findAll();
    }

    @Override
    public void insertar(Carrera carrera) {
        carreraFacade.create(carrera);
    }

    @Override
    public void modificar(Carrera carrera) {
        carreraFacade.edit(carrera);
    }

    @Override
    public void eliminar(Carrera carrera) {
        carreraFacade.remove(carrera);
    }

    @Override
    public Carrera buscarPorId(Integer reticula) {
        return carreraFacade.find(reticula);
    }
    
    @Override
    public List<Carrera> obtenerCarreraPor2(String nombrecarrera, Date fechaFinalizacion) {
        return carreraFacade.buscarCarreraPerTwo(nombrecarrera, fechaFinalizacion);
    }
    
    
}
