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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tarjeta", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByIdTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "Tarjeta.findByUsuario", query = "SELECT t FROM Tarjeta t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Tarjeta.findByFecha", query = "SELECT t FROM Tarjeta t WHERE t.fecha = :fecha")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tarjeta")
    private String idTarjeta;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "idTarjeta")
    private List<CiAsistencia> ciAsistenciaList;
    @OneToMany(mappedBy = "idTarjeta")
    private List<AsistenciaConferencia> asistenciaConferenciaList;
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    @ManyToOne
    private Estatus idEstatus;
    @JoinColumn(name = "id_rol", referencedColumnName = "idrol")
    @ManyToOne
    private Roles idRol;

    public Tarjeta() {
    }

    public Tarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<CiAsistencia> getCiAsistenciaList() {
        return ciAsistenciaList;
    }

    public void setCiAsistenciaList(List<CiAsistencia> ciAsistenciaList) {
        this.ciAsistenciaList = ciAsistenciaList;
    }

    @XmlTransient
    public List<AsistenciaConferencia> getAsistenciaConferenciaList() {
        return asistenciaConferenciaList;
    }

    public void setAsistenciaConferenciaList(List<AsistenciaConferencia> asistenciaConferenciaList) {
        this.asistenciaConferenciaList = asistenciaConferenciaList;
    }

    public Estatus getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Estatus idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tarjeta[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
