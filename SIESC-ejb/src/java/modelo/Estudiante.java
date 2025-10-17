/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "estudiante", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByNoDeControl", query = "SELECT e FROM Estudiante e WHERE e.noDeControl = :noDeControl"),
    @NamedQuery(name = "Estudiante.findByCarrera", query = "SELECT e FROM Estudiante e WHERE e.carrera = :carrera"),
    @NamedQuery(name = "Estudiante.findByEspecialidad", query = "SELECT e FROM Estudiante e WHERE e.especialidad = :especialidad"),
    @NamedQuery(name = "Estudiante.findByNivelEscolar", query = "SELECT e FROM Estudiante e WHERE e.nivelEscolar = :nivelEscolar"),
    @NamedQuery(name = "Estudiante.findBySemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :semestre"),
    @NamedQuery(name = "Estudiante.findByEstatusAlumno", query = "SELECT e FROM Estudiante e WHERE e.estatusAlumno = :estatusAlumno"),
    @NamedQuery(name = "Estudiante.findByPlanDeEstudios", query = "SELECT e FROM Estudiante e WHERE e.planDeEstudios = :planDeEstudios"),
    @NamedQuery(name = "Estudiante.findByApellidoPaterno", query = "SELECT e FROM Estudiante e WHERE e.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Estudiante.findByApellidoMaterno", query = "SELECT e FROM Estudiante e WHERE e.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Estudiante.findByNombreAlumno", query = "SELECT e FROM Estudiante e WHERE e.nombreAlumno = :nombreAlumno"),
    @NamedQuery(name = "Estudiante.findByCurpAlumno", query = "SELECT e FROM Estudiante e WHERE e.curpAlumno = :curpAlumno"),
    @NamedQuery(name = "Estudiante.findByFechaNacimiento", query = "SELECT e FROM Estudiante e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Estudiante.findBySexo", query = "SELECT e FROM Estudiante e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Estudiante.findByEstadoCivil", query = "SELECT e FROM Estudiante e WHERE e.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Estudiante.findByPromedioPeriodoAnterior", query = "SELECT e FROM Estudiante e WHERE e.promedioPeriodoAnterior = :promedioPeriodoAnterior"),
    @NamedQuery(name = "Estudiante.findByPromedioAritmeticoAcumulado", query = "SELECT e FROM Estudiante e WHERE e.promedioAritmeticoAcumulado = :promedioAritmeticoAcumulado"),
    @NamedQuery(name = "Estudiante.findByCreditosAprobados", query = "SELECT e FROM Estudiante e WHERE e.creditosAprobados = :creditosAprobados"),
    @NamedQuery(name = "Estudiante.findByCreditosCursados", query = "SELECT e FROM Estudiante e WHERE e.creditosCursados = :creditosCursados"),
    @NamedQuery(name = "Estudiante.findByTipoServicioMedico", query = "SELECT e FROM Estudiante e WHERE e.tipoServicioMedico = :tipoServicioMedico"),
    @NamedQuery(name = "Estudiante.findByClaveServicioMedico", query = "SELECT e FROM Estudiante e WHERE e.claveServicioMedico = :claveServicioMedico"),
    @NamedQuery(name = "Estudiante.findByEscuelaProcedencia", query = "SELECT e FROM Estudiante e WHERE e.escuelaProcedencia = :escuelaProcedencia"),
    @NamedQuery(name = "Estudiante.findByDomicilioEscuela", query = "SELECT e FROM Estudiante e WHERE e.domicilioEscuela = :domicilioEscuela"),
    @NamedQuery(name = "Estudiante.findByEntidadProcedencia", query = "SELECT e FROM Estudiante e WHERE e.entidadProcedencia = :entidadProcedencia"),
    @NamedQuery(name = "Estudiante.findByCiudadProcedencia", query = "SELECT e FROM Estudiante e WHERE e.ciudadProcedencia = :ciudadProcedencia"),
    @NamedQuery(name = "Estudiante.findByCorreoElectronico", query = "SELECT e FROM Estudiante e WHERE e.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Estudiante.findByFoto", query = "SELECT e FROM Estudiante e WHERE e.foto = :foto"),
    @NamedQuery(name = "Estudiante.findByFirma", query = "SELECT e FROM Estudiante e WHERE e.firma = :firma"),
    @NamedQuery(name = "Estudiante.findByNip", query = "SELECT e FROM Estudiante e WHERE e.nip = :nip"),
    @NamedQuery(name = "Estudiante.findByUsuario", query = "SELECT e FROM Estudiante e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Estudiante.findByFechaActualizacion", query = "SELECT e FROM Estudiante e WHERE e.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Estudiante.findByPromedioFinalAlcanzado", query = "SELECT e FROM Estudiante e WHERE e.promedioFinalAlcanzado = :promedioFinalAlcanzado")})
public class Estudiante implements Serializable {

