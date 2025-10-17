/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "periodo_escolar", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoEscolar.findAll", query = "SELECT p FROM PeriodoEscolar p"),
    @NamedQuery(name = "PeriodoEscolar.findByPeriodo", query = "SELECT p FROM PeriodoEscolar p WHERE p.periodo = :periodo"),
    @NamedQuery(name = "PeriodoEscolar.findByIdentificacionLarga", query = "SELECT p FROM PeriodoEscolar p WHERE p.identificacionLarga = :identificacionLarga"),
    @NamedQuery(name = "PeriodoEscolar.findByIdentificacionCorta", query = "SELECT p FROM PeriodoEscolar p WHERE p.identificacionCorta = :identificacionCorta"),
    @NamedQuery(name = "PeriodoEscolar.findByStatus", query = "SELECT p FROM PeriodoEscolar p WHERE p.status = :status"),
    @NamedQuery(name = "PeriodoEscolar.findByFechaInicio", query = "SELECT p FROM PeriodoEscolar p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "PeriodoEscolar.findByFechaTermino", query = "SELECT p FROM PeriodoEscolar p WHERE p.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "PeriodoEscolar.findByInicioVacacionalSs", query = "SELECT p FROM PeriodoEscolar p WHERE p.inicioVacacionalSs = :inicioVacacionalSs"),
    @NamedQuery(name = "PeriodoEscolar.findByTerminoVacacionalSs", query = "SELECT p FROM PeriodoEscolar p WHERE p.terminoVacacionalSs = :terminoVacacionalSs"),
    @NamedQuery(name = "PeriodoEscolar.findByInicioEspecial", query = "SELECT p FROM PeriodoEscolar p WHERE p.inicioEspecial = :inicioEspecial"),
    @NamedQuery(name = "PeriodoEscolar.findByFinEspecial", query = "SELECT p FROM PeriodoEscolar p WHERE p.finEspecial = :finEspecial"),
    @NamedQuery(name = "PeriodoEscolar.findByCierreHorarios", query = "SELECT p FROM PeriodoEscolar p WHERE p.cierreHorarios = :cierreHorarios"),
    @NamedQuery(name = "PeriodoEscolar.findByCierreSeleccion", query = "SELECT p FROM PeriodoEscolar p WHERE p.cierreSeleccion = :cierreSeleccion"),
    @NamedQuery(name = "PeriodoEscolar.findByInicioEncEstudiantil", query = "SELECT p FROM PeriodoEscolar p WHERE p.inicioEncEstudiantil = :inicioEncEstudiantil"),
    @NamedQuery(name = "PeriodoEscolar.findByFinEncEstudiantil", query = "SELECT p FROM PeriodoEscolar p WHERE p.finEncEstudiantil = :finEncEstudiantil"),
    @NamedQuery(name = "PeriodoEscolar.findByInicioSeleAlumnos", query = "SELECT p FROM PeriodoEscolar p WHERE p.inicioSeleAlumnos = :inicioSeleAlumnos"),
    @NamedQuery(name = "PeriodoEscolar.findByFinSeleAlumnos", query = "SELECT p FROM PeriodoEscolar p WHERE p.finSeleAlumnos = :finSeleAlumnos"),
    @NamedQuery(name = "PeriodoEscolar.findByInicioVacacional", query = "SELECT p FROM PeriodoEscolar p WHERE p.inicioVacacional = :inicioVacacional"),
    @NamedQuery(name = "PeriodoEscolar.findByTerminoVacacional", query = "SELECT p FROM PeriodoEscolar p WHERE p.terminoVacacional = :terminoVacacional"),
    @NamedQuery(name = "PeriodoEscolar.findByParcial1Inicio", query = "SELECT p FROM PeriodoEscolar p WHERE p.parcial1Inicio = :parcial1Inicio"),
    @NamedQuery(name = "PeriodoEscolar.findByParcial1Fin", query = "SELECT p FROM PeriodoEscolar p WHERE p.parcial1Fin = :parcial1Fin"),
    @NamedQuery(name = "PeriodoEscolar.findByParcial2Inicio", query = "SELECT p FROM PeriodoEscolar p WHERE p.parcial2Inicio = :parcial2Inicio"),
    @NamedQuery(name = "PeriodoEscolar.findByParcial2Fin", query = "SELECT p FROM PeriodoEscolar p WHERE p.parcial2Fin = :parcial2Fin"),
    @NamedQuery(name = "PeriodoEscolar.findByParcial3Inicio", query = "SELECT p FROM PeriodoEscolar p WHERE p.parcial3Inicio = :parcial3Inicio"),
    @NamedQuery(name = "PeriodoEscolar.findByParcial3Fin", query = "SELECT p FROM PeriodoEscolar p WHERE p.parcial3Fin = :parcial3Fin"),
    @NamedQuery(name = "PeriodoEscolar.findByFiltro", query = "SELECT p FROM PeriodoEscolar p WHERE p.filtro = :filtro"),
    @NamedQuery(name = "PeriodoEscolar.findByInicioCalDocentes", query = "SELECT p FROM PeriodoEscolar p WHERE p.inicioCalDocentes = :inicioCalDocentes"),
    @NamedQuery(name = "PeriodoEscolar.findByFinCalDocentes", query = "SELECT p FROM PeriodoEscolar p WHERE p.finCalDocentes = :finCalDocentes")})
