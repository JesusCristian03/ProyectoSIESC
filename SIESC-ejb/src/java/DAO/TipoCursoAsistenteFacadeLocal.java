/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoCursoAsistente;

/**
 *
 * @author gacev
 */
@Local
public interface TipoCursoAsistenteFacadeLocal {

    void create(TipoCursoAsistente tipoCursoAsistente);

    void edit(TipoCursoAsistente tipoCursoAsistente);

    void remove(TipoCursoAsistente tipoCursoAsistente);

    TipoCursoAsistente find(Object id);

    List<TipoCursoAsistente> findAll();

    List<TipoCursoAsistente> findRange(int[] range);

    int count();
    
}
