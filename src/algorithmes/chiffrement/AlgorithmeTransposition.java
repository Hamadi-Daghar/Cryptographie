/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement;

import algorithmes.chiffrement.algorithmetransposition.ComparateurCouple;
import algorithmes.chiffrement.algorithmetransposition.Couple;
import donnees.cles.Cle;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import exceptions.ExceptionChiffrementImpossible;
import exceptions.ExceptionConversionImpossible;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Algorithme de Transposition
 * @author Hamadi
 */
public class AlgorithmeTransposition implements Algorithme{
    
    /**
     * Generateur de nombre aléatoire
     */
    private SecureRandom generateur;
    
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        String res = "";
        try{
            String msg = message.asString();
            Cle key = clesPrivees.getCle("cleTransposition");
            char[][] tab = remplirTableauChiffrement(message,key);
            ArrayList<Integer> ordre = getOrdreColonne(key);
            for(int temp : ordre){
                for(int i=0;i<tab.length;i++){
                    res += tab[i][temp-1];
                }
            }
        }catch(ExceptionConversionImpossible e){
            e.gerer();
        }
        return new MessageString(res);
    }

    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionChiffrementImpossible {
        String res = "";
        try{
            String msg = message.asString();
            Cle key = clesPrivees.getCle("cleTransposition");
            char[][] tab = remplirTableauChiffrement(message,key);
            ArrayList<Integer> ordre = getOrdreColonne(key);
            int nb = 0;
            for(int temp : ordre){
                for(int i=0;i<tab.length;i++){
                    tab[i][temp-1] = msg.charAt(nb);
                    nb++;
                }
            }
            for(int y = 0; y < tab.length; y++){
                for(int j = 0; j< tab[0].length;j++){
                    res += tab[y][j];
                }
            }
            
            
        }catch(ExceptionConversionImpossible e){
            e.gerer();
        }
        return new MessageString(res);
    }
    
    /**
     * Permet de remplir un tableau avec un message afin de le chiffrer
     * @param message Le message a chiffrer
     * @param cle Cle pour remplir le tableau 
     * @return Un tableau de char a 2 dimensions
     * @throws ExceptionConversionImpossible 
     */
    private char[][] remplirTableauChiffrement(Message message, Cle cle) throws ExceptionConversionImpossible{
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt((cle.asString()+message.asString()).hashCode());
        this.generateur = new SecureRandom (b.array());
        char[][] tab = null;
        try{
            String msg = message.asString();
            String key = cle.asString();
            int temp = 0;
            int taille = (msg.length() / key.length());
            if(msg.length() % key.length() != 0)
                taille++;
            tab = new char[taille][key.length()];
            for(int i=0; i<taille;i++){
                for(int j=0; j<key.length();j++){
                    if(msg.length() > temp)
                        tab[i][j] = msg.charAt(temp);
                    else
                        tab[i][j] = bourrage();
                    temp++;
                }
            }
        } catch(ExceptionConversionImpossible e){
            e.gerer();
        }
        return tab;
    }
    
    /**
     * Génére un caractère aléatoire entre a..z et A..Z
     * @return le char généré
     */
    private char bourrage(){
        int min = 90-65;
        char temp = (char)(this.generateur.nextInt(26)+65);
        char temp2 = (char)(this.generateur.nextInt(26)+97);
        char fin;
        int alea = this.generateur.nextInt(2);
        if(alea == 0){
            fin = temp;
        }else{
            fin = temp2;
        }
        return fin;
    }
    
    /**
     * 
     * @param cle Cle qui permet de déterminer l'ordre
     * @return Une liste d'Integer représentant la liste do'ordre
     * @throws ExceptionConversionImpossible 
     */
    private ArrayList<Integer> getOrdreColonne(Cle cle) throws ExceptionConversionImpossible{
        ArrayList<Integer> list = new ArrayList<>();
        try{
            ArrayList<Couple> listeCouple = new ArrayList<>();
            String msg = cle.asString();
            for(int i=0;i<msg.length();i++){
                listeCouple.add(new Couple(msg.charAt(i),i+1));
            }
            Collections.sort(listeCouple,new ComparateurCouple());
            for(Couple c : listeCouple){
                list.add(c.getPosition());
            }         
        } catch(ExceptionConversionImpossible e){
            e.gerer();
        }
        return list;
    }
    
    @Override
    public String getNom() {
        return "Transposition";
    }
    
}
