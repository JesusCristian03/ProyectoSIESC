/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.MateriasCarreras;

/**
 *
 * @author gacev
 */
@Stateless
public class MateriasCarrerasFacade extends AbstractFacade<MateriasCarreras> implements MateriasCarrerasFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriasCarrerasFacade() {
        super(MateriasCarreras.class);
    }

    @Override
    public List<MateriasCarreras> buscarMaterias(Integer reticula) {
        List<MateriasCarreras> lista = null;
        String sqlMaterias = "SELECT m FROM MateriasCarreras m WHERE m.reticula.reticula=:reticula order by m.renglon";
        Query queryPersonal = em.createQuery(sqlMaterias);
 
        queryPersonal.setParameter("reticula", reticula);        
        lista = queryPersonal.getResultList();
        return lista;
    }
    
    @Override
    public List<MateriasCarreras> buscarMateriasDepto(Integer reticula, String claveArea) {
        List<MateriasCarreras> lista;
        String sqlMaterias = "SELECT m FROM MateriasCarreras m WHERE m.reticula.reticula=:reticula and m.materia.claveArea.claveArea=:claveArea order by m.semestreReticula";
        Query queryPersonal = em.createQuery(sqlMaterias);
 
        queryPersonal.setParameter("reticula", reticula);
        queryPersonal.setParameter("claveArea", claveArea);
        lista = queryPersonal.getResultList();
        return lista;
    }
    
    @Override
    public List<MateriasCarreras> buscarMateriasCarrera(Integer reticula) {
        List<MateriasCarreras> lista;
        String sqlMaterias = "SELECT m FROM MateriasCarreras m WHERE m.reticula.reticula=:reticula order by m.semestreReticula";
        Query queryPersonal = em.createQuery(sqlMaterias);
 
        queryPersonal.setParameter("reticula", reticula);        
        lista = queryPersonal.getResultList();
        return lista;
    }

    @Override
    public List<MateriasCarreras> buscarAsignaturaSemestre(Integer reticula, Integer semestreReticula) {
        List<MateriasCarreras> lista;
        String sqlMaterias = "SELECT m FROM MateriasCarreras m WHERE m.reticula.reticula=:reticula and m.semestreReticula=:semestreReticula order by m.semestreReticula";
        Query queryPersonal = em.createQuery(sqlMaterias);
 
        queryPersonal.setParameter("reticula", reticula);
        queryPersonal.setParameter("semestreReticula", semestreReticula); 
        lista = queryPersonal.getResultList();
        return lista;
    }
    
    @Override
    public List<MateriasCarreras> buscarMateriasCarreraPerMateria(String idmateria) {
        List<MateriasCarreras> lista;
        String sqlMaterias = "SELECT m FROM MateriasCarreras m WHERE m.materia.materia=:Materia order by m.materia";
        Query queryPersonal = em.createQuery(sqlMaterias);
 
        queryPersonal.setParameter("Materia", idmateria);        
        lista = queryPersonal.getResultList();
        return lista;
    }
    
    
}
