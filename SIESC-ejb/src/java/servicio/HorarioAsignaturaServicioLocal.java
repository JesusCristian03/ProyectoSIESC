/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Local;
import modelo.HorarioAsignatura;
import modelo.Horarios;

/**
 *
 * @author gacev
 */
@Local
public interface HorarioAsignaturaServicioLocal {
    
    List<HorarioAsignatura> buscarHorarioDocente(String rfc, Character tipo);
    
    List<HorarioAsignatura> buscarHorarioAsignatura(String periodo, String materia);
    
    List<HorarioAsignatura> buscarHorarioAsignatura(String periodo, Integer reticula, Integer semestre);
    
    List<HorarioAsignatura> buscarHorarioAsignatura(String periodo, Integer reticula);
    
    List<HorarioAsignatura> horariosaHorarioA(List<Horarios> lista);
    
    HorarioAsignatura buscarHorarioAsignatura(String periodo, String materia, String grupo);
    
    
    
}
