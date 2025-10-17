/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PermisosFunciones;

/**
 *
 * @author gacev
 */
@Local
public interface PermisosFuncionesFacadeLocal {

    void create(PermisosFunciones permisosFunciones);

    void edit(PermisosFunciones permisosFunciones);

    void remove(PermisosFunciones permisosFunciones);

    PermisosFunciones find(Object id);

    List<PermisosFunciones> findAll();

    List<PermisosFunciones> findRange(int[] range);

    int count();
    
}
