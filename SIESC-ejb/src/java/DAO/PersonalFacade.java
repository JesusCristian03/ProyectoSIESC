/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Personal;

/**
 *
 * @author gacev
 */
@Stateless
public class PersonalFacade extends AbstractFacade<Personal> implements PersonalFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalFacade() {
        super(Personal.class);
    }
     @Override
    public List<Personal> personalesActivos() {
        Character estatus = 'D';
        String sqlPeriodoEscolar = "SELECT l FROM Personal l WHERE l.nombramiento=:nombramiento";
        Query queryPeriodo = em.createQuery(sqlPeriodoEscolar);
        queryPeriodo.setParameter("nombramiento", estatus);
        List<Personal> lista = queryPeriodo.getResultList();
        
        return lista;
    }
    
}
