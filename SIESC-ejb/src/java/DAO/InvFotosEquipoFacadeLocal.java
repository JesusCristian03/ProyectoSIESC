/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvFotosEquipo;

/**
 *
 * @author gacev
 */
@Local
public interface InvFotosEquipoFacadeLocal {

    void create(InvFotosEquipo invFotosEquipo);

    void edit(InvFotosEquipo invFotosEquipo);

    void remove(InvFotosEquipo invFotosEquipo);

    InvFotosEquipo find(Object id);

    List<InvFotosEquipo> findAll();

    List<InvFotosEquipo> findRange(int[] range);

    int count();
    
}
