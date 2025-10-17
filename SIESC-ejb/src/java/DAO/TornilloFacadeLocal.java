/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Tornillo;

/**
 *
 * @author gacev
 */
@Local
public interface TornilloFacadeLocal {

    void create(Tornillo tornillo);

    void edit(Tornillo tornillo);

    void remove(Tornillo tornillo);

    Tornillo find(Object id);

    List<Tornillo> findAll();

    List<Tornillo> findRange(int[] range);

    int count();
    
}
