/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public abstract class Conta extends Utilizador implements Cloneable {
    
    //Variavéis de Instancia
    private String nome;
    private int numcc;
    private int nif;
    private int contacto;
    private String morada;
    private String localidade;

    //Construtor
    public Conta(String nome, int numcc, int nif, int contacto, String morada, String localidade, String user, String passwd) {
        super(user, passwd);
        this.nome = nome;
        this.numcc = numcc;
        this.nif = nif;
        this.contacto = contacto;
        this.morada = morada;
        this.localidade = localidade;
    }


    //METODOS DE INSTANCIA
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumcc() {
        return numcc;
    }

    public void setNumcc(int numcc) {
        this.numcc = numcc;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
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

    public abstract Conta getConta();
    
    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone() ;
    }

}