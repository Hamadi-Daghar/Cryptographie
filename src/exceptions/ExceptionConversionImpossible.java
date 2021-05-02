/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * Classe qui permet de gérer les exceptions de conversion
 * @author Hamadi
 */
public class ExceptionConversionImpossible extends ExceptionCryptographie {
    
    /**
     * Constructeur
     * @param message Message qu'on ne peut pas convertir
     */
    public ExceptionConversionImpossible(String message){
        super("Conversion impossible","Cette conversion n'est pas possible");
    }

}
