package fr.richeton.bruno.numbertoletterapi.exceptions;

/**
 * Exception générée par  la conversion 
 * @author Utilisateur
 */
public class NumberToLetterException extends RuntimeException {
    
    private final NumberToLetterErrorCode _errorCode;
    
    public NumberToLetterException(NumberToLetterErrorCode code) {
        super(code.getMessage());
        this._errorCode = code;
    }

    public NumberToLetterException(NumberToLetterErrorCode code, Throwable cause) {
        super(code.getMessage(), cause);
        this._errorCode = code;
    }

    public NumberToLetterErrorCode getErrorCode() {
        return _errorCode;
    }
    
    
}
    
    