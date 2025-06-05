package fr.richeton.bruno.numbertoletterapi.providers;

/**
 * Implementation de base d'un convertisseur
 * @author Bruno 
 */
public abstract class AbstractNumberToLetterConverter implements NumberToLetterConverterApi {
    private final String _language;

    public AbstractNumberToLetterConverter(String _language) {
        this._language = _language;
    }

    @Override
    public String getLanguage() {
        return _language;
    }
}
