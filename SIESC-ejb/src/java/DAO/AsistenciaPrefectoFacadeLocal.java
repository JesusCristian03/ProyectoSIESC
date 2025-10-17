/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.AsistenciaPrefecto;

/**
 *
 * @author gacev
 */
@Local
public interface AsistenciaPrefectoFacadeLocal {

    void create(AsistenciaPrefecto asistenciaPrefecto);

    void edit(AsistenciaPrefecto asistenciaPrefecto);

    void remove(AsistenciaPrefecto asistenciaPrefecto);

    AsistenciaPrefecto find(Object id);

    List<AsistenciaPrefecto> findAll();

    List<AsistenciaPrefecto> findRange(int[] range);

    int count();
    
}
