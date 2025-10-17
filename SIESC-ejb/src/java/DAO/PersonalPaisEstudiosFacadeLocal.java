/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PersonalPaisEstudios;

/**
 *
 * @author gacev
 */
@Local
public interface PersonalPaisEstudiosFacadeLocal {

    void create(PersonalPaisEstudios personalPaisEstudios);

    void edit(PersonalPaisEstudios personalPaisEstudios);

    void remove(PersonalPaisEstudios personalPaisEstudios);

    PersonalPaisEstudios find(Object id);

    List<PersonalPaisEstudios> findAll();

    List<PersonalPaisEstudios> findRange(int[] range);

    int count();
    
}
