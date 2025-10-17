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
@Table(name = "estatus_estudiante", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstatusEstudiante.findAll", query = "SELECT e FROM EstatusEstudiante e"),
    @NamedQuery(name = "EstatusEstudiante.findByEstatusAlumno", query = "SELECT e FROM EstatusEstudiante e WHERE e.estatusAlumno = :estatusAlumno"),
    @NamedQuery(name = "EstatusEstudiante.findByEstatus", query = "SELECT e FROM EstatusEstudiante e WHERE e.estatus = :estatus")})
public class EstatusEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "estatus_alumno")
    private String estatusAlumno;
    @Column(name = "estatus")
    private String estatus;

    public EstatusEstudiante() {
    }

    public EstatusEstudiante(String estatusAlumno) {
        this.estatusAlumno = estatusAlumno;
    }

    public String getEstatusAlumno() {
        return estatusAlumno;
    }

    public void setEstatusAlumno(String estatusAlumno) {
        this.estatusAlumno = estatusAlumno;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estatusAlumno != null ? estatusAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusEstudiante)) {
            return false;
        }
        EstatusEstudiante other = (EstatusEstudiante) object;
        if ((this.estatusAlumno == null && other.estatusAlumno != null) || (this.estatusAlumno != null && !this.estatusAlumno.equals(other.estatusAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstatusEstudiante[ estatusAlumno=" + estatusAlumno + " ]";
    }
    
}
