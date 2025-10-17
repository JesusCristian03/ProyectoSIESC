/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Aulas;

/**
 *
 * @author gacev
 */
@Local
public interface AulasFacadeLocal {

    void create(Aulas aulas);

    void edit(Aulas aulas);

    void remove(Aulas aulas);

    Aulas find(Object id);

    List<Aulas> findAll();

    List<Aulas> findRange(int[] range);

    int count();
    List<Aulas> aulasActivos();
    
}
