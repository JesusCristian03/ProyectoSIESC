/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelo.PersonalInstitucion;

/**
 *
 * @author gacev
 */
@Local
public interface PersonalInstitucionFacadeLocal {

    void create(PersonalInstitucion personalInstitucion);

    void edit(PersonalInstitucion personalInstitucion);

    void remove(PersonalInstitucion personalInstitucion);

    PersonalInstitucion find(Object id);

    List<PersonalInstitucion> findAll();

    List<PersonalInstitucion> findRange(int[] range);

    int count();
    
}
