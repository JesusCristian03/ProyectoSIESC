/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.MtoEquipo;

/**
 *
 * @author gacev
 */
@Local
public interface MtoEquipoFacadeLocal {

    void create(MtoEquipo mtoEquipo);

    void edit(MtoEquipo mtoEquipo);

    void remove(MtoEquipo mtoEquipo);

    MtoEquipo find(Object id);

    List<MtoEquipo> findAll();

    List<MtoEquipo> findRange(int[] range);

    int count();
    
}
