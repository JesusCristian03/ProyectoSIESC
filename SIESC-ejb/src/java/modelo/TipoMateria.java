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
@Table(name = "tipo_materia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMateria.findAll", query = "SELECT t FROM TipoMateria t"),
    @NamedQuery(name = "TipoMateria.findByTipoMateria", query = "SELECT t FROM TipoMateria t WHERE t.tipoMateria = :tipoMateria"),
    @NamedQuery(name = "TipoMateria.findByNombreTipo", query = "SELECT t FROM TipoMateria t WHERE t.nombreTipo = :nombreTipo")})
public class TipoMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_materia")
    private Integer tipoMateria;
    @Column(name = "nombre_tipo")
    private String nombreTipo;
    @OneToMany(mappedBy = "tipoMateria")
    private List<Materia> materiaList;

    public TipoMateria() {
    }

    public TipoMateria(Integer tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public Integer getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(Integer tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoMateria != null ? tipoMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMateria)) {
            return false;
        }
        TipoMateria other = (TipoMateria) object;
        if ((this.tipoMateria == null && other.tipoMateria != null) || (this.tipoMateria != null && !this.tipoMateria.equals(other.tipoMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoMateria[ tipoMateria=" + tipoMateria + " ]";
    }
    
}
