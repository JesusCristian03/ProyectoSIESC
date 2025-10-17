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
import modelo.Estudiante;

/**
 *
 * @author gacev
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    @Override
    public Estudiante loginEstudiante(Estudiante estudiante) {
        Estudiante aux = null;
        String sql = "SELECT e FROM Estudiante e WHERE e.noDeControl =:control AND e.nip =:nip";
        Query query = em.createQuery(sql);
        query.setParameter("control",estudiante.getNoDeControl());        
        query.setParameter("nip",estudiante.getNip());
        List<Estudiante> lista = query.getResultList();
        if(!lista.isEmpty()){
            aux = lista.get(0);            
        }        
        return aux;
    }
    
}
