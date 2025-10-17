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
@Table(name = "nivel_escolar", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEscolar.findAll", query = "SELECT n FROM NivelEscolar n"),
    @NamedQuery(name = "NivelEscolar.findByNivelEscolar", query = "SELECT n FROM NivelEscolar n WHERE n.nivelEscolar = :nivelEscolar"),
    @NamedQuery(name = "NivelEscolar.findByDescripcionNivel", query = "SELECT n FROM NivelEscolar n WHERE n.descripcionNivel = :descripcionNivel")})
public class NivelEscolar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nivel_escolar")
    private String nivelEscolar;
    @Column(name = "descripcion_nivel")
    private String descripcionNivel;
    @OneToMany(mappedBy = "nivelEscolar")
    private List<PersonalEstudios> personalEstudiosList;
    @OneToMany(mappedBy = "nivelEscolar")
    private List<Materia> materiaList;

    public NivelEscolar() {
    }

    public NivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getDescripcionNivel() {
        return descripcionNivel;
    }

    public void setDescripcionNivel(String descripcionNivel) {
        this.descripcionNivel = descripcionNivel;
    }

    @XmlTransient
    public List<PersonalEstudios> getPersonalEstudiosList() {
        return personalEstudiosList;
    }

    public void setPersonalEstudiosList(List<PersonalEstudios> personalEstudiosList) {
        this.personalEstudiosList = personalEstudiosList;
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
        hash += (nivelEscolar != null ? nivelEscolar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEscolar)) {
            return false;
        }
        NivelEscolar other = (NivelEscolar) object;
        if ((this.nivelEscolar == null && other.nivelEscolar != null) || (this.nivelEscolar != null && !this.nivelEscolar.equals(other.nivelEscolar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.NivelEscolar[ nivelEscolar=" + nivelEscolar + " ]";
    }
    
}
