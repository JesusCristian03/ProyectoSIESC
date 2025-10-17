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
@Table(name = "rh_asistencia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhAsistencia.findAll", query = "SELECT r FROM RhAsistencia r"),
    @NamedQuery(name = "RhAsistencia.findByIdRhAsistencia", query = "SELECT r FROM RhAsistencia r WHERE r.idRhAsistencia = :idRhAsistencia"),
    @NamedQuery(name = "RhAsistencia.findByFecha", query = "SELECT r FROM RhAsistencia r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RhAsistencia.findByHora", query = "SELECT r FROM RhAsistencia r WHERE r.hora = :hora"),
    @NamedQuery(name = "RhAsistencia.findByTipo", query = "SELECT r FROM RhAsistencia r WHERE r.tipo = :tipo")})
public class RhAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rh_asistencia")
    private Integer idRhAsistencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodo;
    @JoinColumn(name = "id_rh_biometrico", referencedColumnName = "id_rh_biometrico")
    @ManyToOne
    private RhBiometrico idRhBiometrico;

    public RhAsistencia() {
    }

    public RhAsistencia(Integer idRhAsistencia) {
        this.idRhAsistencia = idRhAsistencia;
    }

    public Integer getIdRhAsistencia() {
        return idRhAsistencia;
    }

    public void setIdRhAsistencia(Integer idRhAsistencia) {
        this.idRhAsistencia = idRhAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    public RhBiometrico getIdRhBiometrico() {
        return idRhBiometrico;
    }

    public void setIdRhBiometrico(RhBiometrico idRhBiometrico) {
        this.idRhBiometrico = idRhBiometrico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRhAsistencia != null ? idRhAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhAsistencia)) {
            return false;
        }
        RhAsistencia other = (RhAsistencia) object;
        if ((this.idRhAsistencia == null && other.idRhAsistencia != null) || (this.idRhAsistencia != null && !this.idRhAsistencia.equals(other.idRhAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RhAsistencia[ idRhAsistencia=" + idRhAsistencia + " ]";
    }
    
}
