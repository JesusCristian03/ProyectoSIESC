/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PersonalEstudiosEstado;

/**
 *
 * @author gacev
 */
@Local
public interface PersonalEstudiosEstadoFacadeLocal {

    void create(PersonalEstudiosEstado personalEstudiosEstado);

    void edit(PersonalEstudiosEstado personalEstudiosEstado);

    void remove(PersonalEstudiosEstado personalEstudiosEstado);

    PersonalEstudiosEstado find(Object id);

    List<PersonalEstudiosEstado> findAll();

    List<PersonalEstudiosEstado> findRange(int[] range);

    int count();
    
}
