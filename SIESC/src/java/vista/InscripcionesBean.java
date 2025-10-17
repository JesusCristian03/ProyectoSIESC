/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import modelo.Estudiante;
import modelo.HorarioAsignatura;
import modelo.Materia;
import modelo.Reticula;
import servicio.HorarioAsignaturaServicioLocal;
import servicio.HorarioServicioLocal;
import servicio.MateriasCarrerasServicioLocal;

/**
 *
 * @author gacev
 */
@Named(value = "inscripcionesBean")
@SessionScoped
public class InscripcionesBean implements Serializable {

    @EJB
    private HorarioAsignaturaServicioLocal horarioAsignaturaServicio;

    @EJB
    private HorarioServicioLocal horarioServicio;

    @EJB
    private MateriasCarrerasServicioLocal materiasCarrerasServicio;
    
    private List<HorarioAsignatura> listaHorarioAsignatura;
    private ArrayList<Reticula> listaM = new ArrayList();
    

    private Estudiante estudiante;
    
    private String grupo = "false";
    private String asignatura = "false";
    
    private String periodo;
    private String materia;
    /**
     * Creates a new instance of InscripcionesBean
     */
    public InscripcionesBean() {
        try{
            FacesContext contexto = FacesContext.getCurrentInstance();
            estudiante = (Estudiante) contexto.getExternalContext().getSessionMap().get("estudiante");
            if(estudiante!=null){
                //System.out.println("Buscarrrrrrrr Materias" + estudiante.getReticula().getReticula());
                //
                
                
            }else{
                grupo = "true";
                asignatura = "true";
            }
        }catch(Exception e){
            System.out.println(e.getStackTrace() + "\nError" + e.getCause().toString());
        }
    }
    
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Reticula> getListaM() {
        return listaM;
    }

    public void setListaM(ArrayList<Reticula> listaM) {
        this.listaM = listaM;
    }

    public List<HorarioAsignatura> getListaHorarioAsignatura() {
        listaHorarioAsignatura = horarioAsignaturaServicio.buscarHorarioAsignatura(periodo, materia);
        return listaHorarioAsignatura;
    }

    public void setListaHorarioAsignatura(List<HorarioAsignatura> listaHorarioAsignatura) {
        
        this.listaHorarioAsignatura = listaHorarioAsignatura;
    }
    
    // Metodos 
    
    public void iniciarInscripcion(){
        
        listaM = materiasCarrerasServicio.buscarMaterias(estudiante);
        
    }
    
    public void onMateriaClick(String materia) {
        // Aquí recuperas la materia seleccionada desde el component binding
        listaHorarioAsignatura = horarioAsignaturaServicio.buscarHorarioAsignatura(periodo, materia);
        this.materia=materia;
        //System.out.println("Entraaaaaa" + materia);
    }
}
