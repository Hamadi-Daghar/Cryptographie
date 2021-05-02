/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import exceptions.ExceptionConversionImpossible;

/**
 * Permet de gérer les Cle Integer
 * @author Hamadi
 */
public class CleInteger implements Cle {
    
    private int cle;
    
    /**
     * Constructeur
     * @param cle Valeur de l'attribut cle
     */
    public CleInteger(int cle){
        this.cle = cle;
    }
    
    @Override
    public String asString() throws ExceptionConversionImpossible {
        String temp = "";
        temp = String.valueOf(cle);
        return temp;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        return this.cle;
    }
    
}
