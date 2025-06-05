package fr.richeton.bruno.numbertoletterapi.manager;

import fr.richeton.bruno.numbertoletterapi.exceptions.NumberToLetterErrorCode;
import fr.richeton.bruno.numbertoletterapi.exceptions.NumberToLetterException;
import fr.richeton.bruno.numbertoletterapi.providers.NumberToLetterConverterApi;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestionnaire de convertisseur nombre => lettres.
 * 
 * Cette classe est un singleton
 * @author Bruno RICHETON <bruno.richeton@free.fr>
 */
public class NumberToLetterConverterManager {
    
    private static NumberToLetterConverterManager _singleton;
    
    private final Map<String, NumberToLetterConverterApi> _registeredConverters = new HashMap();
    
    private NumberToLetterConverterManager(){
    }
    
    /**
     * Retourne le gestionnaire de convertisseur
     * @return le gestionnaire de convertisseur
     */
    static public synchronized  NumberToLetterConverterManager getInstance(){
        if (_singleton == null){
            _singleton = new NumberToLetterConverterManager();
        }
        
        return _singleton;
    }
    
    
    /**
     * Enregistre un convertisseur
     * @param converter le convertisseur
     * @throws NumberToLetterException  en cas d'erreur
     */
    public synchronized void registerConverter(NumberToLetterConverterApi converter) throws NumberToLetterException {
        try {
            if (converter == null){
                throw new NumberToLetterException(NumberToLetterErrorCode.NULL_CONVERTER);
            }

            final String lang = converter.getLanguage();
            if (lang == null){
                throw new NumberToLetterException(NumberToLetterErrorCode.NULL_LANGUAGE);
            }

            if(_registeredConverters.containsKey(lang)){
                throw new NumberToLetterException(NumberToLetterErrorCode.CONVERTER_EXISTS);
            }

            _registeredConverters.put(lang, converter);
        }
        catch(NumberToLetterException e){
            throw e;
        }
        catch(Exception error){
            throw new NumberToLetterException(NumberToLetterErrorCode.UNKNOWN_ERROR, error);
        }
    }
    
    
    /**
     * Retourne le convertisseur pour une langue donnée
     * @param language la langue souhaitée
     * @return le convertisseur ou null si aucun
     * @throws NumberToLetterException en cas d'erreur
     */
    public synchronized NumberToLetterConverterApi getConverter(String language) throws NumberToLetterException {
        try {
            NumberToLetterConverterApi retValue;
            if (language == null){
                throw new NumberToLetterException(NumberToLetterErrorCode.NULL_LANGUAGE);
            }

            retValue = _registeredConverters.get(language);
            return retValue;
        }
        catch(NumberToLetterException e){
            throw e;
        }
        catch(Exception error){
            throw new NumberToLetterException(NumberToLetterErrorCode.UNKNOWN_ERROR, error);
        }
    }
    
    
    /**
     * Retourne un nombre converti en lettre pour une langue donnée
     * @param language la langue souhaitée
     * @param number le nombre à convertir
     * @return le nombre en lettre
     * @throws NumberToLetterException en cas d'erreur
     */
    public String convertNumber(String language, long number) throws NumberToLetterException {
        try {
            String retValue;
            
            if (language == null){
                throw new NumberToLetterException(NumberToLetterErrorCode.NULL_LANGUAGE);
            }
            
            NumberToLetterConverterApi converter = getConverter(language);
            if (converter == null){
                throw new NumberToLetterException(NumberToLetterErrorCode.NULL_CONVERTER);
            }
            retValue = converter.convertToLetters(number);   
            
            return retValue;
         }
        catch(NumberToLetterException e){
            throw e;
        }
        catch(Exception error){
            throw new NumberToLetterException(NumberToLetterErrorCode.UNKNOWN_ERROR, error);
        }
    }
    
}
