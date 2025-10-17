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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "personal_estudios", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalEstudios.findAll", query = "SELECT p FROM PersonalEstudios p"),
    @NamedQuery(name = "PersonalEstudios.findByIdpersonalestudios", query = "SELECT p FROM PersonalEstudios p WHERE p.idpersonalestudios = :idpersonalestudios"),
    @NamedQuery(name = "PersonalEstudios.findByCarrera", query = "SELECT p FROM PersonalEstudios p WHERE p.carrera = :carrera"),
    @NamedQuery(name = "PersonalEstudios.findByCedula", query = "SELECT p FROM PersonalEstudios p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "PersonalEstudios.findByAnio", query = "SELECT p FROM PersonalEstudios p WHERE p.anio = :anio")})
public class PersonalEstudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonalestudios")
    private Integer idpersonalestudios;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "anio")
    private Integer anio;
    @JoinColumn(name = "nivel_escolar", referencedColumnName = "nivel_escolar")
    @ManyToOne
    private NivelEscolar nivelEscolar;
    @JoinColumn(name = "rfc", referencedColumnName = "rfc")
    @ManyToOne
    private Personal rfc;
    @JoinColumn(name = "idpersonalestudiosestado", referencedColumnName = "idper_est_edo")
    @ManyToOne
    private PersonalEstudiosEstado idpersonalestudiosestado;
    @JoinColumn(name = "idinstitucion", referencedColumnName = "id_institucion")
    @ManyToOne
    private PersonalInstitucion idinstitucion;

    public PersonalEstudios() {
    }

    public PersonalEstudios(Integer idpersonalestudios) {
        this.idpersonalestudios = idpersonalestudios;
    }

    public Integer getIdpersonalestudios() {
        return idpersonalestudios;
    }

    public void setIdpersonalestudios(Integer idpersonalestudios) {
        this.idpersonalestudios = idpersonalestudios;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public NivelEscolar getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(NivelEscolar nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public Personal getRfc() {
        return rfc;
    }

    public void setRfc(Personal rfc) {
        this.rfc = rfc;
    }

    public PersonalEstudiosEstado getIdpersonalestudiosestado() {
        return idpersonalestudiosestado;
    }

    public void setIdpersonalestudiosestado(PersonalEstudiosEstado idpersonalestudiosestado) {
        this.idpersonalestudiosestado = idpersonalestudiosestado;
    }

    public PersonalInstitucion getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(PersonalInstitucion idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonalestudios != null ? idpersonalestudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalEstudios)) {
            return false;
        }
        PersonalEstudios other = (PersonalEstudios) object;
        if ((this.idpersonalestudios == null && other.idpersonalestudios != null) || (this.idpersonalestudios != null && !this.idpersonalestudios.equals(other.idpersonalestudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PersonalEstudios[ idpersonalestudios=" + idpersonalestudios + " ]";
    }
    
}
