/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.messages;

import exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 * Permet de gérer les Message de code ASCII
 * @author Hamadi
 */
public class MessageASCII implements Message {
    
    private ArrayList<Integer> liste;
    
    /**
     * Constructeur
     * @param liste 
     */
    public MessageASCII(ArrayList<Integer> liste)
    {
        this.liste = liste;
    }

    @Override
    public String asString() throws ExceptionConversionImpossible {
        String message = "";
        for(Integer temp : liste)
        {
            message += (char)temp.intValue();
        }
        return message;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible {
        throw new ExceptionConversionImpossible("Conversion impossible");
    }

    @Override
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible {
        return this.liste;
    }
    
}
