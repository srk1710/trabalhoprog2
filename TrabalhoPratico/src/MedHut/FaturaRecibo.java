/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import java.util.*;
import java.io.Serializable;


/**
 *
 * @author srk
 */
public class FaturaRecibo implements Serializable{
    private Date dataFatura;
    private float valorTotal;
    private float valorPago;
    private boolean anulada = false;
    private Consulta consulta;
    
    public FaturaRecibo(Consulta consulta){
        this.consulta= consulta;
        this.dataFatura = new Date();
    }
    
    public FaturaRecibo(Consulta consulta, float valorTotal){
        this.consulta = consulta;
        this.valorTotal = valorTotal;
        this.dataFatura = new Date();
    }

    public Date getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(Date dataFatura) {
        this.dataFatura = dataFatura;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public boolean isAnulada() {
        return anulada;
    }

    public void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    
    
}
