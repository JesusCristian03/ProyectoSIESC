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
@Table(name = "grupos", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findByEstatusGrupo", query = "SELECT g FROM Grupos g WHERE g.estatusGrupo = :estatusGrupo"),
    @NamedQuery(name = "Grupos.findByCapacidadGrupo", query = "SELECT g FROM Grupos g WHERE g.capacidadGrupo = :capacidadGrupo"),
    @NamedQuery(name = "Grupos.findByAlumnosInscritos", query = "SELECT g FROM Grupos g WHERE g.alumnosInscritos = :alumnosInscritos"),
    @NamedQuery(name = "Grupos.findByFolioActa", query = "SELECT g FROM Grupos g WHERE g.folioActa = :folioActa"),
    @NamedQuery(name = "Grupos.findByParaleloDe", query = "SELECT g FROM Grupos g WHERE g.paraleloDe = :paraleloDe"),
    @NamedQuery(name = "Grupos.findByCarrera", query = "SELECT g FROM Grupos g WHERE g.carrera = :carrera"),
    @NamedQuery(name = "Grupos.findBySeleccionadoEnBloque", query = "SELECT g FROM Grupos g WHERE g.seleccionadoEnBloque = :seleccionadoEnBloque"),
    @NamedQuery(name = "Grupos.findByTipoPersonal", query = "SELECT g FROM Grupos g WHERE g.tipoPersonal = :tipoPersonal"),
    @NamedQuery(name = "Grupos.findByMateria", query = "SELECT g FROM Grupos g WHERE g.materia = :materia"),
    @NamedQuery(name = "Grupos.findByGrupo", query = "SELECT g FROM Grupos g WHERE g.grupo = :grupo"),
    @NamedQuery(name = "Grupos.findByIdGrupo", query = "SELECT g FROM Grupos g WHERE g.idGrupo = :idGrupo")})
public class Grupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "estatus_grupo")
    private Character estatusGrupo;
    @Column(name = "capacidad_grupo")
    private Integer capacidadGrupo;
    @Column(name = "alumnos_inscritos")
    private Integer alumnosInscritos;
    @Column(name = "folio_acta")
    private String folioActa;
    @Column(name = "paralelo_de")
    private String paraleloDe;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "seleccionado_en_bloque")
    private Character seleccionadoEnBloque;
    @Column(name = "tipo_personal")
    private Character tipoPersonal;
    @Column(name = "materia")
    private String materia;
    @Column(name = "grupo")
    private String grupo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @OneToMany(mappedBy = "idGrupo")
    private List<SeleccionMaterias> seleccionMateriasList;
    @OneToMany(mappedBy = "idGrupo")
    private List<Horarios> horariosList;
    @JoinColumn(name = "reticula", referencedColumnName = "reticula")
    @ManyToOne
    private Carrera reticula;
    @JoinColumn(name = "id_materia_carrera", referencedColumnName = "id_materia_carrera")
    @ManyToOne
    private MateriasCarreras idMateriaCarrera;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodo;
    @JoinColumn(name = "rfc", referencedColumnName = "rfc")
    @ManyToOne
    private Personal rfc;
    @OneToMany(mappedBy = "idGrupo")
    private List<AsistenciaEstudiante> asistenciaEstudianteList;

    public Grupos() {
    }

    public Grupos(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Character getEstatusGrupo() {
        return estatusGrupo;
    }

    public void setEstatusGrupo(Character estatusGrupo) {
        this.estatusGrupo = estatusGrupo;
    }

    public Integer getCapacidadGrupo() {
        return capacidadGrupo;
    }

    public void setCapacidadGrupo(Integer capacidadGrupo) {
        this.capacidadGrupo = capacidadGrupo;
    }

    public Integer getAlumnosInscritos() {
        return alumnosInscritos;
    }

    public void setAlumnosInscritos(Integer alumnosInscritos) {
        this.alumnosInscritos = alumnosInscritos;
    }

    public String getFolioActa() {
        return folioActa;
    }

    public void setFolioActa(String folioActa) {
        this.folioActa = folioActa;
    }

    public String getParaleloDe() {
        return paraleloDe;
    }

    public void setParaleloDe(String paraleloDe) {
        this.paraleloDe = paraleloDe;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Character getSeleccionadoEnBloque() {
        return seleccionadoEnBloque;
    }

    public void setSeleccionadoEnBloque(Character seleccionadoEnBloque) {
        this.seleccionadoEnBloque = seleccionadoEnBloque;
    }

    public Character getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(Character tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
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

    public Carrera getReticula() {
        return reticula;
    }

    public void setReticula(Carrera reticula) {
        this.reticula = reticula;
    }

    public MateriasCarreras getIdMateriaCarrera() {
        return idMateriaCarrera;
    }

    public void setIdMateriaCarrera(MateriasCarreras idMateriaCarrera) {
        this.idMateriaCarrera = idMateriaCarrera;
    }

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    public Personal getRfc() {
        return rfc;
    }

    public void setRfc(Personal rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public List<AsistenciaEstudiante> getAsistenciaEstudianteList() {
        return asistenciaEstudianteList;
    }

    public void setAsistenciaEstudianteList(List<AsistenciaEstudiante> asistenciaEstudianteList) {
        this.asistenciaEstudianteList = asistenciaEstudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Grupos[ idGrupo=" + idGrupo + " ]";
    }
    
}
