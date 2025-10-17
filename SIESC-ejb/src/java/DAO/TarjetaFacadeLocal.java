/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.Tarjeta;

/**
 *
 * @author gacev
 */
@Local
public interface TarjetaFacadeLocal {

    void create(Tarjeta tarjeta);

    void edit(Tarjeta tarjeta);

    void remove(Tarjeta tarjeta);

    Tarjeta find(Object id);

    List<Tarjeta> findAll();

    List<Tarjeta> findRange(int[] range);

    int count();

    Tarjeta buscarActivo(String idTarjeta);
    
}
