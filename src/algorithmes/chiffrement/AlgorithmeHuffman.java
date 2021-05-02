package algorithmes.chiffrement;

import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.huffman.ComparateurNoeuds;
import algorithmes.chiffrement.huffman.Noeud;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import exceptions.ExceptionCryptographie;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description de la classe
 * @author Matthieu
 */
public class AlgorithmeHuffman implements Algorithme {
    

    /**
     * Récuperer le nom de l'algo
     * @return 
     */
    @Override
    public String getNom() {
        return "Huffman";
    }
    
    //Etape 1 - Comptage des caractères ----------------------------------------
    private HashMap<Character,Integer> compterCaracteres(String message) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char c : message.toCharArray()){
            if(hash.get(c) == null)
                hash.put(c, 1);
            else
                hash.put(c, hash.get(c) + 1);
        }
        return hash;
    }
    //--------------------------------------------------------------------------
    
    
    
    
    //Etape 2 - Création de l'arbre --------------------------------------------
    private PriorityQueue<Noeud> creationListeNoeuds(HashMap<Character,Integer> mapComptageCaractere) {
        ComparateurNoeuds comparateur = new ComparateurNoeuds();
        PriorityQueue<Noeud> priority = new PriorityQueue<>(comparateur);
        
        for(Map.Entry<Character, Integer> i : mapComptageCaractere.entrySet()){
            Noeud node = new Noeud(String.valueOf(i.getKey()), i.getValue());
            priority.add(node);
        }
        return priority;
    }
    
    /**
     * On créer l'abre avec la hash map des caractères/occurence
     * @param mapComptageCaractere
     * @return 
     */
    private Noeud creationArbre(HashMap<Character,Integer> mapComptageCaractere) {
        PriorityQueue<Noeud> listeNoeuds = this.creationListeNoeuds(mapComptageCaractere);
        
        while(listeNoeuds.stream().count() >= 2){
            Noeud n1 = listeNoeuds.poll();
            Noeud n2 = listeNoeuds.poll();
            Noeud noeud = new Noeud(n1.getNom()+n2.getNom(),n1.getNombreOccurences()+n2.getNombreOccurences());
            noeud.ajouterFils(n1);
            noeud.ajouterFils(n2);
            listeNoeuds.add(noeud);
        }
        return listeNoeuds.peek();
    }
    //--------------------------------------------------------------------------
    
   
    
    
    //Etape 3 - Création du dictionnaire----------------------------------------
    private HashMap<Character,String> creationDictionnaire(Noeud racine) {
        HashMap<Character, String> dictionnaire = new HashMap<>();
        racine.calculCode(dictionnaire);
        return dictionnaire;
    }
    //--------------------------------------------------------------------------

    
    
    
    //Etape 4 - Chiffrement du message -----------------------------------------
    private String chiffrerMessage(String message,HashMap<Character,String> dictionnaire) {
        String chiffrer ="";
        for(char c : message.toCharArray()){
            chiffrer += dictionnaire.get(c);
        }
        return chiffrer;
    }
    //--------------------------------------------------------------------------
    
    
    
    @Override
    public Message chiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        //TODO
        //On récupère le message comme une chaine de caractères
        
        //Etape 1 - On compe les caractères
        //Etape 2 - On crée l'arbre
        //Etape 3 - On crée le dictionnaire
        //Etape 4 - Encodage avec le dictionnaire
        
        //On renvoit le message compressé
        HashMap<Character,Integer> compteCaracteres = this.compterCaracteres(message.asString());
        Noeud racineArbre = this.creationArbre(compteCaracteres);
        HashMap<Character,String> dictionnaire = this.creationDictionnaire(racineArbre);
        String dico = "";
        for(char c : dictionnaire.keySet()){
            dico += c + dictionnaire.get(c); //on créer le dico sous forme de string 
        }
        Message res = new MessageString(this.chiffrerMessage(message.asString(), dictionnaire)+":"+dico);//on donne le message crypté et le dico en string
        return res;
    }
    
    /**
     * Convertir un string en dictionnaire
     * @param dico
     * @return un dictionnaire
     */
    private HashMap<Character,String> stringToDictionnaire(String msg){
        HashMap<Character,String> dictionnaire = new HashMap<>();
        String temp = "";
        char c;
        int cpt = 0;
        while(cpt<msg.length())
        {
            c = msg.charAt(cpt);
            cpt++;
            while(cpt< msg.length() && (msg.charAt(cpt) == '1' || msg.charAt(cpt) == '0'))
            {
                temp += msg.charAt(cpt);
                cpt++;
            }
            dictionnaire.put(c, temp);
            temp = "";
        }
        return dictionnaire;
    }
    
    /**
     * En l'état actuel, le dictionnaire n'est pas récupérable, 
     * le message crypté contient le dictionnaire sous forme d'un string (on met un delimiter).
     * On recréer le dictionnaire et on parcours ensuite dans notre message chaque caractères, si c'est une
     * feuille on le prend, sinon on continue, jusqu'à trouver une feuille.
     * On concatene ce qu'on trouve et on retourne le message
     */
    @Override
    public Message dechiffrer(Message message, Cles clesPubliques, Cles clesPrivees) throws ExceptionCryptographie {
        String[] msgTemp = message.asString().split(":");
        HashMap<Character,String> dictionnaire;
        dictionnaire = this.stringToDictionnaire(msgTemp[1]);//partie avec le dictionnaire, on créer un dico avec
        String msg = msgTemp[0];//partie sans le dictionnaire
        String res = "";
        String t = "";
        Boolean b = false;
        for(int i = 0; i < msg.length(); i++){
            t += msg.charAt(i);
            for(char c : dictionnaire.keySet()){
                if(t.equals(dictionnaire.get(c))){
                    res += c;
                    b = true;
                }
            }
            if(b == true){
                t = "";
                b = false;
            }

        }
        return new MessageString(res);
    }
    
    
    
}
