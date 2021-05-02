/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocoles;

import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.AlgorithmeSubstitution;
import algorithmes.chiffrement.AlgorithmeVigenere;
import algorithmes.generateurDeCles.GenerateurDeCles;
import algorithmes.generateurDeCles.GenerateurDeClesSubstitution;
import algorithmes.generateurDeCles.GenerateurDeClesVigenere;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionConversionImpossible;

/**
 *
 * @author Hamadi
 */
public class ProtocoleSubstitution implements Protocole {

    @Override
    public void execute() {
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");
        Algorithme algoSubstitution = new AlgorithmeSubstitution();
        alice.setAlgorithme(algoSubstitution);
        bob.setAlgorithme(algoSubstitution);
        
        GenerateurDeCles generateur = new GenerateurDeClesSubstitution();
        Cles cles = generateur.genererClePrivee();
        alice.setClesPrivees(cles);
        bob.setClesPrivees(cles);
        
        Message message = new MessageString("Salut, nous nous appelons Mohamed et Hamadi, tu dois dechiffrer ce message");
        try {
            Message chiffrer = alice.chiffrer(message, cles);
            Univers.addMessage("message", chiffrer);
            Message temp = Univers.getMessage("message");
            Message dechiffrer = bob.dechiffrer(temp, cles);
            System.out.println("Message chiffré : " + chiffrer.asString());
            System.out.println("Message dechiffré : " + dechiffrer.asString());
        } catch (ExceptionAlgorithmeNonDefini | ExceptionConversionImpossible ex) {
            ex.gerer();
        }
    }
    
}
