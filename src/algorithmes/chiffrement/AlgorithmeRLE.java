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
import exceptions.ExceptionCryptographie;
import java.util.ArrayList;

/**
 *
 * @author Hamadi
 */
public class AlgorithmeRLE implements Algorithme{
    
    /**
     * Fonction de compression, retourne le message compressé en utilisant RLE
     * @param message message à compresser
     * @param clesPubliques clé
     * @param clesPrivees
     * @return Message compressé
     * @throws ExceptionChiffrementImpossible
     * @throws ExceptionConversionImpossible 
     */
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible, ExceptionConversionImpossible  {
        int key = clesPubliques.getCle("cleRLE").asInteger();
        String messageChiffre ="";
        String msg = message.asString();     
        for (int i = 0; i < msg.length(); i++) {
            int temp = 1;
            while (i+1 < msg.length() && temp<key && msg.charAt(i) == msg.charAt(i+1)) {
                temp++;
                i++;
            }
            if(String.valueOf(temp).length()<String.valueOf(key).length()){//on vérifie que le nombre d'occurence n'est pas < à la taille de la clé
                String s = Integer.toString(temp);
                while(String.valueOf(s).length()<String.valueOf(key).length()){//tant que le nombre d'occurence n'est pas = à la taille de la clé on rajoute un 0 au début
                    s = "0"+s;
                }
                messageChiffre += s;
            }else{
                messageChiffre += temp;
            }
            messageChiffre += msg.charAt(i);

        }
        Message res = new MessageString(messageChiffre);
        return res;
    }
    
    /**
     * Fonction de décompression
     * @param message Message compressé
     * @param clesPubliques clé
     * @param clesPrivees
     * @return Message décompréssé
     * @throws ExceptionCryptographie 
     */
    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        int key = clesPubliques.getCle("cleRLE").asInteger();
        String messageDechiffree ="";
        String msg = message.asString();
        int nbPart = (msg.length())/(String.valueOf(key).length()+1);
        String[] tab = new String[nbPart];
        int l = msg.length();
        int temp = 0; 
        int c = l/nbPart; 
        if (l % nbPart != 0) {
            System.out.println("Impossible de diviser en "+nbPart+" parti.");
        } 
        else 
        {
            //on divise notre string dans un tableau en nombre de parti souhaité (taille de la clé +1 (pour le caractère à afficher))
            for(int i = 0; i < l; i = i+c) {    
                String part = msg.substring(i, i+c);
                tab[temp] = part;  
                temp++;  
            }
            for(String st : tab){
                char car = st.charAt(st.length()-1);//car à ajouter
                String sansFin = st.substring(0, st.length()-1);
                for(int j=0;j<Integer.parseInt(sansFin);j++)
                    messageDechiffree += car;
            }

        }
        Message res = new MessageString(messageDechiffree);
        return res;
    }

    
    @Override
    public String getNom() {
        return "RLE";
    }

}
