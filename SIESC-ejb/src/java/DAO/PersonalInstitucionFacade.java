/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.PersonalInstitucion;

/**
 *
 * @author gacev
 */
@Stateless
public class PersonalInstitucionFacade extends AbstractFacade<PersonalInstitucion> implements PersonalInstitucionFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalInstitucionFacade() {
        super(PersonalInstitucion.class);
    }
    
}
