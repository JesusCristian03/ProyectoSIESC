/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package servicio;

import DAO.HorariosFacadeLoca;
import DAO.PeriodoEscolarFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.HorarioAsignatura;
import modelo.Horarios;

/**
 *
 * @author gacev
 */
@Stateless
public class HorarioAsignaturaServicio implements HorarioAsignaturaServicioLocal {

    @EJB
    private PeriodoEscolarServicioLocal periodoEscolarServicio;

    @EJB
    private HorarioServicioLocal horarioServicio;

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    public List<HorarioAsignatura> buscarHorarioDocente(String rfc, Character tipo){
        List<Horarios> lista = horarioServicio.horarioDocente(periodoEscolarServicio.periodoActual(),rfc,tipo);
        return horariosaHorarioA(lista);
    }
    
    public List<HorarioAsignatura> buscarHorarioAsignatura(String periodo, String materia){
        List<Horarios> lista = horarioServicio.horarioAsignatura(periodoEscolarServicio.periodoActual(),materia);
        return horariosaHorarioA(lista);
    }
    
    public List<HorarioAsignatura> buscarHorarioAsignatura(String periodo, Integer reticula, Integer semestre){
        List<Horarios> lista = horarioServicio.horarioAsignatura(periodoEscolarServicio.periodoActual(), reticula, semestre);
        return horariosaHorarioA(lista);
    }
    
    public List<HorarioAsignatura> buscarHorarioAsignatura(String periodo, Integer reticula){
        List<Horarios> lista = horarioServicio.horarioAsignatura(periodoEscolarServicio.periodoActual(), reticula);
        return horariosaHorarioA(lista);
    }
    
    //Convierte el resultado de la lista de horarios a Lun Mar Mie Juev Vie Sab
    public List<HorarioAsignatura> horariosaHorarioA(List<Horarios> lista){
        ArrayList<HorarioAsignatura> listaAsignaturas = new ArrayList();
        String horaAula;
        String minutos;
        HorarioAsignatura aux = null;
        for (int indice = 0; indice < lista.size(); indice++){
            if (aux == null){
                aux = new HorarioAsignatura();
                aux.setAsignatura(lista.get(indice).getMateria().getNombreCompletoMateria());
                aux.setGrupo(lista.get(indice).getGrupo());
                aux.setMateria(lista.get(indice).getMateria().getMateria());
            }else
                //if (!(aux.getMateria().equals(lista.get(indice).getMateria().getMateria()))){
                if ((aux.getMateria().equals(lista.get(indice).getMateria().getMateria())) && (aux.getGrupo().equals(lista.get(indice).getGrupo())))
                    ;
                else{
                    listaAsignaturas.add(aux);
                    aux = new HorarioAsignatura();
                    aux.setAsignatura(lista.get(indice).getMateria().getNombreCompletoMateria());
                    aux.setGrupo(lista.get(indice).getGrupo());
                    aux.setMateria(lista.get(indice).getMateria().getMateria());
                    
                }
            
            horaAula = String.valueOf(lista.get(indice).getHoraInicial().getHours()) + ":";
            minutos = String.valueOf(lista.get(indice).getHoraInicial().getMinutes()).equals("0") ? "00" : String.valueOf(lista.get(indice).getHoraInicial().getMinutes());
            horaAula += minutos + "-";
            horaAula += String.valueOf(lista.get(indice).getHoraFinal().getHours()) + ":";
            minutos = String.valueOf(lista.get(indice).getHoraFinal().getMinutes()).equals("0") ? "00" : String.valueOf(lista.get(indice).getHoraFinal().getMinutes());
            horaAula += minutos + "/";
            horaAula += lista.get(indice).getAula().getAula();
            
            switch (lista.get(indice).getDiaSemana()){
                case 2: aux.setLunes(horaAula);
                        break;
                case 3: aux.setMartes(horaAula);
                        break;
                case 4: aux.setMiercoles(horaAula);
                        break;
                case 5: aux.setJueves(horaAula);
                        break;
                case 6: aux.setViernes(horaAula);
                        break;
                case 7: aux.setSabado(horaAula);
                        break;
                                
            }            
        }
        listaAsignaturas.add(aux);
        return listaAsignaturas;        
    }
    
    public HorarioAsignatura buscarHorarioAsignatura(String periodo, String materia, String grupo){
        List<Horarios> lista = horarioServicio.horarioAsignatura(periodo, materia, grupo);
        ArrayList<HorarioAsignatura> listaAsignaturas = new ArrayList();
        String horaAula;
        String minutos;
        HorarioAsignatura aux = null;
        for (int indice = 0; indice < lista.size(); indice++){
            if (aux == null){
                aux = new HorarioAsignatura();
                aux.setAsignatura(lista.get(indice).getMateria().getNombreCompletoMateria());
                aux.setGrupo(lista.get(indice).getGrupo());
                aux.setMateria(lista.get(indice).getMateria().getMateria());
            }else
                if ((aux.getMateria().equals(lista.get(indice).getMateria().getMateria())) && (aux.getGrupo().equals(lista.get(indice).getGrupo())))
                    ;
                else{
                    listaAsignaturas.add(aux);
                    aux = new HorarioAsignatura();
                    aux.setAsignatura(lista.get(indice).getMateria().getNombreCompletoMateria());
                    aux.setGrupo(lista.get(indice).getGrupo());
                    aux.setMateria(lista.get(indice).getMateria().getMateria());  
                }
            
            horaAula = String.valueOf(lista.get(indice).getHoraInicial().getHours()) + ":";
            minutos = String.valueOf(lista.get(indice).getHoraInicial().getMinutes()).equals("0") ? "00" : String.valueOf(lista.get(indice).getHoraInicial().getMinutes());
            horaAula += minutos + "-";
            horaAula += String.valueOf(lista.get(indice).getHoraFinal().getHours()) + ":";
            minutos = String.valueOf(lista.get(indice).getHoraFinal().getMinutes()).equals("0") ? "00" : String.valueOf(lista.get(indice).getHoraFinal().getMinutes());
            horaAula += minutos + "/";
            horaAula += lista.get(indice).getAula().getAula();
            
            switch (lista.get(indice).getDiaSemana()){
                case 2: aux.setLunes(horaAula);
                        break;
                case 3: aux.setMartes(horaAula);
                        break;
                case 4: aux.setMiercoles(horaAula);
                        break;
                case 5: aux.setJueves(horaAula);
                        break;
                case 6: aux.setViernes(horaAula);
                        break;
                case 7: aux.setSabado(horaAula);
                        break;
                                
            }            
        }
        //listaAsignaturas.add(aux);
        return aux;
    }    
}
