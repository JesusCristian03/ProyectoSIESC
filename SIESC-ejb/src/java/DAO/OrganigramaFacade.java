/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Organigrama;

/**
 *
 * @author gacev
 */
@Stateless
public class OrganigramaFacade extends AbstractFacade<Organigrama> implements OrganigramaFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganigramaFacade() {
        super(Organigrama.class);
    }
    
}
