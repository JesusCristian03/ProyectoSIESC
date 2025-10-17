/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PersonalCurso;

/**
 *
 * @author gacev
 */
@Local
public interface PersonalCursoFacadeLocal {

    void create(PersonalCurso personalCurso);

    void edit(PersonalCurso personalCurso);

    void remove(PersonalCurso personalCurso);

    PersonalCurso find(Object id);

    List<PersonalCurso> findAll();

    List<PersonalCurso> findRange(int[] range);

    int count();
    
}