    @OneToMany(mappedBy = "noDeControl")
    private List<SeleccionMateriasLog> seleccionMateriasLogList;
    @OneToMany(mappedBy = "noDeControl")
    private List<HistoriaAlumno> historiaAlumnoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no_de_control")
    private String noDeControl;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "nivel_escolar")
    private Character nivelEscolar;
    @Column(name = "semestre")
    private Integer semestre;
    @Column(name = "estatus_alumno")
    private String estatusAlumno;
    @Basic(optional = false)
    @Column(name = "plan_de_estudios")
    private Character planDeEstudios;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "nombre_alumno")
    private String nombreAlumno;
    @Column(name = "curp_alumno")
    private String curpAlumno;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "estado_civil")
    private Character estadoCivil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "promedio_periodo_anterior")
    private Double promedioPeriodoAnterior;
    @Column(name = "promedio_aritmetico_acumulado")
    private Double promedioAritmeticoAcumulado;
    @Column(name = "creditos_aprobados")
    private Integer creditosAprobados;
    @Column(name = "creditos_cursados")
    private Integer creditosCursados;
    @Column(name = "tipo_servicio_medico")
    private Character tipoServicioMedico;
    @Column(name = "clave_servicio_medico")
    private String claveServicioMedico;
    @Column(name = "escuela_procedencia")
    private String escuelaProcedencia;
    @Column(name = "domicilio_escuela")
    private String domicilioEscuela;
    @Column(name = "entidad_procedencia")
    private String entidadProcedencia;
    @Column(name = "ciudad_procedencia")
    private String ciudadProcedencia;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "foto")
    private String foto;
    @Column(name = "firma")
    private String firma;
    @Column(name = "nip")
    private Integer nip;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "promedio_final_alcanzado")
    private Double promedioFinalAlcanzado;
    @OneToMany(mappedBy = "noDeControl")
    private List<SeleccionMaterias> seleccionMateriasList;
    @JoinColumn(name = "reticula", referencedColumnName = "reticula")
    @ManyToOne
    private Carrera reticula;
    @JoinColumn(name = "periodo_ingreso_it", referencedColumnName = "periodo")
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoIngresoIt;
    @JoinColumn(name = "ultimo_periodo_inscrito", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar ultimoPeriodoInscrito;

    public Estudiante() {
    }

    public Estudiante(String noDeControl) {
        this.noDeControl = noDeControl;
    }

    public Estudiante(String noDeControl, Character planDeEstudios, String nombreAlumno) {
        this.noDeControl = noDeControl;
        this.planDeEstudios = planDeEstudios;
        this.nombreAlumno = nombreAlumno;
    }

    public String getNoDeControl() {
        return noDeControl;
    }

    public void setNoDeControl(String noDeControl) {
        this.noDeControl = noDeControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Character getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(Character nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getEstatusAlumno() {
        return estatusAlumno;
    }

    public void setEstatusAlumno(String estatusAlumno) {
        this.estatusAlumno = estatusAlumno;
    }

    public Character getPlanDeEstudios() {
        return planDeEstudios;
    }

    public void setPlanDeEstudios(Character planDeEstudios) {
        this.planDeEstudios = planDeEstudios;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getCurpAlumno() {
        return curpAlumno;
    }

    public void setCurpAlumno(String curpAlumno) {
        this.curpAlumno = curpAlumno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Character getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Double getPromedioPeriodoAnterior() {
        return promedioPeriodoAnterior;
    }

    public void setPromedioPeriodoAnterior(Double promedioPeriodoAnterior) {
        this.promedioPeriodoAnterior = promedioPeriodoAnterior;
    }

    public Double getPromedioAritmeticoAcumulado() {
        return promedioAritmeticoAcumulado;
    }

    public void setPromedioAritmeticoAcumulado(Double promedioAritmeticoAcumulado) {
        this.promedioAritmeticoAcumulado = promedioAritmeticoAcumulado;
    }

    public Integer getCreditosAprobados() {
        return creditosAprobados;
    }

    public void setCreditosAprobados(Integer creditosAprobados) {
        this.creditosAprobados = creditosAprobados;
    }

    public Integer getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(Integer creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    public Character getTipoServicioMedico() {
        return tipoServicioMedico;
    }

    public void setTipoServicioMedico(Character tipoServicioMedico) {
        this.tipoServicioMedico = tipoServicioMedico;
    }

    public String getClaveServicioMedico() {
        return claveServicioMedico;
    }

    public void setClaveServicioMedico(String claveServicioMedico) {
        this.claveServicioMedico = claveServicioMedico;
    }

    public String getEscuelaProcedencia() {
        return escuelaProcedencia;
    }

    public void setEscuelaProcedencia(String escuelaProcedencia) {
        this.escuelaProcedencia = escuelaProcedencia;
    }

    public String getDomicilioEscuela() {
        return domicilioEscuela;
    }

    public void setDomicilioEscuela(String domicilioEscuela) {
        this.domicilioEscuela = domicilioEscuela;
    }

    public String getEntidadProcedencia() {
        return entidadProcedencia;
    }

    public void setEntidadProcedencia(String entidadProcedencia) {
        this.entidadProcedencia = entidadProcedencia;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Double getPromedioFinalAlcanzado() {
        return promedioFinalAlcanzado;
    }

    public void setPromedioFinalAlcanzado(Double promedioFinalAlcanzado) {
        this.promedioFinalAlcanzado = promedioFinalAlcanzado;
    }

    @XmlTransient
    public List<SeleccionMaterias> getSeleccionMateriasList() {
        return seleccionMateriasList;
    }

    public void setSeleccionMateriasList(List<SeleccionMaterias> seleccionMateriasList) {
        this.seleccionMateriasList = seleccionMateriasList;
    }

    public Carrera getReticula() {
        return reticula;
    }

    public void setReticula(Carrera reticula) {
        this.reticula = reticula;
    }

    public PeriodoEscolar getPeriodoIngresoIt() {
        return periodoIngresoIt;
    }

    public void setPeriodoIngresoIt(PeriodoEscolar periodoIngresoIt) {
        this.periodoIngresoIt = periodoIngresoIt;
    }

    public PeriodoEscolar getUltimoPeriodoInscrito() {
        return ultimoPeriodoInscrito;
    }

    public void setUltimoPeriodoInscrito(PeriodoEscolar ultimoPeriodoInscrito) {
        this.ultimoPeriodoInscrito = ultimoPeriodoInscrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noDeControl != null ? noDeControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.noDeControl == null && other.noDeControl != null) || (this.noDeControl != null && !this.noDeControl.equals(other.noDeControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estudiante[ noDeControl=" + noDeControl + " ]";
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
    
}
