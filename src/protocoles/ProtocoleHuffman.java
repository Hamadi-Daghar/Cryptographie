package protocoles;

import algorithmes.chiffrement.Algorithme;
import algorithmes.chiffrement.AlgorithmeHuffman;
import algorithmes.chiffrement.AlgorithmeRLE;
import algorithmes.generateurDeCles.GenerateurDeCles;
import algorithmes.generateurDeCles.GenerateurDeClesRLE;
import donnees.cles.Cles;
import donnees.messages.Message;
import donnees.messages.MessageString;
import entites.Personne;
import entites.Univers;
import exceptions.ExceptionAlgorithmeNonDefini;
import exceptions.ExceptionConversionImpossible;
import exceptions.ExceptionCryptographie;

/**
 * Description de la classe
 * @author Matthieu
 */
public class ProtocoleHuffman implements Protocole {

    @Override
    public void execute() {
        Personne alice = new Personne("Alice");
        Algorithme algorithmeHuffman = new AlgorithmeHuffman();
        alice.setAlgorithme(algorithmeHuffman);
        String msg = "EDECBEEDAEBCEDAECE";
        Message message = new MessageString(msg);
        try {
            Message chiffrer = alice.chiffrer(message, null);     
            Univers.addMessage("messageHuffman",chiffrer);
            Message mess = Univers.getMessage("messageHuffman");
            System.out.println("Message compressé : "+mess.asString());
            Message dechiffrer = alice.dechiffrer(mess, null);
            System.out.println("Message decompressé : "+dechiffrer.asString());
        } catch (ExceptionAlgorithmeNonDefini | ExceptionConversionImpossible ex) {
            ex.gerer();
        }
    }

}
