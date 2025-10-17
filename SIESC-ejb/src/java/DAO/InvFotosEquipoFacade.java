/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.InvFotosEquipo;

/**
 *
 * @author gacev
 */
@Stateless
public class InvFotosEquipoFacade extends AbstractFacade<InvFotosEquipo> implements InvFotosEquipoFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvFotosEquipoFacade() {
        super(InvFotosEquipo.class);
    }
    
}
