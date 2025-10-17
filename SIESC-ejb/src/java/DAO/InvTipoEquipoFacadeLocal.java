/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvTipoEquipo;

/**
 *
 * @author gacev
 */
@Local
public interface InvTipoEquipoFacadeLocal {

    void create(InvTipoEquipo invTipoEquipo);

    void edit(InvTipoEquipo invTipoEquipo);

    void remove(InvTipoEquipo invTipoEquipo);

    InvTipoEquipo find(Object id);

    List<InvTipoEquipo> findAll();

    List<InvTipoEquipo> findRange(int[] range);

    int count();
    
}
