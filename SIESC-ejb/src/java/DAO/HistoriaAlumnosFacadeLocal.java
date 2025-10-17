/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.HistoriaAlumno;

/**
 *
 * @author gacev
 */
@Local
public interface HistoriaAlumnosFacadeLocal {

    void create(HistoriaAlumno horarios);

    void edit(HistoriaAlumno horarios);

    void remove(HistoriaAlumno horarios);

    HistoriaAlumno find(Object id);

    List<HistoriaAlumno> findAll();

    List<HistoriaAlumno> findRange(int[] range);

    int count();

    List<HistoriaAlumno> buscarReticula(String noDeControl);
    
}
