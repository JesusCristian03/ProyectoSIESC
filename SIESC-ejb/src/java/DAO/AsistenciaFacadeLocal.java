/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Asistencia;

/**
 *
 * @author gacev
 */
@Local
public interface AsistenciaFacadeLocal {

    void create(Asistencia asistencia);

    void edit(Asistencia asistencia);

    void remove(Asistencia asistencia);

    Asistencia find(Object id);

    List<Asistencia> findAll();

    List<Asistencia> findRange(int[] range);

    int count();
    
}
