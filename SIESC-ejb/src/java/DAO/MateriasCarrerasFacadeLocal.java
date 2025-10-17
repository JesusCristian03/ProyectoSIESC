/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.MateriasCarreras;

/**
 *
 * @author gacev
 */
@Local
public interface MateriasCarrerasFacadeLocal {

    void create(MateriasCarreras materiasCarreras);

    void edit(MateriasCarreras materiasCarreras);

    void remove(MateriasCarreras materiasCarreras);

    MateriasCarreras find(Object id);

    List<MateriasCarreras> findAll();

    List<MateriasCarreras> findRange(int[] range);

    int count();

    List<MateriasCarreras> buscarMaterias(Integer reticula);
    
    List<MateriasCarreras> buscarMateriasDepto(Integer reticula, String claveArea);
    
    List<MateriasCarreras> buscarMateriasCarrera(Integer reticula);

    List<MateriasCarreras> buscarAsignaturaSemestre(Integer reticula, Integer semestre);
    List<MateriasCarreras> buscarMateriasCarreraPerMateria(String idmateria);
    
}
