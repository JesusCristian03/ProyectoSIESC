/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.PersonalFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Personal;

/**
 *
 * @author gacev
 */
@Stateless
public class PersonalServicio implements PersonalServicioLocal {

    @EJB
    private PersonalFacadeLocal personalFacade;

    // Add business logic below. (Right-clpersonalFacadeick in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Personal buscarPorId(String rfc) {
        return personalFacade.find(rfc);
    }

    @Override
    public List<Personal> buscarTodos() {
        return personalFacade.findAll();
    }

    @Override
    public List<Personal> personalActivos() {
        return personalFacade.personalesActivos();
    }

}
