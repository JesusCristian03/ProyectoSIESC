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
@Table(name = "tipo_evaluacion", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvaluacion.findAll", query = "SELECT t FROM TipoEvaluacion t"),
    @NamedQuery(name = "TipoEvaluacion.findByPlanDeEstudios", query = "SELECT t FROM TipoEvaluacion t WHERE t.planDeEstudios = :planDeEstudios"),
    @NamedQuery(name = "TipoEvaluacion.findByTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "TipoEvaluacion.findByDescripcionEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.descripcionEvaluacion = :descripcionEvaluacion"),
    @NamedQuery(name = "TipoEvaluacion.findByDescripcionCortaEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.descripcionCortaEvaluacion = :descripcionCortaEvaluacion"),
    @NamedQuery(name = "TipoEvaluacion.findByCalifMinimaAprobatoria", query = "SELECT t FROM TipoEvaluacion t WHERE t.califMinimaAprobatoria = :califMinimaAprobatoria"),
    @NamedQuery(name = "TipoEvaluacion.findByUsocurso", query = "SELECT t FROM TipoEvaluacion t WHERE t.usocurso = :usocurso"),
    @NamedQuery(name = "TipoEvaluacion.findByNosegundas", query = "SELECT t FROM TipoEvaluacion t WHERE t.nosegundas = :nosegundas"),
    @NamedQuery(name = "TipoEvaluacion.findByOrden", query = "SELECT t FROM TipoEvaluacion t WHERE t.orden = :orden"),
    @NamedQuery(name = "TipoEvaluacion.findByPrioridad", query = "SELECT t FROM TipoEvaluacion t WHERE t.prioridad = :prioridad")})
public class TipoEvaluacion implements Serializable {

    @OneToMany(mappedBy = "tipoEvaluacion")
    private List<HistoriaAlumno> historiaAlumnoList;

    private static final long serialVersionUID = 1L;
    @Column(name = "plan_de_estudios")
    private Integer planDeEstudios;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_evaluacion")
    private String tipoEvaluacion;
    @Column(name = "descripcion_evaluacion")
    private String descripcionEvaluacion;
    @Column(name = "descripcion_corta_evaluacion")
    private String descripcionCortaEvaluacion;
    @Column(name = "calif_minima_aprobatoria")
    private Integer califMinimaAprobatoria;
    @Column(name = "usocurso")
    private Character usocurso;
    @Column(name = "nosegundas")
    private Character nosegundas;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "prioridad")
    private Integer prioridad;

    public TipoEvaluacion() {
    }

    public TipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public Integer getPlanDeEstudios() {
        return planDeEstudios;
    }

    public void setPlanDeEstudios(Integer planDeEstudios) {
        this.planDeEstudios = planDeEstudios;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getDescripcionEvaluacion() {
        return descripcionEvaluacion;
    }

    public void setDescripcionEvaluacion(String descripcionEvaluacion) {
        this.descripcionEvaluacion = descripcionEvaluacion;
    }

    public String getDescripcionCortaEvaluacion() {
        return descripcionCortaEvaluacion;
    }

    public void setDescripcionCortaEvaluacion(String descripcionCortaEvaluacion) {
        this.descripcionCortaEvaluacion = descripcionCortaEvaluacion;
    }

    public Integer getCalifMinimaAprobatoria() {
        return califMinimaAprobatoria;
    }

    public void setCalifMinimaAprobatoria(Integer califMinimaAprobatoria) {
        this.califMinimaAprobatoria = califMinimaAprobatoria;
    }

    public Character getUsocurso() {
        return usocurso;
    }

    public void setUsocurso(Character usocurso) {
        this.usocurso = usocurso;
    }

    public Character getNosegundas() {
        return nosegundas;
    }

    public void setNosegundas(Character nosegundas) {
        this.nosegundas = nosegundas;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEvaluacion != null ? tipoEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacion)) {
            return false;
        }
        TipoEvaluacion other = (TipoEvaluacion) object;
        if ((this.tipoEvaluacion == null && other.tipoEvaluacion != null) || (this.tipoEvaluacion != null && !this.tipoEvaluacion.equals(other.tipoEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoEvaluacion[ tipoEvaluacion=" + tipoEvaluacion + " ]";
    }

    @XmlTransient
    public List<HistoriaAlumno> getHistoriaAlumnoList() {
        return historiaAlumnoList;
    }

    public void setHistoriaAlumnoList(List<HistoriaAlumno> historiaAlumnoList) {
        this.historiaAlumnoList = historiaAlumnoList;
    }
    
}
