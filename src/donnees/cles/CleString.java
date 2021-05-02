/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import exceptions.ExceptionConversionImpossible;

/**
 * Permet de gérer les Cle String
 * @author Hamadi
 */
public class CleString implements Cle {
    private String cleString; 
    
    /**
     * Constructeur
     * @param temp Valeur de l'attribut cleString
     */
    public CleString(String temp){
        this.cleString = temp;
    }
    
    @Override
    public String asString() throws ExceptionConversionImpossible {
        return this.cleString;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible("Conversion impossible");
    }
    
}
