/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cle;
import donnees.cles.Cles;
import exceptions.ExceptionConversionImpossible;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesVigenereTest {

    /**
     * Test of genererClePrivee method, of class GenerateurDeClesVigenere.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("genererClePrivee");
        GenerateurDeClesVigenere instance = new GenerateurDeClesVigenere(10);
        Cles result = instance.genererClePrivee();
        
        Cle cle = result.getCle("cleVigenere");
        assertNotNull(cle);
        
        assertEquals(10,cle.asString().length());
        
        for(char c : cle.asString().toCharArray()) {
            if(c<'A' || c>'Z') {
                fail("La clé ne contient pas que des majuscules.");
            }
        }
    }
    
}
