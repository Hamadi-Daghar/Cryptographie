/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * Classe qui permet de gérer les exceptions
 * @author Hamadi
 */
public abstract class ExceptionCryptographie extends Exception {
    
    private String nom;
    private String message;
    
    /**
     * Constructeur
     * @param nom Le nom de l'Exception
     * @param message Le message de l'Exception
     */
    public ExceptionCryptographie(String nom, String message){
        this.message = message;
        this.nom = nom;
    }
    
    /**
     * Affiche le nom de l'erreur suivi du message
     */
    public void gerer(){
        System.err.println(this.nom.toUpperCase()+" : "+this.message);
        this.printStackTrace(System.err);
    }
    
}
