/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.TutTipoevaluacion;

/**
 *
 * @author gacev
 */
@Local
public interface TutTipoevaluacionFacadeLocal {

    void create(TutTipoevaluacion tutTipoevaluacion);

    void edit(TutTipoevaluacion tutTipoevaluacion);

    void remove(TutTipoevaluacion tutTipoevaluacion);

    TutTipoevaluacion find(Object id);

    List<TutTipoevaluacion> findAll();

    List<TutTipoevaluacion> findRange(int[] range);

    int count();
    
}
