/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.AsistenciaEstudiante;

/**
 *
 * @author gacev
 */
@Local
public interface AsistenciaEstudianteFacadeLocal {

    void create(AsistenciaEstudiante asistenciaEstudiante);

    void edit(AsistenciaEstudiante asistenciaEstudiante);

    void remove(AsistenciaEstudiante asistenciaEstudiante);

    AsistenciaEstudiante find(Object id);

    List<AsistenciaEstudiante> findAll();

    List<AsistenciaEstudiante> findRange(int[] range);

    int count();
    
}
