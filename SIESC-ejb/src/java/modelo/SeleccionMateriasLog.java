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
@Table(name = "seleccion_materias_log", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeleccionMateriasLog.findAll", query = "SELECT s FROM SeleccionMateriasLog s"),
    @NamedQuery(name = "SeleccionMateriasLog.findByGrupo", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.grupo = :grupo"),
    @NamedQuery(name = "SeleccionMateriasLog.findByCalificacion", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.calificacion = :calificacion"),
    @NamedQuery(name = "SeleccionMateriasLog.findByTipoEvaluacion", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "SeleccionMateriasLog.findByRepeticion", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.repeticion = :repeticion"),
    @NamedQuery(name = "SeleccionMateriasLog.findByNopresento", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.nopresento = :nopresento"),
    @NamedQuery(name = "SeleccionMateriasLog.findByEstatusSeleccion", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.estatusSeleccion = :estatusSeleccion"),
    @NamedQuery(name = "SeleccionMateriasLog.findByFechaHoraSeleccion", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.fechaHoraSeleccion = :fechaHoraSeleccion"),
    @NamedQuery(name = "SeleccionMateriasLog.findByUsuario", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.usuario = :usuario"),
    @NamedQuery(name = "SeleccionMateriasLog.findByLugar", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.lugar = :lugar"),
    @NamedQuery(name = "SeleccionMateriasLog.findByFechaHoraCambio", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.fechaHoraCambio = :fechaHoraCambio"),
    @NamedQuery(name = "SeleccionMateriasLog.findByTipoOperacion", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.tipoOperacion = :tipoOperacion"),
    @NamedQuery(name = "SeleccionMateriasLog.findByMotivo", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.motivo = :motivo"),
    @NamedQuery(name = "SeleccionMateriasLog.findByIdSeleccionMateriasLog", query = "SELECT s FROM SeleccionMateriasLog s WHERE s.idSeleccionMateriasLog = :idSeleccionMateriasLog")})
public class SeleccionMateriasLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Column(name = "tipo_evaluacion")
    private String tipoEvaluacion;
    @Column(name = "repeticion")
    private Character repeticion;
    @Column(name = "nopresento")
    private Character nopresento;
    @Column(name = "estatus_seleccion")
    private Character estatusSeleccion;
    @Column(name = "fecha_hora_seleccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraSeleccion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "fecha_hora_cambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCambio;
    @Column(name = "tipo_operacion")
    private Character tipoOperacion;
    @Column(name = "motivo")
    private String motivo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seleccion_materias_log")
    private Integer idSeleccionMateriasLog;
    @JoinColumn(name = "no_de_control", referencedColumnName = "no_de_control")
    @ManyToOne
    private Estudiante noDeControl;
    @JoinColumn(name = "materia", referencedColumnName = "materia")
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodo;

    public SeleccionMateriasLog() {
    }

    public SeleccionMateriasLog(Integer idSeleccionMateriasLog) {
        this.idSeleccionMateriasLog = idSeleccionMateriasLog;
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

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public Character getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(Character repeticion) {
        this.repeticion = repeticion;
    }

    public Character getNopresento() {
        return nopresento;
    }

    public void setNopresento(Character nopresento) {
        this.nopresento = nopresento;
    }

    public Character getEstatusSeleccion() {
        return estatusSeleccion;
    }

    public void setEstatusSeleccion(Character estatusSeleccion) {
        this.estatusSeleccion = estatusSeleccion;
    }

    public Date getFechaHoraSeleccion() {
        return fechaHoraSeleccion;
    }

    public void setFechaHoraSeleccion(Date fechaHoraSeleccion) {
        this.fechaHoraSeleccion = fechaHoraSeleccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaHoraCambio() {
        return fechaHoraCambio;
    }

    public void setFechaHoraCambio(Date fechaHoraCambio) {
        this.fechaHoraCambio = fechaHoraCambio;
    }

    public Character getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Character tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getIdSeleccionMateriasLog() {
        return idSeleccionMateriasLog;
    }

    public void setIdSeleccionMateriasLog(Integer idSeleccionMateriasLog) {
        this.idSeleccionMateriasLog = idSeleccionMateriasLog;
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

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeleccionMateriasLog != null ? idSeleccionMateriasLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeleccionMateriasLog)) {
            return false;
        }
        SeleccionMateriasLog other = (SeleccionMateriasLog) object;
        if ((this.idSeleccionMateriasLog == null && other.idSeleccionMateriasLog != null) || (this.idSeleccionMateriasLog != null && !this.idSeleccionMateriasLog.equals(other.idSeleccionMateriasLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeleccionMateriasLog[ idSeleccionMateriasLog=" + idSeleccionMateriasLog + " ]";
    }
    
}
