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
@Table(name = "personal_pais_estudios", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalPaisEstudios.findAll", query = "SELECT p FROM PersonalPaisEstudios p"),
    @NamedQuery(name = "PersonalPaisEstudios.findByIdperPaisEstudios", query = "SELECT p FROM PersonalPaisEstudios p WHERE p.idperPaisEstudios = :idperPaisEstudios"),
    @NamedQuery(name = "PersonalPaisEstudios.findByNombrePais", query = "SELECT p FROM PersonalPaisEstudios p WHERE p.nombrePais = :nombrePais")})
public class PersonalPaisEstudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idper_pais_estudios")
    private Integer idperPaisEstudios;
    @Column(name = "nombre_pais")
    private String nombrePais;
    @OneToMany(mappedBy = "idPais")
    private List<PersonalInstitucion> personalInstitucionList;

    public PersonalPaisEstudios() {
    }

    public PersonalPaisEstudios(Integer idperPaisEstudios) {
        this.idperPaisEstudios = idperPaisEstudios;
    }

    public Integer getIdperPaisEstudios() {
        return idperPaisEstudios;
    }

    public void setIdperPaisEstudios(Integer idperPaisEstudios) {
        this.idperPaisEstudios = idperPaisEstudios;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @XmlTransient
    public List<PersonalInstitucion> getPersonalInstitucionList() {
        return personalInstitucionList;
    }

    public void setPersonalInstitucionList(List<PersonalInstitucion> personalInstitucionList) {
        this.personalInstitucionList = personalInstitucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperPaisEstudios != null ? idperPaisEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalPaisEstudios)) {
            return false;
        }
        PersonalPaisEstudios other = (PersonalPaisEstudios) object;
        if ((this.idperPaisEstudios == null && other.idperPaisEstudios != null) || (this.idperPaisEstudios != null && !this.idperPaisEstudios.equals(other.idperPaisEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PersonalPaisEstudios[ idperPaisEstudios=" + idperPaisEstudios + " ]";
    }
    
}
