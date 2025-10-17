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
@Table(name = "personal_curso", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalCurso.findAll", query = "SELECT p FROM PersonalCurso p"),
    @NamedQuery(name = "PersonalCurso.findByIdCurso", query = "SELECT p FROM PersonalCurso p WHERE p.idCurso = :idCurso"),
    @NamedQuery(name = "PersonalCurso.findByNombreCurso", query = "SELECT p FROM PersonalCurso p WHERE p.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "PersonalCurso.findByAnio", query = "SELECT p FROM PersonalCurso p WHERE p.anio = :anio"),
    @NamedQuery(name = "PersonalCurso.findByHoras", query = "SELECT p FROM PersonalCurso p WHERE p.horas = :horas"),
    @NamedQuery(name = "PersonalCurso.findByObservaciones", query = "SELECT p FROM PersonalCurso p WHERE p.observaciones = :observaciones")})
public class PersonalCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "horas")
    private Integer horas;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idCurso")
    private List<PersonalCursoAsistente> personalCursoAsistenteList;
    @JoinColumn(name = "id_institucion", referencedColumnName = "id_institucion")
    @ManyToOne
    private PersonalInstitucion idInstitucion;
    @JoinColumn(name = "id_tipo_curso", referencedColumnName = "id_tipo_curso")
    @ManyToOne
    private TipoCurso idTipoCurso;

    public PersonalCurso() {
    }

    public PersonalCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<PersonalCursoAsistente> getPersonalCursoAsistenteList() {
        return personalCursoAsistenteList;
    }

    public void setPersonalCursoAsistenteList(List<PersonalCursoAsistente> personalCursoAsistenteList) {
        this.personalCursoAsistenteList = personalCursoAsistenteList;
    }

    public PersonalInstitucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(PersonalInstitucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public TipoCurso getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(TipoCurso idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalCurso)) {
            return false;
        }
        PersonalCurso other = (PersonalCurso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PersonalCurso[ idCurso=" + idCurso + " ]";
    }
    
}
