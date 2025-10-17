/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.PeriodoEscolarFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Stateless
public class PeriodoEscolarServicio implements PeriodoEscolarServicioLocal {

    @EJB
    private PeriodoEscolarFacadeLocal periodoEscolarFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void insertar(PeriodoEscolar periodoEscolar) {
        periodoEscolarFacade.create(periodoEscolar);
    }

    @Override
    public void modificar(PeriodoEscolar periodoEscolar) {
        periodoEscolarFacade.edit(periodoEscolar);
    }

    @Override
    public void eliminar(PeriodoEscolar periodoEscolar) {
        periodoEscolarFacade.remove(periodoEscolar);
    }

    @Override
    public PeriodoEscolar buscarPorId(String periodo) {
        return periodoEscolarFacade.find(periodo);
    }

    @Override
    public List<PeriodoEscolar> buscarTodos() {
        return periodoEscolarFacade.findAll();
    }

    @Override
    public String periodoActual() {
        return periodoEscolarFacade.peridoActual(); 
    }

    @Override
    public PeriodoEscolar periodoEscolarPE() {
        return periodoEscolarFacade.peridoActualPE();
    }

    @Override
    public List<PeriodoEscolar> periodosEscolaresActivos() {
        return periodoEscolarFacade.periodosEscolaresActivos();
    }

}
