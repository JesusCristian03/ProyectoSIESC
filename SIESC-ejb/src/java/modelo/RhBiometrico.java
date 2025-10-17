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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rh_biometrico", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RhBiometrico.findAll", query = "SELECT r FROM RhBiometrico r"),
    @NamedQuery(name = "RhBiometrico.findByIdRhBiometrico", query = "SELECT r FROM RhBiometrico r WHERE r.idRhBiometrico = :idRhBiometrico"),
    @NamedQuery(name = "RhBiometrico.findByIdTarjeta", query = "SELECT r FROM RhBiometrico r WHERE r.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "RhBiometrico.findByEstatus", query = "SELECT r FROM RhBiometrico r WHERE r.estatus = :estatus")})
public class RhBiometrico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rh_biometrico")
    private Integer idRhBiometrico;
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;
    @Column(name = "estatus")
    private String estatus;
    @JoinColumn(name = "rfc", referencedColumnName = "rfc")
    @ManyToOne
    private Personal rfc;
    @OneToMany(mappedBy = "idRhBiometrico")
    private List<RhAsistencia> rhAsistenciaList;

    public RhBiometrico() {
    }

    public RhBiometrico(Integer idRhBiometrico) {
        this.idRhBiometrico = idRhBiometrico;
    }

    public Integer getIdRhBiometrico() {
        return idRhBiometrico;
    }

    public void setIdRhBiometrico(Integer idRhBiometrico) {
        this.idRhBiometrico = idRhBiometrico;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Personal getRfc() {
        return rfc;
    }

    public void setRfc(Personal rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public List<RhAsistencia> getRhAsistenciaList() {
        return rhAsistenciaList;
    }

    public void setRhAsistenciaList(List<RhAsistencia> rhAsistenciaList) {
        this.rhAsistenciaList = rhAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRhBiometrico != null ? idRhBiometrico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RhBiometrico)) {
            return false;
        }
        RhBiometrico other = (RhBiometrico) object;
        if ((this.idRhBiometrico == null && other.idRhBiometrico != null) || (this.idRhBiometrico != null && !this.idRhBiometrico.equals(other.idRhBiometrico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RhBiometrico[ idRhBiometrico=" + idRhBiometrico + " ]";
    }
    
}
