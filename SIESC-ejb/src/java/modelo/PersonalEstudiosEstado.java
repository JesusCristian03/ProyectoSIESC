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
@Table(name = "personal_estudios_estado", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalEstudiosEstado.findAll", query = "SELECT p FROM PersonalEstudiosEstado p"),
    @NamedQuery(name = "PersonalEstudiosEstado.findByIdperEstEdo", query = "SELECT p FROM PersonalEstudiosEstado p WHERE p.idperEstEdo = :idperEstEdo"),
    @NamedQuery(name = "PersonalEstudiosEstado.findByDescripcion", query = "SELECT p FROM PersonalEstudiosEstado p WHERE p.descripcion = :descripcion")})
public class PersonalEstudiosEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idper_est_edo")
    private Integer idperEstEdo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idpersonalestudiosestado")
    private List<PersonalEstudios> personalEstudiosList;

    public PersonalEstudiosEstado() {
    }

    public PersonalEstudiosEstado(Integer idperEstEdo) {
        this.idperEstEdo = idperEstEdo;
    }

    public Integer getIdperEstEdo() {
        return idperEstEdo;
    }

    public void setIdperEstEdo(Integer idperEstEdo) {
        this.idperEstEdo = idperEstEdo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PersonalEstudios> getPersonalEstudiosList() {
        return personalEstudiosList;
    }

    public void setPersonalEstudiosList(List<PersonalEstudios> personalEstudiosList) {
        this.personalEstudiosList = personalEstudiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperEstEdo != null ? idperEstEdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalEstudiosEstado)) {
            return false;
        }
        PersonalEstudiosEstado other = (PersonalEstudiosEstado) object;
        if ((this.idperEstEdo == null && other.idperEstEdo != null) || (this.idperEstEdo != null && !this.idperEstEdo.equals(other.idperEstEdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PersonalEstudiosEstado[ idperEstEdo=" + idperEstEdo + " ]";
    }

}
