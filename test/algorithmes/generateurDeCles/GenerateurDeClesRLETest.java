/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import algorithmes.generateurDeCles.GenerateurDeClesRLE;
import donnees.cles.Cles;
import exceptions.ExceptionConversionImpossible;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesRLETest {
    
    /**
     * Test of genererClePublique method, of class GenerateurDeClesRLE.
     */
    @Test
    public void testGenererClePublique() throws ExceptionConversionImpossible {
        System.out.println("Test 1 de la génération de clé publique");
        for(int i=0;i<1000;i++) {
            GenerateurDeClesRLE instance = new GenerateurDeClesRLE(9);
            int result = instance.genererClePublique().getCle("cleRLE").asInteger();
            assert(result>=2);
            assert(result<=9);
        }
    }
    
    /**
     * Test of genererClePublique method, of class GenerateurDeClesRLE.
     */
    @Test
    public void testGenererClePublique2() throws ExceptionConversionImpossible {
        System.out.println("Test 2 de la génération de clé publique");
        GenerateurDeClesRLE instance = new GenerateurDeClesRLE(2);
        int result = instance.genererClePublique().getCle("cleRLE").asInteger();
        assertEquals(2, result);
    }

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesRLE.
     */
    @Test
    public void testGenererClePrivee() {
        System.out.println("Test de la génération de clé privée");
        GenerateurDeClesRLE instance = new GenerateurDeClesRLE(9);
        Cles expResult = null;
        Cles result = instance.genererClePrivee();
        assertEquals(expResult, result);
    }
    
}
