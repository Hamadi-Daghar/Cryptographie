/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cle;
import donnees.cles.CleString;
import donnees.cles.Cles;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

/**
 * Permet de générer des clés pour l'algorithme de transposition
 * @author Mohamed
 */
public class GenerateurDeClesTransposition implements GenerateurDeCles {
    
    private int taille;
    
    /**
     * Constructeur
     * @param taille valeur de l'attribut taille
     */
    public GenerateurDeClesTransposition(int taille){
        this.taille = taille;
    }

    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        SecureRandom generateur = new SecureRandom ();
        String fin ="";
        int min = 90-65;
        for(int i=0;i<this.taille;i++){
            char temp = (char)(generateur.nextInt(26)+65);
            char temp2 = (char)(generateur.nextInt(26)+97);
            int alea = generateur.nextInt(2);
            if(alea == 0){
                fin += temp;
            }else{
                fin += temp2;
            }
        }
        Cle cle = new CleString(fin);
        Cles cles = new Cles();
        cles.addCle("cleTransposition", cle);
        return cles;
    }
    
}
