/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import exceptions.ExceptionCryptographie;
import java.util.ArrayList;

/**
 *
 * @author Hamadi
 */
public class AlgorithmeSubstitution implements Algorithme {

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String res ="";
        String msg = message.asString().toUpperCase();
        String key = clesPrivees.getCle("cleSubstitution").asString();
        ArrayList<Integer> liste = new MessageString(msg).getListAsciiCode();
        int temp = 0;
        for(Integer i : liste){
            if(i>64 && i<91){
                temp = i-65;
                res += key.charAt(temp);
            }
            else
                res += (char)i.intValue();
        }
        return new MessageString(res);
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String res = "";
        ArrayList<Integer> liste = message.getListAsciiCode();
        String key = clesPrivees.getCle("cleSubstitution").asString();
        int pos;
        for(Integer i : liste){
            if(i<65 || i>90){
                res += (char)i.intValue();
            } else {
                pos = key.indexOf(i);
                res += (char)(pos+65);
            }
        }
        return new MessageString(res);
    }

    @Override
    public String getNom() {
        return "Substitution";
    }
    
}
