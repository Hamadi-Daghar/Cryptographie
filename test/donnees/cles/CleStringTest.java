/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.cles;

import exceptions.ExceptionConversionImpossible;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Test;

/**
 *
 * @author simonetma
 */
public class CleStringTest {
    
    
    /**
     * Test of asString method, of class CleString.
     */
    @Test
    public void testAsString() throws Exception {
        System.out.println("Test de la méthode asString");
        CleString instance = new CleString("cle De Test");
        String expResult = "cle De Test";
        String result = instance.asString();
        assertEquals(expResult, result);
    }

    /**
     * Test of asInteger method, of class CleString.
     */
    @Test
    public void testAsInteger() throws Exception {
        System.out.println("Test de la méthode asInteger");
        CleString instance = new CleString("cle De Test"); ;
        try{
            instance.asInteger();
            fail("La méthode devrait lever une exception");
        }
        catch(ExceptionConversionImpossible ex) {
            
        }
    }
    
}
