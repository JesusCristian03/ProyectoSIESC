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
@Table(name = "personal", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByRfc", query = "SELECT p FROM Personal p WHERE p.rfc = :rfc"),
    @NamedQuery(name = "Personal.findByClaveCentro", query = "SELECT p FROM Personal p WHERE p.claveCentro = :claveCentro"),
    @NamedQuery(name = "Personal.findByCurpEmpleado", query = "SELECT p FROM Personal p WHERE p.curpEmpleado = :curpEmpleado"),
    @NamedQuery(name = "Personal.findByNoTarjeta", query = "SELECT p FROM Personal p WHERE p.noTarjeta = :noTarjeta"),
    @NamedQuery(name = "Personal.findByNombreEmpleado", query = "SELECT p FROM Personal p WHERE p.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Personal.findByNombramiento", query = "SELECT p FROM Personal p WHERE p.nombramiento = :nombramiento"),
    @NamedQuery(name = "Personal.findByIngresoRama", query = "SELECT p FROM Personal p WHERE p.ingresoRama = :ingresoRama"),
    @NamedQuery(name = "Personal.findByInicioGobierno", query = "SELECT p FROM Personal p WHERE p.inicioGobierno = :inicioGobierno"),
    @NamedQuery(name = "Personal.findByInicioSep", query = "SELECT p FROM Personal p WHERE p.inicioSep = :inicioSep"),
    @NamedQuery(name = "Personal.findByInicioPlantel", query = "SELECT p FROM Personal p WHERE p.inicioPlantel = :inicioPlantel"),
    @NamedQuery(name = "Personal.findByDomicilioEmpleado", query = "SELECT p FROM Personal p WHERE p.domicilioEmpleado = :domicilioEmpleado"),
    @NamedQuery(name = "Personal.findByColoniaEmpleado", query = "SELECT p FROM Personal p WHERE p.coloniaEmpleado = :coloniaEmpleado"),
    @NamedQuery(name = "Personal.findByCodigoPostalEmpleado", query = "SELECT p FROM Personal p WHERE p.codigoPostalEmpleado = :codigoPostalEmpleado"),
    @NamedQuery(name = "Personal.findByLocalidad", query = "SELECT p FROM Personal p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Personal.findByTelefonoEmpleado", query = "SELECT p FROM Personal p WHERE p.telefonoEmpleado = :telefonoEmpleado"),
    @NamedQuery(name = "Personal.findBySexoEmpleado", query = "SELECT p FROM Personal p WHERE p.sexoEmpleado = :sexoEmpleado"),
    @NamedQuery(name = "Personal.findByEstadoCivil", query = "SELECT p FROM Personal p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Personal.findByFechaNacimiento", query = "SELECT p FROM Personal p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Personal.findByLugarNacimiento", query = "SELECT p FROM Personal p WHERE p.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "Personal.findByNivelEstudios", query = "SELECT p FROM Personal p WHERE p.nivelEstudios = :nivelEstudios"),
    @NamedQuery(name = "Personal.findByGradoMaximoEstudios", query = "SELECT p FROM Personal p WHERE p.gradoMaximoEstudios = :gradoMaximoEstudios"),
    @NamedQuery(name = "Personal.findByEstatusEmpleado", query = "SELECT p FROM Personal p WHERE p.estatusEmpleado = :estatusEmpleado"),
    @NamedQuery(name = "Personal.findByFoto", query = "SELECT p FROM Personal p WHERE p.foto = :foto"),
    @NamedQuery(name = "Personal.findByFirma", query = "SELECT p FROM Personal p WHERE p.firma = :firma"),
    @NamedQuery(name = "Personal.findByCorreoElectronico", query = "SELECT p FROM Personal p WHERE p.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Personal.findByNumCartillaSmn", query = "SELECT p FROM Personal p WHERE p.numCartillaSmn = :numCartillaSmn"),
    @NamedQuery(name = "Personal.findByObservacionesEmpleado", query = "SELECT p FROM Personal p WHERE p.observacionesEmpleado = :observacionesEmpleado"),
    @NamedQuery(name = "Personal.findByTipoPersonal", query = "SELECT p FROM Personal p WHERE p.tipoPersonal = :tipoPersonal"),
    @NamedQuery(name = "Personal.findByEmergencia", query = "SELECT p FROM Personal p WHERE p.emergencia = :emergencia"),
    @NamedQuery(name = "Personal.findByEntidadFederativa", query = "SELECT p FROM Personal p WHERE p.entidadFederativa = :entidadFederativa"),
    @NamedQuery(name = "Personal.findByMunicipioEmpleado", query = "SELECT p FROM Personal p WHERE p.municipioEmpleado = :municipioEmpleado"),
    @NamedQuery(name = "Personal.findByNacionalidad", query = "SELECT p FROM Personal p WHERE p.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Personal.findByApellidoPaterno", query = "SELECT p FROM Personal p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Personal.findByApellidoMaterno", query = "SELECT p FROM Personal p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Personal.findByIdBiometrico", query = "SELECT p FROM Personal p WHERE p.idBiometrico = :idBiometrico")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "clave_centro")
    private String claveCentro;
    @Column(name = "curp_empleado")
    private String curpEmpleado;
    @Column(name = "no_tarjeta")
    private Integer noTarjeta;
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Basic(optional = false)
    @Column(name = "nombramiento")
    private Character nombramiento;
    @Column(name = "ingreso_rama")
    private String ingresoRama;
    @Column(name = "inicio_gobierno")
    private String inicioGobierno;
    @Column(name = "inicio_sep")
    private String inicioSep;
    @Column(name = "inicio_plantel")
    private String inicioPlantel;
    @Column(name = "domicilio_empleado")
    private String domicilioEmpleado;
    @Column(name = "colonia_empleado")
    private String coloniaEmpleado;
    @Column(name = "codigo_postal_empleado")
    private Integer codigoPostalEmpleado;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;
    @Column(name = "sexo_empleado")
    private Character sexoEmpleado;
    @Column(name = "estado_civil")
    private Character estadoCivil;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "lugar_nacimiento")
    private Integer lugarNacimiento;
    @Column(name = "nivel_estudios")
    private Character nivelEstudios;
    @Column(name = "grado_maximo_estudios")
    private Character gradoMaximoEstudios;
    @Column(name = "estatus_empleado")
    private String estatusEmpleado;
    @Column(name = "foto")
    private String foto;
    @Column(name = "firma")
    private String firma;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "num_cartilla_smn")
    private String numCartillaSmn;
    @Column(name = "observaciones_empleado")
    private String observacionesEmpleado;
    @Column(name = "tipo_personal")
    private Character tipoPersonal;
    @Column(name = "emergencia")
    private String emergencia;
    @Column(name = "entidad_federativa")
    private String entidadFederativa;
    @Column(name = "municipio_empleado")
    private String municipioEmpleado;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "id_biometrico")
    private Integer idBiometrico;
    @OneToMany(mappedBy = "rfc")
    private List<PersonalCursoAsistente> personalCursoAsistenteList;
    @JoinColumn(name = "area_academica", referencedColumnName = "clave_area")
    @ManyToOne
    private Organigrama areaAcademica;
    @JoinColumn(name = "clave_area", referencedColumnName = "clave_area")
    @ManyToOne(optional = false)
    private Organigrama claveArea;
    @OneToMany(mappedBy = "rfc")
    private List<Horarios> horariosList;
    @OneToMany(mappedBy = "rfc")
    private List<PersonalEstudios> personalEstudiosList;
    @OneToMany(mappedBy = "rfc")
    private List<RhBiometrico> rhBiometricoList;
    @OneToMany(mappedBy = "rfc")
    private List<Grupos> gruposList;

    public Personal() {
    }

    public Personal(String rfc) {
        this.rfc = rfc;
    }

    public Personal(String rfc, Character nombramiento) {
        this.rfc = rfc;
        this.nombramiento = nombramiento;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getClaveCentro() {
        return claveCentro;
    }

    public void setClaveCentro(String claveCentro) {
        this.claveCentro = claveCentro;
    }

    public String getCurpEmpleado() {
        return curpEmpleado;
    }

    public void setCurpEmpleado(String curpEmpleado) {
        this.curpEmpleado = curpEmpleado;
    }

    public Integer getNoTarjeta() {
        return noTarjeta;
    }

    public void setNoTarjeta(Integer noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Character getNombramiento() {
        return nombramiento;
    }

    public void setNombramiento(Character nombramiento) {
        this.nombramiento = nombramiento;
    }

    public String getIngresoRama() {
        return ingresoRama;
    }

    public void setIngresoRama(String ingresoRama) {
        this.ingresoRama = ingresoRama;
    }

    public String getInicioGobierno() {
        return inicioGobierno;
    }

    public void setInicioGobierno(String inicioGobierno) {
        this.inicioGobierno = inicioGobierno;
    }

    public String getInicioSep() {
        return inicioSep;
    }

    public void setInicioSep(String inicioSep) {
        this.inicioSep = inicioSep;
    }

    public String getInicioPlantel() {
        return inicioPlantel;
    }

    public void setInicioPlantel(String inicioPlantel) {
        this.inicioPlantel = inicioPlantel;
    }

    public String getDomicilioEmpleado() {
        return domicilioEmpleado;
    }

    public void setDomicilioEmpleado(String domicilioEmpleado) {
        this.domicilioEmpleado = domicilioEmpleado;
    }

    public String getColoniaEmpleado() {
        return coloniaEmpleado;
    }

    public void setColoniaEmpleado(String coloniaEmpleado) {
        this.coloniaEmpleado = coloniaEmpleado;
    }

    public Integer getCodigoPostalEmpleado() {
        return codigoPostalEmpleado;
    }

    public void setCodigoPostalEmpleado(Integer codigoPostalEmpleado) {
        this.codigoPostalEmpleado = codigoPostalEmpleado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public Character getSexoEmpleado() {
        return sexoEmpleado;
    }

    public void setSexoEmpleado(Character sexoEmpleado) {
        this.sexoEmpleado = sexoEmpleado;
    }

    public Character getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(Integer lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Character getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(Character nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public Character getGradoMaximoEstudios() {
        return gradoMaximoEstudios;
    }

    public void setGradoMaximoEstudios(Character gradoMaximoEstudios) {
        this.gradoMaximoEstudios = gradoMaximoEstudios;
    }

    public String getEstatusEmpleado() {
        return estatusEmpleado;
    }

    public void setEstatusEmpleado(String estatusEmpleado) {
        this.estatusEmpleado = estatusEmpleado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumCartillaSmn() {
        return numCartillaSmn;
    }

    public void setNumCartillaSmn(String numCartillaSmn) {
        this.numCartillaSmn = numCartillaSmn;
    }

    public String getObservacionesEmpleado() {
        return observacionesEmpleado;
    }

    public void setObservacionesEmpleado(String observacionesEmpleado) {
        this.observacionesEmpleado = observacionesEmpleado;
    }

    public Character getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(Character tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public String getMunicipioEmpleado() {
        return municipioEmpleado;
    }

    public void setMunicipioEmpleado(String municipioEmpleado) {
        this.municipioEmpleado = municipioEmpleado;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Integer getIdBiometrico() {
        return idBiometrico;
    }

    public void setIdBiometrico(Integer idBiometrico) {
        this.idBiometrico = idBiometrico;
    }

    @XmlTransient
    public List<PersonalCursoAsistente> getPersonalCursoAsistenteList() {
        return personalCursoAsistenteList;
    }

    public void setPersonalCursoAsistenteList(List<PersonalCursoAsistente> personalCursoAsistenteList) {
        this.personalCursoAsistenteList = personalCursoAsistenteList;
    }

    public Organigrama getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(Organigrama areaAcademica) {
        this.areaAcademica = areaAcademica;
    }

    public Organigrama getClaveArea() {
        return claveArea;
    }

    public void setClaveArea(Organigrama claveArea) {
        this.claveArea = claveArea;
    }

    @XmlTransient
    public List<Horarios> getHorariosList() {
        return horariosList;
    }

    public void setHorariosList(List<Horarios> horariosList) {
        this.horariosList = horariosList;
    }

    @XmlTransient
    public List<PersonalEstudios> getPersonalEstudiosList() {
        return personalEstudiosList;
    }

    public void setPersonalEstudiosList(List<PersonalEstudios> personalEstudiosList) {
        this.personalEstudiosList = personalEstudiosList;
    }

    @XmlTransient
    public List<RhBiometrico> getRhBiometricoList() {
        return rhBiometricoList;
    }

    public void setRhBiometricoList(List<RhBiometrico> rhBiometricoList) {
        this.rhBiometricoList = rhBiometricoList;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfc != null ? rfc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.rfc == null && other.rfc != null) || (this.rfc != null && !this.rfc.equals(other.rfc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Personal[ rfc=" + rfc + " ]";
    }
    
}
