/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import algorithmes.chiffrement.Algorithme;
import donnees.cles.Cles;
import donnees.messages.Message;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionCryptographie;

/**
 * Permet de générer une personne qui envoie/reçoie un Message
 * @author Hamadi
 */
public class Personne {
    private String nom;
    private Algorithme algorithme;
    private Cles clesPrivees;
    
    /**
     * Constructeur
     * @param nom Le nom de la personne
     */
    public Personne(String nom){
        this.nom = nom;
        this.algorithme = null;
        this.clesPrivees = new Cles();
    }
    
    /**
     * Chiffre un message a partir de l'algorithme de la Personne
     * @param message Le message a chiffrer
     * @param clesPubliques clesPubliques permettant de chiffrer le message
     * @return
     * @throws ExceptionAlgorithmeNonDefini 
     */
    public Message chiffrer(Message message, Cles clesPubliques) throws ExceptionAlgorithmeNonDefini{
         Message temp = null;
        try{
            temp = this.algorithme.chiffrer(message, clesPubliques, clesPrivees);
        }
        catch(ExceptionCryptographie e)
        {
            e.gerer();
        }
        
        return temp;
    }
    
    /**
     * Dechiffre un message à partir de l'algorithme de la Personne
     * @param message le message a dechiffrer
     * @param clesPubliques Cles publiques qui permet le déchiffrement
     * @return le Message dechiffré
     * @throws ExceptionAlgorithmeNonDefini 
     */
    public Message dechiffrer(Message message, Cles clesPubliques) throws ExceptionAlgorithmeNonDefini{
        Message temp = null;
        try{
            temp = this.algorithme.dechiffrer(message, clesPubliques, this.clesPrivees);
        }
        catch(ExceptionCryptographie e)
        {
            e.gerer();
        }
        
        return temp;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public Algorithme getAlgorithme(){
        return this.algorithme;
    }
    
    public void setAlgorithme(Algorithme algorithme){
        this.algorithme = algorithme;
    }
    
    public Cles getClesPrivees(){
        return this.clesPrivees;
    }
    
    public void setClesPrivees(Cles clesPrivees){
        this.clesPrivees = clesPrivees;
    }
    
}
