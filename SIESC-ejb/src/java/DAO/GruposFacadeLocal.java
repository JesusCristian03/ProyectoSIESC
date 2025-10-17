/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Carrera;
import modelo.Grupos;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Local
public interface GruposFacadeLocal {

    void create(Grupos grupos);

    void edit(Grupos grupos);

    void remove(Grupos grupos);

    Grupos find(Object id);

    List<Grupos> findAll();

    List<Grupos> findRange(int[] range);

    int count();

    List<Grupos> gruposActivos();

    List<Grupos> buscarGrupoSii(Integer reticula, Integer idmateriacarrera, String periodo, String grupo);

    List<Grupos> buscarGruposPorCampoNombre(Carrera reticula, Integer semestre, PeriodoEscolar periodo, String nombregrupo);

}
