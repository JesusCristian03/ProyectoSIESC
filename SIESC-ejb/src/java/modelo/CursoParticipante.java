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
@Table(name = "curso_participante", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoParticipante.findAll", query = "SELECT c FROM CursoParticipante c"),
    @NamedQuery(name = "CursoParticipante.findByRfcParticipante", query = "SELECT c FROM CursoParticipante c WHERE c.rfcParticipante = :rfcParticipante"),
    @NamedQuery(name = "CursoParticipante.findByIdCodigo", query = "SELECT c FROM CursoParticipante c WHERE c.idCodigo = :idCodigo"),
    @NamedQuery(name = "CursoParticipante.findByApellidosParticipante", query = "SELECT c FROM CursoParticipante c WHERE c.apellidosParticipante = :apellidosParticipante"),
    @NamedQuery(name = "CursoParticipante.findByNombreParticipante", query = "SELECT c FROM CursoParticipante c WHERE c.nombreParticipante = :nombreParticipante"),
    @NamedQuery(name = "CursoParticipante.findByItOrigen", query = "SELECT c FROM CursoParticipante c WHERE c.itOrigen = :itOrigen"),
    @NamedQuery(name = "CursoParticipante.findBySexoParticipante", query = "SELECT c FROM CursoParticipante c WHERE c.sexoParticipante = :sexoParticipante"),
    @NamedQuery(name = "CursoParticipante.findByPuesto", query = "SELECT c FROM CursoParticipante c WHERE c.puesto = :puesto")})
public class CursoParticipante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rfc_participante")
    private String rfcParticipante;
    @Column(name = "id_codigo")
    private String idCodigo;
    @Column(name = "apellidos_participante")
    private String apellidosParticipante;
    @Column(name = "nombre_participante")
    private String nombreParticipante;
    @Column(name = "it_origen")
    private String itOrigen;
    @Column(name = "sexo_participante")
    private Character sexoParticipante;
    @Column(name = "puesto")
    private String puesto;
    @OneToMany(mappedBy = "idParticipante")
    private List<CursoAsistencia> cursoAsistenciaList;
    @OneToMany(mappedBy = "idParticipante")
    private List<CursoInstructorParticipante> cursoInstructorParticipanteList;

    public CursoParticipante() {
    }

    public CursoParticipante(String rfcParticipante) {
        this.rfcParticipante = rfcParticipante;
    }

    public String getRfcParticipante() {
        return rfcParticipante;
    }

    public void setRfcParticipante(String rfcParticipante) {
        this.rfcParticipante = rfcParticipante;
    }

    public String getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getApellidosParticipante() {
        return apellidosParticipante;
    }

    public void setApellidosParticipante(String apellidosParticipante) {
        this.apellidosParticipante = apellidosParticipante;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public String getItOrigen() {
        return itOrigen;
    }

    public void setItOrigen(String itOrigen) {
        this.itOrigen = itOrigen;
    }

    public Character getSexoParticipante() {
        return sexoParticipante;
    }

    public void setSexoParticipante(Character sexoParticipante) {
        this.sexoParticipante = sexoParticipante;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @XmlTransient
    public List<CursoAsistencia> getCursoAsistenciaList() {
        return cursoAsistenciaList;
    }

    public void setCursoAsistenciaList(List<CursoAsistencia> cursoAsistenciaList) {
        this.cursoAsistenciaList = cursoAsistenciaList;
    }

    @XmlTransient
    public List<CursoInstructorParticipante> getCursoInstructorParticipanteList() {
        return cursoInstructorParticipanteList;
    }

    public void setCursoInstructorParticipanteList(List<CursoInstructorParticipante> cursoInstructorParticipanteList) {
        this.cursoInstructorParticipanteList = cursoInstructorParticipanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfcParticipante != null ? rfcParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoParticipante)) {
            return false;
        }
        CursoParticipante other = (CursoParticipante) object;
        if ((this.rfcParticipante == null && other.rfcParticipante != null) || (this.rfcParticipante != null && !this.rfcParticipante.equals(other.rfcParticipante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CursoParticipante[ rfcParticipante=" + rfcParticipante + " ]";
    }
    
}
