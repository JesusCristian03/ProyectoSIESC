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
@Table(name = "requisitos_materia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitosMateria.findAll", query = "SELECT r FROM RequisitosMateria r"),
    @NamedQuery(name = "RequisitosMateria.findByIdRequisitosMateria", query = "SELECT r FROM RequisitosMateria r WHERE r.idRequisitosMateria = :idRequisitosMateria"),
    @NamedQuery(name = "RequisitosMateria.findByReticula", query = "SELECT r FROM RequisitosMateria r WHERE r.reticula = :reticula"),
    @NamedQuery(name = "RequisitosMateria.findByTipoRequisito", query = "SELECT r FROM RequisitosMateria r WHERE r.tipoRequisito = :tipoRequisito")})
public class RequisitosMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_requisitos_materia")
    private Long idRequisitosMateria;
    @Column(name = "reticula")
    private Integer reticula;
    @Column(name = "tipo_requisito")
    private String tipoRequisito;
    @JoinColumn(name = "materia", referencedColumnName = "materia")
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "materia_relacion", referencedColumnName = "materia")
    @ManyToOne
    private Materia materiaRelacion;

    public RequisitosMateria() {
    }

    public RequisitosMateria(Long idRequisitosMateria) {
        this.idRequisitosMateria = idRequisitosMateria;
    }

    public Long getIdRequisitosMateria() {
        return idRequisitosMateria;
    }

    public void setIdRequisitosMateria(Long idRequisitosMateria) {
        this.idRequisitosMateria = idRequisitosMateria;
    }

    public Integer getReticula() {
        return reticula;
    }

    public void setReticula(Integer reticula) {
        this.reticula = reticula;
    }

    public String getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(String tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateriaRelacion() {
        return materiaRelacion;
    }

    public void setMateriaRelacion(Materia materiaRelacion) {
        this.materiaRelacion = materiaRelacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisitosMateria != null ? idRequisitosMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitosMateria)) {
            return false;
        }
        RequisitosMateria other = (RequisitosMateria) object;
        if ((this.idRequisitosMateria == null && other.idRequisitosMateria != null) || (this.idRequisitosMateria != null && !this.idRequisitosMateria.equals(other.idRequisitosMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RequisitosMateria[ idRequisitosMateria=" + idRequisitosMateria + " ]";
    }
    
}
