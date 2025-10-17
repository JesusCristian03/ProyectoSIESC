/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "historia_alumno", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaAlumno.findAll", query = "SELECT h FROM HistoriaAlumno h"),
    @NamedQuery(name = "HistoriaAlumno.findByGrupo", query = "SELECT h FROM HistoriaAlumno h WHERE h.grupo = :grupo"),
    @NamedQuery(name = "HistoriaAlumno.findByCalificacion", query = "SELECT h FROM HistoriaAlumno h WHERE h.calificacion = :calificacion"),
    @NamedQuery(name = "HistoriaAlumno.findByFechaCalificacion", query = "SELECT h FROM HistoriaAlumno h WHERE h.fechaCalificacion = :fechaCalificacion"),
    @NamedQuery(name = "HistoriaAlumno.findByPlanDeEstudios", query = "SELECT h FROM HistoriaAlumno h WHERE h.planDeEstudios = :planDeEstudios"),
    @NamedQuery(name = "HistoriaAlumno.findByEstatusMateria", query = "SELECT h FROM HistoriaAlumno h WHERE h.estatusMateria = :estatusMateria"),
    @NamedQuery(name = "HistoriaAlumno.findByNopresento", query = "SELECT h FROM HistoriaAlumno h WHERE h.nopresento = :nopresento"),
    @NamedQuery(name = "HistoriaAlumno.findByChecksum", query = "SELECT h FROM HistoriaAlumno h WHERE h.checksum = :checksum"),
    @NamedQuery(name = "HistoriaAlumno.findByFechaActualizacion", query = "SELECT h FROM HistoriaAlumno h WHERE h.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "HistoriaAlumno.findByIdHistoriaAlumno", query = "SELECT h FROM HistoriaAlumno h WHERE h.idHistoriaAlumno = :idHistoriaAlumno")})
public class HistoriaAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Column(name = "fecha_calificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCalificacion;
    @Column(name = "plan_de_estudios")
    private Character planDeEstudios;
    @Column(name = "estatus_materia")
    private Character estatusMateria;
    @Column(name = "nopresento")
    private Character nopresento;
    @Column(name = "checksum")
    private Character checksum;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historia_alumno")
    private Integer idHistoriaAlumno;
    @JoinColumn(name = "no_de_control", referencedColumnName = "no_de_control")
    @ManyToOne
    private Estudiante noDeControl;
    @JoinColumn(name = "materia", referencedColumnName = "materia")
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "periodo_acredita", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodoAcredita;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodo;
    @JoinColumn(name = "tipo_evaluacion", referencedColumnName = "tipo_evaluacion")
    @ManyToOne
    private TipoEvaluacion tipoEvaluacion;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne
    private Usuario usuario;

    public HistoriaAlumno() {
    }

    public HistoriaAlumno(Integer idHistoriaAlumno) {
        this.idHistoriaAlumno = idHistoriaAlumno;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Date fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public Character getPlanDeEstudios() {
        return planDeEstudios;
    }

    public void setPlanDeEstudios(Character planDeEstudios) {
        this.planDeEstudios = planDeEstudios;
    }

    public Character getEstatusMateria() {
        return estatusMateria;
    }

    public void setEstatusMateria(Character estatusMateria) {
        this.estatusMateria = estatusMateria;
    }

    public Character getNopresento() {
        return nopresento;
    }

    public void setNopresento(Character nopresento) {
        this.nopresento = nopresento;
    }

    public Character getChecksum() {
        return checksum;
    }

    public void setChecksum(Character checksum) {
        this.checksum = checksum;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getIdHistoriaAlumno() {
        return idHistoriaAlumno;
    }

    public void setIdHistoriaAlumno(Integer idHistoriaAlumno) {
        this.idHistoriaAlumno = idHistoriaAlumno;
    }

    public Estudiante getNoDeControl() {
        return noDeControl;
    }

    public void setNoDeControl(Estudiante noDeControl) {
        this.noDeControl = noDeControl;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public PeriodoEscolar getPeriodoAcredita() {
        return periodoAcredita;
    }

    public void setPeriodoAcredita(PeriodoEscolar periodoAcredita) {
        this.periodoAcredita = periodoAcredita;
    }

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaAlumno != null ? idHistoriaAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaAlumno)) {
            return false;
        }
        HistoriaAlumno other = (HistoriaAlumno) object;
        if ((this.idHistoriaAlumno == null && other.idHistoriaAlumno != null) || (this.idHistoriaAlumno != null && !this.idHistoriaAlumno.equals(other.idHistoriaAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HistoriaAlumno[ idHistoriaAlumno=" + idHistoriaAlumno + " ]";
    }
    
}
