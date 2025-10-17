/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import modelo.Estudiante;
import modelo.MateriasCarreras;
import modelo.Reticula;

/**
 *
 * @author gacev
 */
@Local
public interface MateriasCarrerasServicioLocal {

    void prueba();

    ArrayList<Reticula> buscarMaterias(Estudiante estudiante);

    List<MateriasCarreras> buscarPorCarrera(Integer reticula);

    List<MateriasCarreras> buscarPorCarreraDepto(Integer reticula, String claveArea);

    List<MateriasCarreras> buscarAsinaturaSemestre(Integer reticula, Integer semestre);

    List<MateriasCarreras> buscarMateriasCarreraPerMateria(String idmateria);

    public MateriasCarreras buscarPorId(Integer x);
}
