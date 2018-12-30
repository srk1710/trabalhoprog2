/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilizadores;

import java.io.Serializable;

/**
 *
 * @author Pedro Silva e Diogo Correia
 */
public class Admin extends Utilizador implements Serializable{
    
    //CONSTRUTOR
    public Admin(String user, String passwd) {
        super(user, passwd);
    }
    
}