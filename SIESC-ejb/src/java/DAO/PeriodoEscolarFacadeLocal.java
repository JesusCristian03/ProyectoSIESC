/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Local
public interface PeriodoEscolarFacadeLocal {

    void create(PeriodoEscolar periodoEscolar);

    void edit(PeriodoEscolar periodoEscolar);

    void remove(PeriodoEscolar periodoEscolar);

    PeriodoEscolar find(Object id);

    List<PeriodoEscolar> findAll();

    List<PeriodoEscolar> findRange(int[] range);

    int count();
    
    public String peridoActual();
    
    public PeriodoEscolar peridoActualPE();

    List<PeriodoEscolar> periodosEscolaresActivos();
    
}
