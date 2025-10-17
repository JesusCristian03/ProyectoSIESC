/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.EstatusUsuario;

/**
 *
 * @author gacev
 */
@Local
public interface EstatusUsuarioFacadeLocal {

    void create(EstatusUsuario estatusUsuario);

    void edit(EstatusUsuario estatusUsuario);

    void remove(EstatusUsuario estatusUsuario);

    EstatusUsuario find(Object id);

    List<EstatusUsuario> findAll();

    List<EstatusUsuario> findRange(int[] range);

    int count();
    
}
