/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "inv_equipo_inventario", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvEquipoInventario.findAll", query = "SELECT i FROM InvEquipoInventario i"),
    @NamedQuery(name = "InvEquipoInventario.findByIdEquipoInventario", query = "SELECT i FROM InvEquipoInventario i WHERE i.idEquipoInventario = :idEquipoInventario"),
    @NamedQuery(name = "InvEquipoInventario.findByObservaciones", query = "SELECT i FROM InvEquipoInventario i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "InvEquipoInventario.findByClaveInventario", query = "SELECT i FROM InvEquipoInventario i WHERE i.claveInventario = :claveInventario"),
    @NamedQuery(name = "InvEquipoInventario.findByEstado", query = "SELECT i FROM InvEquipoInventario i WHERE i.estado = :estado"),
    @NamedQuery(name = "InvEquipoInventario.findByUsuarioAlta", query = "SELECT i FROM InvEquipoInventario i WHERE i.usuarioAlta = :usuarioAlta"),
    @NamedQuery(name = "InvEquipoInventario.findByFechaAlta", query = "SELECT i FROM InvEquipoInventario i WHERE i.fechaAlta = :fechaAlta")})
public class InvEquipoInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipo_inventario")
    private String idEquipoInventario;
    @Basic(optional = false)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "clave_inventario")
    private String claveInventario;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Column(name = "usuario_alta")
    private String usuarioAlta;
    @Column(name = "fecha_alta")
    private String fechaAlta;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private InvEquipo idEquipo;

    public InvEquipoInventario() {
    }

    public InvEquipoInventario(String idEquipoInventario) {
        this.idEquipoInventario = idEquipoInventario;
    }

    public InvEquipoInventario(String idEquipoInventario, String observaciones, String claveInventario, String estado) {
        this.idEquipoInventario = idEquipoInventario;
        this.observaciones = observaciones;
        this.claveInventario = claveInventario;
        this.estado = estado;
    }

    public String getIdEquipoInventario() {
        return idEquipoInventario;
    }

    public void setIdEquipoInventario(String idEquipoInventario) {
        this.idEquipoInventario = idEquipoInventario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getClaveInventario() {
        return claveInventario;
    }

    public void setClaveInventario(String claveInventario) {
        this.claveInventario = claveInventario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public InvEquipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(InvEquipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoInventario != null ? idEquipoInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvEquipoInventario)) {
            return false;
        }
        InvEquipoInventario other = (InvEquipoInventario) object;
        if ((this.idEquipoInventario == null && other.idEquipoInventario != null) || (this.idEquipoInventario != null && !this.idEquipoInventario.equals(other.idEquipoInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvEquipoInventario[ idEquipoInventario=" + idEquipoInventario + " ]";
    }
    
}
