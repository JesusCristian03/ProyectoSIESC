/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.SeleccionMaterias;

/**
 *
 * @author gacev
 */
@Local
public interface SeleccionMateriasFacadeLocal {

    void create(SeleccionMaterias seleccionMaterias);

    void edit(SeleccionMaterias seleccionMaterias);

    void remove(SeleccionMaterias seleccionMaterias);

    SeleccionMaterias find(Object id);

    List<SeleccionMaterias> findAll();

    List<SeleccionMaterias> findRange(int[] range);

    int count();
    
}
