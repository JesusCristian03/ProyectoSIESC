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
import modelo.HistoriaAlumno;

/**
 *
 * @author gacev
 */
@Stateless
public class HistoriaAlumnoFacade extends AbstractFacade<HistoriaAlumno> implements HistoriaAlumnosFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriaAlumnoFacade() {
        super(HistoriaAlumno.class);
    }

    @Override
    public List<HistoriaAlumno> buscarReticula(String noDeControl) {
        List<HistoriaAlumno> lista = null;
        String sqlHistoriaA = "SELECT h FROM HistoriaAlumno h WHERE h.noDeControl.noDeControl=:control order by h.periodo";
        Query queryPersonal = em.createQuery(sqlHistoriaA);
 
        queryPersonal.setParameter("control", noDeControl);        
        lista = queryPersonal.getResultList();
        return lista;
    }
    
}
