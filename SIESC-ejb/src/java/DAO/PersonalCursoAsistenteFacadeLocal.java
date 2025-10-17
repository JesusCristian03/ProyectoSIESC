/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PersonalCursoAsistente;

/**
 *
 * @author gacev
 */
@Local
public interface PersonalCursoAsistenteFacadeLocal {

    void create(PersonalCursoAsistente personalCursoAsistente);

    void edit(PersonalCursoAsistente personalCursoAsistente);

    void remove(PersonalCursoAsistente personalCursoAsistente);

    PersonalCursoAsistente find(Object id);

    List<PersonalCursoAsistente> findAll();

    List<PersonalCursoAsistente> findRange(int[] range);

    int count();
    
}
