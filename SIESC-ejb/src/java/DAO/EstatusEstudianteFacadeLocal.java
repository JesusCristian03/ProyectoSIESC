/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.EstatusEstudiante;

/**
 *
 * @author gacev
 */
@Local
public interface EstatusEstudianteFacadeLocal {

    void create(EstatusEstudiante estatusEstudiante);

    void edit(EstatusEstudiante estatusEstudiante);

    void remove(EstatusEstudiante estatusEstudiante);

    EstatusEstudiante find(Object id);

    List<EstatusEstudiante> findAll();

    List<EstatusEstudiante> findRange(int[] range);

    int count();
    
}
