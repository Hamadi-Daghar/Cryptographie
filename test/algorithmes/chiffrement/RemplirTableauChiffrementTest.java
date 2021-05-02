/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import donnees.cles.Cle;
import donnees.cles.CleString;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 *
 * @author simonetma
 */
public class RemplirTableauChiffrementTest {
    
    

    

    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testRemplirTableauSansBourrage() throws Exception {
        System.out.println("Test du remplissage du tableau sans bourrage");
        Message message = new MessageString("Bonjour comment ca va ?");
        Cle cleString = new CleString("Chat");
        
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result = (char[][]) methode.invoke(instance, message,cleString);
        
        char[][] expResult = {
            {'B','o','n','j'},
            {'o','u','r',' '},
            {'c','o','m','m'},
            {'e','n','t',' '},
            {'c','a',' ','v'},
            {'a',' ','?','x'},
        };
        
        assertArrayEquals(expResult,result);
    }
    
    /**
     * Test of dechiffrer method, of class AlgorithmeTransposition.
     */
    @Test
    public void testRemplirTableauSansBourrage2() throws Exception {
        System.out.println("Test du remplissage du tableau sans bourrage");
        Message message = new MessageString("Bonjour, comment ca va ?");
        Cle cleString = new CleString("Chat");
        
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result = (char[][]) methode.invoke(instance, message,cleString);
        
        char[][] expResult = {
            {'B','o','n','j'},
            {'o','u','r',','},
            {' ','c','o','m'},
            {'m','e','n','t'},
            {' ','c','a',' '},
            {'v','a',' ','?'},
        };
        
        assertArrayEquals(expResult,result);
    }
}
