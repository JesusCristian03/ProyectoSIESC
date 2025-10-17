/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "organigrama", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organigrama.findAll", query = "SELECT o FROM Organigrama o"),
    @NamedQuery(name = "Organigrama.findByClaveArea", query = "SELECT o FROM Organigrama o WHERE o.claveArea = :claveArea"),
    @NamedQuery(name = "Organigrama.findByDescripcionArea", query = "SELECT o FROM Organigrama o WHERE o.descripcionArea = :descripcionArea"),
    @NamedQuery(name = "Organigrama.findByAreaDepende", query = "SELECT o FROM Organigrama o WHERE o.areaDepende = :areaDepende"),
    @NamedQuery(name = "Organigrama.findByNivel", query = "SELECT o FROM Organigrama o WHERE o.nivel = :nivel"),
    @NamedQuery(name = "Organigrama.findByTipoArea", query = "SELECT o FROM Organigrama o WHERE o.tipoArea = :tipoArea"),
    @NamedQuery(name = "Organigrama.findByExtension", query = "SELECT o FROM Organigrama o WHERE o.extension = :extension"),
    @NamedQuery(name = "Organigrama.findBySiglas", query = "SELECT o FROM Organigrama o WHERE o.siglas = :siglas")})
public class Organigrama implements Serializable {

    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "claveArea")
    private List<Permisos> permisosList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clave_area")
    private String claveArea;
    @Column(name = "descripcion_area")
    private String descripcionArea;
    @Column(name = "area_depende")
    private String areaDepende;
    @Column(name = "nivel")
    private Character nivel;
    @Column(name = "tipo_area")
    private Character tipoArea;
    @Column(name = "extension")
    private String extension;
    @Column(name = "siglas")
    private String siglas;
    @OneToMany(mappedBy = "areaAcademica")
    private List<Personal> personalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claveArea")
    private List<Personal> personalList1;
    @OneToMany(mappedBy = "claveArea")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "claveAreaDepto")
    private List<InvEquipo> invEquipoList;
    @OneToMany(mappedBy = "claveArea")
    private List<Materia> materiaList;

    public Organigrama() {
    }

    public Organigrama(String claveArea) {
        this.claveArea = claveArea;
    }

    public String getClaveArea() {
        return claveArea;
    }

    public void setClaveArea(String claveArea) {
        this.claveArea = claveArea;
    }

    public String getDescripcionArea() {
        return descripcionArea;
    }

    public void setDescripcionArea(String descripcionArea) {
        this.descripcionArea = descripcionArea;
    }

    public String getAreaDepende() {
        return areaDepende;
    }

    public void setAreaDepende(String areaDepende) {
        this.areaDepende = areaDepende;
    }

    public Character getNivel() {
        return nivel;
    }

    public void setNivel(Character nivel) {
        this.nivel = nivel;
    }

    public Character getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(Character tipoArea) {
        this.tipoArea = tipoArea;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @XmlTransient
    public List<Personal> getPersonalList() {
        return personalList;
    }

    public void setPersonalList(List<Personal> personalList) {
        this.personalList = personalList;
    }

    @XmlTransient
    public List<Personal> getPersonalList1() {
        return personalList1;
    }

    public void setPersonalList1(List<Personal> personalList1) {
        this.personalList1 = personalList1;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<InvEquipo> getInvEquipoList() {
        return invEquipoList;
    }

    public void setInvEquipoList(List<InvEquipo> invEquipoList) {
        this.invEquipoList = invEquipoList;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveArea != null ? claveArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organigrama)) {
            return false;
        }
        Organigrama other = (Organigrama) object;
        if ((this.claveArea == null && other.claveArea != null) || (this.claveArea != null && !this.claveArea.equals(other.claveArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Organigrama[ claveArea=" + claveArea + " ]";
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
