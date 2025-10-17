/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvAsignacionEquipo;

/**
 *
 * @author gacev
 */
@Local
public interface InvAsignacionEquipoFacadeLocal {

    void create(InvAsignacionEquipo invAsignacionEquipo);

    void edit(InvAsignacionEquipo invAsignacionEquipo);

    void remove(InvAsignacionEquipo invAsignacionEquipo);

    InvAsignacionEquipo find(Object id);

    List<InvAsignacionEquipo> findAll();

    List<InvAsignacionEquipo> findRange(int[] range);

    int count();
    
}
