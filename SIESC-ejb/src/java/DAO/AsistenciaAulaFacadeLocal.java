/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.AsistenciaAula;

/**
 *
 * @author gacev
 */
@Local
public interface AsistenciaAulaFacadeLocal {

    void create(AsistenciaAula asistenciaAula);

    void edit(AsistenciaAula asistenciaAula);

    void remove(AsistenciaAula asistenciaAula);

    AsistenciaAula find(Object id);

    List<AsistenciaAula> findAll();

    List<AsistenciaAula> findRange(int[] range);

    int count();
    
}
