/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement.algorithmetransposition;

import java.util.ArrayList;
import java.util.Collections;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author simonetma
 */
public class TrieListeCoupleTest {
    
    
    @Test
    public void testTrieListeCouples() {
        System.out.println("Test du trie d'une liste de couple");
        ArrayList<Couple> listeCouple = new ArrayList<>();
        listeCouple.add(new Couple('H',1));
        listeCouple.add(new Couple('e',2));
        listeCouple.add(new Couple('L',3));
        listeCouple.add(new Couple('L',4));
        listeCouple.add(new Couple('o',5));
        Collections.sort(listeCouple,new ComparateurCouple());
        String result = "";
        for(Couple c : listeCouple) {
            result += c.getCaractere() + Integer.toString(c.getPosition());
        }
        
        assertEquals("H1L3L4e2o5", result);
    }
    
}
