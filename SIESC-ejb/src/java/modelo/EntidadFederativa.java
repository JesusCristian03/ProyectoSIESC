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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "entidad_federativa", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadFederativa.findAll", query = "SELECT e FROM EntidadFederativa e"),
    @NamedQuery(name = "EntidadFederativa.findByIdentidad", query = "SELECT e FROM EntidadFederativa e WHERE e.identidad = :identidad"),
    @NamedQuery(name = "EntidadFederativa.findByNombreEntidad", query = "SELECT e FROM EntidadFederativa e WHERE e.nombreEntidad = :nombreEntidad"),
    @NamedQuery(name = "EntidadFederativa.findByClaveEntidad", query = "SELECT e FROM EntidadFederativa e WHERE e.claveEntidad = :claveEntidad")})
public class EntidadFederativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identidad")
    private Integer identidad;
    @Column(name = "nombre_entidad")
    private String nombreEntidad;
    @Column(name = "clave_entidad")
    private String claveEntidad;

    public EntidadFederativa() {
    }

    public EntidadFederativa(Integer identidad) {
        this.identidad = identidad;
    }

    public Integer getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Integer identidad) {
        this.identidad = identidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getClaveEntidad() {
        return claveEntidad;
    }

    public void setClaveEntidad(String claveEntidad) {
        this.claveEntidad = claveEntidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identidad != null ? identidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadFederativa)) {
            return false;
        }
        EntidadFederativa other = (EntidadFederativa) object;
        if ((this.identidad == null && other.identidad != null) || (this.identidad != null && !this.identidad.equals(other.identidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EntidadFederativa[ identidad=" + identidad + " ]";
    }
    
}
