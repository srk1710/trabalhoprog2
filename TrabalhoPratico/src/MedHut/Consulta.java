/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import java.util.*;
import Utilizadores.*;
import java.io.Serializable;

/**
 *
 * @author srk
 */
public class Consulta implements Serializable{
    
    // indice de consulta
    private static int idConsulta=0;
    
    // variaveis consulta
    private Date dataConsulta;
    private Date inicioConsulta;
    private Cliente cliente;
    private float duracaoConsulta;
    private float duracaoMaxima=1;    // corresponde à duracao maxima em horas
    private float preco;
    private boolean confirmado;
    private boolean pago;
    private Set<ArtigoDespesa> despesas;
    
    
}
