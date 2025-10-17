/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.OrganigramaFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Organigrama;

/**
 *
 * @author cris_
 */
@Stateless
public class OrganigramaServicio implements OrganigramaServicioLocal {

    @EJB
    private OrganigramaFacadeLocal organigramaFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     
    @Override
    public Organigrama buscarPorId(String x) {
        return organigramaFacade.find(x);
    }
}
