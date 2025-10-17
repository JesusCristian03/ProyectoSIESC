/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoMateria;

/**
 *
 * @author gacev
 */
@Local
public interface TipoMateriaFacadeLocal {

    void create(TipoMateria tipoMateria);

    void edit(TipoMateria tipoMateria);

    void remove(TipoMateria tipoMateria);

    TipoMateria find(Object id);

    List<TipoMateria> findAll();

    List<TipoMateria> findRange(int[] range);

    int count();
    
}
