/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.AsistenciaConferencia;

/**
 *
 * @author gacev
 */
@Stateless
public class AsistenciaConferenciaFacade extends AbstractFacade<AsistenciaConferencia> implements AsistenciaConferenciaFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistenciaConferenciaFacade() {
        super(AsistenciaConferencia.class);
    }
    
}
