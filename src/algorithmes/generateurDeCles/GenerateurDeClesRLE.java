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
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hamadi
 */
public class GenerateurDeClesRLE implements GenerateurDeCles {
    
    private int k;
    
    /**
     * Constructeur
     * @param temp 
     */
    public GenerateurDeClesRLE(int temp){
        this.k = temp;
    }

    @Override
    public Cles genererClePublique() {
        Cle cle = null;
        /*
        if (k > 2 && k <= 9)
            cle = new CleInteger(new Random().nextInt(this.k - 2) + 2);
        else
            cle = new CleInteger(2);*/
        cle = new CleInteger(k);
        Cles cles = new Cles();
        cles.addCle("cleRLE", cle);
        return cles;
    }

    @Override
    public Cles genererClePrivee() {
        return null;
    }
}
