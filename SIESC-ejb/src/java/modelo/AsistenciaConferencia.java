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
@Table(name = "asistencia_conferencia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaConferencia.findAll", query = "SELECT a FROM AsistenciaConferencia a"),
    @NamedQuery(name = "AsistenciaConferencia.findByIdAsistenciaConferencia", query = "SELECT a FROM AsistenciaConferencia a WHERE a.idAsistenciaConferencia = :idAsistenciaConferencia"),
    @NamedQuery(name = "AsistenciaConferencia.findByFecha", query = "SELECT a FROM AsistenciaConferencia a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AsistenciaConferencia.findByHora", query = "SELECT a FROM AsistenciaConferencia a WHERE a.hora = :hora")})
public class AsistenciaConferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asistencia_conferencia")
    private Integer idAsistenciaConferencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "id_conferencia", referencedColumnName = "id_conferencia")
    @ManyToOne
    private Conferencia idConferencia;
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta")
    @ManyToOne
    private Tarjeta idTarjeta;

    public AsistenciaConferencia() {
    }

    public AsistenciaConferencia(Integer idAsistenciaConferencia) {
        this.idAsistenciaConferencia = idAsistenciaConferencia;
    }

    public Integer getIdAsistenciaConferencia() {
        return idAsistenciaConferencia;
    }

    public void setIdAsistenciaConferencia(Integer idAsistenciaConferencia) {
        this.idAsistenciaConferencia = idAsistenciaConferencia;
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

    public Conferencia getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(Conferencia idConferencia) {
        this.idConferencia = idConferencia;
    }

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistenciaConferencia != null ? idAsistenciaConferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaConferencia)) {
            return false;
        }
        AsistenciaConferencia other = (AsistenciaConferencia) object;
        if ((this.idAsistenciaConferencia == null && other.idAsistenciaConferencia != null) || (this.idAsistenciaConferencia != null && !this.idAsistenciaConferencia.equals(other.idAsistenciaConferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsistenciaConferencia[ idAsistenciaConferencia=" + idAsistenciaConferencia + " ]";
    }
    
}
