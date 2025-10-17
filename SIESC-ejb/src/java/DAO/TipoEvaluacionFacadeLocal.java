/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoEvaluacion;

/**
 *
 * @author gacev
 */
@Local
public interface TipoEvaluacionFacadeLocal {

    void create(TipoEvaluacion tipoEvaluacion);

    void edit(TipoEvaluacion tipoEvaluacion);

    void remove(TipoEvaluacion tipoEvaluacion);

    TipoEvaluacion find(Object id);

    List<TipoEvaluacion> findAll();

    List<TipoEvaluacion> findRange(int[] range);

    int count();
    
}
