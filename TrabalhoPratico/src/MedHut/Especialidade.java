/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;

/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public enum Especialidade {
    CLINICA_GERAL("CLINICA GERAL"),
    OFTALMOLOGIA("OFTALMOLOGIA"),
    OTORRINOLARINGOLOGIA("OTORRINOLARINGOLOGIA"),
    ORTOPEDIA("ORTOPEDIA"),
    CARDIOLOGIA("CARDIOLOGIA"),
    PSIQUIATRIA("PSIQUIATRIA"),
    PNEUMOLOGIA("PNEUMOLOGIA");
    
    private final String nomeEsp;
    
    private Especialidade(String nome){
        this.nomeEsp = nome;
    }
    
    @Override
    public String toString(){
        return nomeEsp;
    }
}