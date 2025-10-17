/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.TarjetaFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Tarjeta;

/**
 *
 * @author gacev
 */
@Stateless
public class TarjetaServicio implements TarjetaServicioLocal {

    @EJB
    private TarjetaFacadeLocal tarjetaFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Tarjeta buscarPorId(String idTarjeta) {
        return tarjetaFacade.find(idTarjeta);
    }

    @Override
    public Tarjeta buscarActivo(String idTarjeta) {
        return tarjetaFacade.buscarActivo(idTarjeta);
    }
    
    
}
