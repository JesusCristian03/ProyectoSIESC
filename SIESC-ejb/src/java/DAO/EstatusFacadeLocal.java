/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Estatus;

/**
 *
 * @author gacev
 */
@Local
public interface EstatusFacadeLocal {

    void create(Estatus estatus);

    void edit(Estatus estatus);

    void remove(Estatus estatus);

    Estatus find(Object id);

    List<Estatus> findAll();

    List<Estatus> findRange(int[] range);

    int count();
    
}
