/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.CursoParticipante;

/**
 *
 * @author gacev
 */
@Local
public interface CursoParticipanteFacadeLocal {

    void create(CursoParticipante cursoParticipante);

    void edit(CursoParticipante cursoParticipante);

    void remove(CursoParticipante cursoParticipante);

    CursoParticipante find(Object id);

    List<CursoParticipante> findAll();

    List<CursoParticipante> findRange(int[] range);

    int count();
    
}
