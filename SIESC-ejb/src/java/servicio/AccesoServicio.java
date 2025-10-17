/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.AccesoFacadeLocal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Acceso;

/**
 *
 * @author gacev
 */
@Stateless
public class AccesoServicio implements AccesoServicioLocal {

    @EJB
    private AccesoFacadeLocal accesoFacade;

    
    @Override
    public List<Acceso> buscarTodos() {
        return accesoFacade.findAll();
    }

    @Override
    public void insertar(Acceso acceso) {
        Date date = new Date();
        //Hora actual de la PC
        Locale local = new Locale("es","MX");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+6:00"),local);
        acceso.setEntrada(cal.getTime());
        accesoFacade.create(acceso);
    }
    
}
