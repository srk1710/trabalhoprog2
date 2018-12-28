/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;

import java.util.*;
import Utilizadores.*;
import java.io.Serializable;

/**
 *
 * @author srk
 */
public class Consulta extends Marcacao implements Serializable{
    
    private float duracaoConsulta;
    private float duracaoMaxima=1;    // corresponde à duracao maxima em horas
    private float preco;
    private Date inicioConsulta;
    private boolean pago;
    private Set<ArtigoDespesa> despesas;

    public Consulta(Date dataConsulta, Cliente cliente) {
        super(dataConsulta, cliente);
    }

    public float getDuracaoConsulta() {
        return duracaoConsulta;
    }

    public void setDuracaoConsulta(float duracaoConsulta) {
        this.duracaoConsulta = duracaoConsulta;
    }

    public float getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public void setDuracaoMaxima(float duracaoMaxima) {
        this.duracaoMaxima = duracaoMaxima;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getInicioConsulta() {
        return inicioConsulta;
    }

    public void setInicioConsulta(Date inicioConsulta) {
        this.inicioConsulta = inicioConsulta;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Set<ArtigoDespesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(Set<ArtigoDespesa> despesas) {
        this.despesas = despesas;
    }
    
    
}
