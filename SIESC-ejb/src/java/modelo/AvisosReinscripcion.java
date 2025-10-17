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
@Table(name = "avisos_reinscripcion", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvisosReinscripcion.findAll", query = "SELECT a FROM AvisosReinscripcion a"),
    @NamedQuery(name = "AvisosReinscripcion.findByIdAvisoReinscripcion", query = "SELECT a FROM AvisosReinscripcion a WHERE a.idAvisoReinscripcion = :idAvisoReinscripcion"),
    @NamedQuery(name = "AvisosReinscripcion.findByAutorizaEscolar", query = "SELECT a FROM AvisosReinscripcion a WHERE a.autorizaEscolar = :autorizaEscolar"),
    @NamedQuery(name = "AvisosReinscripcion.findByReciboPago", query = "SELECT a FROM AvisosReinscripcion a WHERE a.reciboPago = :reciboPago"),
    @NamedQuery(name = "AvisosReinscripcion.findByFechaRecibo", query = "SELECT a FROM AvisosReinscripcion a WHERE a.fechaRecibo = :fechaRecibo"),
    @NamedQuery(name = "AvisosReinscripcion.findByCuentaPago", query = "SELECT a FROM AvisosReinscripcion a WHERE a.cuentaPago = :cuentaPago"),
    @NamedQuery(name = "AvisosReinscripcion.findByFechaHoraSeleccion", query = "SELECT a FROM AvisosReinscripcion a WHERE a.fechaHoraSeleccion = :fechaHoraSeleccion"),
    @NamedQuery(name = "AvisosReinscripcion.findByLugarSeleccion", query = "SELECT a FROM AvisosReinscripcion a WHERE a.lugarSeleccion = :lugarSeleccion"),
    @NamedQuery(name = "AvisosReinscripcion.findByFechaHoraPago", query = "SELECT a FROM AvisosReinscripcion a WHERE a.fechaHoraPago = :fechaHoraPago"),
    @NamedQuery(name = "AvisosReinscripcion.findByLugarPago", query = "SELECT a FROM AvisosReinscripcion a WHERE a.lugarPago = :lugarPago"),
    @NamedQuery(name = "AvisosReinscripcion.findByAdeudaEscolar", query = "SELECT a FROM AvisosReinscripcion a WHERE a.adeudaEscolar = :adeudaEscolar"),
    @NamedQuery(name = "AvisosReinscripcion.findByAdeudaBiblioteca", query = "SELECT a FROM AvisosReinscripcion a WHERE a.adeudaBiblioteca = :adeudaBiblioteca"),
    @NamedQuery(name = "AvisosReinscripcion.findByAdeudaFinancieros", query = "SELECT a FROM AvisosReinscripcion a WHERE a.adeudaFinancieros = :adeudaFinancieros"),
    @NamedQuery(name = "AvisosReinscripcion.findByOtroMensaje", query = "SELECT a FROM AvisosReinscripcion a WHERE a.otroMensaje = :otroMensaje"),
    @NamedQuery(name = "AvisosReinscripcion.findByBaja", query = "SELECT a FROM AvisosReinscripcion a WHERE a.baja = :baja"),
    @NamedQuery(name = "AvisosReinscripcion.findByMotivoAvisoBaja", query = "SELECT a FROM AvisosReinscripcion a WHERE a.motivoAvisoBaja = :motivoAvisoBaja"),
    @NamedQuery(name = "AvisosReinscripcion.findByEgresa", query = "SELECT a FROM AvisosReinscripcion a WHERE a.egresa = :egresa"),
    @NamedQuery(name = "AvisosReinscripcion.findByEncuesto", query = "SELECT a FROM AvisosReinscripcion a WHERE a.encuesto = :encuesto"),
    @NamedQuery(name = "AvisosReinscripcion.findByVoboAdelantaSel", query = "SELECT a FROM AvisosReinscripcion a WHERE a.voboAdelantaSel = :voboAdelantaSel"),
    @NamedQuery(name = "AvisosReinscripcion.findByRegular", query = "SELECT a FROM AvisosReinscripcion a WHERE a.regular = :regular"),
    @NamedQuery(name = "AvisosReinscripcion.findByIndiceReprobacion", query = "SELECT a FROM AvisosReinscripcion a WHERE a.indiceReprobacion = :indiceReprobacion"),
    @NamedQuery(name = "AvisosReinscripcion.findByCreditosAutorizados", query = "SELECT a FROM AvisosReinscripcion a WHERE a.creditosAutorizados = :creditosAutorizados"),
    @NamedQuery(name = "AvisosReinscripcion.findByEstatusReinscripcion", query = "SELECT a FROM AvisosReinscripcion a WHERE a.estatusReinscripcion = :estatusReinscripcion"),
    @NamedQuery(name = "AvisosReinscripcion.findBySemeste", query = "SELECT a FROM AvisosReinscripcion a WHERE a.semeste = :semeste"),
    @NamedQuery(name = "AvisosReinscripcion.findByPromedio", query = "SELECT a FROM AvisosReinscripcion a WHERE a.promedio = :promedio"),
    @NamedQuery(name = "AvisosReinscripcion.findByAdeudoEspecial", query = "SELECT a FROM AvisosReinscripcion a WHERE a.adeudoEspecial = :adeudoEspecial"),
    @NamedQuery(name = "AvisosReinscripcion.findByPromedioAcumulado", query = "SELECT a FROM AvisosReinscripcion a WHERE a.promedioAcumulado = :promedioAcumulado"),
    @NamedQuery(name = "AvisosReinscripcion.findByProareas", query = "SELECT a FROM AvisosReinscripcion a WHERE a.proareas = :proareas")})
