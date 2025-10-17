/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "inv_equipo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvEquipo.findAll", query = "SELECT i FROM InvEquipo i"),
    @NamedQuery(name = "InvEquipo.findByDescripcion", query = "SELECT i FROM InvEquipo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "InvEquipo.findByMarca", query = "SELECT i FROM InvEquipo i WHERE i.marca = :marca"),
    @NamedQuery(name = "InvEquipo.findByModelo", query = "SELECT i FROM InvEquipo i WHERE i.modelo = :modelo"),
    @NamedQuery(name = "InvEquipo.findBySerie", query = "SELECT i FROM InvEquipo i WHERE i.serie = :serie"),
    @NamedQuery(name = "InvEquipo.findByObservaciones", query = "SELECT i FROM InvEquipo i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "InvEquipo.findByEtiqueta", query = "SELECT i FROM InvEquipo i WHERE i.etiqueta = :etiqueta"),
    @NamedQuery(name = "InvEquipo.findByInventarioSep", query = "SELECT i FROM InvEquipo i WHERE i.inventarioSep = :inventarioSep"),
    @NamedQuery(name = "InvEquipo.findByPrecio", query = "SELECT i FROM InvEquipo i WHERE i.precio = :precio"),
    @NamedQuery(name = "InvEquipo.findByFechaAlta", query = "SELECT i FROM InvEquipo i WHERE i.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "InvEquipo.findByFactura", query = "SELECT i FROM InvEquipo i WHERE i.factura = :factura"),
    @NamedQuery(name = "InvEquipo.findByFechaFactura", query = "SELECT i FROM InvEquipo i WHERE i.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "InvEquipo.findByTiempoMantenimiento", query = "SELECT i FROM InvEquipo i WHERE i.tiempoMantenimiento = :tiempoMantenimiento"),
    @NamedQuery(name = "InvEquipo.findByIdEquipo", query = "SELECT i FROM InvEquipo i WHERE i.idEquipo = :idEquipo"),
    @NamedQuery(name = "InvEquipo.findByDescripcionUbicacion", query = "SELECT i FROM InvEquipo i WHERE i.descripcionUbicacion = :descripcionUbicacion")})
public class InvEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "serie")
    private String serie;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "etiqueta")
    private String etiqueta;
    @Basic(optional = false)
    @Column(name = "inventario_sep")
    private String inventarioSep;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "factura")
    private String factura;
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Column(name = "tiempo_mantenimiento")
    private Integer tiempoMantenimiento;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Column(name = "descripcion_ubicacion")
    private String descripcionUbicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<InvEquipoInventario> invEquipoInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<InvFotosEquipo> invFotosEquipoList;
    @JoinColumn(name = "edificio", referencedColumnName = "clave")
    @ManyToOne
    private Edificio edificio;
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    @ManyToOne
    private InvEstatus idEstatus;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private InvTipoEquipo idTipo;
    @JoinColumn(name = "clave_area_depto", referencedColumnName = "clave_area")
    @ManyToOne
    private Organigrama claveAreaDepto;
    @JoinColumn(name = "usuario_registro", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioRegistro;

    public InvEquipo() {
    }

    public InvEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public InvEquipo(Integer idEquipo, String descripcion, String marca, String modelo, String serie, String inventarioSep) {
        this.idEquipo = idEquipo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.inventarioSep = inventarioSep;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getInventarioSep() {
        return inventarioSep;
    }

    public void setInventarioSep(String inventarioSep) {
        this.inventarioSep = inventarioSep;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Integer getTiempoMantenimiento() {
        return tiempoMantenimiento;
    }

    public void setTiempoMantenimiento(Integer tiempoMantenimiento) {
        this.tiempoMantenimiento = tiempoMantenimiento;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getDescripcionUbicacion() {
        return descripcionUbicacion;
    }

    public void setDescripcionUbicacion(String descripcionUbicacion) {
        this.descripcionUbicacion = descripcionUbicacion;
    }

    @XmlTransient
    public List<InvEquipoInventario> getInvEquipoInventarioList() {
        return invEquipoInventarioList;
    }

    public void setInvEquipoInventarioList(List<InvEquipoInventario> invEquipoInventarioList) {
        this.invEquipoInventarioList = invEquipoInventarioList;
    }

    @XmlTransient
    public List<InvFotosEquipo> getInvFotosEquipoList() {
        return invFotosEquipoList;
    }

    public void setInvFotosEquipoList(List<InvFotosEquipo> invFotosEquipoList) {
        this.invFotosEquipoList = invFotosEquipoList;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public InvEstatus getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(InvEstatus idEstatus) {
        this.idEstatus = idEstatus;
    }

    public InvTipoEquipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(InvTipoEquipo idTipo) {
        this.idTipo = idTipo;
    }

    public Organigrama getClaveAreaDepto() {
        return claveAreaDepto;
    }

    public void setClaveAreaDepto(Organigrama claveAreaDepto) {
        this.claveAreaDepto = claveAreaDepto;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvEquipo)) {
            return false;
        }
        InvEquipo other = (InvEquipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvEquipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
