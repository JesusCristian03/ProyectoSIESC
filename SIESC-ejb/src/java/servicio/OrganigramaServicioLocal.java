/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package servicio;

import javax.ejb.Local;
import modelo.Organigrama;

/**
 *
 * @author cris_
 */
@Local
public interface OrganigramaServicioLocal {
    Organigrama buscarPorId(String x);
}
