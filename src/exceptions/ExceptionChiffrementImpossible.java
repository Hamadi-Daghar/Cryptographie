/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import algorithmes.chiffrement.Algorithme;

/**
 * Classe qui permet de gérer les exceptions de chiffrement
 * @author Hamadi
 */
public class ExceptionChiffrementImpossible extends ExceptionCryptographie {
    
    /**
     * Constructeur
     * @param algorithme algorithme qui ne peut pas réaliser le chiffrement 
     */
    public ExceptionChiffrementImpossible(Algorithme algorithme){
        super("Chiffrement impossible","Ce chiffrement n'est pas possible");
    }
}
