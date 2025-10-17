/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import DAO.EstudianteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelo.Estudiante;

/**
 *
 * @author gacev
 */
@Named(value = "estudianteBean")
@SessionScoped
public class EstudianteBean implements Serializable {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

    private List<Estudiante> lista;
    /**
     * Creates a new instance of EstudianteBean
     */
    public EstudianteBean() {
    }

    public List<Estudiante> getLista() {
        lista = estudianteFacade.findAll();
        System.out.println("Leer");
        return lista;
    }

    public void setLista(List<Estudiante> lista) {
        this.lista = lista;
    }
    
}
