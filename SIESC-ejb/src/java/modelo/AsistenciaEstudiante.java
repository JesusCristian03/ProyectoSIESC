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
@Table(name = "asistencia_estudiante", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaEstudiante.findAll", query = "SELECT a FROM AsistenciaEstudiante a"),
    @NamedQuery(name = "AsistenciaEstudiante.findByIdAsistenciaEstudiante", query = "SELECT a FROM AsistenciaEstudiante a WHERE a.idAsistenciaEstudiante = :idAsistenciaEstudiante"),
    @NamedQuery(name = "AsistenciaEstudiante.findByRegistroAsistencia", query = "SELECT a FROM AsistenciaEstudiante a WHERE a.registroAsistencia = :registroAsistencia"),
    @NamedQuery(name = "AsistenciaEstudiante.findByFecha", query = "SELECT a FROM AsistenciaEstudiante a WHERE a.fecha = :fecha")})
public class AsistenciaEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asistencia_estudiante")
    private Integer idAsistenciaEstudiante;
    @Column(name = "registro_asistencia")
    private String registroAsistencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIME)
    private Date fecha;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private Grupos idGrupo;

    public AsistenciaEstudiante() {
    }

    public AsistenciaEstudiante(Integer idAsistenciaEstudiante) {
        this.idAsistenciaEstudiante = idAsistenciaEstudiante;
    }

    public Integer getIdAsistenciaEstudiante() {
        return idAsistenciaEstudiante;
    }

    public void setIdAsistenciaEstudiante(Integer idAsistenciaEstudiante) {
        this.idAsistenciaEstudiante = idAsistenciaEstudiante;
    }

    public String getRegistroAsistencia() {
        return registroAsistencia;
    }

    public void setRegistroAsistencia(String registroAsistencia) {
        this.registroAsistencia = registroAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Grupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistenciaEstudiante != null ? idAsistenciaEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaEstudiante)) {
            return false;
        }
        AsistenciaEstudiante other = (AsistenciaEstudiante) object;
        if ((this.idAsistenciaEstudiante == null && other.idAsistenciaEstudiante != null) || (this.idAsistenciaEstudiante != null && !this.idAsistenciaEstudiante.equals(other.idAsistenciaEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsistenciaEstudiante[ idAsistenciaEstudiante=" + idAsistenciaEstudiante + " ]";
    }
    
}
