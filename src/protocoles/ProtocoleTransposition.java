/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocoles;

import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.AlgorithmeTransposition;
import algorithmes.generateurDeCles.GenerateurDeClesTransposition;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionConversionImpossible;

/**
 * Simulation du protocole Transposition
 * @author Mohamed
 */
public class ProtocoleTransposition implements Protocole{

    @Override
    public void execute() {
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");
        Algorithme transposition = new AlgorithmeTransposition();
        alice.setAlgorithme(transposition);
        bob.setAlgorithme(transposition);
        
        GenerateurDeClesTransposition generateur = new GenerateurDeClesTransposition(100);
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
