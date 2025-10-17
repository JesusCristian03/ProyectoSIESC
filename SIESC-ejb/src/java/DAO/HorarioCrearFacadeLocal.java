/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.HorarioCrear;

/**
 *
 * @author gacev
 */
@Local
public interface HorarioCrearFacadeLocal {

    void create(HorarioCrear horarioCrear);

    void edit(HorarioCrear horarioCrear);

    void remove(HorarioCrear horarioCrear);

    HorarioCrear find(Object id);

    List<HorarioCrear> findAll();

    List<HorarioCrear> findRange(int[] range);

    int count();
    
}
