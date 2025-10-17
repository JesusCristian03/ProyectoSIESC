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
@Table(name = "personal_curso_asistente", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalCursoAsistente.findAll", query = "SELECT p FROM PersonalCursoAsistente p"),
    @NamedQuery(name = "PersonalCursoAsistente.findByIdCursoAsistente", query = "SELECT p FROM PersonalCursoAsistente p WHERE p.idCursoAsistente = :idCursoAsistente"),
    @NamedQuery(name = "PersonalCursoAsistente.findByObservaciones", query = "SELECT p FROM PersonalCursoAsistente p WHERE p.observaciones = :observaciones")})
public class PersonalCursoAsistente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_asistente")
    private Integer idCursoAsistente;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "rfc", referencedColumnName = "rfc")
    @ManyToOne
    private Personal rfc;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private PersonalCurso idCurso;
    @JoinColumn(name = "id_tipo_asistente", referencedColumnName = "id_asistente")
    @ManyToOne
    private TipoCursoAsistente idTipoAsistente;

    public PersonalCursoAsistente() {
    }

    public PersonalCursoAsistente(Integer idCursoAsistente) {
        this.idCursoAsistente = idCursoAsistente;
    }

    public Integer getIdCursoAsistente() {
        return idCursoAsistente;
    }

    public void setIdCursoAsistente(Integer idCursoAsistente) {
        this.idCursoAsistente = idCursoAsistente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Personal getRfc() {
        return rfc;
    }

    public void setRfc(Personal rfc) {
        this.rfc = rfc;
    }

    public PersonalCurso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(PersonalCurso idCurso) {
        this.idCurso = idCurso;
    }

    public TipoCursoAsistente getIdTipoAsistente() {
        return idTipoAsistente;
    }

    public void setIdTipoAsistente(TipoCursoAsistente idTipoAsistente) {
        this.idTipoAsistente = idTipoAsistente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoAsistente != null ? idCursoAsistente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalCursoAsistente)) {
            return false;
        }
        PersonalCursoAsistente other = (PersonalCursoAsistente) object;
        if ((this.idCursoAsistente == null && other.idCursoAsistente != null) || (this.idCursoAsistente != null && !this.idCursoAsistente.equals(other.idCursoAsistente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PersonalCursoAsistente[ idCursoAsistente=" + idCursoAsistente + " ]";
    }
    
}
