/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package vista;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import modelo.Aulas;
import modelo.Carrera;
import modelo.Grupos;
import modelo.HorarioCrear;
import modelo.Horarios;
import modelo.Materia;
import modelo.MateriasCarreras;
import modelo.Organigrama;
import modelo.PeriodoEscolar;
import modelo.Permisos;
import modelo.Personal;
import modelo.Reticula;
import modelo.Usuario;
import org.primefaces.PrimeFaces;
import servicio.AulasServicioLocal;
import servicio.CarreraServicioLocal;
import servicio.GruposServicioLocal;
import servicio.HorarioServicioLocal;
import servicio.MateriaServicioLocal;
import servicio.MateriasCarrerasServicioLocal;
import servicio.OrganigramaServicioLocal;
import servicio.PeriodoEscolarServicioLocal;
import servicio.PermisoServicioLocal;
import servicio.PersonalServicioLocal;

/**
 *
 * @author gacev
 */
@Named(value = "horarioCrearBean")
@SessionScoped
public class HorarioCrearBean implements Serializable {

    @EJB
    private MateriaServicioLocal materiaServicio;

    @EJB
    private PersonalServicioLocal personalServicio;
    @EJB
    private OrganigramaServicioLocal organigramaServicio;

    @EJB
    private AulasServicioLocal aulasServicio;

    @EJB
    private PermisoServicioLocal permisoServicio;

    @EJB
    private MateriasCarrerasServicioLocal materiasCarrerasServicio;

    @EJB
    private PeriodoEscolarServicioLocal periodoEscolarServicio;

    @EJB
    private CarreraServicioLocal carreraServicio;

    @EJB
    private HorarioServicioLocal horarioServicio;

    @EJB
    private GruposServicioLocal gruposServicio;

    private List<HorarioCrear> listaHorarioCrear;
    private List<HorarioCrear> listaHorarioBorrar;//Muestra los horarios que va a eliminar.

    private List<Carrera> listaCarrera;
    private List<Permisos> listaPermisos;
    private List<PeriodoEscolar> listaPeriodoEscolar;
    private List<MateriasCarreras> listaMateria;
    private ArrayList<String> listaSemestres;
    private List<Aulas> listaAulas;
    private List<Grupos> listagrupos;
    private List<Grupos> listagrupogenerado;
    private List<Personal> listapersonal;
    private List<Materia> listaMateriaI;
    private List<Horarios> listaHorarios; //Para guardar los horarios en la BD
    private List<Horarios> listaHorariosGenerados; //Para guardar los horarios en la BD
    private List<String> listacoordenadas;
    private List<Horarios> horariosAEliminar;
    private Optional<Horarios> horarioExacto;// Busco el horario el cual voy a actualizar. 

    private Usuario usuario;
    private Grupos grupo;
    private Horarios horario;
    private Carrera carreraI;
    private Materia materia;
    private MateriasCarreras materiasCarreras;
    private PeriodoEscolar periodo;
    private Aulas aula;
    private HorarioCrear horariocrear;
    private Boolean puedeguardar = false;
    private Boolean camposllenos = false;//Verifico que todos los campos tengan algo en la vista.
    private Organigrama organigrama;
    private Horarios materiaSeleccionada;
    private boolean modoIntercambio = false;//Voy a intercambiar a modo horarios
    private Boolean modoSeleccionMateria = false;//La uso para seleccionar o deseleccionar la materia de la tabla. 

    private String nombreMateriaSeleccionada;//Sirve para el modo eliminar y modificar materia obtiene nombre de la materiaSeleccionada
    private String aulaMateriaSeleccionada;//Sirve para el modo eliminar y modificar materia obtiene aula de la materiaselccionada
    private String nuevaAulaSeleccionada;//Es el aula que se ha escogido dentro de la ventana emergente de modificar materia. 
    private int filaMateriaSeleccionada;//Fila seleccionada para modificar horario
    private int columnaMateriaSeleccionada;  //Columna seleccionada para modificar horario
    private int filaSeleccionadaAnterior = -1;
    private int columnaSeleccionadaAnterior = -1;

    private int filaDestino;//Columnas donde sera pasado la materia.
    private int columnaDestino;//Columnas donde será pasado la materia. 

    private int creditos = 0;
    private String carreraS = "";//CarreraS de la lista de carreras 
    private String asignaturaS = "";//AsignaturaS de la lista asignaturas
    private String posicionesSeleccionadas = "";//Posicones que se han seleccionado en la tabla para guardar los horarios
    private String periodoS = "";//PeriodoS sirve para guardar el periodo 20252
    private String semestreS = "";//SemestreS sirve para guardar el numero del semestre el cual se ha seleccionado
    private String aulas = "";//Aulas sirve para guardar el valor del aula que se ha seleccionado 
    private String grupoS = "";//Grupos sirve para guardar el valor del grupo que se ha seleccionado. 
    private String personal = "";
    private int numestudiantes = 0;
    private String valorgrupo = "";
    private Boolean seleccionadocarreramateria2 = false;
    private boolean eliminando = false;
    private Boolean activarModificar = false;

    Date horainicioMateria;
    Date horainiciofinMateria;

    public List<HorarioCrear> getListaHorarioBorrar() {
        return listaHorarioBorrar;
    }

    public void setListaHorarioBorrar(List<HorarioCrear> listaHorarioBorrar) {
        this.listaHorarioBorrar = listaHorarioBorrar;
    }

    public List<Horarios> getHorariosAEliminar() {
        return horariosAEliminar;
    }

    public void setHorariosAEliminar(List<Horarios> horariosAEliminar) {
        this.horariosAEliminar = horariosAEliminar;
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    public int getColumnaDestino() {
        return columnaDestino;
    }

    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }

    public Optional<Horarios> getHorarioExacto() {
        return horarioExacto;
    }

    public void setHorarioExacto(Optional<Horarios> horarioExacto) {
        this.horarioExacto = horarioExacto;
    }

    public Boolean getModoSeleccionMateria() {
        return modoSeleccionMateria;
    }

    public void setModoSeleccionMateria(Boolean modoSeleccionMateria) {
        this.modoSeleccionMateria = modoSeleccionMateria;
    }

    public boolean isModoIntercambio() {
        return modoIntercambio;
    }

    public void setModoIntercambio(boolean modoIntercambio) {
        this.modoIntercambio = modoIntercambio;
    }

    public Boolean getActivarModificar() {
        return activarModificar;
    }

    public void setActivarModificar(Boolean activarModificar) {
        this.activarModificar = activarModificar;
    }

    public int getFilaMateriaSeleccionada() {
        return filaMateriaSeleccionada;
    }

    public void setFilaMateriaSeleccionada(int filaMateriaSeleccionada) {
        this.filaMateriaSeleccionada = filaMateriaSeleccionada;
    }

    public int getColumnaMateriaSeleccionada() {
        return columnaMateriaSeleccionada;
    }

    public void setColumnaMateriaSeleccionada(int columnaMateriaSeleccionada) {
        this.columnaMateriaSeleccionada = columnaMateriaSeleccionada;
    }

    public String getNuevaAulaSeleccionada() {
        return nuevaAulaSeleccionada;
    }

