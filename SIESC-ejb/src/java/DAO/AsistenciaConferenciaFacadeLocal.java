/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.AsistenciaConferencia;

/**
 *
 * @author gacev
 */
@Local
public interface AsistenciaConferenciaFacadeLocal {

    void create(AsistenciaConferencia asistenciaConferencia);

    void edit(AsistenciaConferencia asistenciaConferencia);

    void remove(AsistenciaConferencia asistenciaConferencia);

    AsistenciaConferencia find(Object id);

    List<AsistenciaConferencia> findAll();

    List<AsistenciaConferencia> findRange(int[] range);

    int count();
    
}
