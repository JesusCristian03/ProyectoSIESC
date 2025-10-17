/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Local;
import modelo.Materia;

/**
 *
 * @author cris_
 */
@Local
public interface MateriaServicioLocal {
    List<Materia> findByNombreCompleto(String nombreCompleto);
    List<Materia> findByNombreAbreviado(String nombreAbreviado);
    Materia findByMateria(String materia);
    
}
