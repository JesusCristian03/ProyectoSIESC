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
@Table(name = "tornillo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tornillo.findAll", query = "SELECT t FROM Tornillo t"),
    @NamedQuery(name = "Tornillo.findByIdTornillo", query = "SELECT t FROM Tornillo t WHERE t.idTornillo = :idTornillo"),
    @NamedQuery(name = "Tornillo.findByDescripcion", query = "SELECT t FROM Tornillo t WHERE t.descripcion = :descripcion")})
public class Tornillo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tornillo")
    private String idTornillo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "tornilloEntrada")
    private List<Acceso> accesoList;
    @OneToMany(mappedBy = "tornilloSalida")
    private List<Acceso> accesoList1;

    public Tornillo() {
    }

    public Tornillo(String idTornillo) {
        this.idTornillo = idTornillo;
    }

    public String getIdTornillo() {
        return idTornillo;
    }

    public void setIdTornillo(String idTornillo) {
        this.idTornillo = idTornillo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    @XmlTransient
    public List<Acceso> getAccesoList1() {
        return accesoList1;
    }

    public void setAccesoList1(List<Acceso> accesoList1) {
        this.accesoList1 = accesoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTornillo != null ? idTornillo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tornillo)) {
            return false;
        }
        Tornillo other = (Tornillo) object;
        if ((this.idTornillo == null && other.idTornillo != null) || (this.idTornillo != null && !this.idTornillo.equals(other.idTornillo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tornillo[ idTornillo=" + idTornillo + " ]";
    }
    
}
