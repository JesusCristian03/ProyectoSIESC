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
@Table(name = "materia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByMateria", query = "SELECT m FROM Materia m WHERE m.materia = :materia"),
    @NamedQuery(name = "Materia.findByNombreCompletoMateria", query = "SELECT m FROM Materia m WHERE m.nombreCompletoMateria = :nombreCompletoMateria"),
    @NamedQuery(name = "Materia.findByNombreAbreviadoMateria", query = "SELECT m FROM Materia m WHERE m.nombreAbreviadoMateria = :nombreAbreviadoMateria")})
public class Materia implements Serializable {

    @OneToMany(mappedBy = "materia")
    private List<RequisitosMateria> requisitosMateriaList;
    @OneToMany(mappedBy = "materiaRelacion")
    private List<RequisitosMateria> requisitosMateriaList1;

    @OneToMany(mappedBy = "materia")
    private List<HistoriaAlumno> historiaAlumnoList;

    @OneToMany(mappedBy = "materia")
    private List<SeleccionMateriasLog> seleccionMateriasLogList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "materia")
    private String materia;
    @Basic(optional = false)
    @Column(name = "nombre_completo_materia")
    private String nombreCompletoMateria;
    @Basic(optional = false)
    @Column(name = "nombre_abreviado_materia")
    private String nombreAbreviadoMateria;
    @OneToMany(mappedBy = "materia")
    private List<SeleccionMaterias> seleccionMateriasList;
    @OneToMany(mappedBy = "materia")
    private List<Horarios> horariosList;
    @OneToMany(mappedBy = "materia")
    private List<MateriasCarreras> materiasCarrerasList;
    @JoinColumn(name = "nivel_escolar", referencedColumnName = "nivel_escolar")
    @ManyToOne
    private NivelEscolar nivelEscolar;
    @JoinColumn(name = "clave_area", referencedColumnName = "clave_area")
    @ManyToOne
    private Organigrama claveArea;
    @JoinColumn(name = "tipo_materia", referencedColumnName = "tipo_materia")
    @ManyToOne
    private TipoMateria tipoMateria;

    public Materia() {
    }

    public Materia(String materia) {
        this.materia = materia;
    }

    public Materia(String materia, String nombreCompletoMateria, String nombreAbreviadoMateria) {
        this.materia = materia;
        this.nombreCompletoMateria = nombreCompletoMateria;
        this.nombreAbreviadoMateria = nombreAbreviadoMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombreCompletoMateria() {
        return nombreCompletoMateria;
    }

    public void setNombreCompletoMateria(String nombreCompletoMateria) {
        this.nombreCompletoMateria = nombreCompletoMateria;
    }

    public String getNombreAbreviadoMateria() {
        return nombreAbreviadoMateria;
    }

    public void setNombreAbreviadoMateria(String nombreAbreviadoMateria) {
        this.nombreAbreviadoMateria = nombreAbreviadoMateria;
    }

    @XmlTransient
    public List<SeleccionMaterias> getSeleccionMateriasList() {
        return seleccionMateriasList;
    }

    public void setSeleccionMateriasList(List<SeleccionMaterias> seleccionMateriasList) {
        this.seleccionMateriasList = seleccionMateriasList;
    }

    @XmlTransient
    public List<Horarios> getHorariosList() {
        return horariosList;
    }

    public void setHorariosList(List<Horarios> horariosList) {
        this.horariosList = horariosList;
    }

    @XmlTransient
    public List<MateriasCarreras> getMateriasCarrerasList() {
        return materiasCarrerasList;
    }

    public void setMateriasCarrerasList(List<MateriasCarreras> materiasCarrerasList) {
        this.materiasCarrerasList = materiasCarrerasList;
    }

    public NivelEscolar getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(NivelEscolar nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public Organigrama getClaveArea() {
        return claveArea;
    }

    public void setClaveArea(Organigrama claveArea) {
        this.claveArea = claveArea;
    }

    public TipoMateria getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(TipoMateria tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materia != null ? materia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materia == null && other.materia != null) || (this.materia != null && !this.materia.equals(other.materia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Materia[ materia=" + materia + " ]";
    }

    @XmlTransient
    public List<SeleccionMateriasLog> getSeleccionMateriasLogList() {
        return seleccionMateriasLogList;
    }

    public void setSeleccionMateriasLogList(List<SeleccionMateriasLog> seleccionMateriasLogList) {
        this.seleccionMateriasLogList = seleccionMateriasLogList;
    }

    @XmlTransient
    public List<HistoriaAlumno> getHistoriaAlumnoList() {
        return historiaAlumnoList;
    }

    public void setHistoriaAlumnoList(List<HistoriaAlumno> historiaAlumnoList) {
        this.historiaAlumnoList = historiaAlumnoList;
    }

    @XmlTransient
    public List<RequisitosMateria> getRequisitosMateriaList() {
        return requisitosMateriaList;
    }

    public void setRequisitosMateriaList(List<RequisitosMateria> requisitosMateriaList) {
        this.requisitosMateriaList = requisitosMateriaList;
    }

    @XmlTransient
    public List<RequisitosMateria> getRequisitosMateriaList1() {
        return requisitosMateriaList1;
    }

    public void setRequisitosMateriaList1(List<RequisitosMateria> requisitosMateriaList1) {
        this.requisitosMateriaList1 = requisitosMateriaList1;
    }
    
}
