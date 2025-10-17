/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.CursoInstructorParticipante;

/**
 *
 * @author gacev
 */
@Local
public interface CursoInstructorParticipanteFacadeLocal {

    void create(CursoInstructorParticipante cursoInstructorParticipante);

    void edit(CursoInstructorParticipante cursoInstructorParticipante);

    void remove(CursoInstructorParticipante cursoInstructorParticipante);

    CursoInstructorParticipante find(Object id);

    List<CursoInstructorParticipante> findAll();

    List<CursoInstructorParticipante> findRange(int[] range);

    int count();
    
}
