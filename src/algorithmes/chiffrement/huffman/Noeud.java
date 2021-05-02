package algorithmes.chiffrement.huffman;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description de la classe
 * @author Matthieu
 */
public class Noeud {

    private String nom;                             
    private int valeur;                             
    private ArrayList<Noeud> listeFils;
    private String code;
    
    public Noeud(String nom, int nombreOccurences) {
        this.nom = nom;
        this.valeur = nombreOccurences;
        this.listeFils = new ArrayList<>();
        this.code = "";
    }

    public String getNom() {
        return nom;
    }

    public int getNombreOccurences() {
        return valeur;
    }
    
    public String toString() {
        return nom+" - "+this.valeur;
    }
    
    public void ajouterFils(Noeud fils) {
        this.listeFils.add(fils);
    }
    
    public void calculCode(HashMap<Character,String> dictionnaire) {
        if(this.listeFils.isEmpty())
            dictionnaire.put(this.nom.charAt(0), this.code);
        else{
            this.listeFils.get(0).code = this.code + "0";
            this.listeFils.get(1).code = this.code + "1";
            this.listeFils.get(0).calculCode(dictionnaire);
            this.listeFils.get(1).calculCode(dictionnaire);
        }
    }
}
