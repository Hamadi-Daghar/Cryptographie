/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmes.generateurDeCles;

import donnees.cles.Cles;

/**
 * Permet de générer des clés pour les algorithmes
 * @author Mohamed
 */
public interface GenerateurDeCles {
    
    /**
     * Genere une Cles publique
     * @return Cles contenant des Cle
     */
    public Cles genererClePublique();
    
    /**
     * Génére une Cles privee
     * @return Cles contenant des Cle
     */
    public Cles genererClePrivee();
}
