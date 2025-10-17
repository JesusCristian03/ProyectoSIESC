/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "permisos_funciones", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosFunciones.findAll", query = "SELECT p FROM PermisosFunciones p"),
    @NamedQuery(name = "PermisosFunciones.findByIdPermisoFuncion", query = "SELECT p FROM PermisosFunciones p WHERE p.idPermisoFuncion = :idPermisoFuncion")})
public class PermisosFunciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso_funcion")
    private Integer idPermisoFuncion;
    @JoinColumn(name = "funcion", referencedColumnName = "funcion")
    @ManyToOne
    private Funciones funcion;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne
    private Usuario usuario;

    public PermisosFunciones() {
    }

    public PermisosFunciones(Integer idPermisoFuncion) {
        this.idPermisoFuncion = idPermisoFuncion;
    }

    public Integer getIdPermisoFuncion() {
        return idPermisoFuncion;
    }

    public void setIdPermisoFuncion(Integer idPermisoFuncion) {
        this.idPermisoFuncion = idPermisoFuncion;
    }

    public Funciones getFuncion() {
        return funcion;
    }

    public void setFuncion(Funciones funcion) {
        this.funcion = funcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisoFuncion != null ? idPermisoFuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosFunciones)) {
            return false;
        }
        PermisosFunciones other = (PermisosFunciones) object;
        if ((this.idPermisoFuncion == null && other.idPermisoFuncion != null) || (this.idPermisoFuncion != null && !this.idPermisoFuncion.equals(other.idPermisoFuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PermisosFunciones[ idPermisoFuncion=" + idPermisoFuncion + " ]";
    }
    
}
