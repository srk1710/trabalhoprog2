/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

import java.util.*;
import MedHut.*;
import java.io.Serializable;
/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public class Cliente extends Conta implements Serializable {
    
    //Variaveis de instancia
    private List <Marcacao> marcacoes ;
    private int pontos = 0;
    
   //Construtor
    public Cliente(String nome, int numcc, int nif, int contacto, String morada, String localidade, String user, String passwd){
        super(nome, numcc, nif, contacto, morada, localidade, user, passwd);
        this.marcacoes = new ArrayList<>();
    }
    
    //Metodos de instancia

    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }

    public void setMarcacoes(List<Marcacao> marcacoes) {
        this.marcacoes = marcacoes;
    }
    
    public Marcacao getMarcaçaoAtual (Date data) {
        Marcacao marcacao = null ;
        for (Marcacao m : this.marcacoes) {
            if (data.after(m.getInicioConsulta()) && data.before(m.getFimConsulta())) {
                marcacao = m ;
            }
        }
        return marcacao ;
    }
    
    public List<Marcacao> getMarcacoesConfirmadas () {
        List<Marcacao> marcacao = new ArrayList <> () ;
        for (Marcacao m : this.marcacoes) {
            if (m.isConfirmado() == true) {
                marcacao.add(m) ;
            }
        }
        return marcacao ;
    }
    
    public void addMarcacao(Marcacao marcacao){
        this.marcacoes.add(marcacao);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public Conta getConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
