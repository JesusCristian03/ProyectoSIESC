/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Tarjeta;

/**
 *
 * @author gacev
 */
@Stateless
public class TarjetaFacade extends AbstractFacade<Tarjeta> implements TarjetaFacadeLocal {

    @PersistenceContext(unitName = "SIESC-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarjetaFacade() {
        super(Tarjeta.class);
    }

    @Override
    public Tarjeta buscarActivo(String idTarjeta) {
        Tarjeta aux = null;
        String estatus = "ACT";
        String sql = "SELECT t FROM Tarjeta t WHERE t.idTarjeta =:idTarjeta AND t.idEstatus.idEstatus =:estatus";
        Query query = em.createQuery(sql);
        query.setParameter("idTarjeta",idTarjeta);
        query.setParameter("estatus",estatus);
        List<Tarjeta> lista = query.getResultList();
        //System.out.println("Byscar ---" + idTarjeta + "---");
        if(!lista.isEmpty()){
            aux = lista.get(0);
            //System.out.println("usuarioooo : " + aux.getUsuario());
        }
        
        return aux;
    }
    
}
