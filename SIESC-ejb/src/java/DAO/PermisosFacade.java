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
import modelo.Permisos;

/**
 *
 * @author gacev
 */
@Stateless
public class PermisosFacade extends AbstractFacade<Permisos> implements PermisosFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisosFacade() {
        super(Permisos.class);
    }

    @Override
    public List<Permisos> buscarCarreras(String usuario) {
        List<Permisos> lista = null;
        System.out.println("Iniciai");
        String sqlPermisos = "SELECT p FROM Permisos p WHERE p.claveArea.claveArea=null and p.usuario.usuario=:usuario";
        System.out.println("Consulta " + sqlPermisos);
        Query queryPersonal = em.createQuery(sqlPermisos);
 
        queryPersonal.setParameter("usuario", usuario);

        lista = (List<Permisos>) (queryPersonal.getResultList());
        
        return lista;
    }

    @Override
    public List<Permisos> buscarDepartamentos(String usuario) {
        List<Permisos> lista = null;
        System.out.println("Iniciai");
        String sqlPermisos = "SELECT p FROM Permisos p WHERE p.reticula.reticula=null p.usuario.usuario=:usuario";
        System.out.println("Consulta " + sqlPermisos);
        Query queryPersonal = em.createQuery(sqlPermisos);
 
        queryPersonal.setParameter("usuario", usuario);

        lista = (List<Permisos>) (queryPersonal.getResultList());
        
        return lista;
    }
    
}
