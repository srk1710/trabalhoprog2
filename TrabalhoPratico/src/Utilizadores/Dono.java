/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

import java.util.*;
/**
 *
 * @author Pedro Silva
 */
public class Dono extends Conta implements Cloneable {
    
    //Variaveis de Instancia
    private List<Consultorio> consultorios;
    
    
    public Dono(String nome, int numcc, int nif, int contacto, String morada, String localidade, String user, String passwd){
        super(nome, numcc, nif, contacto, morada, localidade, user, passwd);
        this.consultorios = new ArrayList<>();
    }
    
    
@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Conta getConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
