/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.EstatusChecada;

/**
 *
 * @author gacev
 */
@Local
public interface EstatusChecadaFacadeLocal {

    void create(EstatusChecada estatusChecada);

    void edit(EstatusChecada estatusChecada);

    void remove(EstatusChecada estatusChecada);

    EstatusChecada find(Object id);

    List<EstatusChecada> findAll();

    List<EstatusChecada> findRange(int[] range);

    int count();
    
}
