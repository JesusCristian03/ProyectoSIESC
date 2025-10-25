/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Carrera;

/**
 *
 * @author gacev
 */
@Stateless
public class CarreraFacade extends AbstractFacade<Carrera> implements CarreraFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarreraFacade() {
        super(Carrera.class);
    }
     @Override
    public List<Carrera> buscarCarreraPerTwo(String nombrecarrera, Date fechaFinalizacion) {
        List<Carrera> lista;
        String sqlMaterias = "SELECT m FROM Carrera m WHERE m.nombreCarrera=:nombrecarrera and m.fechaTermino=:fechatermino order by m.nombreCarrera";
        Query queryPersonal = em.createQuery(sqlMaterias);
 
        queryPersonal.setParameter("nombrecarrera", nombrecarrera);
        queryPersonal.setParameter("fechatermino", fechaFinalizacion); 
        lista = queryPersonal.getResultList();
        return lista;
    }
    
    
}
