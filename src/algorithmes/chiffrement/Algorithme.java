/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import exceptions.ExceptionCryptographie;

/**
 *
 * @author Hamadi
 */
public interface Algorithme {
    /**
     * nom de l'agorithme
     */
    public String nom = null;
    
    /**
     * Fonction qui permet de chiffrer un message
     * @param message Le message a chiffrer
     * @param clesPubliques Cles publiques permettant de chiffrer le message
     * @param clesPrivees Cles privees permettant de chiffrer le message
     * @return Le message chiffrer
     * @throws ExceptionCryptographie Lève une exception si 
     */
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie;
    
    /**
     * 
     * @param message Le message a dechiffrer
     * @param clesPubliques Cles publiques permettant de dechiffrer le message
     * @param clesPrivees Cles privées permettant de ddechiffrer le message
     * @return Le message dechiffrer
     * @throws ExceptionCryptographie 
     */
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie;
    
    /**
     * Ascesseur de l'attribut nom
     * @return Le nom
     */
    public String getNom();
}
