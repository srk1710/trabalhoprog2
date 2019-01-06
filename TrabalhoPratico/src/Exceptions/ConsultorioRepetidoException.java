/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Pedro Silva
 */
public class ConsultorioRepetidoException extends Exception{
    public ConsultorioRepetidoException (String msg) {
        super(msg);
    }
    public ConsultorioRepetidoException () {
        super();
    }
}
