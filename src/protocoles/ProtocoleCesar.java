/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocoles;


import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.AlgorithmeCesar;
import algorithmes.generateurDeCles.GenerateurDeClesCesar;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionConversionImpossible;

/**
 * Simulation du protocole Cesar
 * @author Mohamed
 */
public class ProtocoleCesar implements Protocole{

    @Override
    public void execute() {
        Personne alice = new Personne("Alice");
        Personne bob = new Personne("Bob");
        Algorithme cesar = new AlgorithmeCesar();
        alice.setAlgorithme(cesar);
        bob.setAlgorithme(cesar);
        GenerateurDeClesCesar generateur = new GenerateurDeClesCesar();
        Cles cle = generateur.genererClePrivee();
        alice.setClesPrivees(generateur.genererClePrivee());
        bob.setClesPrivees(generateur.genererClePrivee());
        Message message = new MessageString("Bonjour");
        try {
            Message msgAliceChiffré = alice.chiffrer(message, alice.getClesPrivees());
            System.out.println("Message chiffré : " + msgAliceChiffré.asString());
            Univers.addMessage("Message d'alice", alice.chiffrer(message, alice.getClesPrivees()));
            bob.dechiffrer(Univers.getMessage("Message d'alice"), bob.getClesPrivees());
            Message msgBobDechiffré = bob.dechiffrer(Univers.getMessage("Message d'alice"), bob.getClesPrivees());
            System.out.println("Message dechiffré : " + msgBobDechiffré.asString());
        } catch (ExceptionAlgorithmeNonDefini | ExceptionConversionImpossible ex) {
            ex.gerer();
        }        
           
    }
    
}
