/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

/**
 *
 * @author Pedro Silva
 */
public abstract class Conta extends Utilizador implements Cloneable {
    
    //Variavéis de Instancia
    private String nome;
    private int numcc;
    private int nif;
    private int contacto;
    private String morada;
    private String localidade;
    
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

