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
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Stateless
public class PeriodoEscolarFacade extends AbstractFacade<PeriodoEscolar> implements PeriodoEscolarFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodoEscolarFacade() {
        super(PeriodoEscolar.class);
    }
    
    public String peridoActual(){
        String periodo = "";
        Character estatus = '0';
        String sqlPeriodoEscolar = "SELECT p FROM PeriodoEscolar p WHERE p.status=:status";
        Query queryPeriodo = em.createQuery(sqlPeriodoEscolar);
        queryPeriodo.setParameter("status", estatus);
        List<PeriodoEscolar> lista = queryPeriodo.getResultList();
        if (lista.size() >= 1)
            periodo = lista.get(0).getPeriodo();
        return periodo;
    }
    
    public PeriodoEscolar peridoActualPE(){
        PeriodoEscolar periodo = null;
        Character estatus = '0';
        String sqlPeriodoEscolar = "SELECT p FROM PeriodoEscolar p WHERE p.status=:status";
        Query queryPeriodo = em.createQuery(sqlPeriodoEscolar);
        queryPeriodo.setParameter("status", estatus);
        List<PeriodoEscolar> lista = queryPeriodo.getResultList();
        if (lista.size() >= 1)
            periodo = (PeriodoEscolar) (lista.get(0));
        return periodo;
    }

    @Override
    public List<PeriodoEscolar> periodosEscolaresActivos() {
        Character estatus = '0';
        String sqlPeriodoEscolar = "SELECT p FROM PeriodoEscolar p WHERE p.status=:status";
        Query queryPeriodo = em.createQuery(sqlPeriodoEscolar);
        queryPeriodo.setParameter("status", estatus);
        List<PeriodoEscolar> lista = queryPeriodo.getResultList();
        
        return lista;
    }
    
    
}
