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
@Table(name = "materias_carreras", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriasCarreras.findAll", query = "SELECT m FROM MateriasCarreras m"),
    @NamedQuery(name = "MateriasCarreras.findByCarrera", query = "SELECT m FROM MateriasCarreras m WHERE m.carrera = :carrera"),
    @NamedQuery(name = "MateriasCarreras.findByCreditosMateria", query = "SELECT m FROM MateriasCarreras m WHERE m.creditosMateria = :creditosMateria"),
    @NamedQuery(name = "MateriasCarreras.findByHorasTeoricas", query = "SELECT m FROM MateriasCarreras m WHERE m.horasTeoricas = :horasTeoricas"),
    @NamedQuery(name = "MateriasCarreras.findByHorasPracticas", query = "SELECT m FROM MateriasCarreras m WHERE m.horasPracticas = :horasPracticas"),
    @NamedQuery(name = "MateriasCarreras.findByOrdenCertificado", query = "SELECT m FROM MateriasCarreras m WHERE m.ordenCertificado = :ordenCertificado"),
    @NamedQuery(name = "MateriasCarreras.findBySemestreReticula", query = "SELECT m FROM MateriasCarreras m WHERE m.semestreReticula = :semestreReticula"),
    @NamedQuery(name = "MateriasCarreras.findByCreditosPrerequisito", query = "SELECT m FROM MateriasCarreras m WHERE m.creditosPrerequisito = :creditosPrerequisito"),
    @NamedQuery(name = "MateriasCarreras.findByEspecialidad", query = "SELECT m FROM MateriasCarreras m WHERE m.especialidad = :especialidad"),
    @NamedQuery(name = "MateriasCarreras.findByClaveOficialMateria", query = "SELECT m FROM MateriasCarreras m WHERE m.claveOficialMateria = :claveOficialMateria"),
    @NamedQuery(name = "MateriasCarreras.findByEstatusMateriaCarrera", query = "SELECT m FROM MateriasCarreras m WHERE m.estatusMateriaCarrera = :estatusMateriaCarrera"),
    @NamedQuery(name = "MateriasCarreras.findByProgramaEstudios", query = "SELECT m FROM MateriasCarreras m WHERE m.programaEstudios = :programaEstudios"),
    @NamedQuery(name = "MateriasCarreras.findByRenglon", query = "SELECT m FROM MateriasCarreras m WHERE m.renglon = :renglon"),
    @NamedQuery(name = "MateriasCarreras.findByIdMateriaCarrera", query = "SELECT m FROM MateriasCarreras m WHERE m.idMateriaCarrera = :idMateriaCarrera")})
public class MateriasCarreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "creditos_materia")
    private Integer creditosMateria;
    @Column(name = "horas_teoricas")
    private Integer horasTeoricas;
    @Column(name = "horas_practicas")
    private Integer horasPracticas;
    @Column(name = "orden_certificado")
    private Integer ordenCertificado;
    @Column(name = "semestre_reticula")
    private Integer semestreReticula;
    @Column(name = "creditos_prerequisito")
    private Integer creditosPrerequisito;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "clave_oficial_materia")
    private String claveOficialMateria;
    @Column(name = "estatus_materia_carrera")
    private Character estatusMateriaCarrera;
    @Column(name = "programa_estudios")
    private String programaEstudios;
    @Column(name = "renglon")
    private Integer renglon;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia_carrera")
    private Integer idMateriaCarrera;
    @JoinColumn(name = "reticula", referencedColumnName = "reticula")
    @ManyToOne
    private Carrera reticula;
    @JoinColumn(name = "materia", referencedColumnName = "materia")
    @ManyToOne
    private Materia materia;
    @OneToMany(mappedBy = "idMateriaCarrera")
    private List<Grupos> gruposList;

    public MateriasCarreras() {
    }

    public MateriasCarreras(Integer idMateriaCarrera) {
        this.idMateriaCarrera = idMateriaCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getCreditosMateria() {
        return creditosMateria;
    }

    public void setCreditosMateria(Integer creditosMateria) {
        this.creditosMateria = creditosMateria;
    }

    public Integer getHorasTeoricas() {
        return horasTeoricas;
    }

    public void setHorasTeoricas(Integer horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }

    public Integer getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(Integer horasPracticas) {
        this.horasPracticas = horasPracticas;
    }

    public Integer getOrdenCertificado() {
        return ordenCertificado;
    }

    public void setOrdenCertificado(Integer ordenCertificado) {
        this.ordenCertificado = ordenCertificado;
    }

    public Integer getSemestreReticula() {
        return semestreReticula;
    }

    public void setSemestreReticula(Integer semestreReticula) {
        this.semestreReticula = semestreReticula;
    }

    public Integer getCreditosPrerequisito() {
        return creditosPrerequisito;
    }

    public void setCreditosPrerequisito(Integer creditosPrerequisito) {
        this.creditosPrerequisito = creditosPrerequisito;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getClaveOficialMateria() {
        return claveOficialMateria;
    }

    public void setClaveOficialMateria(String claveOficialMateria) {
        this.claveOficialMateria = claveOficialMateria;
    }

    public Character getEstatusMateriaCarrera() {
        return estatusMateriaCarrera;
    }

    public void setEstatusMateriaCarrera(Character estatusMateriaCarrera) {
        this.estatusMateriaCarrera = estatusMateriaCarrera;
    }

    public String getProgramaEstudios() {
        return programaEstudios;
    }

    public void setProgramaEstudios(String programaEstudios) {
        this.programaEstudios = programaEstudios;
    }

    public Integer getRenglon() {
        return renglon;
    }

    public void setRenglon(Integer renglon) {
        this.renglon = renglon;
    }

    public Integer getIdMateriaCarrera() {
        return idMateriaCarrera;
    }

    public void setIdMateriaCarrera(Integer idMateriaCarrera) {
        this.idMateriaCarrera = idMateriaCarrera;
    }

    public Carrera getReticula() {
        return reticula;
    }

    public void setReticula(Carrera reticula) {
        this.reticula = reticula;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaCarrera != null ? idMateriaCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriasCarreras)) {
            return false;
        }
        MateriasCarreras other = (MateriasCarreras) object;
        if ((this.idMateriaCarrera == null && other.idMateriaCarrera != null) || (this.idMateriaCarrera != null && !this.idMateriaCarrera.equals(other.idMateriaCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MateriasCarreras[ idMateriaCarrera=" + idMateriaCarrera + " ]";
    }
    
}
