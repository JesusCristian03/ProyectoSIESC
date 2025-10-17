/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Edificio;

/**
 *
 * @author gacev
 */
@Local
public interface EdificioFacadeLocal {

    void create(Edificio edificio);

    void edit(Edificio edificio);

    void remove(Edificio edificio);

    Edificio find(Object id);

    List<Edificio> findAll();

    List<Edificio> findRange(int[] range);

    int count();
    
}
