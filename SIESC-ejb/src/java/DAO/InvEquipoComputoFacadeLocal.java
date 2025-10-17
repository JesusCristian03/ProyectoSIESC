/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvEquipoComputo;

/**
 *
 * @author gacev
 */
@Local
public interface InvEquipoComputoFacadeLocal {

    void create(InvEquipoComputo invEquipoComputo);

    void edit(InvEquipoComputo invEquipoComputo);

    void remove(InvEquipoComputo invEquipoComputo);

    InvEquipoComputo find(Object id);

    List<InvEquipoComputo> findAll();

    List<InvEquipoComputo> findRange(int[] range);

    int count();
    
}
