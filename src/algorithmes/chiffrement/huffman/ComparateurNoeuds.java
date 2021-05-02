package algorithmes.chiffrement.huffman;

import algorithmes.chiffrement.huffman.Noeud;
import java.util.Comparator;

/**
 * Description de la classe
 * @author Matthieu
 */
public class ComparateurNoeuds implements Comparator<Noeud> {

    @Override
    public int compare(Noeud o1, Noeud o2) {
        return o1.getNombreOccurences() - o2.getNombreOccurences();
    }

}
