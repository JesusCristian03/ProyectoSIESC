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
@Table(name = "asistencia_aula", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaAula.findAll", query = "SELECT a FROM AsistenciaAula a"),
    @NamedQuery(name = "AsistenciaAula.findByIdAsistenciaaula", query = "SELECT a FROM AsistenciaAula a WHERE a.idAsistenciaaula = :idAsistenciaaula"),
    @NamedQuery(name = "AsistenciaAula.findByFecha", query = "SELECT a FROM AsistenciaAula a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AsistenciaAula.findByChecada", query = "SELECT a FROM AsistenciaAula a WHERE a.checada = :checada"),
    @NamedQuery(name = "AsistenciaAula.findByObservaciones", query = "SELECT a FROM AsistenciaAula a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "AsistenciaAula.findByObservacionDa", query = "SELECT a FROM AsistenciaAula a WHERE a.observacionDa = :observacionDa"),
    @NamedQuery(name = "AsistenciaAula.findByObservacionRh", query = "SELECT a FROM AsistenciaAula a WHERE a.observacionRh = :observacionRh")})
public class AsistenciaAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asistenciaaula")
    private Integer idAsistenciaaula;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "checada")
    @Temporal(TemporalType.TIME)
    private Date checada;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "observacion_da")
    private String observacionDa;
    @Column(name = "observacion_rh")
    private String observacionRh;
    @JoinColumn(name = "id_estatusc", referencedColumnName = "id_estatusc")
    @ManyToOne
    private EstatusChecada idEstatusc;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    @ManyToOne
    private Horarios idHorario;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne
    private Usuario usuario;

    public AsistenciaAula() {
    }

    public AsistenciaAula(Integer idAsistenciaaula) {
        this.idAsistenciaaula = idAsistenciaaula;
    }

    public Integer getIdAsistenciaaula() {
        return idAsistenciaaula;
    }

    public void setIdAsistenciaaula(Integer idAsistenciaaula) {
        this.idAsistenciaaula = idAsistenciaaula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getChecada() {
        return checada;
    }

    public void setChecada(Date checada) {
        this.checada = checada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservacionDa() {
        return observacionDa;
    }

    public void setObservacionDa(String observacionDa) {
        this.observacionDa = observacionDa;
    }

    public String getObservacionRh() {
        return observacionRh;
    }

    public void setObservacionRh(String observacionRh) {
        this.observacionRh = observacionRh;
    }

    public EstatusChecada getIdEstatusc() {
        return idEstatusc;
    }

    public void setIdEstatusc(EstatusChecada idEstatusc) {
        this.idEstatusc = idEstatusc;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
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
        hash += (idAsistenciaaula != null ? idAsistenciaaula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaAula)) {
            return false;
        }
        AsistenciaAula other = (AsistenciaAula) object;
        if ((this.idAsistenciaaula == null && other.idAsistenciaaula != null) || (this.idAsistenciaaula != null && !this.idAsistenciaaula.equals(other.idAsistenciaaula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsistenciaAula[ idAsistenciaaula=" + idAsistenciaaula + " ]";
    }
    
}
