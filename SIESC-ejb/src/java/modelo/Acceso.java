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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "acceso", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a"),
    @NamedQuery(name = "Acceso.findByIdAcceso", query = "SELECT a FROM Acceso a WHERE a.idAcceso = :idAcceso"),
    @NamedQuery(name = "Acceso.findByIdTarjeta", query = "SELECT a FROM Acceso a WHERE a.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "Acceso.findBySalida", query = "SELECT a FROM Acceso a WHERE a.salida = :salida"),
    @NamedQuery(name = "Acceso.findByEntrada", query = "SELECT a FROM Acceso a WHERE a.entrada = :entrada")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acceso")
    private Integer idAcceso;
    @Column(name = "id_tarjeta")
    private String idTarjeta;
    @Column(name = "salida")
    @Temporal(TemporalType.TIME)
    private Date salida;
    @Column(name = "entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @JoinColumn(name = "tornillo_entrada", referencedColumnName = "id_tornillo")
    @ManyToOne
    private Tornillo tornilloEntrada;
    @JoinColumn(name = "tornillo_salida", referencedColumnName = "id_tornillo")
    @ManyToOne
    private Tornillo tornilloSalida;

    public Acceso() {
    }

    public Acceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Integer getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Tornillo getTornilloEntrada() {
        return tornilloEntrada;
    }

    public void setTornilloEntrada(Tornillo tornilloEntrada) {
        this.tornilloEntrada = tornilloEntrada;
    }

    public Tornillo getTornilloSalida() {
        return tornilloSalida;
    }

    public void setTornilloSalida(Tornillo tornilloSalida) {
        this.tornilloSalida = tornilloSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcceso != null ? idAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.idAcceso == null && other.idAcceso != null) || (this.idAcceso != null && !this.idAcceso.equals(other.idAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Acceso[ idAcceso=" + idAcceso + " ]";
    }
    
}
