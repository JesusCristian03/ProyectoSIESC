/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import javax.ejb.Local;
import modelo.Estudiante;

/**
 *
 * @author gacev
 */
@Local
public interface EstudianteServicioLocal {

    Estudiante buscarPorID(String no_de_control);

    Estudiante loginEstudiante(Estudiante estudiante);
    
}
