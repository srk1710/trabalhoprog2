/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;

import Utilizadores.Dono;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author srk
 */
public class Consultorio implements Serializable{
    //corresponde ao consultorio
    
    // indice de consultorio
    public static int numConsultorio=0;
    
    // variaveis consultorio
    private int idConsultorio=0;
    private String nome;
    private String morada;
    private String localidade;
    private Especialidade especialidade;
    private Dono donoConsultorio;
    private List<Marcacao> marcacoes;
    
    
    public Consultorio(String nome, String morada, String localidade, Especialidade especialidade, Dono donoConsultorio){
        idConsultorio = Consultorio.numConsultorio + 1;
        this.nome=nome;
        this.morada=morada;
        this.localidade=localidade;
        this.especialidade=especialidade;
        this.donoConsultorio=donoConsultorio;
        this.marcacoes = new ArrayList<>();
        Consultorio.numConsultorio ++;
    }

    public static int getNumConsultorio() {
        return numConsultorio;
    }

    public static void setNumConsultorio(int numConsultorio) {
        Consultorio.numConsultorio = numConsultorio;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Dono getDonoConsultorio() {
        return donoConsultorio;
    }

    public void setDonoConsultorio(Dono donoConsultorio) {
        this.donoConsultorio = donoConsultorio;
    }

    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }

    public void setMarcacoes(List<Marcacao> marcacoes) {
        this.marcacoes = marcacoes;
    }
    
    
    
}
