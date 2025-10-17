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
@Table(name = "curso_asistencia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoAsistencia.findAll", query = "SELECT c FROM CursoAsistencia c"),
    @NamedQuery(name = "CursoAsistencia.findByIdCursoChecada", query = "SELECT c FROM CursoAsistencia c WHERE c.idCursoChecada = :idCursoChecada"),
    @NamedQuery(name = "CursoAsistencia.findByHoraEntrada", query = "SELECT c FROM CursoAsistencia c WHERE c.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "CursoAsistencia.findByHoraSalida", query = "SELECT c FROM CursoAsistencia c WHERE c.horaSalida = :horaSalida"),
    @NamedQuery(name = "CursoAsistencia.findByObservaciones", query = "SELECT c FROM CursoAsistencia c WHERE c.observaciones = :observaciones")})
public class CursoAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_curso_checada")
    private Integer idCursoChecada;
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.DATE)
    private Date horaEntrada;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.DATE)
    private Date horaSalida;
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_participante", referencedColumnName = "rfc_participante")
    @ManyToOne
    private CursoParticipante idParticipante;
    @JoinColumn(name = "estatus_asistencia", referencedColumnName = "id_estatusc")
    @ManyToOne
    private EstatusChecada estatusAsistencia;

    public CursoAsistencia() {
    }

    public CursoAsistencia(Integer idCursoChecada) {
        this.idCursoChecada = idCursoChecada;
    }

    public Integer getIdCursoChecada() {
        return idCursoChecada;
    }

    public void setIdCursoChecada(Integer idCursoChecada) {
        this.idCursoChecada = idCursoChecada;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public CursoParticipante getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(CursoParticipante idParticipante) {
        this.idParticipante = idParticipante;
    }

    public EstatusChecada getEstatusAsistencia() {
        return estatusAsistencia;
    }

    public void setEstatusAsistencia(EstatusChecada estatusAsistencia) {
        this.estatusAsistencia = estatusAsistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoChecada != null ? idCursoChecada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoAsistencia)) {
            return false;
        }
        CursoAsistencia other = (CursoAsistencia) object;
        if ((this.idCursoChecada == null && other.idCursoChecada != null) || (this.idCursoChecada != null && !this.idCursoChecada.equals(other.idCursoChecada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CursoAsistencia[ idCursoChecada=" + idCursoChecada + " ]";
    }
    
}
