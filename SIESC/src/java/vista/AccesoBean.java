/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.ejb.EJB;
import modelo.Acceso;
import modelo.Estudiante;
import modelo.Personal;
import modelo.Tarjeta;
import servicio.AccesoServicioLocal;
import servicio.EstudianteServicioLocal;
import servicio.PersonalServicioLocal;
import servicio.TarjetaServicioLocal;
import servicio.TornilloServicioLocal;

/**
 *
 * @author gacev
 */
@Named(value = "accesoBean")
@SessionScoped
public class AccesoBean implements Serializable {

    @EJB
    private TornilloServicioLocal tornilloServicio;

    @EJB
    private PersonalServicioLocal personalServicio;

    @EJB
    private EstudianteServicioLocal estudianteServicio;

    @EJB
    private TarjetaServicioLocal tarjetaServicio;

    @EJB
    private AccesoServicioLocal accesoServicio;

    //private List<Acceso> listaAcceso;
    private ArrayList<ListaAcceso> listaAcceso;
    ListaAcceso registroAcceso = new ListaAcceso();
    
    private Tarjeta tarjeta;
    private Personal personal;
    private Estudiante estudiante;
    
    private String idTarjeta;
    private String idTarjetaAnt="L";
    private String usuarioS = "";
    private String fotoS = "imagen";
    /**
     * Creates a new instance of AccesoBean
     */
    public AccesoBean() {
        listaAcceso = new ArrayList();
    }

    public String getFotoS() {
        return fotoS;
    }

    public void setFotoS(String fotoS) {
        this.fotoS = fotoS;
    }

    public String getUsuarioS() {
        return usuarioS;
    }

    public void setUsuarioS(String usuarioS) {
        this.usuarioS = usuarioS;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        if (!idTarjeta.equals(idTarjetaAnt)){
            idTarjetaAnt = idTarjeta;
            tarjeta = tarjetaServicio.buscarActivo(idTarjeta);

            //System.out.println("busca terjeta");
            if (tarjeta != null){

                //System.out.println("Encuentra tarjeta");
                Acceso acceso = new Acceso();
                
                registroAcceso = new ListaAcceso();
                Date date = new Date();
                //Hora actual de la PC
                Locale local = new Locale("es","MX");
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+6:00"),local);
                //Llenamos y almacenamos en la BD

                acceso.setIdTarjeta(idTarjeta.trim());
                acceso.setTornilloEntrada(tornilloServicio.buscarPorId("101"));
                accesoServicio.insertar(acceso);
                
                //Llenamos y visualizamos en la BD
                registroAcceso.setFecha(cal.getTime());
                
                    
                if (tarjeta.getUsuario().trim().length() >= 13){
                    
                    personal = personalServicio.buscarPorId(tarjeta.getUsuario().trim());
                    registroAcceso.setNombre(personal.getApellidoPaterno() + " " + personal.getApellidoMaterno() + " " + personal.getNombreEmpleado());
                    registroAcceso.setTipo("Docente");
                }else{
                    //Estudiante estudiante;                    
                    System.out.println("Encuentra Estudiante ---" + tarjeta.getUsuario().trim() + "---");
                    estudiante = estudianteServicio.buscarPorID(tarjeta.getUsuario().trim());                    
                    registroAcceso.setNombre(estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno() + " " + estudiante.getNombreAlumno());                    
                    registroAcceso.setTipo("Estudiante");
                    fotoS = tarjeta.getUsuario();
                    usuarioS = registroAcceso.getNombre();
                }
                System.out.println(registroAcceso.getNombre() + "Ingresar " + registroAcceso);
                listaAcceso.add(0, registroAcceso);
                System.out.println("Agrega Registro ");
            }
        }        
    }

    public ListaAcceso getRegistroAcceso() {
        return registroAcceso;
    }

    public void setRegistroAcceso(ListaAcceso registroAcceso) {
        this.registroAcceso = registroAcceso;
    }

    public ArrayList<ListaAcceso> getListaAcceso() {
        return listaAcceso;
    }

    public void setListaAcceso(ArrayList<ListaAcceso> listaAcceso) {
        this.listaAcceso = listaAcceso;
    }

   
    public ArrayList<ListaAcceso> llenarLista(){
        ArrayList<ListaAcceso> listaUsuariosAcceso = new ArrayList();
        /*listaAcceso = accesoServicio.buscarTodos();
        ListaAcceso usuario;
        CiAsistencia usuarioCI;
        Estudiante estudiante;
        Personal personal;
        for (int i = 0; i < asistentesCI.size(); i++){
            usuario = new ListaUsuariosCI();
            usuarioCI = asistentesCI.get(i);
            usuario.setFecha(usuarioCI.getFecha());
            usuario.setHora(usuarioCI.getHora());
            usuario.setIdTarjeta(usuarioCI.getIdTarjeta().getIdTarjeta());
            if (usuarioCI.getIdTarjeta().getIdRol().getIdrol().equals("EST")){
               estudiante = estudianteFacade.find(usuarioCI.getIdTarjeta().getUsuario());
               usuario.setUsuario(estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno() + " " + estudiante.getNombreAlumno());
               usuario.setTipo("Estudiante");
               usuario.setCarrera(estudiante.getReticula().getNombreCarrera());
            }else if (usuarioCI.getIdTarjeta().getIdRol().getIdrol().equals("PRO")){
               personal = personalServicio.buscarPorID(usuarioCI.getIdTarjeta().getUsuario());
               usuario.setUsuario(personal.getApellidoPaterno() + " " + personal.getApellidoMaterno() + " " + personal.getNombreEmpleado());
               usuario.setTipo("Docente");
               usuario.setCarrera(personal.getClaveArea().getDescripcionArea());
            }
        }*/
        return listaUsuariosAcceso;
    }
}
