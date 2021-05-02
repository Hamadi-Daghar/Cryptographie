/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import entites.Personne;

/**
 * Classe qui permet de gérer les exceptions lorsqu'un algortihme n'est pas défini
 * @author Hamadi
 */
public class ExceptionAlgorithmeNonDefini extends ExceptionCryptographie {
    /**
     * Constructeur
     * @param personne Personne qui n'a pas d'algo
     */
    public ExceptionAlgorithmeNonDefini(Personne personne){
        super("Algorithme non défini","Cet algorithme n'est pas défini");
    }
}
