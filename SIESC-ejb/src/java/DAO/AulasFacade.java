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
import modelo.Aulas;

/**
 *
 * @author gacev
 */
@Stateless
public class AulasFacade extends AbstractFacade<Aulas> implements AulasFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AulasFacade() {
        super(Aulas.class);
    }
    @Override
    public List<Aulas> aulasActivos() {
        String sqlAulas = "SELECT a FROM Aulas a";
        Query queryPeriodo = em.createQuery(sqlAulas);
        List<Aulas> lista = queryPeriodo.getResultList();
        
        return lista;
    }
    
}
