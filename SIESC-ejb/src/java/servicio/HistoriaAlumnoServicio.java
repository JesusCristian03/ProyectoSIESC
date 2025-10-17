/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.HistoriaAlumnosFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.HistoriaAlumno;
import modelo.Reticula;

/**
 *
 * @author gacev
 */
@Stateless
public class HistoriaAlumnoServicio implements HistoriaAlumnoServicioLocal {

    @EJB
    private HistoriaAlumnosFacadeLocal historiaAlumnoFacade;

    @Override
    public List<Reticula> buscarReticula(String noDeControl) {
        ArrayList<Reticula> reticula = new ArrayList();
        List<HistoriaAlumno> lista = historiaAlumnoFacade.buscarReticula(noDeControl);
        return null;
    }

    @Override
    public List<HistoriaAlumno> buscarAsignaturas(String noDeCcontrol) {
        return historiaAlumnoFacade.buscarReticula(noDeCcontrol);
    }

    
    
}
