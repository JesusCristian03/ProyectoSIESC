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
@Table(name = "estatus_checada", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstatusChecada.findAll", query = "SELECT e FROM EstatusChecada e"),
    @NamedQuery(name = "EstatusChecada.findByIdEstatusc", query = "SELECT e FROM EstatusChecada e WHERE e.idEstatusc = :idEstatusc"),
    @NamedQuery(name = "EstatusChecada.findByDescripcion", query = "SELECT e FROM EstatusChecada e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstatusChecada.findByNivel", query = "SELECT e FROM EstatusChecada e WHERE e.nivel = :nivel")})
public class EstatusChecada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estatusc")
    private String idEstatusc;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nivel")
    private Integer nivel;
    @OneToMany(mappedBy = "estatusAsistencia")
    private List<CursoAsistencia> cursoAsistenciaList;
    @OneToMany(mappedBy = "idEstatusc")
    private List<AsistenciaAula> asistenciaAulaList;

    public EstatusChecada() {
    }

    public EstatusChecada(String idEstatusc) {
        this.idEstatusc = idEstatusc;
    }

    public String getIdEstatusc() {
        return idEstatusc;
    }

    public void setIdEstatusc(String idEstatusc) {
        this.idEstatusc = idEstatusc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<CursoAsistencia> getCursoAsistenciaList() {
        return cursoAsistenciaList;
    }

    public void setCursoAsistenciaList(List<CursoAsistencia> cursoAsistenciaList) {
        this.cursoAsistenciaList = cursoAsistenciaList;
    }

    @XmlTransient
    public List<AsistenciaAula> getAsistenciaAulaList() {
        return asistenciaAulaList;
    }

    public void setAsistenciaAulaList(List<AsistenciaAula> asistenciaAulaList) {
        this.asistenciaAulaList = asistenciaAulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatusc != null ? idEstatusc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusChecada)) {
            return false;
        }
        EstatusChecada other = (EstatusChecada) object;
        if ((this.idEstatusc == null && other.idEstatusc != null) || (this.idEstatusc != null && !this.idEstatusc.equals(other.idEstatusc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstatusChecada[ idEstatusc=" + idEstatusc + " ]";
    }
    
}
