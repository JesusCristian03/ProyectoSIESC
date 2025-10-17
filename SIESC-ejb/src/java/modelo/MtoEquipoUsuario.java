/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "mto_equipo_usuario", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MtoEquipoUsuario.findAll", query = "SELECT m FROM MtoEquipoUsuario m"),
    @NamedQuery(name = "MtoEquipoUsuario.findByIdMtoEquipoUsuario", query = "SELECT m FROM MtoEquipoUsuario m WHERE m.idMtoEquipoUsuario = :idMtoEquipoUsuario"),
    @NamedQuery(name = "MtoEquipoUsuario.findByIdEquipo", query = "SELECT m FROM MtoEquipoUsuario m WHERE m.idEquipo = :idEquipo"),
    @NamedQuery(name = "MtoEquipoUsuario.findByClave", query = "SELECT m FROM MtoEquipoUsuario m WHERE m.clave = :clave")})
public class MtoEquipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mto_equipo_usuario")
    private Integer idMtoEquipoUsuario;
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Column(name = "clave")
    private String clave;

    public MtoEquipoUsuario() {
    }

    public MtoEquipoUsuario(Integer idMtoEquipoUsuario) {
        this.idMtoEquipoUsuario = idMtoEquipoUsuario;
    }

    public Integer getIdMtoEquipoUsuario() {
        return idMtoEquipoUsuario;
    }

    public void setIdMtoEquipoUsuario(Integer idMtoEquipoUsuario) {
        this.idMtoEquipoUsuario = idMtoEquipoUsuario;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMtoEquipoUsuario != null ? idMtoEquipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MtoEquipoUsuario)) {
            return false;
        }
        MtoEquipoUsuario other = (MtoEquipoUsuario) object;
        if ((this.idMtoEquipoUsuario == null && other.idMtoEquipoUsuario != null) || (this.idMtoEquipoUsuario != null && !this.idMtoEquipoUsuario.equals(other.idMtoEquipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MtoEquipoUsuario[ idMtoEquipoUsuario=" + idMtoEquipoUsuario + " ]";
    }
    
}
