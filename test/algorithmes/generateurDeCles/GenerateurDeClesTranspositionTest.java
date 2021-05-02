/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cle;
import donnees.cles.Cles;
import exceptions.ExceptionConversionImpossible;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author simonetma
 */
public class GenerateurDeClesTranspositionTest {
    
    @Test
    public void testGenererClePublique() {
        System.out.println("Test de la génération de clé publique");
        GenerateurDeClesTransposition instance = new GenerateurDeClesTransposition(10);
        Cles expResult = null;
        Cles result = instance.genererClePublique();
        assertEquals(expResult, result);
    }

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesTransposition.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("Test de la génération de clé privée");
        GenerateurDeClesTransposition instance = new GenerateurDeClesTransposition(10);
        Cles result = instance.genererClePrivee();
        Cle cleResult = result.getCle("cleTransposition");
        assertEquals(10, cleResult.asString().length());
        Boolean valide = true;
        for(char c : cleResult.asString().toCharArray()) {
            if( (c<'a' || c>'z') && (c<'A' || c>'Z')) {
                valide = false;
            }
        }
        assertEquals(Boolean.valueOf(true),valide);
    }
    
}
