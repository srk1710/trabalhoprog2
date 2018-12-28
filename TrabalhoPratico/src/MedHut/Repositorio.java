/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import java.io.*;
import java.util.*;
import Utilizadores.*;

/**
 *
 * @author srk
 */
public class Repositorio implements Serializable{
    
    private List<Utilizador> utilizadores;
    private Map<Consultorio,Especialidade> ConsultorioEspecialidade;
    private Map<Consultorio, String> ConsultorioLocalidade;
    
    private static Repositorio bd=null;
    
    private Repositorio(){
        this.utilizadores = new ArrayList<>();
        this.ConsultorioEspecialidade = new HashMap<>();
        this.ConsultorioLocalidade = new HashMap<>();
    }
    
    
    public static Repositorio getInstance(){
        if( bd == null){
            bd = new Repositorio();
        }
        
        return bd;
    }
    
}
