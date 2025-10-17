/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.List;
import javax.ejb.Local;
import modelo.PeriodoEscolar;

/**
 *
 * @author gacev
 */
@Local
public interface PeriodoEscolarServicioLocal {

    void insertar(PeriodoEscolar periodoEscolar);

    void modificar(PeriodoEscolar periodoEscolar);

    void eliminar(PeriodoEscolar periodoEscolar);

    PeriodoEscolar buscarPorId(String periodo);

    List<PeriodoEscolar> buscarTodos();

    String periodoActual();

    PeriodoEscolar periodoEscolarPE();

    List<PeriodoEscolar> periodosEscolaresActivos();
    
    
    
}
