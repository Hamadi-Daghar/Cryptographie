/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cle;
import donnees.cles.CleInteger;
import donnees.cles.Cles;
import java.util.Random;

/**
 * Permet de générer des clés pour l'algorithme de Cesar
 * @author Hamadi
 */
public class GenerateurDeClesCesar implements GenerateurDeCles {
    
    Integer nb = null;
    
    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        if (nb == null)
        {
            Random rand = new Random();
            nb = rand.nextInt(26);
        }
        Cles cles = new Cles();
        Cle cle = new CleInteger(nb);
        cles.addCle("cleCesar", cle);
        return cles;
    }
    
}
