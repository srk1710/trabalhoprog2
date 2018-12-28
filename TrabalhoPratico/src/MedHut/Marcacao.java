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

public class Marcacao implements Serializable{
    
    // indice de consulta
    private static int numConsulta=0;
    
    // variaveis consulta
    private int idConsulta;
    private Date dataConsulta;
    private Cliente cliente;
    private boolean confirmado;
    
    
    
    public Marcacao(Date dataConsulta, Cliente cliente){
        idConsulta = Marcacao.numConsulta +1;
        this.dataConsulta = new Date();
        this.cliente = cliente;
        Marcacao.numConsulta++;
    }

    public static int getNumConsulta() {
        return numConsulta;
    }

    public static void setNumConsulta(int numConsulta) {
        Marcacao.numConsulta = numConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
    
    
}
