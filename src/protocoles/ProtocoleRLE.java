/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocoles;

import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.AlgorithmeCesar;
import algorithmes.chiffrement.AlgorithmeRLE;
import algorithmes.generateurDeCles.GenerateurDeCles;
import algorithmes.generateurDeCles.GenerateurDeClesCesar;
import algorithmes.generateurDeCles.GenerateurDeClesRLE;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionConversionImpossible;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hamadi
 */
public class ProtocoleRLE implements Protocole {

    @Override
    public void execute() {
        Personne alice = new Personne("Alice");
        Algorithme algorithmeRLE = new AlgorithmeRLE();
        alice.setAlgorithme(algorithmeRLE);
        GenerateurDeCles generateur = new GenerateurDeClesRLE(45);
        Cles cles = generateur.genererClePublique();
        Univers.addCles("cleRLE", cles);
        String msg = "AAAAAAAAA221111111111111111111111111111AAAAAAAAAAAAAA4512111111111111111111111111AAAAAAAAAAAAACCCCCDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDAAAABBBBBBBBBBBDDDDDDDDDD";
        Message message = new MessageString(msg);
        try {
            Message chiffrer = alice.chiffrer(message, Univers.getCles("cleRLE"));     
            Univers.addMessage("messageRLE",chiffrer);
            Message mess = Univers.getMessage("messageRLE");
            System.out.println("Message compressé : "+mess.asString());
            Message dechiffrer = alice.dechiffrer(mess, Univers.getCles("cleRLE"));
            System.out.println("Message decompressé : "+dechiffrer.asString());
            System.out.println("Messageà compresser : "+msg);
            if(mess.asString().length() != 0)
                System.out.println("Taux de compression : "+(double)dechiffrer.asString().length()/(double)mess.asString().length());
            
        } catch (ExceptionAlgorithmeNonDefini | ExceptionConversionImpossible ex) {
            ex.gerer();
        }
        
    }
    
}
