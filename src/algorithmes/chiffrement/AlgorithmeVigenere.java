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
 * Classe AlgorithmeVigenere
 */
public class AlgorithmeVigenere implements Algorithme {

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String res ="";
        String msg = message.asString();
        String key = clesPrivees.getCle("cleVigenere").asString();
        for(int j=0;j<msg.length();j++){
            key += key.charAt(j);
        }
        msg = msg.toUpperCase();
        Message msgMessage = new MessageString(msg);
        ArrayList<Integer> liste = msgMessage.getListAsciiCode();
        int j = 0;
        for(Integer i : liste){
            int ascii = i;
            int asciiKey = key.charAt(j) - 65;
            
            int temp = ascii + asciiKey;
            if(temp>90)
            {
                temp = temp %91 +65;
                if(ascii > 90)
                    ascii = ascii + 26;
            }
            if (65>ascii || ascii > 90)
                temp = ascii;
            res += (char)temp;
            j++;
        }
        return new MessageString(res);
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String res ="";
        String msg = message.asString();
        String key = clesPrivees.getCle("cleVigenere").asString();
        for(int j=0;j<msg.length();j++){
            key += key.charAt(j);
        }
        msg = msg.toUpperCase();
        Message msgMessage = new MessageString(msg);
        ArrayList<Integer> liste = msgMessage.getListAsciiCode();
        int j = 0;
        for(Integer i : liste){
            int ascii = i;
            int asciiKey = key.charAt(j) - 65;
            
            int temp = ascii - asciiKey;
            if(temp<65)
            {
                temp = temp +26;
                if(ascii > 90)
                    ascii = ascii%91+65;
            }
            if (65>ascii || ascii > 90)
                temp = ascii;
            res += (char)temp;
            j++;
        }
        return new MessageString(res);
    }

    @Override
    public String getNom() {
        return "Vigenere";
    }
    
}
