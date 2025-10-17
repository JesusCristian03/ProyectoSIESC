/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PersonalEstudios;

/**
 *
 * @author gacev
 */
@Local
public interface PersonalEstudiosFacadeLocal {

    void create(PersonalEstudios personalEstudios);

    void edit(PersonalEstudios personalEstudios);

    void remove(PersonalEstudios personalEstudios);

    PersonalEstudios find(Object id);

    List<PersonalEstudios> findAll();

    List<PersonalEstudios> findRange(int[] range);

    int count();
    
}
