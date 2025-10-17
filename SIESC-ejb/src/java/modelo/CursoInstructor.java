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
@Table(name = "curso_instructor", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoInstructor.findAll", query = "SELECT c FROM CursoInstructor c"),
    @NamedQuery(name = "CursoInstructor.findByRfc", query = "SELECT c FROM CursoInstructor c WHERE c.rfc = :rfc"),
    @NamedQuery(name = "CursoInstructor.findByApellidosInstructor", query = "SELECT c FROM CursoInstructor c WHERE c.apellidosInstructor = :apellidosInstructor"),
    @NamedQuery(name = "CursoInstructor.findByNombreInstructor", query = "SELECT c FROM CursoInstructor c WHERE c.nombreInstructor = :nombreInstructor"),
    @NamedQuery(name = "CursoInstructor.findByUltimoGradoEstudios", query = "SELECT c FROM CursoInstructor c WHERE c.ultimoGradoEstudios = :ultimoGradoEstudios"),
    @NamedQuery(name = "CursoInstructor.findByCarrera", query = "SELECT c FROM CursoInstructor c WHERE c.carrera = :carrera"),
    @NamedQuery(name = "CursoInstructor.findBySexoInstructor", query = "SELECT c FROM CursoInstructor c WHERE c.sexoInstructor = :sexoInstructor")})
public class CursoInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "apellidos_instructor")
    private String apellidosInstructor;
    @Column(name = "nombre_instructor")
    private String nombreInstructor;
    @Column(name = "ultimo_grado_estudios")
    private String ultimoGradoEstudios;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "sexo_instructor")
    private Character sexoInstructor;
    @OneToMany(mappedBy = "instructor")
    private List<Curso> cursoList;

    public CursoInstructor() {
    }

    public CursoInstructor(String rfc) {
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getApellidosInstructor() {
        return apellidosInstructor;
    }

    public void setApellidosInstructor(String apellidosInstructor) {
        this.apellidosInstructor = apellidosInstructor;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

    public String getUltimoGradoEstudios() {
        return ultimoGradoEstudios;
    }

    public void setUltimoGradoEstudios(String ultimoGradoEstudios) {
        this.ultimoGradoEstudios = ultimoGradoEstudios;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Character getSexoInstructor() {
        return sexoInstructor;
    }

    public void setSexoInstructor(Character sexoInstructor) {
        this.sexoInstructor = sexoInstructor;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfc != null ? rfc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoInstructor)) {
            return false;
        }
        CursoInstructor other = (CursoInstructor) object;
        if ((this.rfc == null && other.rfc != null) || (this.rfc != null && !this.rfc.equals(other.rfc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CursoInstructor[ rfc=" + rfc + " ]";
    }
    
}
