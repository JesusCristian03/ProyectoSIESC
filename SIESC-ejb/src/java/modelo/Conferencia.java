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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "conferencia", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferencia.findAll", query = "SELECT c FROM Conferencia c"),
    @NamedQuery(name = "Conferencia.findByIdConferencia", query = "SELECT c FROM Conferencia c WHERE c.idConferencia = :idConferencia"),
    @NamedQuery(name = "Conferencia.findByNombre", query = "SELECT c FROM Conferencia c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Conferencia.findByFecha", query = "SELECT c FROM Conferencia c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Conferencia.findByHora", query = "SELECT c FROM Conferencia c WHERE c.hora = :hora"),
    @NamedQuery(name = "Conferencia.findByPonente", query = "SELECT c FROM Conferencia c WHERE c.ponente = :ponente")})
public class Conferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conferencia")
    private Integer idConferencia;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "ponente")
    private String ponente;
    @JoinColumn(name = "aula", referencedColumnName = "aula")
    @ManyToOne
    private Aulas aula;
    @OneToMany(mappedBy = "idConferencia")
    private List<AsistenciaConferencia> asistenciaConferenciaList;

    public Conferencia() {
    }

    public Conferencia(Integer idConferencia) {
        this.idConferencia = idConferencia;
    }

    public Integer getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(Integer idConferencia) {
        this.idConferencia = idConferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getPonente() {
        return ponente;
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }

    public Aulas getAula() {
        return aula;
    }

    public void setAula(Aulas aula) {
        this.aula = aula;
    }

    @XmlTransient
    public List<AsistenciaConferencia> getAsistenciaConferenciaList() {
        return asistenciaConferenciaList;
    }

    public void setAsistenciaConferenciaList(List<AsistenciaConferencia> asistenciaConferenciaList) {
        this.asistenciaConferenciaList = asistenciaConferenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConferencia != null ? idConferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferencia)) {
            return false;
        }
        Conferencia other = (Conferencia) object;
        if ((this.idConferencia == null && other.idConferencia != null) || (this.idConferencia != null && !this.idConferencia.equals(other.idConferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Conferencia[ idConferencia=" + idConferencia + " ]";
    }
    
}