public class AvisosReinscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aviso_reinscripcion")
    private Integer idAvisoReinscripcion;
    @Column(name = "autoriza_escolar")
    private Character autorizaEscolar;
    @Column(name = "recibo_pago")
    private String reciboPago;
    @Column(name = "fecha_recibo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecibo;
    @Column(name = "cuenta_pago")
    private String cuentaPago;
    @Column(name = "fecha_hora_seleccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraSeleccion;
    @Column(name = "lugar_seleccion")
    private String lugarSeleccion;
    @Column(name = "fecha_hora_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPago;
    @Column(name = "lugar_pago")
    private String lugarPago;
    @Column(name = "adeuda_escolar")
    private Character adeudaEscolar;
    @Column(name = "adeuda_biblioteca")
    private Character adeudaBiblioteca;
    @Column(name = "adeuda_financieros")
    private Character adeudaFinancieros;
    @Column(name = "otro_mensaje")
    private String otroMensaje;
    @Column(name = "baja")
    private Character baja;
    @Column(name = "motivo_aviso_baja")
    private String motivoAvisoBaja;
    @Column(name = "egresa")
    private Character egresa;
    @Column(name = "encuesto")
    private Character encuesto;
    @Column(name = "vobo_adelanta_sel")
    private Character voboAdelantaSel;
    @Column(name = "regular")
    private Character regular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "indice_reprobacion")
    private Double indiceReprobacion;
    @Column(name = "creditos_autorizados")
    private Integer creditosAutorizados;
    @Column(name = "estatus_reinscripcion")
    private Character estatusReinscripcion;
    @Column(name = "semeste")
    private Integer semeste;
    @Column(name = "promedio")
    private Double promedio;
    @Column(name = "adeudo_especial")
    private Character adeudoEspecial;
    @Column(name = "promedio_acumulado")
    private Double promedioAcumulado;
    @Column(name = "proareas")
    private Character proareas;
    @JoinColumn(name = "no_de_control", referencedColumnName = "no_de_control")
    @ManyToOne
    private Estudiante noDeControl;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne
    private PeriodoEscolar periodo;

    public AvisosReinscripcion() {
    }

    public AvisosReinscripcion(Integer idAvisoReinscripcion) {
        this.idAvisoReinscripcion = idAvisoReinscripcion;
    }

    public Integer getIdAvisoReinscripcion() {
        return idAvisoReinscripcion;
    }

    public void setIdAvisoReinscripcion(Integer idAvisoReinscripcion) {
        this.idAvisoReinscripcion = idAvisoReinscripcion;
    }

    public Character getAutorizaEscolar() {
        return autorizaEscolar;
    }

    public void setAutorizaEscolar(Character autorizaEscolar) {
        this.autorizaEscolar = autorizaEscolar;
    }

    public String getReciboPago() {
        return reciboPago;
    }

    public void setReciboPago(String reciboPago) {
        this.reciboPago = reciboPago;
    }

    public Date getFechaRecibo() {
        return fechaRecibo;
    }

    public void setFechaRecibo(Date fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
    }

    public String getCuentaPago() {
        return cuentaPago;
    }

    public void setCuentaPago(String cuentaPago) {
        this.cuentaPago = cuentaPago;
    }

    public Date getFechaHoraSeleccion() {
        return fechaHoraSeleccion;
    }

    public void setFechaHoraSeleccion(Date fechaHoraSeleccion) {
        this.fechaHoraSeleccion = fechaHoraSeleccion;
    }

    public String getLugarSeleccion() {
        return lugarSeleccion;
    }

    public void setLugarSeleccion(String lugarSeleccion) {
        this.lugarSeleccion = lugarSeleccion;
    }

    public Date getFechaHoraPago() {
        return fechaHoraPago;
    }

    public void setFechaHoraPago(Date fechaHoraPago) {
        this.fechaHoraPago = fechaHoraPago;
    }

    public String getLugarPago() {
        return lugarPago;
    }

    public void setLugarPago(String lugarPago) {
        this.lugarPago = lugarPago;
    }

    public Character getAdeudaEscolar() {
        return adeudaEscolar;
    }

    public void setAdeudaEscolar(Character adeudaEscolar) {
        this.adeudaEscolar = adeudaEscolar;
    }

    public Character getAdeudaBiblioteca() {
        return adeudaBiblioteca;
    }

    public void setAdeudaBiblioteca(Character adeudaBiblioteca) {
        this.adeudaBiblioteca = adeudaBiblioteca;
    }

    public Character getAdeudaFinancieros() {
        return adeudaFinancieros;
    }

    public void setAdeudaFinancieros(Character adeudaFinancieros) {
        this.adeudaFinancieros = adeudaFinancieros;
    }

    public String getOtroMensaje() {
        return otroMensaje;
    }

    public void setOtroMensaje(String otroMensaje) {
        this.otroMensaje = otroMensaje;
    }

    public Character getBaja() {
        return baja;
    }

    public void setBaja(Character baja) {
        this.baja = baja;
    }

    public String getMotivoAvisoBaja() {
        return motivoAvisoBaja;
    }

    public void setMotivoAvisoBaja(String motivoAvisoBaja) {
        this.motivoAvisoBaja = motivoAvisoBaja;
    }

    public Character getEgresa() {
        return egresa;
    }

    public void setEgresa(Character egresa) {
        this.egresa = egresa;
    }

    public Character getEncuesto() {
        return encuesto;
    }

    public void setEncuesto(Character encuesto) {
        this.encuesto = encuesto;
    }

    public Character getVoboAdelantaSel() {
        return voboAdelantaSel;
    }

    public void setVoboAdelantaSel(Character voboAdelantaSel) {
        this.voboAdelantaSel = voboAdelantaSel;
    }

    public Character getRegular() {
        return regular;
    }

    public void setRegular(Character regular) {
        this.regular = regular;
    }

    public Double getIndiceReprobacion() {
        return indiceReprobacion;
    }

    public void setIndiceReprobacion(Double indiceReprobacion) {
        this.indiceReprobacion = indiceReprobacion;
    }

    public Integer getCreditosAutorizados() {
        return creditosAutorizados;
    }

    public void setCreditosAutorizados(Integer creditosAutorizados) {
        this.creditosAutorizados = creditosAutorizados;
    }

    public Character getEstatusReinscripcion() {
        return estatusReinscripcion;
    }

    public void setEstatusReinscripcion(Character estatusReinscripcion) {
        this.estatusReinscripcion = estatusReinscripcion;
    }

    public Integer getSemeste() {
        return semeste;
    }

    public void setSemeste(Integer semeste) {
        this.semeste = semeste;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Character getAdeudoEspecial() {
        return adeudoEspecial;
    }

    public void setAdeudoEspecial(Character adeudoEspecial) {
        this.adeudoEspecial = adeudoEspecial;
    }

    public Double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(Double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public Character getProareas() {
        return proareas;
    }

    public void setProareas(Character proareas) {
        this.proareas = proareas;
    }

    public Estudiante getNoDeControl() {
        return noDeControl;
    }

    public void setNoDeControl(Estudiante noDeControl) {
        this.noDeControl = noDeControl;
    }

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvisoReinscripcion != null ? idAvisoReinscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvisosReinscripcion)) {
            return false;
        }
        AvisosReinscripcion other = (AvisosReinscripcion) object;
        if ((this.idAvisoReinscripcion == null && other.idAvisoReinscripcion != null) || (this.idAvisoReinscripcion != null && !this.idAvisoReinscripcion.equals(other.idAvisoReinscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AvisosReinscripcion[ idAvisoReinscripcion=" + idAvisoReinscripcion + " ]";
    }
    
}
