/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement.algorithmetransposition;

/**
 * Classe qui represente un couple de caractère et de position
 * @author Hamadi
 */
public class Couple {
    
    private char caractere;
    
    private int position;
    
    /**
     * Constructeur
     * @param car valeur voulu de l'attribut caractere
     * @param pos valeur voulu de l'attribut position
     */
    public Couple(char car, int pos){
        this.caractere = car;
        this.position = pos;
    }
    
    
    /**
     * Ascesseur de l'attribut position
     * @return attribut position
     */
    public int getPosition(){
        return position;
    }
    
    /**
     * Ascesseur de l'attribut caractere
     * @return attribut caractere
     */
    public char getCaractere(){
        return caractere;
    }
    
    /**
     * Mutateur de l'attribut position
     * @param pos nouvelle valeur de position
     */
    public void setPosition(int pos){
        this.position = pos;
    }
    
    /**
     * Mutateur de l'attribut caractère
     * @param c nouvelle valeur de caractere
     */
    public void setCaractere(char c){
        this.caractere = c;
    }
    
}
