/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.InvTipoEquipo;

/**
 *
 * @author gacev
 */
@Stateless
public class InvTipoEquipoFacade extends AbstractFacade<InvTipoEquipo> implements InvTipoEquipoFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvTipoEquipoFacade() {
        super(InvTipoEquipo.class);
    }
    
}