    public void setNuevaAulaSeleccionada(String nuevaAulaSeleccionada) {
        this.nuevaAulaSeleccionada = nuevaAulaSeleccionada;
    }

    public String getAulaMateriaSeleccionada() {
        System.out.println("GetAulaMateriaSeleccionada" + aulaMateriaSeleccionada);
        return aulaMateriaSeleccionada;
    }

    public void setAulaMateriaSeleccionada(String aulaMateriaSeleccionada) {
        this.aulaMateriaSeleccionada = aulaMateriaSeleccionada;
    }

    public String getNombreMateriaSeleccionada() {
        System.out.println("GetNombreMateriaSeleccionada" + nombreMateriaSeleccionada);
        return nombreMateriaSeleccionada;
    }

    public void setNombreMateriaSeleccionada(String nombreMateriaSeleccionada) {
        this.nombreMateriaSeleccionada = nombreMateriaSeleccionada;
    }

    public boolean isEliminando() {
        return eliminando;
    }

    public void setEliminando(boolean eliminando) {
        this.eliminando = eliminando;
    }

    public Horarios getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    public void setMateriaSeleccionada(Horarios materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    public Organigrama getOrganigrama() {
        return organigrama;
    }

    public void setOrganigrama(Organigrama organigrama) {
        this.organigrama = organigrama;
    }

    public Boolean getPuedeguardar() {
        return puedeguardar;
    }

    public void setPuedeguardar(Boolean puedeguardar) {
        this.puedeguardar = puedeguardar;
    }

    public Boolean getSeleccionadocarreramateria2() {
        return seleccionadocarreramateria2;
    }

    public void setSeleccionadocarreramateria2(Boolean seleccionadocarreramateria2) {
        this.seleccionadocarreramateria2 = seleccionadocarreramateria2;
    }

    private void addMessage(FacesMessage.Severity severity, String titulo, String detalle) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titulo, detalle));
    }

    public HorarioCrear getHorariocrear() {
        return horariocrear;
    }

    public void setHorariocrear(HorarioCrear horariocrear) {
        this.horariocrear = horariocrear;
    }

    public String getValorgrupo() {

        return valorgrupo;
    }

    public void setValorgrupo(String valorgrupo) {
        this.valorgrupo = valorgrupo;
    }

    public int getNumestudiantes() {
        return numestudiantes;
    }

    public void setNumestudiantes(int numestudiantes) {

        this.numestudiantes = numestudiantes;
    }

    public List<Grupos> getListagrupos() {
        return listagrupos;
    }

    public void setListagrupos(List<Grupos> listagrupos) {
        this.listagrupos = listagrupos;
    }

    public List<Personal> getListapersonal() {
        return listapersonal;
    }

    public void setListapersonal(List<Personal> listapersonal) {
        this.listapersonal = listapersonal;
    }

    public String getGrupoS() {
        return grupoS;
    }

    public void setGrupoS(String grupoS) {
        this.grupoS = grupoS;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public List<Aulas> getListaAulas() {
        return listaAulas;
    }

    public void setListaAulas(List<Aulas> listaAulas) {
        this.listaAulas = listaAulas;
    }

    public String getAulas() {
        return aulas;
    }

    public void setAulas(String aulas) {
        this.aulas = aulas;
    }

    /**
     * Creates a new instance of HorarioCrearBean
     */
    public HorarioCrearBean() {

    }

    public String getSemestreS() {
        return semestreS;
    }

    public void setSemestreS(String semestreS) {
        this.semestreS = semestreS;
    }

    public String getPeriodoS() {
        return periodoS;
    }

    public void setPeriodoS(String periodoS) {
        this.periodoS = periodoS;
    }

    public List<Permisos> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    public List<Carrera> getListaCarrera() {
        return listaCarrera;
    }

    public void setListaCarrera(List<Carrera> listaCarrera) {
        this.listaCarrera = listaCarrera;
    }

    public List<PeriodoEscolar> getListaPeriodoEscolar() {
        return listaPeriodoEscolar;
    }

    public void setListaPeriodoEscolar(List<PeriodoEscolar> listaPeriodoEscolar) {
        this.listaPeriodoEscolar = listaPeriodoEscolar;
    }

    public List<MateriasCarreras> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<MateriasCarreras> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public String getCarreraS() {
        return carreraS;
    }

    public void setCarreraS(String carreraS) {
        this.carreraS = carreraS;
    }

    public List<HorarioCrear> getListaHorarioCrear() {
        return listaHorarioCrear;
    }

    public void setListaHorarioCrear(List<HorarioCrear> listaHorarioCrear) {
        this.listaHorarioCrear = listaHorarioCrear;
    }

    public void onCellEdit(ActionEvent e) {
        //System.out.println(e.getComponent().getClientId());
    }

    public int getCreditos() {

        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getPosicionesSeleccionadas() {
        return posicionesSeleccionadas;
    }

    public void setPosicionesSeleccionadas(String posicionesSeleccionadas) {
        this.posicionesSeleccionadas = posicionesSeleccionadas;
    }

    public String getAsignaturaS() {
        return asignaturaS;
    }

    public void setAsignaturaS(String asignaturaS) {
        this.asignaturaS = asignaturaS;
    }

    public ArrayList<String> getListaSemestres() {
        return listaSemestres;
    }

    public void setListaSemestres(ArrayList<String> listaSemestres) {
        this.listaSemestres = listaSemestres;
    }

    public void valoresCelda() {//Mostrar mensajes de lo que se ha obtenido

        System.out.println("=== ENTRE A CONFIRMAR/INTERCAMBIAR===");
        System.out.println("Nombre: " + nombreMateriaSeleccionada);
        System.out.println("Aula actual: " + aulaMateriaSeleccionada);
        System.out.println("Fila: " + filaMateriaSeleccionada);
        System.out.println("Columna: " + columnaMateriaSeleccionada);
    }

    public void encontrarMateriaDeCelda() {//Encuentra la materia de la celda en la lista de horarios generados
        // Buscar el horario exacto
        horarioExacto = listaHorariosGenerados.stream()
                .filter(h -> h.getMateria().getNombreCompletoMateria().equalsIgnoreCase(nombreMateriaSeleccionada.trim())
                && h.getAula().getAula().equalsIgnoreCase(aulaMateriaSeleccionada.trim())
                && ConvertirDateAInt(h) == filaMateriaSeleccionada - 1
                && (h.getDiaSemana() - 1) == columnaMateriaSeleccionada)
                .findFirst();

    }

    public int ConvertirDateAInt(Horarios h) {//Convierto el tipo date a un entero mejor 

        Calendar cal = Calendar.getInstance();
        Date horainicial = new Date();
        int hora, fila;

        horainicial = h.getHoraInicial();
        cal.setTime(horainicial);
        hora = cal.get(Calendar.HOUR_OF_DAY); // obtiene la hora en formato 24h
        fila = obtenerFilaHorario(hora);
        return fila;

    }

    public int obtenerFilaHorario(int hora) {

        switch (hora) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            case 17:
                return 10;
            case 18:
                return 11;
            case 19:
                return 12;
            default:
                return -1; // hora fuera de rango
        }

    }

    public String ConvertirDateAHora(Horarios h) {//Convierto el tipo date a un 7:00-8:00;

        Calendar cal = Calendar.getInstance();
        Date horainicial = new Date();
        int hora;
        String horaMateria;

        horainicial = h.getHoraInicial();
        cal.setTime(horainicial);
        hora = cal.get(Calendar.HOUR_OF_DAY); // obtiene la hora en formato 24h
        horaMateria = obtenerStringHorario(hora);
        return horaMateria;

    }

    public String obtenerStringHorario(int hora) {

        switch (hora) {
            case 7:
                return "7:00 - 8:00";
            case 8:
                return "8:00 - 9:00";
            case 9:
                return "9:00 - 10:00";
            case 10:
                return "10:00 - 11:00";
            case 11:
                return "11:00 - 12:00";
            case 12:
                return "12:00 - 13:00";
            case 13:
                return "13:00 - 14:00";
            case 14:
                return "14:00 - 15:00";
            case 15:
                return "15:00 - 16:00";
            case 16:
                return "16:00 - 17:00";
            case 17:
                return "17:00 - 18:00";
            case 18:
                return "18:00 - 19:00";
            case 19:
                return "19:00 - 20:00";
            default:
                return "00:00 - 00:00"; // hora fuera de rango
        }

    }

    public void activarEliminar() {//Activo el color de fondo del modo eliminar
        eliminando = !eliminando;
        //Para evitar que se empalmen los horarios en colores.
        modoIntercambio = false;
        activarModificar = false;
        modoSeleccionMateria = false;
        if (eliminando) {
            cambiarModoColorTabla("F8D5D4");
        } else {
            actualizarTabla();
        }
    }

    // 🔹 BOTÓN MODIFICAR
    public void activarModoModificar() {//Para poner todo en naranja para modificar
        activarModificar = !activarModificar;
        //Para evitar que se empalmen los horarios en colores.
        modoIntercambio = false;
        eliminando = false;
        modoSeleccionMateria = false;
        if (activarModificar) {
            cambiarModoColorTabla("FEA785");
        } else {
            actualizarTabla();
        }

    }

    // 🔹 BOTÓN INTERCAMBIO
    public void activarModoIntercambio() {
        modoIntercambio = !modoIntercambio; // si ya estaba, lo desactiva
        //Para evitar que se empalmen los horarios en colores.
        activarModificar = false;
        eliminando = false;
        modoSeleccionMateria = false;
        if (modoIntercambio) {
            System.out.println("VariableModoIntercambio" + modoIntercambio);
            cambiarModoColorTabla("A6E8CC");
        } else {
            actualizarTabla();
        }

    }

    public void cambiarModoColorTabla(String x) {//Cambia todo la tabla por un solo color pero primero tengo que darle j  color yo.
        System.out.println("listaHorariosGenerados.size" + listaHorariosGenerados.size());
        if (listaHorariosGenerados.size() != 0) {
            Calendar cal = Calendar.getInstance();
            Date horainicial = new Date();
            int hora, fila, columna;

            for (int i = 0; i < listaHorariosGenerados.size(); i++) {
                horario = listaHorariosGenerados.get(i);

                horainicial = horario.getHoraInicial();
                cal.setTime(horainicial);
                hora = cal.get(Calendar.HOUR_OF_DAY); // obtiene la hora en formato 24h
                fila = obtenerFilaHorario(hora);
                columna = horario.getDiaSemana() - 1;
                for (int j = 0; j < listaHorarioCrear.size(); j++) {//Recorrer la tabla primero por las filas
                    horariocrear = listaHorarioCrear.get(j);
                    if (j == fila) {
                        //  horariocrear.setColor("#3B0000");//Poner el color que le corresponde a las materias. 
                        asignarDatoSemana(horariocrear, columna, horario, "#" + x, "#3B0000");
                        break;
                    }

                }
            }

        }
    }

    /*  public void asignarMateriaSeleccionadaI() {//Sacar todas las variables de la materia que voy a modificar. 
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        nombreMateriaSeleccionada = params.get("nombre");
        aulaMateriaSeleccionada = params.get("aula");
        filaMateriaSeleccionada = Integer.parseInt(params.get("fila"));
        columnaMateriaSeleccionada = Integer.parseInt(params.get("columna"));

        System.out.println("IMateria seleccionada: " + nombreMateriaSeleccionada);
        System.out.println("IAula: " + aulaMateriaSeleccionada);
        System.out.println("IFila: " + filaMateriaSeleccionada);
        System.out.println("IColumna: " + columnaMateriaSeleccionada);

    }*/
    public void asignarMateriaSeleccionadaRC() {//Sacar todas las variables de la materia que voy a eliminar y mostrarlas en el cuadro de dialogo emergente. 
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        nombreMateriaSeleccionada = params.get("nombre");
        aulaMateriaSeleccionada = params.get("aula");
        System.out.println("Materia seleccionada: " + nombreMateriaSeleccionada);
        System.out.println("Aula: " + aulaMateriaSeleccionada);
        addMessage(FacesMessage.SEVERITY_INFO, "MATERIA", nombreMateriaSeleccionada + " AULA:" + aulaMateriaSeleccionada);
        
        modoEliminarSeleccionado();//Pinta de color rojo mas oscuro con letra blanca cuales he seleccionado

        obtenerHorasDeMateriaEiliminar();  //Obtiene de la lista Horarios Generados es decir lo que se obtuvo de la base los Horarios que corresponde

        HorarioCrear h = new HorarioCrear();//Solo le voy a dar un solo objeto a ListaHorarioBorrar 

        int[] conteoDias = new int[6];//Si vuelve a repetirse el dia en el cual va ser puesto la materia, es decir si una materia se toma mas de 1 hora al dia. 
        listaHorarioBorrar = new ArrayList<>();
        h.setHora(nombreMateriaSeleccionada);//Poner en la primera columna la materia que he seleccionado
        // Eliminar de la base de datos
        for (int i = 0; i < horariosAEliminar.size(); i++) {
            Horarios y = horariosAEliminar.get(i);
            //P1: ObjetoHorarioCrear para la TablaBorrarMensajeEmergente. P2. Dia de la semana de un horarioEliminar (1). P3: Hora devuelta: 7:00-8:00
            insertarValoresListaHorariosBorrarColumna(h, (int) (y.getDiaSemana()-1), ConvertirDateAHora(y), conteoDias);

            //Le doy solo un objeto HorarioCrear y le agrego 
        }

        listaHorarioBorrar.add(h); // agrega el único elemento

    }

    public void insertarValoresListaHorariosBorrarColumna(HorarioCrear h, int diaSemana, String horaString, int[] conteoDias) {
        String guardarValorAnterior;
        switch (diaSemana) {
            case 1: // Lunes
                if (conteoDias[0] == 0) {
                    h.setLunes(horaString);
                } else {
                    guardarValorAnterior = h.getLunes();
                    h.setLunes(guardarValorAnterior + "  " + horaString);
                }
                conteoDias[0]++;
                break;
            case 2: // Martes
                if (conteoDias[1] == 0) {
                    h.setMartes(horaString);
                } else {
                    guardarValorAnterior = h.getMartes();
                    h.setMartes(guardarValorAnterior + "  " + horaString);
                }
                conteoDias[1]++;
                break;
            case 3: // Miércoles
                if (conteoDias[2] == 0) {
                    h.setMiercoles(horaString);
                } else {
                    guardarValorAnterior = h.getMiercoles();
                    h.setMiercoles(guardarValorAnterior + "  " + horaString);
                }
                conteoDias[2]++;
                break;
            case 4: // Jueves
                if (conteoDias[3] == 0) {
                    h.setJueves(horaString);
                } else {
                    guardarValorAnterior = h.getJueves();
                    h.setJueves(guardarValorAnterior + "  " + horaString);
                }
                conteoDias[3]++;
                break;
            case 5: // Viernes
                if (conteoDias[4] == 0) {
                    h.setViernes(horaString);
                } else {
                    guardarValorAnterior = h.getViernes();
                    h.setViernes(guardarValorAnterior + "  " + horaString);
                }
                conteoDias[4]++;
                break;
            case 6: // Sábado
                if (conteoDias[5] == 0) {
                    h.setSabado(horaString);
                } else {
                    guardarValorAnterior = h.getSabado();
                    h.setSabado(guardarValorAnterior + "  " + horaString);
                }
                conteoDias[5]++;
                break;
            default:
                System.out.println("Día de la semana inválido");
                break; // hora fuera de rango
        }

    }

    public void asignarMateriaSeleccionadaM() {//Sacar todas las variables de la materia que voy a modificar para el cuadro de dialogo emergente de modificar
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        nombreMateriaSeleccionada = params.get("nombre");
        aulaMateriaSeleccionada = params.get("aula");
        filaMateriaSeleccionada = Integer.parseInt(params.get("fila"));
        columnaMateriaSeleccionada = Integer.parseInt(params.get("columna"));

        System.out.println("MMateria seleccionada: " + nombreMateriaSeleccionada);
        System.out.println("MAula: " + aulaMateriaSeleccionada);
        System.out.println("MFila: " + filaMateriaSeleccionada);
        System.out.println("MColumna: " + columnaMateriaSeleccionada);

        addMessage(FacesMessage.SEVERITY_INFO, "MATERIA SELECCIONADA", nombreMateriaSeleccionada + "  " + aulaMateriaSeleccionada);
    }

    public void confirmarModificarMateria() {//Se actualiza el aula que he escogido en la ventana emergente de modificar dentro de la BD y del bean y la vista 
        valoresCelda();
        encontrarMateriaDeCelda();
        // Usar el resultado
        if (horarioExacto.isPresent()) {
            Horarios horario = horarioExacto.get();
            System.out.println("NuevaAulasSeleccionada" + nuevaAulaSeleccionada);
            // Buscar la nueva aula seleccionada en el combobox
            Aulas nuevaAula = aulasServicio.buscarPorId(nuevaAulaSeleccionada);
            // (usa el ID real que el usuario seleccionó del combobox)

            if (nuevaAula == null) {

                addMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El aula seleccionada no existe.");
                return;
            }

            // Actualizamos el aula
            horario.setAula(nuevaAula);
            horarioServicio.actualizar(horario);

            // Refrescar la lista local (opcional, si quieres ver reflejado el cambio en la vista)
            Carrera carrera = carreraServicio.buscarPorId(Integer.parseInt(carreraS));
            this.listaHorariosGenerados = horarioServicio.buscarHorariosPorGrupos(carrera, Integer.parseInt(semestreS), periodoEscolarServicio.buscarPorId(periodoS), valorgrupo);
            //actualizarTabla()

            addMessage(FacesMessage.SEVERITY_INFO, "ÉXITO", "El aula se modificó correctamente.");
            activarModoModificar();
            // Actualizar la tabla visualmente
            PrimeFaces.current().ajax().update("horarioG:grupo");
        } else {
            System.out.println("No se encontró el horario exacto.");
        }

    }

    public void cambiarMateriaSeleccionadaX() {//Metodo por si quiero cambiar el color pero por el Bean
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();

        int fila = Integer.parseInt(params.get("fila"));
        int columna = Integer.parseInt(params.get("columna"));
        String nombre = params.get("nombre");
        String aula = params.get("aula");

        System.out.println("Materia seleccionada: " + nombre + " | Aula: " + aula);

        addMessage(FacesMessage.SEVERITY_INFO, "MATERIA SELECCIONADA", "MATERIA: " + nombre + " AULA: " + aula);
        // Si es la misma materia que ya estaba seleccionada → deselecciona

        // Nueva selección
        filaMateriaSeleccionada = fila;
        columnaMateriaSeleccionada = columna;
        nombreMateriaSeleccionada = nombre;
        aulaMateriaSeleccionada = aula;

        // Cambia color de la nueva seleccionada
        modificarSeleccion();

    }

    private void deseleccionarAnterior() {
        if (filaSeleccionadaAnterior == -1 || columnaSeleccionadaAnterior == -1) {
            return;
        }
        HorarioCrear hc = listaHorarioCrear.get(filaSeleccionadaAnterior - 1);
        modificarColor(hc, columnaSeleccionadaAnterior, "#A6E8CC", "#3B0000");
    }

    public void modificarSeleccion() {

        for (int i = 0; i < listaHorarioCrear.size(); i++) {//Recorro la tabla ListaHorariosGenerar
            if (i == (filaMateriaSeleccionada - 1)) {//Si encuentro la fila a la cual corresponde.
                HorarioCrear hc = listaHorarioCrear.get(i);//Tomo la fila
                if (!modoSeleccionMateria) {//Verifica que 
                    modificarColor(hc, columnaMateriaSeleccionada, "#04BC86", "#FFFFFF");
                    //hc.setColor("#FFFFFF");
                    modoSeleccionMateria = true;
                    //System.out.println("ENTRO->*" + i);

                    addMessage(FacesMessage.SEVERITY_INFO, "INFORMACION", "SE HA SELECCIONADO MATERIA");
                    System.out.println("SE HA SELECCIONADO MATERIA");
                    return;
                }

            }
        }
    }

    public void modificarColor(HorarioCrear x, int y, String colorFondo, String colorLetra) {//Le agrego el color de fondo y color de letra a mi dia de la semana.
        String materiayaula;

        switch (y) {
            case 1:
                materiayaula = getSepararAtributos(x.getLunes(), 0);
                x.setLunes(materiayaula + "  " + colorFondo + "  " + colorLetra);
                //System.out.println("ValorMetodoModificarColor" + x.getLunes());
                break;
            case 2:
                materiayaula = getSepararAtributos(x.getMartes(), 0);
                x.setMartes(materiayaula + "  " + colorFondo + "  " + colorLetra);
                //System.out.println("ValorMetodoModificarColor" + x.getMartes() + "  " + colorLetra);
                break;
            case 3:
                materiayaula = getSepararAtributos(x.getMiercoles(), 0);
                x.setMiercoles(materiayaula + "  " + colorFondo + "  " + colorLetra);
                //System.out.println("ValorMetodoModificarColor" + x.getMiercoles() + "  " + colorLetra);
                break;
            case 4:
                materiayaula = getSepararAtributos(x.getJueves(), 0);
                x.setJueves(materiayaula + "  " + colorFondo + "  " + colorLetra);
                // System.out.println("ValorMetodoModificarColor" + x.getJueves() + "  " + colorLetra);
                break;
            case 5:
                materiayaula = getSepararAtributos(x.getViernes(), 0);
                x.setViernes(materiayaula + "  " + colorFondo + "  " + colorLetra);
                // System.out.println("ValorMetodoModificarColor" + x.getViernes() + "  " + colorLetra);
                break;
            case 6:
                materiayaula = getSepararAtributos(x.getSabado(), 0);
                x.setSabado(materiayaula + "  " + colorFondo + "  " + colorLetra);
                // System.out.println("ValorMetodoModificarColor" + x.getSabado() + "  " + colorLetra);
                break;
            default:
                break;
        }
    }

    public void moverMateriaSeleccionada() {//Cuando se intercambie la materia dentro de la tabla. 

        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        filaDestino = Integer.parseInt(params.get("filaDestino"));
        columnaDestino = Integer.parseInt(params.get("columnaDestino"));

        System.out.println("MovMateria seleccionada: " + nombreMateriaSeleccionada);
        System.out.println("MovAula: " + aulaMateriaSeleccionada);
        System.out.println("MovFila: " + filaMateriaSeleccionada);
        System.out.println("MovColumna: " + columnaMateriaSeleccionada);
        System.out.println("MovMover a fila " + filaDestino + ", columna " + columnaDestino);

        encontrarMateriaDeCelda();

        if (horarioExacto.isPresent()) {
            Horarios horario = horarioExacto.get();
            horario.setDiaSemana((short) (columnaDestino + 1));//Guarda el dia de la semana con numero. 
            asignarHoras(filaDestino);//Elige primero el rango que va a convertir, por ejemplo "7:00-8:00" los transforma a date 7 y 8. 
            horario.setHoraInicial(horainicioMateria);
            horario.setHoraFinal(horainiciofinMateria);
            horarioServicio.actualizar(horario);

            // Refrescar la lista local (opcional, si quieres ver reflejado el cambio en la vista)
            //Carrera carrera = carreraServicio.buscarPorId(Integer.parseInt(carreraS));
            //this.listaHorariosGenerados = horarioServicio.buscarHorariosPorGrupos(carrera, Integer.parseInt(semestreS), periodoEscolarServicio.buscarPorId(periodoS), valorgrupo);
            actualizarTabla();
            cambiarModoColorTabla("A6E8CC");
            modoSeleccionMateria = false;
            filaSeleccionadaAnterior = -1;
            columnaSeleccionadaAnterior = -1;
            //activarModoIntercambio();
            //activarModificar();
            System.out.println("Se ha actualizado intercambio de materia");
            addMessage(FacesMessage.SEVERITY_INFO, "INFO", "SE HA ACTUALIZADO INTERCAMBIO DE MATERIA");

        } else {
            System.out.println("No se encontró el horario exacto.");
            addMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "NO SE ENCONTRÓ EL HORARIOE EXACTO");
        }

        // Aquí puedes hacer la lógica de intercambio real:
        // 1. Verificar que el destino está vacío.
        // 2. Modificar los valores en listaHorariosGenerados.
        // 3. Actualizar la tabla si es necesario.
    }

    public void limpiarVariablesDeEstadoEliminar() {

        // Limpiar variables y estado
        nombreMateriaSeleccionada = null;
        aulaMateriaSeleccionada = null;
        eliminando = false;
        modoSeleccionMateria = false;

        actualizarTabla();
        cambiarModoColorTabla("F8D5D4");
        System.out.println("Limpiando cancelar....");
        addMessage(FacesMessage.SEVERITY_WARN, "CANCELAR", "LIMPIANDO CANCELAR.");
    }

    public void confirmarEliminarMateria() {

        System.out.println("Ejecutar Nombre materia seleccionada:" + nombreMateriaSeleccionada);
        System.out.println("Ejecutar Aula materia seleccionada:" + aulaMateriaSeleccionada);

        if (nombreMateriaSeleccionada == null || aulaMateriaSeleccionada == null) {
            System.out.println("⚠ No hay materia o aula seleccionada.");
            return;
        }

        obtenerHorasDeMateriaEiliminar();// Filtrar todos los horarios que coincidan con materia

        // Eliminar de la base de datos
        for (Horarios h : horariosAEliminar) {//Cuando acabe de eliminar en la BD 
            horarioServicio.eliminar(h);
        }

        for (Horarios h : horariosAEliminar) {
            gruposServicio.eliminar(h.getIdGrupo());
        }

        // Eliminar de la lista en memoria
        listaHorariosGenerados.removeAll(horariosAEliminar);

        limpiarVariablesDeEstadoEliminar();
        actualizarTabla();
        addMessage(FacesMessage.SEVERITY_WARN, "MATERIA ELIMINADA", "Se eliminaron " + horariosAEliminar.size() + " coincidencias de la materia seleccionada.");
        // Actualiza la tabla en pantalla (si tienes método para ello)

    }

    public void obtenerHorasDeMateriaEiliminar() {
        // Filtrar todos los horarios que coincidan con materia
        horariosAEliminar = listaHorariosGenerados.stream()
                .filter(h -> h.getMateria().getNombreCompletoMateria().equalsIgnoreCase(nombreMateriaSeleccionada.trim())
                )
                .collect(Collectors.toList());

        if (horariosAEliminar.isEmpty()) {

            addMessage(FacesMessage.SEVERITY_WARN, "SIN COINCIDENCIAS", "No se encontraron horarios con esa materia y aula.");
            return;
        }

    }

    public void modoEliminarSeleccionado() {//Aplicarle color rojo pastel cuando seleccione una materia.

        columnaMateriaSeleccionada = 0;

        for (int i = 0; i < listaHorarioCrear.size(); i++) {//Recorro la tabla ListaHorariosGenerar para encontrar coincidencias
            //Es decir encuentro CALCULO DIFERENCIAL compara en todo los horarios 
            HorarioCrear hc = listaHorarioCrear.get(i);//Tomo la fila
            if (!modoSeleccionMateria) {//Verifica que 
                String[] dias = {hc.getLunes(), hc.getMartes(), hc.getMiercoles(), hc.getJueves(), hc.getViernes(), hc.getSabado()};
                for (int j = 0; j < dias.length; j++) {
                    String dia = dias[j];
                    if (dia != null && !dia.isEmpty()) {
                        String valor = getSepararAtributos(dia, 3);
                        if (valor.equals(nombreMateriaSeleccionada)) {
                            columnaMateriaSeleccionada = j + 1; // j=0 → lunes = 1
                            modificarColor(hc, columnaMateriaSeleccionada, "#AD1C09", "#FFFFFF");

                            System.out.println("Posicion i:->" + i + "Posicion j:->" + j);
                        }
                    }
                }
                columnaMateriaSeleccionada = 0;

            }

        }
        modoSeleccionMateria = true;
        //Agregar una de modoSeleccionMateria;
        //Comparar con el tamaño encontrado 
        addMessage(FacesMessage.SEVERITY_INFO, "MATERIA", nombreMateriaSeleccionada);
        System.out.println("SE HA SELECCIONADO MATERIA");
    }

    public void mostrarNotificacionCeldaMateria() {
        addMessage(FacesMessage.SEVERITY_WARN, "EMPALME MATERIA", "NO PUEDES PONER LA MATERIA EN UN HORARIO OCUPADO");
        actualizarTabla();
        cambiarModoColorTabla("A6E8CC");
        modoSeleccionMateria = false;
        filaSeleccionadaAnterior = -1;
        columnaSeleccionadaAnterior = -1;
    }

    public void actualizarTabla() {
        System.out.println("ENTREEEEEEEEEEE");
        verificacionDeCamposActualizado();//Verifica que los campos esten llenos antes de actualizar la tabla por los datos actuales
        inicializarHorario();//Asi evitamos que se sobreescriba la informacion que se actualiza en la tabla.

        if (!"".equals(carreraS)
                && !"".equals(semestreS)
                && !"".equals(periodoS)
                && !"".equals(valorgrupo)) {

            Carrera carrera = carreraServicio.buscarPorId(Integer.parseInt(carreraS));
            listaHorariosGenerados = horarioServicio.buscarHorariosPorGrupos(carrera, Integer.parseInt(semestreS), periodoEscolarServicio.buscarPorId(periodoS), valorgrupo);
            System.out.println("Se encontro horarios:->" + listaHorariosGenerados.size());

            if (listaHorariosGenerados.size() != 0) {
                Calendar cal = Calendar.getInstance();
                Date horainicial = new Date();
                int hora, fila, columna;
                for (int i = 0; i < listaHorariosGenerados.size(); i++) {
                    horario = listaHorariosGenerados.get(i);
                    materiasCarreras = materiasCarrerasServicio.buscarPorId(horario.getIdGrupo().getIdMateriaCarrera().getIdMateriaCarrera());
                    organigrama = organigramaServicio.buscarPorId(materiasCarreras.getMateria().getClaveArea().getClaveArea());
                    horainicial = horario.getHoraInicial();
                    cal.setTime(horainicial);
                    hora = cal.get(Calendar.HOUR_OF_DAY); // obtiene la hora en formato 24h
                    fila = obtenerFilaHorario(hora);
                    columna = horario.getDiaSemana() - 1;
                    for (int j = 0; j < listaHorarioCrear.size(); j++) {//Recorrer la tabla primero por las filas
                        horariocrear = listaHorarioCrear.get(j);
                        if (j == fila) {
                            //horariocrear.setColor("#3B0000");//Poner el color que le corresponde a las materias. 
                            asignarDatoSemana(horariocrear, columna, horario, "#" + organigrama.getColor(), "#3B0000");
                            break;
                        }

                    }
                }
            }
        }
    }

    public Boolean verificarMateriaInsertada() {
        String materia = materiasCarreras.getMateria().getNombreCompletoMateria();
        for (HorarioCrear horariocrear : listaHorarioCrear) {
            String[] dias = {
                horariocrear.getLunes(),
                horariocrear.getMartes(),
                horariocrear.getMiercoles(),
                horariocrear.getJueves(),
                horariocrear.getViernes(),
                horariocrear.getSabado()
            };

            for (String dia : dias) {
                if (materia.equals(dia)) { // usar equals, no ==
                    addMessage(FacesMessage.SEVERITY_FATAL, "INFO", "MATERIA ENCONTRADA");
                    return true; // si solo quieres un mensaje por fila
                }
            }
        }
        return false;
    }

    // ********************** Metodos 
    public void nuevoHorario() {
        inicializarHorario();//Inicializamos horario

        // 4. Obtiene el contexto actual de JSF (para trabajar con sesión, request, etc.)
        FacesContext contexto = FacesContext.getCurrentInstance();
        // 5. Recupera el objeto "usuario" guardado en la sesión
        usuario = (Usuario) contexto.getExternalContext().getSessionMap().get("usuario");
        // 6. Usa el servicio permisoServicio para buscar carreras relacionadas al usuario
        listaPermisos = permisoServicio.buscarCarreras(usuario.getUsuario());
        listaPeriodoEscolar = periodoEscolarServicio.periodosEscolaresActivos();
        listaAulas = aulasServicio.aulasActivos();
        listagrupos = gruposServicio.gruposActivos();
        listapersonal = personalServicio.personalActivos();
        listaMateria = null;

    }

    public void inicializarHorario() {
        listaHorarioCrear = new ArrayList();
        // 1. Inicializa la lista de semestres (vacía)
        listaSemestres = new ArrayList();
        // 2. Agrega del 1 al 9 como Strings ("1", "2", ..., "9")
        for (int i = 1; i <= 9; i++) {
            listaSemestres.add(String.valueOf(i).trim());
        }// 3. Genera horas de 7 a 19 y las guarda en objetos HorarioCrear
        for (int i = 7; i <= 19; i++) {
            horariocrear = new HorarioCrear();
            horariocrear.setHora(i + ":00-" + (i + 1) + ":00");// ejemplo: "7:8", "8:9", ...
            listaHorarioCrear.add(horariocrear);
        }
    }

    public void guardarHorario() {
        System.out.println("Celdas seleccionadas: " + posicionesSeleccionadas);

        // Aquí puedes convertirlo en una lista si lo deseas
        if (!posicionesSeleccionadas.equals("")) {
            String[] pares = posicionesSeleccionadas.split(";");
            for (String par : pares) {
                String[] indices = par.split(",");
                int fila = Integer.parseInt(indices[0]);
                int columna = Integer.parseInt(indices[1]);
                // Guardar en BD, usar lógica de negocio, etc.
                System.out.println("Fila " + fila + " columna " + columna);
            }
        }
    }

    public void transformarCoordenadas() {
        System.out.println("Celdas seleccionadas: " + posicionesSeleccionadas);

        // Crear ArrayList para guardar las coordenadas
        listacoordenadas = new ArrayList<>();

        if (posicionesSeleccionadas != null && !posicionesSeleccionadas.isEmpty()) {
            String[] pares = posicionesSeleccionadas.split(";");
            for (String par : pares) {
                listacoordenadas.add(par);
                System.out.println(par);
            }
        }

        // Mostrar el ArrayList
        System.out.println("Coordenadas guardadas en ArrayList: " + listacoordenadas);
    }

    public void generarGrupo() throws ParseException {
        grupo = new Grupos();
        Carrera carrera = carreraServicio.buscarPorId(Integer.parseInt(carreraS));
        materiasCarreras = materiasCarrerasServicio.buscarPorId(Integer.parseInt(asignaturaS));
        periodo = periodoEscolarServicio.buscarPorId(periodoS);

        listagrupogenerado = gruposServicio.buscarGrupoSii(//Busca el grupo en la base de datos
                materiasCarreras.getReticula().getReticula(),
                materiasCarreras.getIdMateriaCarrera(),
                periodoS,
                valorgrupo);
        System.out.println("listagrupogenerado" + listagrupogenerado);
        if (listagrupogenerado != null && !listagrupogenerado.isEmpty()) {//Verificamos antes si la misma materia no ha sido insertada antes. 
            grupo = listagrupogenerado.get(0);
            System.out.println("entre porque este esta vacio" + listagrupogenerado);
            addMessage(FacesMessage.SEVERITY_INFO, "INFO", "GRUPO ENCONTRADO");
        } else {
            grupo.setEstatusGrupo('A');
            grupo.setCapacidadGrupo(numestudiantes);
            grupo.setAlumnosInscritos(0);
            grupo.setCarrera(convertirsiglasCarrerra(carrera.getNombreCarrera()));
            System.out.println("CARRERA ELEGIDA:" + carreraS);
            grupo.setTipoPersonal('D');

            grupo.setReticula(materiasCarreras.getReticula());

            grupo.setIdMateriaCarrera(materiasCarreras);

            grupo.setPeriodo(periodo);

            grupo.setMateria(materiasCarreras.getMateria().getMateria());

            grupo.setGrupo(valorgrupo);

            gruposServicio.insertarNuevoGrupo(grupo);
            addMessage(FacesMessage.SEVERITY_INFO, "LISTO", "SE HA COMPLETADO  DE INSERTAR GRUPO");

        }

    }

    public String getSepararAtributos(String valor, int x) {//Sirve para separar MATEMATICAS DISCRETAS A1 #FAS31A
        if (valor == null || valor.trim().isEmpty()) {
            return null;
        }

        String[] partes = valor.split("  "); // o split("\\s+") si quieres separar por cualquier espacio
        if (partes.length > 0 && x == 0) {
            return partes[0] + "  " + partes[1];
        } else if (x == 1) {
            return partes[2];
        } else if (x == 2) {
            return partes[3];
        } else if (x == 3) {
            return partes[0];
        } else {
            return null;

        }
    }

    public void actualizarCreditos() {

        materiasCarreras = materiasCarrerasServicio.buscarPorId(Integer.parseInt(asignaturaS));
        if (materiasCarreras != null) {
            creditos = materiasCarreras.getHorasPracticas() + materiasCarreras.getHorasTeoricas();
            // Enviar el valor actualizado al cliente ANTES del update
            PrimeFaces.current().ajax().addCallbackParam("creditos", this.creditos);
        }
    }

    public void generarHorario() throws ParseException {
        materiasCarreras = materiasCarrerasServicio.buscarPorId(Integer.parseInt(asignaturaS));
        verificacionDeCampos();//VERIFICA QUE LOS CAMPOS TENGAN ALGO
        modoSeleccionMateria = false;//¨Por si paso de modo eliminar a modo Insertar Materia.

        if (listaHorariosGenerados != null) {//Verifico que no ya este la materia que voy a insertar en la base de datos. 
            for (Horarios h : listaHorariosGenerados) {
                if (materiasCarreras.getMateria().getNombreCompletoMateria().equals(h.getMateria().getNombreCompletoMateria())) {
                    addMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "MATERIA YA INSERTADA");
                    return;
                }
            }

        }

        if (camposllenos) {//COMPRUEBA QUE TODOS LOS CAMPOS TENGAN ALGO Y QUE HAYAN SIDO SELECCIOANDAS AL MENOS UNA CELDA
            generarGrupo();

            transformarCoordenadas();// pasa de esto 1,1;1,2;1,3;1,4;1,5 a ["1,1"]["1,2"]["1,3"]["1,4"]["1,5"]

            organigrama = organigramaServicio.buscarPorId(materiasCarreras.getMateria().getClaveArea().getClaveArea());

            if (listaHorarios == null) {//VERIFICA TODOS LOS HORARIOS QUE SE HAN LLENADO
                listaHorarios = new ArrayList<>();//Vamos a guardar todos los horarios que se van a guardar en la base de datos

                System.out.println("AQUIs" + posicionesSeleccionadas);//Imprime esto 1,1;1,2;1,3;1,4;1,5 
                System.out.println(" Periodo " + periodo + "Cadena " + periodoS);
                aula = aulasServicio.buscarPorId(aulas);

                for (int i = 0; i < listacoordenadas.size(); i++) {
                    horario = new Horarios();
                    String celda = listacoordenadas.get(i);//Voy a recorrer todos estos ["1,1"]["1,2"]["1,3"]["1,4"]["1,5"]
                    horario.setPeriodo(periodo);//Insertar periodo
                    horario.setTipoHorario('V');//Preguntar al maestro

                    String[] indices = celda.split(",");//tienen el formato ["1,1"] entonces los separa respectivamente fila: 1 y columna: 1
                    int fila = Integer.parseInt(indices[0]);
                    int columna = Integer.parseInt(indices[1]);

                    horario.setDiaSemana((short) (columna + 1));//Guarda el dia de la semana con numero. 
                    asignarHoras(fila + 1);//Elige primero el rango que va a convertir, por ejemplo "7:00-8:00" los transforma a date 7 y 8. 
                    horario.setHoraInicial(horainicioMateria);
                    horario.setHoraFinal(horainiciofinMateria);
                    horario.setMateria(materiasCarreras.getMateria());
                    horario.setGrupo(valorgrupo);
                    horario.setAula(aula);
                    horario.setTipoPersonal('D');
                    horario.setIdGrupo(grupo);
                    listaHorarios.add(horario);
                    horarioServicio.insertarHorario(horario);
                }
                addMessage(FacesMessage.SEVERITY_INFO, "ÉXITO", "SE HAN AGREGADO TODAS LOS HORARIOS A LA BD");
                //ACOMODAR EN LA TABLA LA INFORMACION 
                for (int i = 0; i < listaHorarios.size(); i++) {//Obtener el objeto donde tengo la informacion de las materias.
                    horario = listaHorarios.get(i);
                    String celda = listacoordenadas.get(i);//Voy a recorrer todos estos ["1,1"]["1,2"]["1,3"]["1,4"]["1,5"]
                    String[] indices = celda.split(",");//tienen el formato ["1,1"] entonces los separa respectivamente fila: 1 y columna: 1
                    int fila = Integer.parseInt(indices[0]);
                    int columna = Integer.parseInt(indices[1]);

                    for (int j = 0; j < listaHorarioCrear.size(); j++) {//Recorrer la tabla primero por las filas
                        horariocrear = listaHorarioCrear.get(j);
                        if (j == fila) {
                            //horariocrear.setColor("#3B0000");//Poner el color que le corresponde a las materias. 
                            asignarDatoSemana(horariocrear, columna, horario, "#" + organigrama.getColor(), "#3B0000");
                            break;
                        }

                    }

                }
            } else if (materiasCarreras.getMateria().getNombreCompletoMateria() == listaHorarios.get(0).getMateria().getNombreCompletoMateria()) {
                addMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "MATERIA YA INSERTADA");
            } else {
                addMessage(FacesMessage.SEVERITY_INFO, "INFO", "LIMPIANDO LISTA");
                listaHorarios = null;
                generarHorario();
            }

        }

    }

    public void redirectToPage() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("divisionEP/gruposNE.xhtml");
    }

    public void verificacionDeCampos() {//Verifica que los campos todos tengan algo
        System.out.println("CarreraS: " + carreraS + " PeriodosS: " + periodoS + " SemestreS: " + semestreS + " AsignaturaS: " + asignaturaS
                + " Aulas: " + aulas + " Valorgrupo: " + valorgrupo + " Numestudiantes " + numestudiantes);
        System.out.println("Celdas seleccionadas: " + posicionesSeleccionadas);

        String[] pares = null;
        camposllenos = false;
        // Aquí puedes convertirlo en una lista si lo deseas
        if (!posicionesSeleccionadas.equals("")) {
            pares = posicionesSeleccionadas.split(";");
        }

        if (carreraS == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO CARRERA VACIO");
        } else if ("0".equals(semestreS)) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO SEMESTRE VACIO");
        } else if (aulas == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO AULA VACIO");
        } else if (numestudiantes == 0) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO ESTUDIANTES EN 0");
        } else if (periodoS == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO PERIODO VACIO");
        } else if (asignaturaS == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO ASIGNATURA VACIO");
        } else if (valorgrupo == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO NOMBRE GRUPO VACIO");
        } else if (pares == null) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "NO TIENES NINGUNA SELECCIONADA");
        } else if (pares.length == 0) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "SELECCIONA TODAS LAS HORAS TOTAL: " + creditos);
        } else if (pares.length != creditos) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "TE FALTAN: " + (creditos - pares.length) + " HORAS");
        } else {
            camposllenos = true;
            addMessage(FacesMessage.SEVERITY_INFO, "INFO", "CAMPOS COMPLETOS");
        }
    }

    public void verificacionDeCamposActualizado() {//Verifica que los campos todos tengan algo
        System.out.println("CarreraS: " + carreraS + " PeriodosS: " + periodoS + " SemestreS: " + semestreS + " AsignaturaS: " + asignaturaS
                + " Aulas: " + aulas + " Valorgrupo: " + valorgrupo + " Numestudiantes " + numestudiantes);
        System.out.println("Celdas seleccionadas: " + posicionesSeleccionadas);

        if (carreraS == null || "".equals(carreraS)) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO CARRERAs VACIO");
        } else if ("0".equals(semestreS)) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO SEMESTRE VACIO");
        } else if (periodoS == null || "".equals(periodoS)) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO PERIODO VACIO");
        } else if (valorgrupo == null || "".equals(valorgrupo)) {
            addMessage(FacesMessage.SEVERITY_WARN, "INFO", "CAMPO NOMBRE GRUPO VACIO");
        } else {
            addMessage(FacesMessage.SEVERITY_INFO, "INFO", "CAMPOS COMPLETOS");
        }
    }

    public void transformarHorasDate(int x, int y) {
        Calendar calInicio = Calendar.getInstance();
        calInicio.set(Calendar.HOUR_OF_DAY, x); // 7 AM
        calInicio.set(Calendar.MINUTE, 0);
        calInicio.set(Calendar.SECOND, 0);
        calInicio.set(Calendar.MILLISECOND, 0);

        horainicioMateria = calInicio.getTime();
        System.out.println("horainicioMateria " + horainicioMateria);

        Calendar calFin = Calendar.getInstance();
        calFin.set(Calendar.HOUR_OF_DAY, y); // 8 AM
        calFin.set(Calendar.MINUTE, 0);
        calFin.set(Calendar.SECOND, 0);
        calFin.set(Calendar.MILLISECOND, 0);

        horainiciofinMateria = calFin.getTime();

        System.out.println("horainiciofinMateria" + horainiciofinMateria);
    }

    public String convertirsiglasCarrerra(String nombrecarrera) {
        switch (nombrecarrera) {
            case "INGENIERIA INDUSTRIAL":
                return "II";
            case "INGENIERIA ELECTRONICA":
                return "IE";
            case "INGENIERIA EN SISTEMAS COMPUTACIONALES":
                return "ISC";
            case "INGENIERIA EN GESTION EMPRESARIAL":
                return "IGE";
            case "INGENIERIA MECATRONICA":
                return "IM";
            case "CONTADOR PUBLICO":
                return "CP";
            case "MAESTRIA EN INGENIERIA ADMINISTRATIVA":
                return "MIA";
            case "INGENIERIA CIVIL":
                return "IC";
        }
        return "";
    }

    public void asignarDatoSemana(HorarioCrear x, int y, Horarios z, String colorFondo, String colorLetra) {

        switch (y) {
            case 1:
                x.setLunes(z.getMateria().getNombreCompletoMateria() + "  " + z.getAula().getAula() + "  " + colorFondo + "  " + colorLetra);
                break;
            case 2:
                x.setMartes(z.getMateria().getNombreCompletoMateria() + "  " + z.getAula().getAula() + "  " + colorFondo + "  " + colorLetra);
                break;
            case 3:
                x.setMiercoles(z.getMateria().getNombreCompletoMateria() + "  " + z.getAula().getAula() + "  " + colorFondo + "  " + colorLetra);
                break;
            case 4:
                x.setJueves(z.getMateria().getNombreCompletoMateria() + "  " + z.getAula().getAula() + "  " + colorFondo + "  " + colorLetra);
                break;
            case 5:
                x.setViernes(z.getMateria().getNombreCompletoMateria() + "  " + z.getAula().getAula() + "  " + colorFondo + "  " + colorLetra);
                break;
            case 56:
                x.setSabado(z.getMateria().getNombreCompletoMateria() + "  " + z.getAula().getAula() + "  " + colorFondo + "  " + colorLetra);
                break;
            default:
                System.out.println("Rango inválido");
        }
    }

    public void asignarHoras(int rango) {
        switch (rango) {
            case 1:
                transformarHorasDate(7, 8);
                break;
            case 2:
                transformarHorasDate(8, 9);
                break;
            case 3:
                transformarHorasDate(9, 10);
                break;
            case 4:
                transformarHorasDate(10, 11);
                break;
            case 5:
                transformarHorasDate(11, 12);
                break;
            case 6:
                transformarHorasDate(12, 13);
                break;
            case 7:
                transformarHorasDate(13, 14);
                break;
            case 8:
                transformarHorasDate(14, 15);
                break;
            case 9:
                transformarHorasDate(15, 16);
                break;
            case 10:
                transformarHorasDate(16, 17);
                break;
            case 11:
                transformarHorasDate(17, 18);
                break;
            case 12:
                transformarHorasDate(18, 19);
                break;
            case 13:
                transformarHorasDate(19, 20);
                break;
            default:
                System.out.println("Rango inválido");
        }
    }

    public void cambioCarrera() {
        inicializarHorario();
        if (carreraS != null && !"".equals(carreraS)) {
            System.out.println("Buscar " + carreraS);
            listaMateria = materiasCarrerasServicio.buscarPorCarrera(Integer.parseInt(carreraS));
            System.out.println("Total " + listaMateria.size());
            semestreS = "";
            //seleccionadocarreramateria2 = true;
        } else {

        }
    }

    public void cambioSemestre() {
        System.out.println("Selecciono " + semestreS);
        inicializarHorario();
        if (carreraS != null && !"".equals(carreraS)) {
            System.out.println("Buscar " + carreraS);
            listaMateria = materiasCarrerasServicio.buscarAsinaturaSemestre(Integer.parseInt(carreraS), Integer.parseInt(semestreS));
            System.out.println("Total " + listaMateria.size());
        } else {

        }
    }
}
