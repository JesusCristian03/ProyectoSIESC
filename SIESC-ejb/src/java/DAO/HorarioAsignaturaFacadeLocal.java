/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.HorarioAsignatura;

/**
 *
 * @author gacev
 */
@Local
public interface HorarioAsignaturaFacadeLocal {

    void create(HorarioAsignatura horarioAsignatura);

    void edit(HorarioAsignatura horarioAsignatura);

    void remove(HorarioAsignatura horarioAsignatura);

    HorarioAsignatura find(Object id);

    List<HorarioAsignatura> findAll();

    List<HorarioAsignatura> findRange(int[] range);

    int count();
    
}
