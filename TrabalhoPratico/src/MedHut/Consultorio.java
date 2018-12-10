/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;

/**
 *
 * @author srk
 */
public class Consultorio {
    
    // indice de consultorio
    public static int numConsultorio=0;
    
    // variaveis consultorio
    private int idConsultorio=0;
    private String nome;
    private String morada;
    private String localidade;
    private Especialidade especialidade;
    
    
    public Consultorio(String nome, String morada, String localidade, Especialidade especialidade){
        idConsultorio = Consultorio.numConsultorio + 1;
        this.nome=nome;
        this.morada=morada;
        this.localidade=localidade;
        this.especialidade=especialidade;
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
    
    
    
}