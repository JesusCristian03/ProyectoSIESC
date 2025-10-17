/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gacev
 */
@Entity
@Table(name = "inv_equipo_computo", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvEquipoComputo.findAll", query = "SELECT i FROM InvEquipoComputo i"),
    @NamedQuery(name = "InvEquipoComputo.findByIdEquipoComputo", query = "SELECT i FROM InvEquipoComputo i WHERE i.idEquipoComputo = :idEquipoComputo"),
    @NamedQuery(name = "InvEquipoComputo.findByIdEquipoSep", query = "SELECT i FROM InvEquipoComputo i WHERE i.idEquipoSep = :idEquipoSep"),
    @NamedQuery(name = "InvEquipoComputo.findByIp", query = "SELECT i FROM InvEquipoComputo i WHERE i.ip = :ip"),
    @NamedQuery(name = "InvEquipoComputo.findByObservaciones", query = "SELECT i FROM InvEquipoComputo i WHERE i.observaciones = :observaciones"),
    @NamedQuery(name = "InvEquipoComputo.findByRam", query = "SELECT i FROM InvEquipoComputo i WHERE i.ram = :ram"),
    @NamedQuery(name = "InvEquipoComputo.findByDiscoDuro", query = "SELECT i FROM InvEquipoComputo i WHERE i.discoDuro = :discoDuro"),
    @NamedQuery(name = "InvEquipoComputo.findByMicroprocesador", query = "SELECT i FROM InvEquipoComputo i WHERE i.microprocesador = :microprocesador"),
    @NamedQuery(name = "InvEquipoComputo.findByModelo", query = "SELECT i FROM InvEquipoComputo i WHERE i.modelo = :modelo")})
public class InvEquipoComputo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipo_computo")
    private Integer idEquipoComputo;
    @Column(name = "id_equipo_sep")
    private String idEquipoSep;
    @Column(name = "ip")
    private String ip;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "ram")
    private String ram;
    @Column(name = "disco_duro")
    private String discoDuro;
    @Column(name = "microprocesador")
    private String microprocesador;
    @Column(name = "modelo")
    private String modelo;

    public InvEquipoComputo() {
    }

    public InvEquipoComputo(Integer idEquipoComputo) {
        this.idEquipoComputo = idEquipoComputo;
    }

    public Integer getIdEquipoComputo() {
        return idEquipoComputo;
    }

    public void setIdEquipoComputo(Integer idEquipoComputo) {
        this.idEquipoComputo = idEquipoComputo;
    }

    public String getIdEquipoSep() {
        return idEquipoSep;
    }

    public void setIdEquipoSep(String idEquipoSep) {
        this.idEquipoSep = idEquipoSep;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getMicroprocesador() {
        return microprocesador;
    }

    public void setMicroprocesador(String microprocesador) {
        this.microprocesador = microprocesador;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoComputo != null ? idEquipoComputo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvEquipoComputo)) {
            return false;
        }
        InvEquipoComputo other = (InvEquipoComputo) object;
        if ((this.idEquipoComputo == null && other.idEquipoComputo != null) || (this.idEquipoComputo != null && !this.idEquipoComputo.equals(other.idEquipoComputo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InvEquipoComputo[ idEquipoComputo=" + idEquipoComputo + " ]";
    }
    
}
