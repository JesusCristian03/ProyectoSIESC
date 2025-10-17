/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Organigrama;

/**
 *
 * @author gacev
 */
@Local
public interface OrganigramaFacadeLocal {

    void create(Organigrama organigrama);

    void edit(Organigrama organigrama);

    void remove(Organigrama organigrama);

    Organigrama find(Object id);

    List<Organigrama> findAll();

    List<Organigrama> findRange(int[] range);

    int count();
    
}
