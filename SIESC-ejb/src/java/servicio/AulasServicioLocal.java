/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Local;
import modelo.Aulas;

/**
 *
 * @author cris_
 */
@Local
public interface AulasServicioLocal {
    List<Aulas> aulasActivos();
    Aulas buscarPorId(String x);
}
