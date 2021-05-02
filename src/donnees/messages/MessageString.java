/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees.messages;

import exceptions.ExceptionConversionImpossible;
import java.util.ArrayList;

/**
 * Permet de gérer les Message de chaîne de caractère
 * @author Mohamed
 */
public class MessageString implements Message{
    
    private String message;
    
    /**
     * Constructeur
     * @param message 
     */
    public MessageString(String message){
        this.message = message;
    } 

    @Override
    public String asString() throws ExceptionConversionImpossible{
        String temp = "";
        temp = this.message;  
        return temp;
    }

    @Override
    public int asInteger() throws ExceptionConversionImpossible{
        int temp = 0;
        try
        {
            temp = Integer.valueOf(this.message);
        }
        catch(NumberFormatException e)
        {
            throw new ExceptionConversionImpossible(this.message);
        }
        return temp;
    }

    @Override
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible {
        ArrayList<Integer> list = new ArrayList();
        for(int i=0;i<this.message.length();i++){
            list.add((int)this.message.charAt(i));
        }
        return list;
    }
    
    
}
