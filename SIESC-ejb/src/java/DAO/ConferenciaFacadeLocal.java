/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Conferencia;

/**
 *
 * @author gacev
 */
@Local
public interface ConferenciaFacadeLocal {

    void create(Conferencia conferencia);

    void edit(Conferencia conferencia);

    void remove(Conferencia conferencia);

    Conferencia find(Object id);

    List<Conferencia> findAll();

    List<Conferencia> findRange(int[] range);

    int count();
    
}
