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
    
  // corresponde à duracao maxima em horas
    private float preco;
    private Date inicioConsulta;
    private Date fimConsulta;
    private boolean pago;
    private Set<ArtigoDespesa> despesas;
    private FaturaRecibo fatura;

    public Consulta(Date dataConsulta, Cliente cliente) {
        super(dataConsulta, cliente);
        this.despesas = new HashSet<>();
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

    public Date getFimConsulta() {
        return fimConsulta;
    }

    public void setFimConsulta(Date fimConsulta) {
        this.fimConsulta = fimConsulta;
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

    public FaturaRecibo getFatura() {
        return fatura;
    }

    public void setFatura(FaturaRecibo fatura) {
        this.fatura = fatura;
    }
    
    
}
