/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cle;
import donnees.cles.CleString;
import donnees.cles.Cles;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hamadi
 */
public class GenerateurDeClesSubstitution implements GenerateurDeCles {

    @Override
    public Cles genererClePublique() {
        return null;
    }

    @Override
    public Cles genererClePrivee() {
        String cleString = "";
        List<Character> list = new ArrayList<>();
        for(int i=65;i<91;i++){
            char tmp = (char)i;
            list.add(tmp);
        }
        Collections.shuffle(list);
        for(char c : list)
            cleString += c;
        Cles cles = new Cles();
        Cle cle = new CleString(cleString);
        cles.addCle("cleSubstitution", cle);
        return cles;
    }
    
}
