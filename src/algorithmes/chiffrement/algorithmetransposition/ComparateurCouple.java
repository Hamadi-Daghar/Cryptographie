/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.chiffrement.algorithmetransposition;

import java.util.Comparator;

/**
 * Permet de comparer des couples de Couple
 * @author Hamadi
 */
public class ComparateurCouple implements Comparator<Couple>{

    @Override
    public int compare(Couple t, Couple t1) {
        int res = 0;
        if(t.getCaractere() < t1.getCaractere())
        {
            res = -1;
        }
        else 
        {
            if (t.getCaractere() == t1.getCaractere()){
                if(t.getPosition() < t1.getPosition())
                {
                    res = -1;
                }
            }
        }
        return res;
    }
    
}
