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
@Table(name = "usuario", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuario.findByUltimoAcceso", query = "SELECT u FROM Usuario u WHERE u.ultimoAcceso = :ultimoAcceso"),
    @NamedQuery(name = "Usuario.findByObservaciones", query = "SELECT u FROM Usuario u WHERE u.observaciones = :observaciones")})
public class Usuario implements Serializable {

    @OneToMany(mappedBy = "usuario")
    private List<PermisosFunciones> permisosFuncionesList;
    @OneToMany(mappedBy = "usuario")
    private List<Permisos> permisosList;

    @OneToMany(mappedBy = "usuario")
    private List<HistoriaAlumno> historiaAlumnoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "ultimo_acceso")
    @Temporal(TemporalType.DATE)
    private Date ultimoAcceso;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "usuario")
    private List<AsistenciaAula> asistenciaAulaList;
    @JoinColumn(name = "idestatus", referencedColumnName = "idestatus")
    @ManyToOne(optional = false)
    private EstatusUsuario idestatus;
    @JoinColumn(name = "clave_area", referencedColumnName = "clave_area")
    @ManyToOne
    private Organigrama claveArea;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Roles idrol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRegistro")
    private List<InvEquipo> invEquipoList;
    @OneToMany(mappedBy = "usuario")
    private List<InvMantenimientoProgramado> invMantenimientoProgramadoList;

    public Usuario() {
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<AsistenciaAula> getAsistenciaAulaList() {
        return asistenciaAulaList;
    }

    public void setAsistenciaAulaList(List<AsistenciaAula> asistenciaAulaList) {
        this.asistenciaAulaList = asistenciaAulaList;
    }

    public EstatusUsuario getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(EstatusUsuario idestatus) {
        this.idestatus = idestatus;
    }

    public Organigrama getClaveArea() {
        return claveArea;
    }

    public void setClaveArea(Organigrama claveArea) {
        this.claveArea = claveArea;
    }

    public Roles getIdrol() {
        return idrol;
    }

    public void setIdrol(Roles idrol) {
        this.idrol = idrol;
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
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ usuario=" + usuario + " ]";
    }

    @XmlTransient
    public List<HistoriaAlumno> getHistoriaAlumnoList() {
        return historiaAlumnoList;
    }

    public void setHistoriaAlumnoList(List<HistoriaAlumno> historiaAlumnoList) {
        this.historiaAlumnoList = historiaAlumnoList;
    }

    @XmlTransient
    public List<PermisosFunciones> getPermisosFuncionesList() {
        return permisosFuncionesList;
    }

    public void setPermisosFuncionesList(List<PermisosFunciones> permisosFuncionesList) {
        this.permisosFuncionesList = permisosFuncionesList;
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }
    
}
