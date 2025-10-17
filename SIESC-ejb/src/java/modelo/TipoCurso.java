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
@Table(name = "tipo_curso", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCurso.findAll", query = "SELECT t FROM TipoCurso t"),
    @NamedQuery(name = "TipoCurso.findByIdTipoCurso", query = "SELECT t FROM TipoCurso t WHERE t.idTipoCurso = :idTipoCurso"),
    @NamedQuery(name = "TipoCurso.findByNombreCurso", query = "SELECT t FROM TipoCurso t WHERE t.nombreCurso = :nombreCurso")})
public class TipoCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_curso")
    private Integer idTipoCurso;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @OneToMany(mappedBy = "idTipoCurso")
    private List<PersonalCurso> personalCursoList;

    public TipoCurso() {
    }

    public TipoCurso(Integer idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public Integer getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(Integer idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @XmlTransient
    public List<PersonalCurso> getPersonalCursoList() {
        return personalCursoList;
    }

    public void setPersonalCursoList(List<PersonalCurso> personalCursoList) {
        this.personalCursoList = personalCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCurso != null ? idTipoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCurso)) {
            return false;
        }
        TipoCurso other = (TipoCurso) object;
        if ((this.idTipoCurso == null && other.idTipoCurso != null) || (this.idTipoCurso != null && !this.idTipoCurso.equals(other.idTipoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoCurso[ idTipoCurso=" + idTipoCurso + " ]";
    }
    
}
