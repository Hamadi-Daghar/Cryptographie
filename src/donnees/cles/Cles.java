/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import java.util.HashMap;

/**
 * Permet de gérer des HashMap de Cle
 * @author Hamadi
 */
public class Cles {
    private HashMap<String,Cle> listeCles;
    
    /**
     * Constructeur
     */
    public Cles(){
        listeCles = new HashMap<>();
    }
    
    /**
     * Renvoie la clé identifiée par le nom donné en paramètre
     * @param nom Identifiant de la cle voulu
     * @return la Cle correspondante
     */
    public Cle getCle(String nom){
        return this.listeCles.get(nom);
    }
    
    /**
     * Ajoute la clé donnée en paramètre en l’identifiant par le nom donné en paramètre
     * @param nom identifiant de  Cle 
     * @param cle Cle a ajouter
     */
    public void addCle(String nom, Cle cle){
        listeCles.put(nom, cle);
    }
}
