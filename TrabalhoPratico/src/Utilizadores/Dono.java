/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

import MedHut.Consultorio;
import java.util.*;
/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public class Dono extends Conta implements Cloneable {
    
    //Variaveis de Instancia
    private List<Consultorio> consultorios;
    
    //Construtor
    public Dono(String nome, int numcc, int nif, int contacto, String morada, String localidade, String user, String passwd){
        super(nome, numcc, nif, contacto, morada, localidade, user, passwd);
        this.consultorios = new ArrayList<>();
    }
    
    //Metodos de Instancia
    
    public List<Consultorio> getConsultorio(){
        return consultorios;
    }
    
    public void setConsultorio(List<Consultorio> consultorios){
        this.consultorios = consultorios;
    }
    
    public void addConsultorio(Consultorio consultorio){
        this.consultorios.add(consultorio);
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
