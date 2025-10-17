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
import modelo.Carrera;
import modelo.Grupos;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Stateless
public class GruposFacade extends AbstractFacade<Grupos> implements GruposFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruposFacade() {
        super(Grupos.class);
    }

    @Override
    public List<Grupos> gruposActivos() {

        String sqlPeriodoEscolar = "SELECT g FROM Grupos g";
        Query queryPeriodo = em.createQuery(sqlPeriodoEscolar);

        List<Grupos> lista = queryPeriodo.getResultList();

        return lista;
    }

    @Override
    public List<Grupos> buscarGrupoSii(Integer reticula, Integer idmateriacarrera, String periodo, String grupo) {
        List<Grupos> lista = null;
        System.out.println("BUSCANDO GRUPO: -> ");
        String sqlPermisos = "SELECT p FROM Grupos p WHERE p.reticula.reticula=:reticula and p.idMateriaCarrera.idMateriaCarrera=:idmateriacarrera and p.periodo.periodo=:periodo and p.grupo=:grupo";

        //System.out.println("Consulta " + sqlPermisos);
        Query queryPersonal = em.createQuery(sqlPermisos);

        queryPersonal.setParameter("reticula", reticula);
        queryPersonal.setParameter("idmateriacarrera", idmateriacarrera);
        queryPersonal.setParameter("periodo", periodo);
        queryPersonal.setParameter("grupo", grupo);

        lista = (List<Grupos>) (queryPersonal.getResultList());
        return lista;
    }
    @Override
    public List<Grupos> buscarGruposPorCampoNombre(Carrera reticula, Integer semestre, PeriodoEscolar periodo, String nombregrupo) {
        List<Grupos> lista = null;
        System.out.println("BUSCANDO GRUPO: -> ");
        String sqlPermisos = "SELECT g FROM Grupos g " +
              "JOIN g.idMateriaCarrera mc " +
              "WHERE g.reticula = :reticula " +
              "AND mc.semestreReticula = :semestre " +
              "AND g.periodo = :periodo " +
              "AND g.grupo = :nombreGrupo";

        //System.out.println("Consulta " + sqlPermisos);
        Query queryPersonal = em.createQuery(sqlPermisos);

        queryPersonal.setParameter("reticula", reticula);
        queryPersonal.setParameter("semestre", semestre);
        queryPersonal.setParameter("periodo", periodo);
        queryPersonal.setParameter("nombreGrupo", nombregrupo);

        lista = (List<Grupos>) (queryPersonal.getResultList());

        return lista;
    }
    
}