public class PeriodoEscolar implements Serializable {

    @OneToMany(mappedBy = "periodo")
    private List<AvisosReinscripcion> avisosReinscripcionList;

    @OneToMany(mappedBy = "periodo")
    private List<SeleccionMateriasLog> seleccionMateriasLogList;
    @OneToMany(mappedBy = "periodoAcredita")
    private List<HistoriaAlumno> historiaAlumnoList;
    @OneToMany(mappedBy = "periodo")
    private List<HistoriaAlumno> historiaAlumnoList1;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @Column(name = "identificacion_larga")
    private String identificacionLarga;
    @Column(name = "identificacion_corta")
    private String identificacionCorta;
    @Basic(optional = false)
    @Column(name = "status")
    private Character status;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Column(name = "inicio_vacacional_ss")
    @Temporal(TemporalType.DATE)
    private Date inicioVacacionalSs;
    @Column(name = "termino_vacacional_ss")
    @Temporal(TemporalType.DATE)
    private Date terminoVacacionalSs;
    @Column(name = "inicio_especial")
    @Temporal(TemporalType.DATE)
    private Date inicioEspecial;
    @Column(name = "fin_especial")
    @Temporal(TemporalType.DATE)
    private Date finEspecial;
    @Column(name = "cierre_horarios")
    private Character cierreHorarios;
    @Column(name = "cierre_seleccion")
    private Character cierreSeleccion;
    @Column(name = "inicio_enc_estudiantil")
    @Temporal(TemporalType.DATE)
    private Date inicioEncEstudiantil;
    @Column(name = "fin_enc_estudiantil")
    @Temporal(TemporalType.DATE)
    private Date finEncEstudiantil;
    @Column(name = "inicio_sele_alumnos")
    @Temporal(TemporalType.DATE)
    private Date inicioSeleAlumnos;
    @Column(name = "fin_sele_alumnos")
    @Temporal(TemporalType.DATE)
    private Date finSeleAlumnos;
    @Column(name = "inicio_vacacional")
    @Temporal(TemporalType.DATE)
    private Date inicioVacacional;
    @Column(name = "termino_vacacional")
    @Temporal(TemporalType.DATE)
    private Date terminoVacacional;
    @Column(name = "parcial1_inicio")
    @Temporal(TemporalType.DATE)
    private Date parcial1Inicio;
    @Column(name = "parcial1_fin")
    @Temporal(TemporalType.DATE)
    private Date parcial1Fin;
    @Column(name = "parcial2_inicio")
    @Temporal(TemporalType.DATE)
    private Date parcial2Inicio;
    @Column(name = "parcial2_fin")
    @Temporal(TemporalType.DATE)
    private Date parcial2Fin;
    @Column(name = "parcial3_inicio")
    @Temporal(TemporalType.DATE)
    private Date parcial3Inicio;
    @Column(name = "parcial3_fin")
    @Temporal(TemporalType.DATE)
    private Date parcial3Fin;
    @Column(name = "filtro")
    private Character filtro;
    @Column(name = "inicio_cal_docentes")
    @Temporal(TemporalType.DATE)
    private Date inicioCalDocentes;
    @Column(name = "fin_cal_docentes")
    @Temporal(TemporalType.DATE)
    private Date finCalDocentes;
    @OneToMany(mappedBy = "periodo")
    private List<SeleccionMaterias> seleccionMateriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<Horarios> horariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoIngresoIt")
    private List<Estudiante> estudianteList;
    @OneToMany(mappedBy = "ultimoPeriodoInscrito")
    private List<Estudiante> estudianteList1;
    @OneToMany(mappedBy = "periodo")
    private List<Grupos> gruposList;
    @OneToMany(mappedBy = "periodo")
    private List<RhAsistencia> rhAsistenciaList;

