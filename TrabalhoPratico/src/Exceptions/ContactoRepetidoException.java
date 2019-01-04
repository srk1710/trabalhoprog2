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
public class ContactoRepetidoException extends Exception{
    public ContactoRepetidoException (String msg) {
        super(msg);
    }
    public ContactoRepetidoException(){
        super();
    }
    
}
