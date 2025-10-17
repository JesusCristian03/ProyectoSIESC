/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.PersonalEstudios;

/**
 *
 * @author gacev
 */
@Stateless
public class PersonalEstudiosFacade extends AbstractFacade<PersonalEstudios> implements PersonalEstudiosFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalEstudiosFacade() {
        super(PersonalEstudios.class);
    }
    
}