    public PeriodoEscolar() {
    }

    public PeriodoEscolar(String periodo) {
        this.periodo = periodo;
    }

    public PeriodoEscolar(String periodo, String identificacionLarga, Character status) {
        this.periodo = periodo;
        this.identificacionLarga = identificacionLarga;
        this.status = status;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getIdentificacionLarga() {
        return identificacionLarga;
    }

    public void setIdentificacionLarga(String identificacionLarga) {
        this.identificacionLarga = identificacionLarga;
    }

    public String getIdentificacionCorta() {
        return identificacionCorta;
    }

    public void setIdentificacionCorta(String identificacionCorta) {
        this.identificacionCorta = identificacionCorta;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Date getInicioVacacionalSs() {
        return inicioVacacionalSs;
    }

    public void setInicioVacacionalSs(Date inicioVacacionalSs) {
        this.inicioVacacionalSs = inicioVacacionalSs;
    }

    public Date getTerminoVacacionalSs() {
        return terminoVacacionalSs;
    }

    public void setTerminoVacacionalSs(Date terminoVacacionalSs) {
        this.terminoVacacionalSs = terminoVacacionalSs;
    }

    public Date getInicioEspecial() {
        return inicioEspecial;
    }

    public void setInicioEspecial(Date inicioEspecial) {
        this.inicioEspecial = inicioEspecial;
    }

    public Date getFinEspecial() {
        return finEspecial;
    }

    public void setFinEspecial(Date finEspecial) {
        this.finEspecial = finEspecial;
    }

    public Character getCierreHorarios() {
        return cierreHorarios;
    }

    public void setCierreHorarios(Character cierreHorarios) {
        this.cierreHorarios = cierreHorarios;
    }

    public Character getCierreSeleccion() {
        return cierreSeleccion;
    }

    public void setCierreSeleccion(Character cierreSeleccion) {
        this.cierreSeleccion = cierreSeleccion;
    }

    public Date getInicioEncEstudiantil() {
        return inicioEncEstudiantil;
    }

    public void setInicioEncEstudiantil(Date inicioEncEstudiantil) {
        this.inicioEncEstudiantil = inicioEncEstudiantil;
    }

    public Date getFinEncEstudiantil() {
        return finEncEstudiantil;
    }

    public void setFinEncEstudiantil(Date finEncEstudiantil) {
        this.finEncEstudiantil = finEncEstudiantil;
    }

    public Date getInicioSeleAlumnos() {
        return inicioSeleAlumnos;
    }

    public void setInicioSeleAlumnos(Date inicioSeleAlumnos) {
        this.inicioSeleAlumnos = inicioSeleAlumnos;
    }

    public Date getFinSeleAlumnos() {
        return finSeleAlumnos;
    }

    public void setFinSeleAlumnos(Date finSeleAlumnos) {
        this.finSeleAlumnos = finSeleAlumnos;
    }

    public Date getInicioVacacional() {
        return inicioVacacional;
    }

    public void setInicioVacacional(Date inicioVacacional) {
        this.inicioVacacional = inicioVacacional;
    }

    public Date getTerminoVacacional() {
        return terminoVacacional;
    }

    public void setTerminoVacacional(Date terminoVacacional) {
        this.terminoVacacional = terminoVacacional;
    }

    public Date getParcial1Inicio() {
        return parcial1Inicio;
    }

    public void setParcial1Inicio(Date parcial1Inicio) {
        this.parcial1Inicio = parcial1Inicio;
    }

    public Date getParcial1Fin() {
        return parcial1Fin;
    }

    public void setParcial1Fin(Date parcial1Fin) {
        this.parcial1Fin = parcial1Fin;
    }

    public Date getParcial2Inicio() {
        return parcial2Inicio;
    }

    public void setParcial2Inicio(Date parcial2Inicio) {
        this.parcial2Inicio = parcial2Inicio;
    }

    public Date getParcial2Fin() {
        return parcial2Fin;
    }

    public void setParcial2Fin(Date parcial2Fin) {
        this.parcial2Fin = parcial2Fin;
    }

    public Date getParcial3Inicio() {
        return parcial3Inicio;
    }

    public void setParcial3Inicio(Date parcial3Inicio) {
        this.parcial3Inicio = parcial3Inicio;
    }

    public Date getParcial3Fin() {
        return parcial3Fin;
    }

    public void setParcial3Fin(Date parcial3Fin) {
        this.parcial3Fin = parcial3Fin;
    }

    public Character getFiltro() {
        return filtro;
    }

    public void setFiltro(Character filtro) {
        this.filtro = filtro;
    }

    public Date getInicioCalDocentes() {
        return inicioCalDocentes;
    }

    public void setInicioCalDocentes(Date inicioCalDocentes) {
        this.inicioCalDocentes = inicioCalDocentes;
    }

    public Date getFinCalDocentes() {
        return finCalDocentes;
    }

    public void setFinCalDocentes(Date finCalDocentes) {
        this.finCalDocentes = finCalDocentes;
    }

    @XmlTransient
    public List<SeleccionMaterias> getSeleccionMateriasList() {
        return seleccionMateriasList;
    }

    public void setSeleccionMateriasList(List<SeleccionMaterias> seleccionMateriasList) {
        this.seleccionMateriasList = seleccionMateriasList;
    }

    @XmlTransient
    public List<Horarios> getHorariosList() {
        return horariosList;
    }

    public void setHorariosList(List<Horarios> horariosList) {
        this.horariosList = horariosList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList1() {
        return estudianteList1;
    }

    public void setEstudianteList1(List<Estudiante> estudianteList1) {
        this.estudianteList1 = estudianteList1;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @XmlTransient
    public List<RhAsistencia> getRhAsistenciaList() {
        return rhAsistenciaList;
    }

    public void setRhAsistenciaList(List<RhAsistencia> rhAsistenciaList) {
        this.rhAsistenciaList = rhAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodo != null ? periodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoEscolar)) {
            return false;
        }
        PeriodoEscolar other = (PeriodoEscolar) object;
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeriodoEscolar[ periodo=" + periodo + " ]";
    }

    @XmlTransient
    public List<SeleccionMateriasLog> getSeleccionMateriasLogList() {
        return seleccionMateriasLogList;
    }

    public void setSeleccionMateriasLogList(List<SeleccionMateriasLog> seleccionMateriasLogList) {
        this.seleccionMateriasLogList = seleccionMateriasLogList;
    }

    @XmlTransient
    public List<HistoriaAlumno> getHistoriaAlumnoList() {
        return historiaAlumnoList;
    }

    public void setHistoriaAlumnoList(List<HistoriaAlumno> historiaAlumnoList) {
        this.historiaAlumnoList = historiaAlumnoList;
    }

    @XmlTransient
    public List<HistoriaAlumno> getHistoriaAlumnoList1() {
        return historiaAlumnoList1;
    }

    public void setHistoriaAlumnoList1(List<HistoriaAlumno> historiaAlumnoList1) {
        this.historiaAlumnoList1 = historiaAlumnoList1;
    }

    @XmlTransient
    public List<AvisosReinscripcion> getAvisosReinscripcionList() {
        return avisosReinscripcionList;
    }

    public void setAvisosReinscripcionList(List<AvisosReinscripcion> avisosReinscripcionList) {
        this.avisosReinscripcionList = avisosReinscripcionList;
    }
    
}
