package fr.richeton.bruno.numbertoletterapi.providers;

import fr.richeton.bruno.numbertoletterapi.exceptions.NumberToLetterException;

/**
 * Interface de l'api d'un convertisseur nombre en lettre
 * @author Bruno RICHETON
 */
public interface NumberToLetterConverterApi {
    
    /**
     * Retourne la langue gérée par ce convertisseur
     * @return le code de la langue
     */
   String getLanguage();  
   
   
   /**
    * Méthode de conversion d'un nombre en lettre
    * @param number le nombre à convertir
    * @return le nombre écrit
    * @throws NumberToLetterException en cas d'erreur
    */
   String convertToLetters(long number) throws NumberToLetterException;
}
