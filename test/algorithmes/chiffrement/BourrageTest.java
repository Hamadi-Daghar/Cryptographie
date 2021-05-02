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
public class BourrageTest {
    
    @Test
    public void testBourragem() throws Exception {
        System.out.println("Test du bourrage aléatoire seedé");
        Message message = new MessageString("Bonjour comment ca va ?");
        Cle cleString = new CleString("Chat");
        
        AlgorithmeTransposition instance = new AlgorithmeTransposition();
        Method methode = instance.getClass().getDeclaredMethod("remplirTableauChiffrement", Message.class,Cle.class);
        methode.setAccessible(true);
        char[][] result1 = (char[][]) methode.invoke(instance, message,cleString);
        char[][] result2 = (char[][]) methode.invoke(instance, message,cleString);
        char[][] result3 = (char[][]) methode.invoke(instance, message,cleString);
        char[][] result4 = (char[][]) methode.invoke(instance, message,cleString);
        
        //Test de seedage
        assertArrayEquals(result1,result2);
        assertArrayEquals(result1,result3);
        assertArrayEquals(result1,result4);
    }

}
