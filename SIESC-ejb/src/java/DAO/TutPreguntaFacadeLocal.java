/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.TutPregunta;

/**
 *
 * @author gacev
 */
@Local
public interface TutPreguntaFacadeLocal {

    void create(TutPregunta tutPregunta);

    void edit(TutPregunta tutPregunta);

    void remove(TutPregunta tutPregunta);

    TutPregunta find(Object id);

    List<TutPregunta> findAll();

    List<TutPregunta> findRange(int[] range);

    int count();
    
}
