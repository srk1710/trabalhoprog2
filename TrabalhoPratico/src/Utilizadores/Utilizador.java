/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

import java.io.Serializable;
/**
 *
 * @author srk
 */
public abstract class Utilizador implements Serializable{
    
    // indice de utilizador
    public static int numUtilizador=0;
    
    // variaveis utilizador
    private int id=0;
    private String user;
    private String passwd;
    private boolean online = false ;
    private boolean ativo = true ;
    
    public Utilizador(String user, String passwd){
        id = Utilizador.numUtilizador + 1;
        this.user = user;
        this.passwd = passwd;
        Utilizador.numUtilizador ++;
    }

    public static void setNumUtilizador(int numUtilizador) {
        Utilizador.numUtilizador = numUtilizador;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    

    public static int getNumUtilizador() {
        return numUtilizador;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    } 

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
