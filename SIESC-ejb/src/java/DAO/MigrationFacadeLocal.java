/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Migration;

/**
 *
 * @author gacev
 */
@Local
public interface MigrationFacadeLocal {

    void create(Migration migration);

    void edit(Migration migration);

    void remove(Migration migration);

    Migration find(Object id);

    List<Migration> findAll();

    List<Migration> findRange(int[] range);

    int count();
    
}
