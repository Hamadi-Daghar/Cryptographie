/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cle;
import donnees.cles.CleInteger;
import donnees.cles.CleString;
import donnees.cles.Cles;
import java.util.Random;

/**
 * Generateur de clés pour l'algorithme de Vigenere
 * @author Mohamed
 */
public class GenerateurDeClesVigenere implements GenerateurDeCles{
    
    private int tailleCle;
    
    /**
     * Constructeur
     * @param nb taille de la clé
     */
    public GenerateurDeClesVigenere(int nb){
        this.tailleCle = nb;
    }

    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        String cleString = "";
        int temp;
        for(int i = 0; i < this.tailleCle; i++){
            Random rand = new Random();
            temp = rand.nextInt(26);
            cleString += (char)(65 + temp);
        }
        Cles cles = new Cles();
        Cle cle = new CleString(cleString);
        cles.addCle("cleVigenere", cle);
        return cles;
            
    }
}
