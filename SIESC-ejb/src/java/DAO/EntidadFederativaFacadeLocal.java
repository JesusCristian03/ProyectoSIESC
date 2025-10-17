/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.EntidadFederativa;

/**
 *
 * @author gacev
 */
@Local
public interface EntidadFederativaFacadeLocal {

    void create(EntidadFederativa entidadFederativa);

    void edit(EntidadFederativa entidadFederativa);

    void remove(EntidadFederativa entidadFederativa);

    EntidadFederativa find(Object id);

    List<EntidadFederativa> findAll();

    List<EntidadFederativa> findRange(int[] range);

    int count();
    
}
