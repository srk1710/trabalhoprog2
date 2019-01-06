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
    
    private float preco;
    private boolean pago;
    private Set<ArtigoDespesa> despesas;
    private FaturaRecibo fatura;

    public Consulta(Date dataConsulta, Cliente cliente, Date inicioConsulta, Date fimConsulta) {
        super(dataConsulta, cliente,inicioConsulta, fimConsulta);
        this.despesas = new HashSet<>();
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
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
