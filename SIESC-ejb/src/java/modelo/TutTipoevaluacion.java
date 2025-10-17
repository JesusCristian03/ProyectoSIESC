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
@Table(name = "tut_tipoevaluacion", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TutTipoevaluacion.findAll", query = "SELECT t FROM TutTipoevaluacion t"),
    @NamedQuery(name = "TutTipoevaluacion.findByIdtuttipoevaluacion", query = "SELECT t FROM TutTipoevaluacion t WHERE t.idtuttipoevaluacion = :idtuttipoevaluacion"),
    @NamedQuery(name = "TutTipoevaluacion.findByTutTipo", query = "SELECT t FROM TutTipoevaluacion t WHERE t.tutTipo = :tutTipo"),
    @NamedQuery(name = "TutTipoevaluacion.findByTutTipoDescripcion", query = "SELECT t FROM TutTipoevaluacion t WHERE t.tutTipoDescripcion = :tutTipoDescripcion"),
    @NamedQuery(name = "TutTipoevaluacion.findByValor", query = "SELECT t FROM TutTipoevaluacion t WHERE t.valor = :valor")})
public class TutTipoevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtuttipoevaluacion")
    private Integer idtuttipoevaluacion;
    @Column(name = "tut_tipo")
    private String tutTipo;
    @Column(name = "tut_tipo_descripcion")
    private String tutTipoDescripcion;
    @Column(name = "valor")
    private Integer valor;

    public TutTipoevaluacion() {
    }

    public TutTipoevaluacion(Integer idtuttipoevaluacion) {
        this.idtuttipoevaluacion = idtuttipoevaluacion;
    }

    public Integer getIdtuttipoevaluacion() {
        return idtuttipoevaluacion;
    }

    public void setIdtuttipoevaluacion(Integer idtuttipoevaluacion) {
        this.idtuttipoevaluacion = idtuttipoevaluacion;
    }

    public String getTutTipo() {
        return tutTipo;
    }

    public void setTutTipo(String tutTipo) {
        this.tutTipo = tutTipo;
    }

    public String getTutTipoDescripcion() {
        return tutTipoDescripcion;
    }

    public void setTutTipoDescripcion(String tutTipoDescripcion) {
        this.tutTipoDescripcion = tutTipoDescripcion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtuttipoevaluacion != null ? idtuttipoevaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutTipoevaluacion)) {
            return false;
        }
        TutTipoevaluacion other = (TutTipoevaluacion) object;
        if ((this.idtuttipoevaluacion == null && other.idtuttipoevaluacion != null) || (this.idtuttipoevaluacion != null && !this.idtuttipoevaluacion.equals(other.idtuttipoevaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TutTipoevaluacion[ idtuttipoevaluacion=" + idtuttipoevaluacion + " ]";
    }
    
}
