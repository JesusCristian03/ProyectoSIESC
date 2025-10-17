/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoCurso;

/**
 *
 * @author gacev
 */
@Local
public interface TipoCursoFacadeLocal {

    void create(TipoCurso tipoCurso);

    void edit(TipoCurso tipoCurso);

    void remove(TipoCurso tipoCurso);

    TipoCurso find(Object id);

    List<TipoCurso> findAll();

    List<TipoCurso> findRange(int[] range);

    int count();
    
}
