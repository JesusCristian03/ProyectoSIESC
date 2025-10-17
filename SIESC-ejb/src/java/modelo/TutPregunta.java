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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "tut_pregunta", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TutPregunta.findAll", query = "SELECT t FROM TutPregunta t"),
    @NamedQuery(name = "TutPregunta.findByIdtutpregunta", query = "SELECT t FROM TutPregunta t WHERE t.idtutpregunta = :idtutpregunta"),
    @NamedQuery(name = "TutPregunta.findByDescripcion", query = "SELECT t FROM TutPregunta t WHERE t.descripcion = :descripcion")})
public class TutPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtutpregunta")
    private Integer idtutpregunta;
    @Column(name = "descripcion")
    private String descripcion;

    public TutPregunta() {
    }

    public TutPregunta(Integer idtutpregunta) {
        this.idtutpregunta = idtutpregunta;
    }

    public Integer getIdtutpregunta() {
        return idtutpregunta;
    }

    public void setIdtutpregunta(Integer idtutpregunta) {
        this.idtutpregunta = idtutpregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtutpregunta != null ? idtutpregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutPregunta)) {
            return false;
        }
        TutPregunta other = (TutPregunta) object;
        if ((this.idtutpregunta == null && other.idtutpregunta != null) || (this.idtutpregunta != null && !this.idtutpregunta.equals(other.idtutpregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TutPregunta[ idtutpregunta=" + idtutpregunta + " ]";
    }
    
}
