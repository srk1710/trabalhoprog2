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
public class ContaNaoReconhecidaException extends Exception{
    public ContaNaoReconhecidaException (String msg) {
        super(msg);
    }
    public ContaNaoReconhecidaException () {
        super();
    }
}
