/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.GruposFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Carrera;
import modelo.Grupos;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Stateless
public class GruposServicio implements GruposServicioLocal {

    @EJB
    private GruposFacadeLocal gruposFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Grupos> gruposActivos() {
        return gruposFacade.gruposActivos();
    }

    @Override
    public void insertarNuevoGrupo(Grupos grupo) {
        gruposFacade.create(grupo);
    }
    @Override
    public void eliminar(Grupos grupo) {
        gruposFacade.remove(grupo);
    }

    @Override
    public Grupos buscarPorId(String x) {
        return gruposFacade.find(x);
    }

    @Override
    public List<Grupos> buscarGrupoSii(Integer reticula, Integer idmateriacarrera, String periodo, String grupo) {
        return gruposFacade.buscarGrupoSii(reticula, idmateriacarrera, periodo, grupo);
    }

    @Override
    public List<Grupos> buscarGruposPorCampoNombre(Carrera reticula, Integer semestre, PeriodoEscolar periodo, String grupo) {
        return gruposFacade.buscarGruposPorCampoNombre(reticula, semestre, periodo, grupo);
    }

}
