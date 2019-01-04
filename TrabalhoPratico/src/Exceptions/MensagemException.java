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
public class MensagemException extends Exception{
    public MensagemException (String msg){
        super(msg);
    }
    public MensagemException () {
        super();
    }
    
}
