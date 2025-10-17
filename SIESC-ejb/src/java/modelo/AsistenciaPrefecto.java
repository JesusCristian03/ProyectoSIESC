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
@Table(name = "asistencia_prefecto", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaPrefecto.findAll", query = "SELECT a FROM AsistenciaPrefecto a"),
    @NamedQuery(name = "AsistenciaPrefecto.findByIdAsistenciaPrefecto", query = "SELECT a FROM AsistenciaPrefecto a WHERE a.idAsistenciaPrefecto = :idAsistenciaPrefecto"),
    @NamedQuery(name = "AsistenciaPrefecto.findByUsuario", query = "SELECT a FROM AsistenciaPrefecto a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AsistenciaPrefecto.findByFecha", query = "SELECT a FROM AsistenciaPrefecto a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AsistenciaPrefecto.findByObservaciones", query = "SELECT a FROM AsistenciaPrefecto a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "AsistenciaPrefecto.findByMotivoFalta", query = "SELECT a FROM AsistenciaPrefecto a WHERE a.motivoFalta = :motivoFalta"),
    @NamedQuery(name = "AsistenciaPrefecto.findByAsistencia", query = "SELECT a FROM AsistenciaPrefecto a WHERE a.asistencia = :asistencia")})
public class AsistenciaPrefecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asistencia_prefecto")
    private Integer idAsistenciaPrefecto;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "motivo_falta")
    private String motivoFalta;
    @Column(name = "asistencia")
    private Character asistencia;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    @ManyToOne
    private Horarios idHorario;

    public AsistenciaPrefecto() {
    }

    public AsistenciaPrefecto(Integer idAsistenciaPrefecto) {
        this.idAsistenciaPrefecto = idAsistenciaPrefecto;
    }

    public Integer getIdAsistenciaPrefecto() {
        return idAsistenciaPrefecto;
    }

    public void setIdAsistenciaPrefecto(Integer idAsistenciaPrefecto) {
        this.idAsistenciaPrefecto = idAsistenciaPrefecto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMotivoFalta() {
        return motivoFalta;
    }

    public void setMotivoFalta(String motivoFalta) {
        this.motivoFalta = motivoFalta;
    }

    public Character getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Character asistencia) {
        this.asistencia = asistencia;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistenciaPrefecto != null ? idAsistenciaPrefecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaPrefecto)) {
            return false;
        }
        AsistenciaPrefecto other = (AsistenciaPrefecto) object;
        if ((this.idAsistenciaPrefecto == null && other.idAsistenciaPrefecto != null) || (this.idAsistenciaPrefecto != null && !this.idAsistenciaPrefecto.equals(other.idAsistenciaPrefecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsistenciaPrefecto[ idAsistenciaPrefecto=" + idAsistenciaPrefecto + " ]";
    }
    
}
