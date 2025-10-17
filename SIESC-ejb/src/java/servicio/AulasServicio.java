/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.AulasFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Aulas;

/**
 *
 * @author cris_
 */
@Stateless
public class AulasServicio implements AulasServicioLocal {

    @EJB
    private AulasFacadeLocal aulasFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List<Aulas> aulasActivos() {
        return aulasFacade.aulasActivos();
    }
    
    
    @Override
    public Aulas buscarPorId(String x) {
        return aulasFacade.find(x);
    }
    
    
}
