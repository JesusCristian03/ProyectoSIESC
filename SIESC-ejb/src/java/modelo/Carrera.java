/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "carrera", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = "Carrera.findByCarrera", query = "SELECT c FROM Carrera c WHERE c.carrera = :carrera"),
    @NamedQuery(name = "Carrera.findByReticula", query = "SELECT c FROM Carrera c WHERE c.reticula = :reticula"),
    @NamedQuery(name = "Carrera.findByNivelEscolar", query = "SELECT c FROM Carrera c WHERE c.nivelEscolar = :nivelEscolar"),
    @NamedQuery(name = "Carrera.findByClaveOficial", query = "SELECT c FROM Carrera c WHERE c.claveOficial = :claveOficial"),
    @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera"),
    @NamedQuery(name = "Carrera.findByNombreReducido", query = "SELECT c FROM Carrera c WHERE c.nombreReducido = :nombreReducido"),
    @NamedQuery(name = "Carrera.findBySiglas", query = "SELECT c FROM Carrera c WHERE c.siglas = :siglas"),
    @NamedQuery(name = "Carrera.findByCargaMaxima", query = "SELECT c FROM Carrera c WHERE c.cargaMaxima = :cargaMaxima"),
    @NamedQuery(name = "Carrera.findByCargaMinima", query = "SELECT c FROM Carrera c WHERE c.cargaMinima = :cargaMinima"),
    @NamedQuery(name = "Carrera.findByFechaInicio", query = "SELECT c FROM Carrera c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Carrera.findByFechaTermino", query = "SELECT c FROM Carrera c WHERE c.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Carrera.findByCreditosTotales", query = "SELECT c FROM Carrera c WHERE c.creditosTotales = :creditosTotales"),
    @NamedQuery(name = "Carrera.findByModalidad", query = "SELECT c FROM Carrera c WHERE c.modalidad = :modalidad"),
    @NamedQuery(name = "Carrera.findByAutorizacion", query = "SELECT c FROM Carrera c WHERE c.autorizacion = :autorizacion")})

public class Carrera implements Serializable {

    @OneToMany(mappedBy = "reticula")
    private List<Permisos> permisosList;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "carrera")
    private String carrera;
    @Id
    @Basic(optional = false)
    @Column(name = "reticula")
    private Integer reticula;
    @Column(name = "nivel_escolar")
    private Character nivelEscolar;
    @Column(name = "clave_oficial")
    private String claveOficial;
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Column(name = "nombre_reducido")
    private String nombreReducido;
    @Column(name = "siglas")
    private String siglas;
    @Column(name = "carga_maxima")
    private Integer cargaMaxima;
    @Column(name = "carga_minima")
    private Integer cargaMinima;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Column(name = "creditos_totales")
    private Integer creditosTotales;
    @Column(name = "modalidad")
    private Character modalidad;
    @Column(name = "autorizacion")
    private String autorizacion;
    @OneToMany(mappedBy = "reticula")
    private List<MateriasCarreras> materiasCarrerasList;
    @OneToMany(mappedBy = "reticula")
    private List<Estudiante> estudianteList;
    @OneToMany(mappedBy = "reticula")
    private List<Grupos> gruposList;

    public Carrera() {
    }

    public Carrera(Integer reticula) {
        this.reticula = reticula;
    }

    public Carrera(Integer reticula, String carrera) {
        this.reticula = reticula;
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getReticula() {
        return reticula;
    }

    public void setReticula(Integer reticula) {
        this.reticula = reticula;
    }

    public Character getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(Character nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getClaveOficial() {
        return claveOficial;
    }

    public void setClaveOficial(String claveOficial) {
        this.claveOficial = claveOficial;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreReducido() {
        return nombreReducido;
    }

    public void setNombreReducido(String nombreReducido) {
        this.nombreReducido = nombreReducido;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public Integer getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(Integer cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public Integer getCargaMinima() {
        return cargaMinima;
    }

    public void setCargaMinima(Integer cargaMinima) {
        this.cargaMinima = cargaMinima;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Integer getCreditosTotales() {
        return creditosTotales;
    }

    public void setCreditosTotales(Integer creditosTotales) {
        this.creditosTotales = creditosTotales;
    }

    public Character getModalidad() {
        return modalidad;
    }

    public void setModalidad(Character modalidad) {
        this.modalidad = modalidad;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    @XmlTransient
    public List<MateriasCarreras> getMateriasCarrerasList() {
        return materiasCarrerasList;
    }

    public void setMateriasCarrerasList(List<MateriasCarreras> materiasCarrerasList) {
        this.materiasCarrerasList = materiasCarrerasList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
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
        hash += (reticula != null ? reticula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.reticula == null && other.reticula != null) || (this.reticula != null && !this.reticula.equals(other.reticula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Carrera[ reticula=" + reticula + " ]";
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

}
