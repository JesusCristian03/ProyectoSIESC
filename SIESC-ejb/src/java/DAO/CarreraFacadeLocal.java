/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import modelo.Carrera;

/**
 *
 * @author gacev
 */
@Local
public interface CarreraFacadeLocal {

    void create(Carrera carrera);

    void edit(Carrera carrera);

    void remove(Carrera carrera);

    Carrera find(Object id);

    List<Carrera> findAll();

    List<Carrera> findRange(int[] range);

    int count();

    List<Carrera> buscarCarreraPerTwo(String nombrecarrera, Date fechaFinalizacion);
}
