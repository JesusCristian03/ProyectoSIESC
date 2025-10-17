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
@Table(name = "inv_estatus", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvEstatus.findAll", query = "SELECT i FROM InvEstatus i"),
    @NamedQuery(name = "InvEstatus.findByEstatusCompleto", query = "SELECT i FROM InvEstatus i WHERE i.estatusCompleto = :estatusCompleto"),
    @NamedQuery(name = "InvEstatus.findByIdEstatus", query = "SELECT i FROM InvEstatus i WHERE i.idEstatus = :idEstatus")})
public class InvEstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "estatus_completo")
    private String estatusCompleto;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estatus")
    private Integer idEstatus;
    @OneToMany(mappedBy = "idEstatus")
    private List<InvAsignacionEquipo> invAsignacionEquipoList;
    @OneToMany(mappedBy = "idEstatus")
    private List<InvEquipo> invEquipoList;
    @OneToMany(mappedBy = "idEstatus")
    private List<InvMantenimientoProgramado> invMantenimientoProgramadoList;

    public InvEstatus() {
    }

    public InvEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getEstatusCompleto() {
        return estatusCompleto;
    }

    public void setEstatusCompleto(String estatusCompleto) {
        this.estatusCompleto = estatusCompleto;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    @XmlTransient
    public List<InvAsignacionEquipo> getInvAsignacionEquipoList() {
        return invAsignacionEquipoList;
    }

    public void setInvAsignacionEquipoList(List<InvAsignacionEquipo> invAsignacionEquipoList) {
        this.invAsignacionEquipoList = invAsignacionEquipoList;
    }

    @XmlTransient
    public List<InvEquipo> getInvEquipoList() {
        return invEquipoList;
    }

    public void setInvEquipoList(List<InvEquipo> invEquipoList) {
        this.invEquipoList = invEquipoList;
    }

    @XmlTransient
    public List<InvMantenimientoProgramado> getInvMantenimientoProgramadoList() {
        return invMantenimientoProgramadoList;
    }

    public void setInvMantenimientoProgramadoList(List<InvMantenimientoProgramado> invMantenimientoProgramadoList) {
        this.invMantenimientoProgramadoList = invMantenimientoProgramadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatus != null ? idEstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvEstatus)) {
            return false;
        }
        InvEstatus other = (InvEstatus) object;
        if ((this.idEstatus == null && other.idEstatus != null) || (this.idEstatus != null && !this.idEstatus.equals(other.idEstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvEstatus[ idEstatus=" + idEstatus + " ]";
    }
    
}
