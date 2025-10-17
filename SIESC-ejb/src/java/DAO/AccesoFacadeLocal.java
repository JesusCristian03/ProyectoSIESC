/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Acceso;

/**
 *
 * @author gacev
 */
@Local
public interface AccesoFacadeLocal {

    void create(Acceso acceso);

    void edit(Acceso acceso);

    void remove(Acceso acceso);

    Acceso find(Object id);

    List<Acceso> findAll();

    List<Acceso> findRange(int[] range);

    int count();
    
}
