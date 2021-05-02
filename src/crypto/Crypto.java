/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import protocoles.Protocole;
import protocoles.ProtocoleCesar;
import protocoles.ProtocoleHuffman;
import protocoles.ProtocoleRLE;
import protocoles.ProtocoleSubstitution;
import protocoles.ProtocoleTransposition;
import protocoles.ProtocoleVigenere;

/**
 *
 * @author Hamadi
 */
public class Crypto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------\n                    PROTOCOLE CESAR\n");
        Protocole c = new ProtocoleCesar();
        c.execute();
        System.out.println("\n------------------------------------------------------------\n                    PROTOCOLE TRANSPOSITION\n");
        Protocole t = new ProtocoleTransposition();
        t.execute();
        System.out.println("\n------------------------------------------------------------\n                    PROTOCOLE SUBSTITUTION\n");
        Protocole w = new ProtocoleSubstitution();
        w.execute();
        System.out.println("\n------------------------------------------------------------\n                    PROTOCOLE VIGENERE\n");
        Protocole x = new ProtocoleVigenere();
        x.execute();
        System.out.println("\n------------------------------------------------------------\n                    PROTOCOLE RLE\n");
        Protocole g = new ProtocoleRLE();
        g.execute();
        System.out.println("\n------------------------------------------------------------\n                    PROTOCOLE HUFFMAN\n");
        Protocole y = new ProtocoleHuffman();
        y.execute();
    }
    
}
