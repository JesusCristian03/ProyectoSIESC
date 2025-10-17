/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Local;
import modelo.HistoriaAlumno;
import modelo.Reticula;

/**
 *
 * @author gacev
 */
@Local
public interface HistoriaAlumnoServicioLocal {

    List<Reticula> buscarReticula(String noDeControl);

    List<HistoriaAlumno> buscarAsignaturas(String noDeCcontrol);
    
}
