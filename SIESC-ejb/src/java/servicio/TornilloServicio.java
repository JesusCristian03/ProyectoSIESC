/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.TornilloFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Tornillo;

/**
 *
 * @author gacev
 */
@Stateless
public class TornilloServicio implements TornilloServicioLocal {

    @EJB
    private TornilloFacadeLocal tornilloFacade;

    @Override
    public Tornillo buscarPorId(String idTornillo) {
        return tornilloFacade.find(idTornillo);
    }

    @Override
    public List<Tornillo> buscarTodos() {
        return tornilloFacade.findAll();
    }

    
}
