/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

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
public interface HorarioServicioLocal {

    List<Horarios> horarioDocente(String periodo, String rfc, Character tipo);

    List<Horarios> horarioAsignatura(String periodo, String materia, String grupo);

    List<Horarios> horarioAsignatura(String periodo, String materia);

    List<Horarios> horarioAsignatura(String periodo, Integer reticula, Integer semestre);

    List<Horarios> horarioAsignatura(String periodo, Integer reticula);

    void insertarHorario(Horarios horarios);

    List<Horarios> buscarHorariosPorGrupos(Carrera reticula, int semestre, PeriodoEscolar periodo, String nombregrupo);
    void eliminar(Horarios horarios);
    void actualizar(Horarios horarios);
}
