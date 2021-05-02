/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import exceptions.ExceptionChiffrementImpossible;
import exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class AlgorithmeCesar implements Algorithme{
    

    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible { 
        String temp = "";
        try {
            ArrayList<Integer> l = message.getListAsciiCode();
            
            int nbTemp;
            int nbAscii;
            int cle = clesPrivees.getCle("cleCesar").asInteger();
            
            for(Integer integer : l){
                nbAscii = integer;
                nbTemp = nbAscii + cle;
                if(64 < nbAscii && nbAscii < 91)
                {
                    if((nbAscii + cle) > 90)
                        nbTemp = 65 + ((nbAscii + cle) % 91);
                }
                else if(96 < nbAscii && nbAscii < 123)
                {
                    if((nbAscii + cle) > 122)
                        nbTemp = 97 + ((nbAscii + cle) % 123);
                }
                else
                {
                    nbTemp = integer;
                }
                
                temp += (char)(nbTemp);
            }
        } catch (ExceptionConversionImpossible e) {
            e.gerer();
        }
        return new MessageString(temp);
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        String temp = "";
        try {
            ArrayList<Integer> l = message.getListAsciiCode();
            
            int nbTemp;
            int nbAscii;
            int cle = clesPrivees.getCle("cleCesar").asInteger();
            
            for(Integer integer : l){
                nbAscii = integer;
                nbTemp = nbAscii - cle;
                if(64 < nbAscii && nbAscii < 91)
                {
                    if((nbAscii - cle) < 65)
                        nbTemp = 91 - (65 - (nbAscii - cle));
                }
                else if(96 < nbAscii && nbAscii < 123)
                {
                    if((nbAscii - cle) < 97)
                        nbTemp = 123 - (97 - (nbAscii - cle));
                }
                else
                {
                    nbTemp = integer;
                }
                
                temp += (char)(nbTemp);
            }
        } catch (ExceptionConversionImpossible e) {
            e.gerer();
        }
        return new MessageString(temp);
    }

    @Override
    public String getNom() {
        return "Cesar";
    }
    
}
