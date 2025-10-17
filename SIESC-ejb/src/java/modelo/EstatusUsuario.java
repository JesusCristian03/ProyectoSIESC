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
@Table(name = "estatus_usuario", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstatusUsuario.findAll", query = "SELECT e FROM EstatusUsuario e"),
    @NamedQuery(name = "EstatusUsuario.findByIdestatus", query = "SELECT e FROM EstatusUsuario e WHERE e.idestatus = :idestatus"),
    @NamedQuery(name = "EstatusUsuario.findByEstatus", query = "SELECT e FROM EstatusUsuario e WHERE e.estatus = :estatus")})
public class EstatusUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestatus")
    private Integer idestatus;
    @Basic(optional = false)
    @Column(name = "estatus")
    private String estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestatus")
    private List<Usuario> usuarioList;

    public EstatusUsuario() {
    }

    public EstatusUsuario(Integer idestatus) {
        this.idestatus = idestatus;
    }

    public EstatusUsuario(Integer idestatus, String estatus) {
        this.idestatus = idestatus;
        this.estatus = estatus;
    }

    public Integer getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(Integer idestatus) {
        this.idestatus = idestatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestatus != null ? idestatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusUsuario)) {
            return false;
        }
        EstatusUsuario other = (EstatusUsuario) object;
        if ((this.idestatus == null && other.idestatus != null) || (this.idestatus != null && !this.idestatus.equals(other.idestatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstatusUsuario[ idestatus=" + idestatus + " ]";
    }
    
}
