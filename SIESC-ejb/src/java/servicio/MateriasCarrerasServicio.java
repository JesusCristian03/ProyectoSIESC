/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.MateriasCarrerasFacadeLocal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Estudiante;
import modelo.HistoriaAlumno;
import modelo.MateriasCarreras;
import modelo.Reticula;
import modelo.ReticulaDatos;

/**
 *
 * @author gacev
 */
@Stateless
public class MateriasCarrerasServicio implements MateriasCarrerasServicioLocal {
    
    @EJB
    private MateriasCarrerasFacadeLocal materiasCarrerasFacade1;
    
    @EJB
    private HistoriaAlumnoServicioLocal historiaAlumnoServicio;
    
    @EJB
    private MateriasCarrerasFacadeLocal materiasCarrerasFacade;
    
    private Reticula reticula;
    
    @Override
    public void prueba() {
        System.out.println("Prueba");
    }
    
     @Override
    public MateriasCarreras buscarPorId(Integer x) {
        return materiasCarrerasFacade1.find(x);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public ArrayList<Reticula> buscarMaterias(Estudiante estudiante) {
        
        ArrayList<Reticula> listaR = new ArrayList();
        List<MateriasCarreras> listaM = materiasCarrerasFacade.buscarMaterias(estudiante.getReticula().getReticula());
        List<HistoriaAlumno> listaHA = historiaAlumnoServicio.buscarAsignaturas(estudiante.getNoDeControl());
        Integer renglonAnt = 1;
        reticula = new Reticula();
        for (MateriasCarreras materia : listaM) {
            System.out.println(materia.getRenglon() + "/" + materia.getSemestreReticula() + " Materia Semestre" + materia.getMateria().getNombreCompletoMateria() + " clave " + materia.getMateria().getMateria());
            if (renglonAnt != materia.getRenglon()) {
                listaR.add(reticula);
                reticula = new Reticula();                
                agregarDatos(materia, estudiante.getSemestre());
                renglonAnt = materia.getRenglon();
            } else {
                agregarDatos(materia, estudiante.getSemestre());
                renglonAnt = materia.getRenglon();                
            }
            
        }
        String color;        
        boolean disponible;
        for (HistoriaAlumno historiaA : listaHA) {
            if (historiaA.getCalificacion() >= 70) {
                color = "acreditado";
                disponible = false;
            } else {
                disponible = true;
                switch (historiaA.getTipoEvaluacion().getPrioridad()) {
                    case 1:
                        color = "ordinario";
                        break;
                    case 2:
                        color = "repeticion";
                        break;
                    case 3:
                        color = "especial";
                        break;
                    default:                        
                        color = "nodisponible";
                        break;
                }
            }
            for (int ren = 0; ren < listaR.size(); ren++) {
                Reticula aux = listaR.get(ren);
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre1().getMateria())) {
                    aux.getSemestre1().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());                    
                    aux.getSemestre1().setColor(color);
                    aux.getSemestre1().setDisponible(disponible);                    
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre2().getMateria())) {
                    aux.getSemestre2().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre2().setColor(color);
                    aux.getSemestre2().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre3().getMateria())) {
                    aux.getSemestre3().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre3().setColor(color);
                    aux.getSemestre3().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre4().getMateria())) {
                    aux.getSemestre4().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre4().setColor(color);
                    aux.getSemestre4().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre5().getMateria())) {
                    aux.getSemestre5().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre5().setColor(color);
                    aux.getSemestre5().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre6().getMateria())) {
                    aux.getSemestre6().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre6().setColor(color);
                    aux.getSemestre6().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre7().getMateria())) {
                    aux.getSemestre7().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre7().setColor(color);
                    aux.getSemestre7().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre8().getMateria())) {
                    aux.getSemestre8().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre8().setColor(color);
                    aux.getSemestre8().setDisponible(disponible);
                }
                if (historiaA.getMateria().getMateria().equals(aux.getSemestre9().getMateria())) {
                    aux.getSemestre9().setCalificacion(String.valueOf(historiaA.getCalificacion()) + " / " + historiaA.getTipoEvaluacion().getTipoEvaluacion());
                    aux.getSemestre9().setColor(color);
                    aux.getSemestre9().setDisponible(disponible);
                }
            }
        }
        return listaR;
    }
    @Override
    public List<MateriasCarreras> buscarMateriasCarreraPerMateria(String idmateria) {
        return materiasCarrerasFacade.buscarMateriasCarreraPerMateria(idmateria);
    }

    private void agregarDatos(MateriasCarreras materia, Integer semestre) {
        ReticulaDatos reticulaDatos = new ReticulaDatos();
        reticulaDatos.setMateria(materia.getMateria().getMateria());
        reticulaDatos.setNombreMateria(materia.getMateria().getNombreAbreviadoMateria());
        reticulaDatos.setClave(materia.getClaveOficialMateria());
        if (materia.getSemestreReticula() <= semestre) {
            reticulaDatos.setColor("disponible");
            reticulaDatos.setDisponible(true);
        } else {
            reticulaDatos.setColor("nodisponible");
            reticulaDatos.setDisponible(false);
        }
        switch (materia.getSemestreReticula()) {
            case 1:
                reticula.setSemestre1(reticulaDatos);
                break;
            case 2:
                reticula.setSemestre2(reticulaDatos);
                break;
            case 3:
                reticula.setSemestre3(reticulaDatos);
                break;
            case 4:
                reticula.setSemestre4(reticulaDatos);
                break;
            case 5:
                reticula.setSemestre5(reticulaDatos);
                break;
            case 6:
                reticula.setSemestre6(reticulaDatos);
                break;
            case 7:
                reticula.setSemestre7(reticulaDatos);
                break;
            case 8:
                reticula.setSemestre8(reticulaDatos);
                break;
            case 9:
                reticula.setSemestre9(reticulaDatos);
                break;
        }
    }
    
    @Override
    public List<MateriasCarreras> buscarPorCarrera(Integer reticula) {        
        return materiasCarrerasFacade1.buscarMateriasCarrera(reticula);
    }
    
    @Override
    public List<MateriasCarreras> buscarPorCarreraDepto(Integer reticula, String claveArea) {
        return materiasCarrerasFacade1.buscarMateriasDepto(reticula, claveArea);
    }
    
    @Override
    public List<MateriasCarreras> buscarAsinaturaSemestre(Integer reticula, Integer semestre) {
        return materiasCarrerasFacade1.buscarAsignaturaSemestre(reticula, semestre);
    }
    
}
