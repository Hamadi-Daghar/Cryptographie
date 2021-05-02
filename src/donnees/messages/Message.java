/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.messages;

import exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 * Permet de gérer les Messages échangés
 * @author Mohamed
 */
public interface Message {
    
    /**
     * Renvoie le message sous forme d'une chaine de caractère
     * @return une chaîne de caractère
     * @throws ExceptionConversionImpossible 
     */
    public String asString() throws ExceptionConversionImpossible;
    
    /**
     * Renvoie le message sous forme d'un entier
     * @return l'entier
     * @throws ExceptionConversionImpossible 
     */
    public int asInteger() throws ExceptionConversionImpossible;
    
    /**
     * Renvoie une list d'Integer contenant les codes ascii des caractère composant le message
     * @return Une list d'Integer
     * @throws ExceptionConversionImpossible 
     */
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible;
}
