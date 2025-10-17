/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvMantenimientoProgramado;

/**
 *
 * @author gacev
 */
@Local
public interface InvMantenimientoProgramadoFacadeLocal {

    void create(InvMantenimientoProgramado invMantenimientoProgramado);

    void edit(InvMantenimientoProgramado invMantenimientoProgramado);

    void remove(InvMantenimientoProgramado invMantenimientoProgramado);

    InvMantenimientoProgramado find(Object id);

    List<InvMantenimientoProgramado> findAll();

    List<InvMantenimientoProgramado> findRange(int[] range);

    int count();
    
}
