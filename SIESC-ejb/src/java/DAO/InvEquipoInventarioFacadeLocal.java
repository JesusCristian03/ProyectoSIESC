/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvEquipoInventario;

/**
 *
 * @author gacev
 */
@Local
public interface InvEquipoInventarioFacadeLocal {

    void create(InvEquipoInventario invEquipoInventario);

    void edit(InvEquipoInventario invEquipoInventario);

    void remove(InvEquipoInventario invEquipoInventario);

    InvEquipoInventario find(Object id);

    List<InvEquipoInventario> findAll();

    List<InvEquipoInventario> findRange(int[] range);

    int count();
    
}
