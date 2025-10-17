/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "estudios_docente", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudiosDocente.findAll", query = "SELECT e FROM EstudiosDocente e"),
    @NamedQuery(name = "EstudiosDocente.findByIdestudios", query = "SELECT e FROM EstudiosDocente e WHERE e.idestudios = :idestudios"),
    @NamedQuery(name = "EstudiosDocente.findByCarrera", query = "SELECT e FROM EstudiosDocente e WHERE e.carrera = :carrera"),
    @NamedQuery(name = "EstudiosDocente.findByGrado", query = "SELECT e FROM EstudiosDocente e WHERE e.grado = :grado"),
    @NamedQuery(name = "EstudiosDocente.findByInstitucion", query = "SELECT e FROM EstudiosDocente e WHERE e.institucion = :institucion"),
    @NamedQuery(name = "EstudiosDocente.findByIdregionEstudios", query = "SELECT e FROM EstudiosDocente e WHERE e.idregionEstudios = :idregionEstudios"),
    @NamedQuery(name = "EstudiosDocente.findByIdestatus", query = "SELECT e FROM EstudiosDocente e WHERE e.idestatus = :idestatus")})
public class EstudiosDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idestudios")
    private Integer idestudios;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "grado")
    private String grado;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "idregion_estudios")
    private String idregionEstudios;
    @Column(name = "idestatus")
    private String idestatus;

    public EstudiosDocente() {
    }

    public EstudiosDocente(Integer idestudios) {
        this.idestudios = idestudios;
    }

    public Integer getIdestudios() {
        return idestudios;
    }

    public void setIdestudios(Integer idestudios) {
        this.idestudios = idestudios;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getIdregionEstudios() {
        return idregionEstudios;
    }

    public void setIdregionEstudios(String idregionEstudios) {
        this.idregionEstudios = idregionEstudios;
    }

    public String getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(String idestatus) {
        this.idestatus = idestatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudios != null ? idestudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosDocente)) {
            return false;
        }
        EstudiosDocente other = (EstudiosDocente) object;
        if ((this.idestudios == null && other.idestudios != null) || (this.idestudios != null && !this.idestudios.equals(other.idestudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstudiosDocente[ idestudios=" + idestudios + " ]";
    }
    
}
