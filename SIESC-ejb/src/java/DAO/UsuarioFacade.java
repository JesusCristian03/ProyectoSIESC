/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author gacev
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciaSesion(Usuario usuario){
        Usuario usr = null  ;
        String sql = "SELECT u FROM Usuario u WHERE u.usuario =:usuario AND u.contrasena =:contrasena";
        Query query = em.createQuery(sql);
        query.setParameter("usuario",usuario.getUsuario());
        query.setParameter("contrasena",usuario.getContrasena());
        List<Usuario> lista = query.getResultList();
        System.out.println(usuario.getUsuario() + "usuario" + usuario.getContrasena());
        if(!lista.isEmpty()){
            usr = lista.get(0);
            System.out.println("usuarioooo : "+usr.getUsuario());
        }
        
        return usr;
    }
}
