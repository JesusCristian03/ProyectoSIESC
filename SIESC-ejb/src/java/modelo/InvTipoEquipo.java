/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "inv_tipo_equipo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvTipoEquipo.findAll", query = "SELECT i FROM InvTipoEquipo i"),
    @NamedQuery(name = "InvTipoEquipo.findByIdTipo", query = "SELECT i FROM InvTipoEquipo i WHERE i.idTipo = :idTipo"),
    @NamedQuery(name = "InvTipoEquipo.findByDescripcion", query = "SELECT i FROM InvTipoEquipo i WHERE i.descripcion = :descripcion")})
public class InvTipoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<InvEquipo> invEquipoList;

    public InvTipoEquipo() {
    }

    public InvTipoEquipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public InvTipoEquipo(Integer idTipo, String descripcion) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTipoEquipo)) {
            return false;
        }
        InvTipoEquipo other = (InvTipoEquipo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvTipoEquipo[ idTipo=" + idTipo + " ]";
    }
    
}
