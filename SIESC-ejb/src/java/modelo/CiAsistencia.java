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
@Table(name = "ci_asistencia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CiAsistencia.findAll", query = "SELECT c FROM CiAsistencia c"),
    @NamedQuery(name = "CiAsistencia.findByIdAsistenciaci", query = "SELECT c FROM CiAsistencia c WHERE c.idAsistenciaci = :idAsistenciaci"),
    @NamedQuery(name = "CiAsistencia.findByFecha", query = "SELECT c FROM CiAsistencia c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CiAsistencia.findByObservaciones", query = "SELECT c FROM CiAsistencia c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CiAsistencia.findByHora", query = "SELECT c FROM CiAsistencia c WHERE c.hora = :hora")})
public class CiAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asistenciaci")
    private Integer idAsistenciaci;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta")
    @ManyToOne
    private Tarjeta idTarjeta;

    public CiAsistencia() {
    }

    public CiAsistencia(Integer idAsistenciaci) {
        this.idAsistenciaci = idAsistenciaci;
    }

    public Integer getIdAsistenciaci() {
        return idAsistenciaci;
    }

    public void setIdAsistenciaci(Integer idAsistenciaci) {
        this.idAsistenciaci = idAsistenciaci;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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
        hash += (idAsistenciaci != null ? idAsistenciaci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiAsistencia)) {
            return false;
        }
        CiAsistencia other = (CiAsistencia) object;
        if ((this.idAsistenciaci == null && other.idAsistenciaci != null) || (this.idAsistenciaci != null && !this.idAsistenciaci.equals(other.idAsistenciaci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CiAsistencia[ idAsistenciaci=" + idAsistenciaci + " ]";
    }
    
}
