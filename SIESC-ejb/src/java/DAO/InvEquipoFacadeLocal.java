/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvEquipo;

/**
 *
 * @author gacev
 */
@Local
public interface InvEquipoFacadeLocal {

    void create(InvEquipo invEquipo);

    void edit(InvEquipo invEquipo);

    void remove(InvEquipo invEquipo);

    InvEquipo find(Object id);

    List<InvEquipo> findAll();

    List<InvEquipo> findRange(int[] range);

    int count();
    
}
