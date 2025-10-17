/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.EstudianteFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Estudiante;

/**
 *
 * @author gacev
 */
@Stateless
public class EstudianteServicio implements EstudianteServicioLocal {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

    @Override
    public Estudiante buscarPorID(String no_de_control) {
        return estudianteFacade.find(no_de_control);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Estudiante loginEstudiante(Estudiante estudiante) {
        return estudianteFacade.loginEstudiante(estudiante);
    }
    
    
}
