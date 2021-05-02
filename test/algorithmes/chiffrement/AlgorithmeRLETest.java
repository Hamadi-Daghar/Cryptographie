/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import donnees.cles.CleInteger;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthieu
 */
public class AlgorithmeRLETest {
    
   

    /**
     * Test of chiffrer method, of class AlgorithmeRLE.
     */
    @Test
    public void testChiffrer1() throws Exception {
        System.out.println("Test du chiffrage, M=AAAABBBBB et K=7");
        Message message = new MessageString("AAAABBBBB");
        Cles clesPrivees = null;
        Cles clesPubliques = new Cles();
        clesPubliques.addCle("cleRLE", new CleInteger(7));
        AlgorithmeRLE instance = new AlgorithmeRLE();
        String expResult = "4A5B";
        String result = instance.chiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of chiffrer method, of class AlgorithmeRLE.
     */
    @Test
    public void testChiffrer2() throws Exception {
        System.out.println("Test du chiffrage, M=AAAABBBBB et K=3");
        Message message = new MessageString("AAAABBBBB");
        Cles clesPrivees = null;
        Cles clesPubliques = new Cles();
        clesPubliques.addCle("cleRLE", new CleInteger(3));
        AlgorithmeRLE instance = new AlgorithmeRLE();
        String expResult = "3A1A3B2B";
        String result = instance.chiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of chiffrer method, of class AlgorithmeRLE.
     */
    @Test
    public void testChiffrer3() throws Exception {
        System.out.println("Test du chiffrage, M=AAAABBBABACCCBBBAAABAAA et K=9");
        Message message = new MessageString("AAAABBBABACCCBBBAAABAAA");
        Cles clesPrivees = null;
        Cles clesPubliques = new Cles();
        clesPubliques.addCle("cleRLE", new CleInteger(9));
        AlgorithmeRLE instance = new AlgorithmeRLE();
        String expResult = "4A3B1A1B1A3C3B3A1B3A";
        String result = instance.chiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of dechiffrer method, of class AlgorithmeRLE.
     */
    @Test
    public void testDechiffrer1() throws Exception {
        System.out.println("Test du chiffrage, M=3A1A3B2B et K=3");
        Message message = new MessageString("3A1A3B2B");
        Cles clesPrivees = null;
        Cles clesPubliques = new Cles();
        clesPubliques.addCle("cleRLE", new CleInteger(9));
        AlgorithmeRLE instance = new AlgorithmeRLE();
        String expResult = "AAAABBBBB";
        String result = instance.dechiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of dechiffrer method, of class AlgorithmeRLE.
     */
    @Test
    public void testDechiffrer2() throws Exception {
       System.out.println("Test du chiffrage, M=AAAABBBABACCCBBBAAABAAA et K=9");
        Message message = new MessageString("4A3B1A1B1A3C3B3A1B3A");
        Cles clesPrivees = null;
        Cles clesPubliques = new Cles();
        clesPubliques.addCle("cleRLE", new CleInteger(9));
        AlgorithmeRLE instance = new AlgorithmeRLE();
        String expResult = "AAAABBBABACCCBBBAAABAAA";
        String result = instance.dechiffrer(message, clesPubliques, clesPrivees).asString();
        assertEquals(expResult, result);
    }
    
}
