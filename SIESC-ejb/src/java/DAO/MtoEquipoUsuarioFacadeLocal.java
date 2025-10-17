/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.MtoEquipoUsuario;

/**
 *
 * @author gacev
 */
@Local
public interface MtoEquipoUsuarioFacadeLocal {

    void create(MtoEquipoUsuario mtoEquipoUsuario);

    void edit(MtoEquipoUsuario mtoEquipoUsuario);

    void remove(MtoEquipoUsuario mtoEquipoUsuario);

    MtoEquipoUsuario find(Object id);

    List<MtoEquipoUsuario> findAll();

    List<MtoEquipoUsuario> findRange(int[] range);

    int count();
    
}
