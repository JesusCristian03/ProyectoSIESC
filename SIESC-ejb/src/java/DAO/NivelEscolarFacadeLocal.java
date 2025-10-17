/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.NivelEscolar;

/**
 *
 * @author gacev
 */
@Local
public interface NivelEscolarFacadeLocal {

    void create(NivelEscolar nivelEscolar);

    void edit(NivelEscolar nivelEscolar);

    void remove(NivelEscolar nivelEscolar);

    NivelEscolar find(Object id);

    List<NivelEscolar> findAll();

    List<NivelEscolar> findRange(int[] range);

    int count();
    
}
