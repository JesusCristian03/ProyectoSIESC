/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.RhAsistencia;

/**
 *
 * @author gacev
 */
@Local
public interface RhAsistenciaFacadeLocal {

    void create(RhAsistencia rhAsistencia);

    void edit(RhAsistencia rhAsistencia);

    void remove(RhAsistencia rhAsistencia);

    RhAsistencia find(Object id);

    List<RhAsistencia> findAll();

    List<RhAsistencia> findRange(int[] range);

    int count();
    
}
