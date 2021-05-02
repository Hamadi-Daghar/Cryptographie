/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import donnees.cles.CleString;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author simonetma
 */
public class AlgorithmeTranspositionTest {
    

    /**
     * Test of chiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testChiffrer() throws Exception {
        System.out.println("Test du chiffrement par transposition");
        Message message = new MessageString("Bonjour ceci est un message de test");
        Cles clesPrivees = new Cles();
        clesPrivees.addCle("cleTransposition", new CleString("HeLLo"));
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        String expResult = "Buctmg n  us ejcensdsori eetoes aet";
        String result = instance.chiffrer(message, null, clesPrivees).asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testDechiffrer() throws Exception {
        System.out.println("Test du déchiffrement par transposition");
        Message message = new MessageString("Buctmg n  us ejcensdsori eetoes aet");
        Cles clesPrivees = new Cles();
        clesPrivees.addCle("cleTransposition", new CleString("HeLLo"));
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        String expResult = "Bonjour ceci est un message de test";
        String result = instance.dechiffrer(message, null, clesPrivees).asString();
        assertEquals(expResult, result);
    }
    
}
