/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "curso_instructor_participante", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoInstructorParticipante.findAll", query = "SELECT c FROM CursoInstructorParticipante c"),
    @NamedQuery(name = "CursoInstructorParticipante.findByIdCursoIp", query = "SELECT c FROM CursoInstructorParticipante c WHERE c.idCursoIp = :idCursoIp"),
    @NamedQuery(name = "CursoInstructorParticipante.findByAcredita", query = "SELECT c FROM CursoInstructorParticipante c WHERE c.acredita = :acredita"),
    @NamedQuery(name = "CursoInstructorParticipante.findByConstancia", query = "SELECT c FROM CursoInstructorParticipante c WHERE c.constancia = :constancia"),
    @NamedQuery(name = "CursoInstructorParticipante.findByObservaciones", query = "SELECT c FROM CursoInstructorParticipante c WHERE c.observaciones = :observaciones")})
public class CursoInstructorParticipante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_ip")
    private Integer idCursoIp;
    @Column(name = "acredita")
    private Character acredita;
    @Column(name = "constancia")
    private String constancia;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso idCurso;
    @JoinColumn(name = "id_participante", referencedColumnName = "rfc_participante")
    @ManyToOne
    private CursoParticipante idParticipante;

    public CursoInstructorParticipante() {
    }

    public CursoInstructorParticipante(Integer idCursoIp) {
        this.idCursoIp = idCursoIp;
    }

    public Integer getIdCursoIp() {
        return idCursoIp;
    }

    public void setIdCursoIp(Integer idCursoIp) {
        this.idCursoIp = idCursoIp;
    }

    public Character getAcredita() {
        return acredita;
    }

    public void setAcredita(Character acredita) {
        this.acredita = acredita;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public CursoParticipante getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(CursoParticipante idParticipante) {
        this.idParticipante = idParticipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoIp != null ? idCursoIp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoInstructorParticipante)) {
            return false;
        }
        CursoInstructorParticipante other = (CursoInstructorParticipante) object;
        if ((this.idCursoIp == null && other.idCursoIp != null) || (this.idCursoIp != null && !this.idCursoIp.equals(other.idCursoIp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CursoInstructorParticipante[ idCursoIp=" + idCursoIp + " ]";
    }
    
}
