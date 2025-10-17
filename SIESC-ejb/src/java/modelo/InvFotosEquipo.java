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
@Table(name = "inv_fotos_equipo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvFotosEquipo.findAll", query = "SELECT i FROM InvFotosEquipo i"),
    @NamedQuery(name = "InvFotosEquipo.findByFecha", query = "SELECT i FROM InvFotosEquipo i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "InvFotosEquipo.findByDescripcion", query = "SELECT i FROM InvFotosEquipo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "InvFotosEquipo.findByRuta", query = "SELECT i FROM InvFotosEquipo i WHERE i.ruta = :ruta"),
    @NamedQuery(name = "InvFotosEquipo.findByIdFotos", query = "SELECT i FROM InvFotosEquipo i WHERE i.idFotos = :idFotos")})
public class InvFotosEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ruta")
    private String ruta;
    @Id
    @Basic(optional = false)
    @Column(name = "id_fotos")
    private String idFotos;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private InvEquipo idEquipo;

    public InvFotosEquipo() {
    }

    public InvFotosEquipo(String idFotos) {
        this.idFotos = idFotos;
    }

    public InvFotosEquipo(String idFotos, Date fecha, String descripcion, String ruta) {
        this.idFotos = idFotos;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getIdFotos() {
        return idFotos;
    }

    public void setIdFotos(String idFotos) {
        this.idFotos = idFotos;
    }

    public InvEquipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(InvEquipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotos != null ? idFotos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvFotosEquipo)) {
            return false;
        }
        InvFotosEquipo other = (InvFotosEquipo) object;
        if ((this.idFotos == null && other.idFotos != null) || (this.idFotos != null && !this.idFotos.equals(other.idFotos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvFotosEquipo[ idFotos=" + idFotos + " ]";
    }
    
}
