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
@Table(name = "inv_asignacion_equipo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvAsignacionEquipo.findAll", query = "SELECT i FROM InvAsignacionEquipo i"),
    @NamedQuery(name = "InvAsignacionEquipo.findByIdAsignacion", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "InvAsignacionEquipo.findByIdEquipo", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.idEquipo = :idEquipo"),
    @NamedQuery(name = "InvAsignacionEquipo.findByFechaInicio", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "InvAsignacionEquipo.findByFechaTermino", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "InvAsignacionEquipo.findByUsuarioAlta", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.usuarioAlta = :usuarioAlta"),
    @NamedQuery(name = "InvAsignacionEquipo.findByUsuarioBaja", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.usuarioBaja = :usuarioBaja"),
    @NamedQuery(name = "InvAsignacionEquipo.findByObservacionesBaja", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.observacionesBaja = :observacionesBaja"),
    @NamedQuery(name = "InvAsignacionEquipo.findByEstado", query = "SELECT i FROM InvAsignacionEquipo i WHERE i.estado = :estado")})
public class InvAsignacionEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private String idEquipo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Column(name = "usuario_alta")
    private String usuarioAlta;
    @Column(name = "usuario_baja")
    private String usuarioBaja;
    @Column(name = "observaciones_baja")
    private String observacionesBaja;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    @ManyToOne
    private InvEstatus idEstatus;

    public InvAsignacionEquipo() {
    }

    public InvAsignacionEquipo(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public InvAsignacionEquipo(Integer idAsignacion, String idEquipo) {
        this.idAsignacion = idAsignacion;
        this.idEquipo = idEquipo;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
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

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getUsuarioBaja() {
        return usuarioBaja;
    }

    public void setUsuarioBaja(String usuarioBaja) {
        this.usuarioBaja = usuarioBaja;
    }

    public String getObservacionesBaja() {
        return observacionesBaja;
    }

    public void setObservacionesBaja(String observacionesBaja) {
        this.observacionesBaja = observacionesBaja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public InvEstatus getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(InvEstatus idEstatus) {
        this.idEstatus = idEstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvAsignacionEquipo)) {
            return false;
        }
        InvAsignacionEquipo other = (InvAsignacionEquipo) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvAsignacionEquipo[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
