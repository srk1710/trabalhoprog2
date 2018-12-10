/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

import java.util.*;
/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public class Cliente extends Conta implements Cloneable {
    
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
    
    public void addMarcacao(Marcacao marcacao){
        this.marcacoes.add(marcacao);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
