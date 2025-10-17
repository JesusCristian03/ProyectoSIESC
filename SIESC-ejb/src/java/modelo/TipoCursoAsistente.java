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
@Table(name = "tipo_curso_asistente", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCursoAsistente.findAll", query = "SELECT t FROM TipoCursoAsistente t"),
    @NamedQuery(name = "TipoCursoAsistente.findByIdAsistente", query = "SELECT t FROM TipoCursoAsistente t WHERE t.idAsistente = :idAsistente"),
    @NamedQuery(name = "TipoCursoAsistente.findByTipoAsistente", query = "SELECT t FROM TipoCursoAsistente t WHERE t.tipoAsistente = :tipoAsistente")})
public class TipoCursoAsistente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asistente")
    private Integer idAsistente;
    @Column(name = "tipo_asistente")
    private String tipoAsistente;
    @OneToMany(mappedBy = "idTipoAsistente")
    private List<PersonalCursoAsistente> personalCursoAsistenteList;

    public TipoCursoAsistente() {
    }

    public TipoCursoAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
    }

    public Integer getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
    }

    public String getTipoAsistente() {
        return tipoAsistente;
    }

    public void setTipoAsistente(String tipoAsistente) {
        this.tipoAsistente = tipoAsistente;
    }

    @XmlTransient
    public List<PersonalCursoAsistente> getPersonalCursoAsistenteList() {
        return personalCursoAsistenteList;
    }

    public void setPersonalCursoAsistenteList(List<PersonalCursoAsistente> personalCursoAsistenteList) {
        this.personalCursoAsistenteList = personalCursoAsistenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistente != null ? idAsistente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCursoAsistente)) {
            return false;
        }
        TipoCursoAsistente other = (TipoCursoAsistente) object;
        if ((this.idAsistente == null && other.idAsistente != null) || (this.idAsistente != null && !this.idAsistente.equals(other.idAsistente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoCursoAsistente[ idAsistente=" + idAsistente + " ]";
    }
    
}
