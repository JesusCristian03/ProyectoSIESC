/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.MtoEquipoUsuario;

/**
 *
 * @author gacev
 */
@Stateless
public class MtoEquipoUsuarioFacade extends AbstractFacade<MtoEquipoUsuario> implements MtoEquipoUsuarioFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MtoEquipoUsuarioFacade() {
        super(MtoEquipoUsuario.class);
    }
    
}
