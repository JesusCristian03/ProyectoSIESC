/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Funciones;

/**
 *
 * @author gacev
 */
@Local
public interface FuncionesFacadeLocal {

    void create(Funciones funciones);

    void edit(Funciones funciones);

    void remove(Funciones funciones);

    Funciones find(Object id);

    List<Funciones> findAll();

    List<Funciones> findRange(int[] range);

    int count();
    
}
