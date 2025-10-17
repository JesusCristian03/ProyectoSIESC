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
@Table(name = "mto_equipo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MtoEquipo.findAll", query = "SELECT m FROM MtoEquipo m"),
    @NamedQuery(name = "MtoEquipo.findByIdEquipo", query = "SELECT m FROM MtoEquipo m WHERE m.idEquipo = :idEquipo"),
    @NamedQuery(name = "MtoEquipo.findByClaveSep", query = "SELECT m FROM MtoEquipo m WHERE m.claveSep = :claveSep"),
    @NamedQuery(name = "MtoEquipo.findByClaveInventario", query = "SELECT m FROM MtoEquipo m WHERE m.claveInventario = :claveInventario"),
    @NamedQuery(name = "MtoEquipo.findByDescripcionEquipo", query = "SELECT m FROM MtoEquipo m WHERE m.descripcionEquipo = :descripcionEquipo")})
public class MtoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Column(name = "clave_sep")
    private String claveSep;
    @Column(name = "clave_inventario")
    private String claveInventario;
    @Column(name = "descripcion_equipo")
    private String descripcionEquipo;

    public MtoEquipo() {
    }

    public MtoEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getClaveSep() {
        return claveSep;
    }

    public void setClaveSep(String claveSep) {
        this.claveSep = claveSep;
    }

    public String getClaveInventario() {
        return claveInventario;
    }

    public void setClaveInventario(String claveInventario) {
        this.claveInventario = claveInventario;
    }

    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MtoEquipo)) {
            return false;
        }
        MtoEquipo other = (MtoEquipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MtoEquipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
