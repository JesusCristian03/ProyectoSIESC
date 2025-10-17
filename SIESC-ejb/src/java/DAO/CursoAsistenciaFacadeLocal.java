/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.CursoAsistencia;

/**
 *
 * @author gacev
 */
@Local
public interface CursoAsistenciaFacadeLocal {

    void create(CursoAsistencia cursoAsistencia);

    void edit(CursoAsistencia cursoAsistencia);

    void remove(CursoAsistencia cursoAsistencia);

    CursoAsistencia find(Object id);

    List<CursoAsistencia> findAll();

    List<CursoAsistencia> findRange(int[] range);

    int count();
    
}
