/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Carrera;
import modelo.Horarios;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Local
public interface HorariosFacadeLoca {

    void create(Horarios horarios);

    void edit(Horarios horarios);

    void remove(Horarios horarios);

    Horarios find(Object id);

    List<Horarios> findAll();

    List<Horarios> findRange(int[] range);

    int count();

    List<Horarios> horarioDocente(String periodo, String rfc, Character tipo);

    List<Horarios> entradaDocente(short dia, int hora, String periodo, Character tipoHorario);

    List<Horarios> listaDocentes(String periodo);

    List<Horarios> horarioAsignatura(String periodo, String materia, String grupo);

    List<Horarios> horarioAsignatura(String periodo, String materia);

    List<Horarios> horarioAsignatura(String periodo, Integer reticula, Integer semestre);

    List<Horarios> horarioAsignatura(String periodo, Integer reticula);

    List<Horarios> horariosSinChecar(String periodo, int hora);

    List<Horarios> horarioDia(String periodo, short dia, Character tipo);

    List<Horarios> buscarDocentesArea(String periodo, String areaAcademica);

    List<Horarios> buscarHorariosPorGrupos(Carrera reticula, int semestre, PeriodoEscolar periodo, String nombregrupo);

}
