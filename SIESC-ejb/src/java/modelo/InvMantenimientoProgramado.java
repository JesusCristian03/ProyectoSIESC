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
@Table(name = "inv_mantenimiento_programado", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvMantenimientoProgramado.findAll", query = "SELECT i FROM InvMantenimientoProgramado i"),
    @NamedQuery(name = "InvMantenimientoProgramado.findByIdMantenimiento", query = "SELECT i FROM InvMantenimientoProgramado i WHERE i.idMantenimiento = :idMantenimiento"),
    @NamedQuery(name = "InvMantenimientoProgramado.findByIdEquipo", query = "SELECT i FROM InvMantenimientoProgramado i WHERE i.idEquipo = :idEquipo"),
    @NamedQuery(name = "InvMantenimientoProgramado.findByFechaProgramado", query = "SELECT i FROM InvMantenimientoProgramado i WHERE i.fechaProgramado = :fechaProgramado"),
    @NamedQuery(name = "InvMantenimientoProgramado.findByFechaRealizado", query = "SELECT i FROM InvMantenimientoProgramado i WHERE i.fechaRealizado = :fechaRealizado"),
    @NamedQuery(name = "InvMantenimientoProgramado.findByObservaciones", query = "SELECT i FROM InvMantenimientoProgramado i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "InvMantenimientoProgramado.findByEstado", query = "SELECT i FROM InvMantenimientoProgramado i WHERE i.estado = :estado")})
public class InvMantenimientoProgramado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private int idEquipo;
    @Column(name = "fecha_programado")
    @Temporal(TemporalType.DATE)
    private Date fechaProgramado;
    @Column(name = "fecha_realizado")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizado;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    @ManyToOne
    private InvEstatus idEstatus;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne
    private Usuario usuario;

    public InvMantenimientoProgramado() {
    }

    public InvMantenimientoProgramado(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public InvMantenimientoProgramado(Integer idMantenimiento, int idEquipo) {
        this.idMantenimiento = idMantenimiento;
        this.idEquipo = idEquipo;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Date getFechaProgramado() {
        return fechaProgramado;
    }

    public void setFechaProgramado(Date fechaProgramado) {
        this.fechaProgramado = fechaProgramado;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvMantenimientoProgramado)) {
            return false;
        }
        InvMantenimientoProgramado other = (InvMantenimientoProgramado) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvMantenimientoProgramado[ idMantenimiento=" + idMantenimiento + " ]";
    }
    
}
