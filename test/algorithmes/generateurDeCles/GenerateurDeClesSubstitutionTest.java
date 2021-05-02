/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;


import donnees.cles.Cles;
import exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Matthieu
 */
public class GenerateurDeClesSubstitutionTest {
    
    /**
     * Test of genererClePrivee method, of class GenerateurDeClesSubstitution.
     */
    @Test
    public void testGenererClePrivee() throws ExceptionConversionImpossible {
        System.out.println("genererClePrivee");
        GenerateurDeClesSubstitution instance = new GenerateurDeClesSubstitution();
        
        HashMap<Character,Boolean> verif = new HashMap<>();
        for(char c='A';c<='Z';c++) {
            verif.put(c, Boolean.FALSE);
        }
        
        String strCle = instance.genererClePrivee().getCle("cleSubstitution").asString();
        for(Character c:strCle.toCharArray()) {
            verif.put(c, Boolean.TRUE);
        }
        
        for(char c='A';c<='Z';c++) {
            if(!verif.get(c)) {
                fail("La clé ne contient pas de "+c);
            }
        }
    }
    
}
