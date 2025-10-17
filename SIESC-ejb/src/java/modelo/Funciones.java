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
@Table(name = "funciones", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funciones.findAll", query = "SELECT f FROM Funciones f"),
    @NamedQuery(name = "Funciones.findByFuncion", query = "SELECT f FROM Funciones f WHERE f.funcion = :funcion"),
    @NamedQuery(name = "Funciones.findByDescripcion", query = "SELECT f FROM Funciones f WHERE f.descripcion = :descripcion")})
public class Funciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funcion")
    private Integer funcion;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "funcion")
    private List<PermisosFunciones> permisosFuncionesList;

    public Funciones() {
    }

    public Funciones(Integer funcion) {
        this.funcion = funcion;
    }

    public Integer getFuncion() {
        return funcion;
    }

    public void setFuncion(Integer funcion) {
        this.funcion = funcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PermisosFunciones> getPermisosFuncionesList() {
        return permisosFuncionesList;
    }

    public void setPermisosFuncionesList(List<PermisosFunciones> permisosFuncionesList) {
        this.permisosFuncionesList = permisosFuncionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcion != null ? funcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funciones)) {
            return false;
        }
        Funciones other = (Funciones) object;
        if ((this.funcion == null && other.funcion != null) || (this.funcion != null && !this.funcion.equals(other.funcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Funciones[ funcion=" + funcion + " ]";
    }
    
}
