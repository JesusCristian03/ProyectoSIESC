/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author gacev
 */
@Entity

public class Reticula implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private String noDeControl;
    private ReticulaDatos semestre1 = new ReticulaDatos();
    private ReticulaDatos semestre2 = new ReticulaDatos();
    private ReticulaDatos semestre3 = new ReticulaDatos();
    private ReticulaDatos semestre4 = new ReticulaDatos();
    private ReticulaDatos semestre5 = new ReticulaDatos();
    private ReticulaDatos semestre6 = new ReticulaDatos();
    private ReticulaDatos semestre7 = new ReticulaDatos();
    private ReticulaDatos semestre8 = new ReticulaDatos();
    private ReticulaDatos semestre9 = new ReticulaDatos();

    public String getNoDeControl() {
        return noDeControl;
    }

    public void setNoDeControl(String noDeControl) {
        this.noDeControl = noDeControl;
    }

    public ReticulaDatos getSemestre1() {
        return semestre1;
    }

    public void setSemestre1(ReticulaDatos semestre1) {
        this.semestre1 = semestre1;
    }

    public ReticulaDatos getSemestre2() {
        return semestre2;
    }

    public void setSemestre2(ReticulaDatos semestre2) {
        this.semestre2 = semestre2;
    }

    public ReticulaDatos getSemestre3() {
        return semestre3;
    }

    public void setSemestre3(ReticulaDatos semestre3) {
        this.semestre3 = semestre3;
    }

    public ReticulaDatos getSemestre4() {
        return semestre4;
    }

    public void setSemestre4(ReticulaDatos semestre4) {
        this.semestre4 = semestre4;
    }

    public ReticulaDatos getSemestre5() {
        return semestre5;
    }

    public void setSemestre5(ReticulaDatos semestre5) {
        this.semestre5 = semestre5;
    }

    public ReticulaDatos getSemestre6() {
        return semestre6;
    }

    public void setSemestre6(ReticulaDatos semestre6) {
        this.semestre6 = semestre6;
    }

    public ReticulaDatos getSemestre7() {
        return semestre7;
    }

    public void setSemestre7(ReticulaDatos semestre7) {
        this.semestre7 = semestre7;
    }

    public ReticulaDatos getSemestre8() {
        return semestre8;
    }

    public void setSemestre8(ReticulaDatos semestre8) {
        this.semestre8 = semestre8;
    }

    public ReticulaDatos getSemestre9() {
        return semestre9;
    }

    public void setSemestre9(ReticulaDatos semestre9) {
        this.semestre9 = semestre9;
    }
}
