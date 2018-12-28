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
    
}
