/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDados;

import MedHut.Especialidade;
import Utilizadores.Utilizador;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public class Repositorio implements Serializable{
    private List<Utilizador> utilizadores;
    private Map<String,enum<Especialidade>> EspecialidadeConsultorio;
    
    
}
