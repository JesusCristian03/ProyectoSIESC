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
@Table(name = "horarios", catalog = "scit", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h"),
    @NamedQuery(name = "Horarios.findByTipoHorario", query = "SELECT h FROM Horarios h WHERE h.tipoHorario = :tipoHorario"),
    @NamedQuery(name = "Horarios.findByDiaSemana", query = "SELECT h FROM Horarios h WHERE h.diaSemana = :diaSemana"),
    @NamedQuery(name = "Horarios.findByHoraInicial", query = "SELECT h FROM Horarios h WHERE h.horaInicial = :horaInicial"),
    @NamedQuery(name = "Horarios.findByHoraFinal", query = "SELECT h FROM Horarios h WHERE h.horaFinal = :horaFinal"),
    @NamedQuery(name = "Horarios.findByGrupo", query = "SELECT h FROM Horarios h WHERE h.grupo = :grupo"),
    @NamedQuery(name = "Horarios.findByActividad", query = "SELECT h FROM Horarios h WHERE h.actividad = :actividad"),
    @NamedQuery(name = "Horarios.findByVigenciaInicio", query = "SELECT h FROM Horarios h WHERE h.vigenciaInicio = :vigenciaInicio"),
    @NamedQuery(name = "Horarios.findByVigenciaFin", query = "SELECT h FROM Horarios h WHERE h.vigenciaFin = :vigenciaFin"),
    @NamedQuery(name = "Horarios.findByConsecutivoAdmvo", query = "SELECT h FROM Horarios h WHERE h.consecutivoAdmvo = :consecutivoAdmvo"),
    @NamedQuery(name = "Horarios.findByTipoPersonal", query = "SELECT h FROM Horarios h WHERE h.tipoPersonal = :tipoPersonal"),
    @NamedQuery(name = "Horarios.findByIdHorario", query = "SELECT h FROM Horarios h WHERE h.idHorario = :idHorario")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "tipo_horario")
    private Character tipoHorario;
    @Basic(optional = false)
    @Column(name = "dia_semana")
    private short diaSemana;
    @Basic(optional = false)
    @Column(name = "hora_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicial;
    @Column(name = "hora_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFinal;
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "actividad")
    private String actividad;
    @Column(name = "vigencia_inicio")
    @Temporal(TemporalType.DATE)
    private Date vigenciaInicio;
    @Column(name = "vigencia_fin")
    @Temporal(TemporalType.DATE)
    private Date vigenciaFin;
    @Column(name = "consecutivo_admvo")
    private Integer consecutivoAdmvo;
    @Column(name = "tipo_personal")
    private Character tipoPersonal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario")
    private Integer idHorario;
    @OneToMany(mappedBy = "idHorario")
    private List<AsistenciaAula> asistenciaAulaList;
    @JoinColumn(name = "aula", referencedColumnName = "aula")
    @ManyToOne
    private Aulas aula;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private Grupos idGrupo;
    @JoinColumn(name = "materia", referencedColumnName = "materia")
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "periodo", referencedColumnName = "periodo")
    @ManyToOne(optional = false)
    private PeriodoEscolar periodo;
    @JoinColumn(name = "rfc", referencedColumnName = "rfc")
    @ManyToOne
    private Personal rfc;
    @OneToMany(mappedBy = "idHorario")
    private List<AsistenciaPrefecto> asistenciaPrefectoList;

    public Horarios() {
    }

    public Horarios(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Horarios(Integer idHorario, Character tipoHorario, short diaSemana, Date horaInicial) {
        this.idHorario = idHorario;
        this.tipoHorario = tipoHorario;
        this.diaSemana = diaSemana;
        this.horaInicial = horaInicial;
    }

    public Character getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(Character tipoHorario) {
        this.tipoHorario = tipoHorario;
    }

    public short getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(short diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(Date vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public Date getVigenciaFin() {
        return vigenciaFin;
    }

    public void setVigenciaFin(Date vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
    }

    public Integer getConsecutivoAdmvo() {
        return consecutivoAdmvo;
    }

    public void setConsecutivoAdmvo(Integer consecutivoAdmvo) {
        this.consecutivoAdmvo = consecutivoAdmvo;
    }

    public Character getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(Character tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    @XmlTransient
    public List<AsistenciaAula> getAsistenciaAulaList() {
        return asistenciaAulaList;
    }

    public void setAsistenciaAulaList(List<AsistenciaAula> asistenciaAulaList) {
        this.asistenciaAulaList = asistenciaAulaList;
    }

    public Aulas getAula() {
        return aula;
    }

    public void setAula(Aulas aula) {
        this.aula = aula;
    }

    public Grupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public PeriodoEscolar getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEscolar periodo) {
        this.periodo = periodo;
    }

    public Personal getRfc() {
        return rfc;
    }

    public void setRfc(Personal rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public List<AsistenciaPrefecto> getAsistenciaPrefectoList() {
        return asistenciaPrefectoList;
    }

    public void setAsistenciaPrefectoList(List<AsistenciaPrefecto> asistenciaPrefectoList) {
        this.asistenciaPrefectoList = asistenciaPrefectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Horarios[ idHorario=" + idHorario + " ]";
    }
    
}
