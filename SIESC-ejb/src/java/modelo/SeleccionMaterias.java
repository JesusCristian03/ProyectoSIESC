/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "seleccion_materias", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeleccionMaterias.findAll", query = "SELECT s FROM SeleccionMaterias s"),
    @NamedQuery(name = "SeleccionMaterias.findByGrupo", query = "SELECT s FROM SeleccionMaterias s WHERE s.grupo = :grupo"),
    @NamedQuery(name = "SeleccionMaterias.findByCalificacion", query = "SELECT s FROM SeleccionMaterias s WHERE s.calificacion = :calificacion"),
    @NamedQuery(name = "SeleccionMaterias.findByTipoEvaluacion", query = "SELECT s FROM SeleccionMaterias s WHERE s.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "SeleccionMaterias.findByRepeticion", query = "SELECT s FROM SeleccionMaterias s WHERE s.repeticion = :repeticion"),
    @NamedQuery(name = "SeleccionMaterias.findByNopresento", query = "SELECT s FROM SeleccionMaterias s WHERE s.nopresento = :nopresento"),
    @NamedQuery(name = "SeleccionMaterias.findByStatusSeleccion", query = "SELECT s FROM SeleccionMaterias s WHERE s.statusSeleccion = :statusSeleccion"),
    @NamedQuery(name = "SeleccionMaterias.findByFechaHoraSeleccion", query = "SELECT s FROM SeleccionMaterias s WHERE s.fechaHoraSeleccion = :fechaHoraSeleccion"),
    @NamedQuery(name = "SeleccionMaterias.findByGlobal", query = "SELECT s FROM SeleccionMaterias s WHERE s.global = :global"),
    @NamedQuery(name = "SeleccionMaterias.findByIdSm", query = "SELECT s FROM SeleccionMaterias s WHERE s.idSm = :idSm")})
public class SeleccionMaterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "grupo")
    private String grupo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion")
    private Double calificacion;
    @Column(name = "tipo_evaluacion")
    private String tipoEvaluacion;
    @Column(name = "repeticion")
    private Character repeticion;
    @Column(name = "nopresento")
    private Character nopresento;
    @Column(name = "status_seleccion")
    private Character statusSeleccion;
    @Column(name = "fecha_hora_seleccion")
    @Temporal(TemporalType.DATE)
    private Date fechaHoraSeleccion;
    @Column(name = "global")
    private Character global;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sm")
    private Integer idSm;
    @JoinColumn(name = "no_de_control", referencedColumnName = "no_de_control")
    @ManyToOne
    private Estudiante noDeControl;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private Grupos idGrupo;
    @JoinColumn(name = "materia", referencedColumnName = "materia")
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodo;

    public SeleccionMaterias() {
    }

    public SeleccionMaterias(Integer idSm) {
        this.idSm = idSm;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public Character getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(Character repeticion) {
        this.repeticion = repeticion;
    }

    public Character getNopresento() {
        return nopresento;
    }

    public void setNopresento(Character nopresento) {
        this.nopresento = nopresento;
    }

    public Character getStatusSeleccion() {
        return statusSeleccion;
    }

    public void setStatusSeleccion(Character statusSeleccion) {
        this.statusSeleccion = statusSeleccion;
    }

    public Date getFechaHoraSeleccion() {
        return fechaHoraSeleccion;
    }

    public void setFechaHoraSeleccion(Date fechaHoraSeleccion) {
        this.fechaHoraSeleccion = fechaHoraSeleccion;
    }

    public Character getGlobal() {
        return global;
    }

    public void setGlobal(Character global) {
        this.global = global;
    }

    public Integer getIdSm() {
        return idSm;
    }

    public void setIdSm(Integer idSm) {
        this.idSm = idSm;
    }

    public Estudiante getNoDeControl() {
        return noDeControl;
    }

    public void setNoDeControl(Estudiante noDeControl) {
        this.noDeControl = noDeControl;
    }

    public Grupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSm != null ? idSm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeleccionMaterias)) {
            return false;
        }
        SeleccionMaterias other = (SeleccionMaterias) object;
        if ((this.idSm == null && other.idSm != null) || (this.idSm != null && !this.idSm.equals(other.idSm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeleccionMaterias[ idSm=" + idSm + " ]";
    }
    
}
