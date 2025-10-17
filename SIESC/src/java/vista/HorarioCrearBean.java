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
import java.util.Set;
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
    Boolean camposllenos = false;
    private Organigrama organigrama;

    private int creditos = 0;
    private String carreraS = "";
    private String asignaturaS = "";
    private String posicionesSeleccionadas = "";
    private String periodoS = "";
    private String semestreS = "";
    private String aulas = "";
    private String grupoS = "";
    private String personal = "";
    private int numestudiantes = 0;
    private String valorgrupo = "";
    private Boolean seleccionadocarreramateria2 = false;

    Date horainicioMateria;
    Date horainiciofinMateria;

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

    public void actualizarTabla() {
        verificacionDeCampos();//Verifica que los campos esten llenos antes de actualizar la tabla por los datos actuales
        inicializarHorario();//Asi evitamos que se sobreescriba la informacion que se actualiza en la tabla 
        materiasCarreras = materiasCarrerasServicio.buscarPorId(Integer.parseInt(asignaturaS));

        organigrama = organigramaServicio.buscarPorId(materiasCarreras.getMateria().getClaveArea().getClaveArea());
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
                    horainicial = horario.getHoraInicial();
                    cal.setTime(horainicial);
                    hora = cal.get(Calendar.HOUR_OF_DAY); // obtiene la hora en formato 24h
                    fila = obtenerFilaHorario(hora);
                    columna = horario.getDiaSemana() - 1;
                    for (int j = 0; j < listaHorarioCrear.size(); j++) {//Recorrer la tabla primero por las filas
                        horariocrear = listaHorarioCrear.get(j);

                        horariocrear.setColor("#" + organigrama.getColor());//Poner el color que le corresponde a las materias. 
                        if (j == fila) {
                            asignarDatoSemana(horariocrear, columna, horario);
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

    public void actualizarCreditos() {

        materiasCarreras = materiasCarrerasServicio.buscarPorId(Integer.parseInt(asignaturaS));
        if (materiasCarreras != null) {
            creditos = materiasCarreras.getHorasPracticas() + materiasCarreras.getHorasTeoricas();
            // Enviar el valor actualizado al cliente ANTES del update
            PrimeFaces.current().ajax().addCallbackParam("creditos", this.creditos);
        }
    }

    public void generarHorario() throws ParseException {

        verificacionDeCampos();//VERIFICA QUE LOS CAMPOS TENGAN ALGO
        if (camposllenos) {//COMPRUEBA QUE TODOS LOS CAMPOS TENGAN ALGO Y QUE HAYAN SIDO SELECCIOANDAS AL MENOS UNA CELDA
            generarGrupo();

            transformarCoordenadas();// pasa de esto 1,1;1,2;1,3;1,4;1,5 a ["1,1"]["1,2"]["1,3"]["1,4"]["1,5"]
            materiasCarreras = materiasCarrerasServicio.buscarPorId(Integer.parseInt(asignaturaS));
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
                    //listaHorarioscomprobacion = listaHorarios;
                    horarioServicio.insertarHorario(horario);
                    System.out.println("Celda " + i + ": " + celda);
                }

                //ACOMODAR EN LA TABLA LA INFORMACION 
                for (int i = 0; i < listaHorarios.size(); i++) {//Obtener el objeto donde tengo la informacion de las materias.
                    horario = listaHorarios.get(i);
                    String celda = listacoordenadas.get(i);//Voy a recorrer todos estos ["1,1"]["1,2"]["1,3"]["1,4"]["1,5"]
                    String[] indices = celda.split(",");//tienen el formato ["1,1"] entonces los separa respectivamente fila: 1 y columna: 1
                    int fila = Integer.parseInt(indices[0]);
                    int columna = Integer.parseInt(indices[1]);

                    for (int j = 0; j < listaHorarioCrear.size(); j++) {//Recorrer la tabla primero por las filas
                        horariocrear = listaHorarioCrear.get(j);
                        horariocrear.setColor("#" + organigrama.getColor());//Poner el color que le corresponde a las materias. 
                        if (j == fila) {
                            asignarDatoSemana(horariocrear, columna, horario);
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
        /*FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "ÉXITO", "HORARIO GENERADO CORRECTAMENTE"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);*/
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

    public void asignarDatoSemana(HorarioCrear x, int y, Horarios z) {

        switch (y) {
            case 1:
                x.setLunes(z.getMateria().getNombreCompletoMateria() + " " + z.getAula().getAula());
                break;
            case 2:
                x.setMartes(z.getMateria().getNombreCompletoMateria() + " " + z.getAula().getAula());
                break;
            case 3:
                x.setMiercoles(z.getMateria().getNombreCompletoMateria() + " " + z.getAula().getAula());
                break;
            case 4:
                x.setJueves(z.getMateria().getNombreCompletoMateria() + " " + z.getAula().getAula());
                break;
            case 5:
                x.setViernes(z.getMateria().getNombreCompletoMateria() + z.getAula().getAula());
                break;
            case 56:
                x.setSabado(z.getMateria().getNombreCompletoMateria() + z.getAula().getAula());
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
