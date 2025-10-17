/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.AsistenciaPrefecto;

/**
 *
 * @author gacev
 */
@Stateless
public class AsistenciaPrefectoFacade extends AbstractFacade<AsistenciaPrefecto> implements AsistenciaPrefectoFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistenciaPrefectoFacade() {
        super(AsistenciaPrefecto.class);
    }
    
}
