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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "personal_institucion", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalInstitucion.findAll", query = "SELECT p FROM PersonalInstitucion p"),
    @NamedQuery(name = "PersonalInstitucion.findByIdInstitucion", query = "SELECT p FROM PersonalInstitucion p WHERE p.idInstitucion = :idInstitucion"),
    @NamedQuery(name = "PersonalInstitucion.findByDescripcion", query = "SELECT p FROM PersonalInstitucion p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PersonalInstitucion.findByIdestado", query = "SELECT p FROM PersonalInstitucion p WHERE p.idestado = :idestado")})
public class PersonalInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institucion")
    private Integer idInstitucion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "idestado")
    private Integer idestado;
    @OneToMany(mappedBy = "idinstitucion")
    private List<PersonalEstudios> personalEstudiosList;
    @OneToMany(mappedBy = "idInstitucion")
    private List<PersonalCurso> personalCursoList;
    @JoinColumn(name = "id_pais", referencedColumnName = "idper_pais_estudios")
    @ManyToOne
    private PersonalPaisEstudios idPais;

    public PersonalInstitucion() {
    }

    public PersonalInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    @XmlTransient
    public List<PersonalEstudios> getPersonalEstudiosList() {
        return personalEstudiosList;
    }

    public void setPersonalEstudiosList(List<PersonalEstudios> personalEstudiosList) {
        this.personalEstudiosList = personalEstudiosList;
    }

    @XmlTransient
    public List<PersonalCurso> getPersonalCursoList() {
        return personalCursoList;
    }

    public void setPersonalCursoList(List<PersonalCurso> personalCursoList) {
        this.personalCursoList = personalCursoList;
    }

    public PersonalPaisEstudios getIdPais() {
        return idPais;
    }

    public void setIdPais(PersonalPaisEstudios idPais) {
        this.idPais = idPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitucion != null ? idInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalInstitucion)) {
            return false;
        }
        PersonalInstitucion other = (PersonalInstitucion) object;
        if ((this.idInstitucion == null && other.idInstitucion != null) || (this.idInstitucion != null && !this.idInstitucion.equals(other.idInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PersonalInstitucion[ idInstitucion=" + idInstitucion + " ]";
    }
    
}
