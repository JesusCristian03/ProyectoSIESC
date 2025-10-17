/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.CursoInstructor;

/**
 *
 * @author gacev
 */
@Local
public interface CursoInstructorFacadeLocal {

    void create(CursoInstructor cursoInstructor);

    void edit(CursoInstructor cursoInstructor);

    void remove(CursoInstructor cursoInstructor);

    CursoInstructor find(Object id);

    List<CursoInstructor> findAll();

    List<CursoInstructor> findRange(int[] range);

    int count();
    
}
