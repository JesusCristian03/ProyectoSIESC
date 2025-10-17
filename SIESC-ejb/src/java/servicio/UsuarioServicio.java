/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.UsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;

/**
 *
 * @author gacev
 */
@Stateless
public class UsuarioServicio implements UsuarioServicioLocal {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    @Override
    public Usuario iniciaSesion(Usuario usuario) {
        Usuario aux = usuarioFacade.iniciaSesion(usuario);
        return aux;
    }
}
