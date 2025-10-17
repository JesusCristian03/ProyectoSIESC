/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.EstudiosDocente;

/**
 *
 * @author gacev
 */
@Local
public interface EstudiosDocenteFacadeLocal {

    void create(EstudiosDocente estudiosDocente);

    void edit(EstudiosDocente estudiosDocente);

    void remove(EstudiosDocente estudiosDocente);

    EstudiosDocente find(Object id);

    List<EstudiosDocente> findAll();

    List<EstudiosDocente> findRange(int[] range);

    int count();
    
}
