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
public class Consulta implements Serializable{
    
    // indice de consulta
    private static int numConsulta=0;
    
    // variaveis consulta
    private int idCondulta;
    private Date dataConsulta;
    private Date inicioConsulta;
    private Cliente cliente;
    private float duracaoConsulta;
    private float duracaoMaxima=1;    // corresponde à duracao maxima em horas
    private float preco;
    private boolean confirmado;
    private boolean pago;
    private Set<ArtigoDespesa> despesas;
    
    public Consulta(Date dataConsulta, Date inicioConsulta, Cliente cliente, float duracaoConsulta, float preco){
        idCondulta = Consulta.numConsulta +1;
        this.dataConsulta=dataConsulta;
        this.inicioConsulta=inicioConsulta;
        this.cliente=cliente;
        this.duracaoConsulta=duracaoConsulta;
        this.preco=preco;
        this.despesas= new HashSet<>();
        Consulta.numConsulta++;
    }

    public static int getNumConsulta() {
        return numConsulta;
    }

    public static void setNumConsulta(int numConsulta) {
        Consulta.numConsulta = numConsulta;
    }

    public int getIdCondulta() {
        return idCondulta;
    }

    public void setIdCondulta(int idCondulta) {
        this.idCondulta = idCondulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Date getInicioConsulta() {
        return inicioConsulta;
    }

    public void setInicioConsulta(Date inicioConsulta) {
        this.inicioConsulta = inicioConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
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
