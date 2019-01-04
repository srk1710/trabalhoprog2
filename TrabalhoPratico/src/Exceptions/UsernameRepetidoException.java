/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author srk
 */
public class UsernameRepetidoException extends Exception{
    public UsernameRepetidoException (String msg) {
        super(msg);
    }
    public UsernameRepetidoException(){
        super();
    }
}
