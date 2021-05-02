/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import exceptions.ExceptionConversionImpossible;

/**
 *
 * @author Hamadi
 */
public interface Cle {
    /**
     * Renvoie la clé sous forme d'une chaîne de caractère
     * @return la clé sous forme d'une chaîne de caractère
     * @throws ExceptionConversionImpossible 
     */
    public String asString() throws ExceptionConversionImpossible;
    
    /**
     * Renvoie la clé sous forme d'un entier
     * @return la clé sous forme d'un entier
     * @throws ExceptionConversionImpossible 
     */
    public int asInteger() throws ExceptionConversionImpossible;
    
}
