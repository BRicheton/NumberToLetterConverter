/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.richeton.bruno.numbertoletterapi.exceptions;

/**
 * Enum des erreurs potentielles
 * @author Bruno RICHETON <bruno.richeton@free.fr>
 */
public enum NumberToLetterErrorCode {
    NULL_LANGUAGE(1, "A converter cannot have a null language"),
    NULL_CONVERTER(2, "Null converter found"),
    CONVERTER_EXISTS(3, "Converter already exists"),
    CONVERSION_ERROR(100, "An error occured while converting number"),
    NUMBER_TOO_BIG(101, "Number is too big"),
    UNKNOWN_ERROR(255, "Unknown error");
            
    
    private final int code;
    private final String message;

    private NumberToLetterErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
    
    
    
    
}
