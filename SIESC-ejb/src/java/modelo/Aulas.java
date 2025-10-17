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
@Table(name = "aulas", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByAula", query = "SELECT a FROM Aulas a WHERE a.aula = :aula"),
    @NamedQuery(name = "Aulas.findByUbicacion", query = "SELECT a FROM Aulas a WHERE a.ubicacion = :ubicacion"),
    @NamedQuery(name = "Aulas.findByCapacidadAula", query = "SELECT a FROM Aulas a WHERE a.capacidadAula = :capacidadAula"),
    @NamedQuery(name = "Aulas.findByObservaciones", query = "SELECT a FROM Aulas a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "Aulas.findByPermiteCruce", query = "SELECT a FROM Aulas a WHERE a.permiteCruce = :permiteCruce"),
    @NamedQuery(name = "Aulas.findByEstatus", query = "SELECT a FROM Aulas a WHERE a.estatus = :estatus")})
public class Aulas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "aula")
    private String aula;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "capacidad_aula")
    private int capacidadAula;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "permite_cruce")
    private Character permiteCruce;
    @Column(name = "estatus")
    private Character estatus;
    @OneToMany(mappedBy = "aula")
    private List<Horarios> horariosList;
    @OneToMany(mappedBy = "aula")
    private List<Conferencia> conferenciaList;

    public Aulas() {
    }

    public Aulas(String aula) {
        this.aula = aula;
    }

    public Aulas(String aula, int capacidadAula) {
        this.aula = aula;
        this.capacidadAula = capacidadAula;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadAula() {
        return capacidadAula;
    }

    public void setCapacidadAula(int capacidadAula) {
        this.capacidadAula = capacidadAula;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Character getPermiteCruce() {
        return permiteCruce;
    }

    public void setPermiteCruce(Character permiteCruce) {
        this.permiteCruce = permiteCruce;
    }

    public Character getEstatus() {
        return estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Horarios> getHorariosList() {
        return horariosList;
    }

    public void setHorariosList(List<Horarios> horariosList) {
        this.horariosList = horariosList;
    }

    @XmlTransient
    public List<Conferencia> getConferenciaList() {
        return conferenciaList;
    }

    public void setConferenciaList(List<Conferencia> conferenciaList) {
        this.conferenciaList = conferenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aula != null ? aula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.aula == null && other.aula != null) || (this.aula != null && !this.aula.equals(other.aula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Aulas[ aula=" + aula + " ]";
    }
    
}
