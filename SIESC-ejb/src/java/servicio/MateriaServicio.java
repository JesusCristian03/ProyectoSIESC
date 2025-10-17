/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Materia;

/**
 *
 * @author cris_
 */
@Stateless
public class MateriaServicio implements MateriaServicioLocal {

    @PersistenceContext
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @Override
    public Materia findByMateria(String materia) {
        return em.createNamedQuery("Materia.findByMateria", modelo.Materia.class)
                .setParameter("materia", materia)
                .getSingleResult();
    }

    // Buscar por nombre completo
    @Override
    public List<Materia> findByNombreCompleto(String nombreCompleto) {
        return em.createNamedQuery("Materia.findByNombreCompletoMateria", modelo.Materia.class)
                .setParameter("nombreCompletoMateria", nombreCompleto)
                .getResultList();
    }

    // Buscar por nombre abreviado
     @Override
    public List<Materia> findByNombreAbreviado(String nombreAbreviado) {
        return em.createNamedQuery("Materia.findByNombreAbreviadoMateria", modelo.Materia.class)
                .setParameter("nombreAbreviadoMateria", nombreAbreviado)
                .getResultList();
    }
}
