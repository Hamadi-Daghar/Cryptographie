/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import donnees.cles.Cles;
import donnees.messages.Message;
import java.util.HashMap;

/**
 * Singleton Univers
 * @author Mohamed
 */
public class Univers {
    
    private HashMap<String, Cles> listeClesPubliques;
    private HashMap<String, Message> listeMessagesPublics;
    private static Univers instance = null;
    
    /**
     * Constructeur
     */
    private Univers(){
        listeClesPubliques = new HashMap<>();
        listeMessagesPublics = new HashMap<>();
    }
    
    /**
     * Ascesseur de l'attribut instance
     * @return l'instance Univers
     */
    public static Univers get(){
        if (instance == null)
        {
            instance = new Univers();
        }
        return instance;
    }
    
    /**
     * Ajoute une cles à listeClesPubliques
     * @param identifiant Identifiant de la Cle
     * @param cles Cle à ajouter
     */
    public static void addCles(String identifiant, Cles cles){
        Univers.get().listeClesPubliques.put(identifiant, cles);
    }
    
    /**
     * Recupérer Cles à l'aide de l'identifiant 
     * @param identifiant Identifiant de cles
     * @return Cles correspondant à l'identifiant passé en paramètre
     */
    public static Cles getCles(String identifiant){
        return Univers.get().listeClesPubliques.get(identifiant);
    }
    
    /**
     * Ajoute un Message à listeMessagesPublics
     * @param identifiant Identifiant du Message a ajouter
     * @param message 
     */
    public static void addMessage(String identifiant, Message message){
        Univers.get().listeMessagesPublics.put(identifiant, message);
    }
    
    /**
     * Récupère un Message à l'aide de l'identifiant
     * @param identifiant Identifiant du Message
     * @return Le Message correspondant
     */
    public static Message getMessage(String identifiant){
        return Univers.get().listeMessagesPublics.get(identifiant);
    }
    
    
}
