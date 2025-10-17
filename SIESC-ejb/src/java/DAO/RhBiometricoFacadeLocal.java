/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.RhBiometrico;

/**
 *
 * @author gacev
 */
@Local
public interface RhBiometricoFacadeLocal {

    void create(RhBiometrico rhBiometrico);

    void edit(RhBiometrico rhBiometrico);

    void remove(RhBiometrico rhBiometrico);

    RhBiometrico find(Object id);

    List<RhBiometrico> findAll();

    List<RhBiometrico> findRange(int[] range);

    int count();
    
}
