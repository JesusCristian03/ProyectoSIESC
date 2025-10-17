/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.InvEstatus;

/**
 *
 * @author gacev
 */
@Local
public interface InvEstatusFacadeLocal {

    void create(InvEstatus invEstatus);

    void edit(InvEstatus invEstatus);

    void remove(InvEstatus invEstatus);

    InvEstatus find(Object id);

    List<InvEstatus> findAll();

    List<InvEstatus> findRange(int[] range);

    int count();
    
}
