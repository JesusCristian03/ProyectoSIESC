/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "edificio", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e"),
    @NamedQuery(name = "Edificio.findByClave", query = "SELECT e FROM Edificio e WHERE e.clave = :clave"),
    @NamedQuery(name = "Edificio.findByDescripcion", query = "SELECT e FROM Edificio e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Edificio.findByObservacion", query = "SELECT e FROM Edificio e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "Edificio.findByCapacidad", query = "SELECT e FROM Edificio e WHERE e.capacidad = :capacidad"),
    @NamedQuery(name = "Edificio.findByStatus", query = "SELECT e FROM Edificio e WHERE e.status = :status")})
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "status")
    private Character status;
    @OneToMany(mappedBy = "edificio")
    private List<InvEquipo> invEquipoList;

    public Edificio() {
    }

    public Edificio(String clave) {
        this.clave = clave;
    }

    public Edificio(String clave, String descripcion, String observacion, int capacidad, Character status) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.capacidad = capacidad;
        this.status = status;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public List<InvEquipo> getInvEquipoList() {
        return invEquipoList;
    }

    public void setInvEquipoList(List<InvEquipo> invEquipoList) {
        this.invEquipoList = invEquipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Edificio[ clave=" + clave + " ]";
    }
    
}
