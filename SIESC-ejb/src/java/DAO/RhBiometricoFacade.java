/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.RhBiometrico;

/**
 *
 * @author gacev
 */
@Stateless
public class RhBiometricoFacade extends AbstractFacade<RhBiometrico> implements RhBiometricoFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RhBiometricoFacade() {
        super(RhBiometrico.class);
    }
    
}
