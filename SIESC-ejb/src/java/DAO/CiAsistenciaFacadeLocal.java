/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.CiAsistencia;

/**
 *
 * @author gacev
 */
@Local
public interface CiAsistenciaFacadeLocal {

    void create(CiAsistencia ciAsistencia);

    void edit(CiAsistencia ciAsistencia);

    void remove(CiAsistencia ciAsistencia);

    CiAsistencia find(Object id);

    List<CiAsistencia> findAll();

    List<CiAsistencia> findRange(int[] range);

    int count();
    
}
