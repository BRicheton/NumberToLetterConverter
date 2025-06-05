package fr.richeton.bruno.englishnumbertoletter.converter;

import fr.richeton.bruno.numbertoletterapi.exceptions.NumberToLetterErrorCode;
import fr.richeton.bruno.numbertoletterapi.exceptions.NumberToLetterException;
import fr.richeton.bruno.numbertoletterapi.providers.AbstractNumberToLetterConverter;

/**
 *
 * @author Bruno RICHETON <bruno.richeton@free.fr>
 */
public class EnglishNumberToLetterConverter extends AbstractNumberToLetterConverter {

    public static final String ENGLISH_LANGUAGE = "english";
    
    
    public EnglishNumberToLetterConverter() {
        super(ENGLISH_LANGUAGE);
    }
    
    
    @Override
    public String convertToLetters(long number) throws NumberToLetterException {
        try {
            String retValue;
            
            if (number == 0){
                retValue = "zero";
            }
            else if (number < 0){
                StringBuilder sb = new StringBuilder("minus ");
                sb.append(convertToLetters(-number));
                retValue = sb.toString();
            }
            else {
                retValue = parseNumber(0, number);
            }
            return retValue;
        }
        catch (Exception e){
            throw new NumberToLetterException(NumberToLetterErrorCode.CONVERSION_ERROR, e);
        }
    }
    
    
    private String parseNumber(int level, long number) throws NumberToLetterException{
        StringBuilder sb = new StringBuilder();
        long greater = (number /1000L);
        
        if (greater > 0L ){
            level ++;
            sb.append(parseNumber(level, greater));
            
            switch(level){
                case 1 -> {
                    sb.append(" thousand");
                }
                case 2 -> {
                    sb.append(" million");
                }
                case 3 -> {
                    sb.append(" billion");
                }
                case 4 -> {
                    sb.append(" trillion");
                }
                default-> {
                    throw new NumberToLetterException(NumberToLetterErrorCode.NUMBER_TOO_BIG);
                }
            }
        }
        
        long rest = number - (1000L * greater);
        if (rest > 0){
            String restText = convertUnderThousand(rest);
            
            if (sb.length() > 0){
                sb.append(' ');
                
            }
            sb.append(restText);
        }
        return sb.toString();
    }
    
    
    private String convertUnderThousand(long number) throws NumberToLetterException {
        assert(number > 0L && number < 1000L);
        String retValue;
        if (number < 20L){
            retValue = convertUnderTwenty(number);
        }
        else {
            StringBuilder sb = new StringBuilder("");
            long hundreds = (number / 100L);
            if (hundreds > 0){
                sb.append(convertUnderTen(hundreds));
                sb.append(" hundred");
            }
            
            long tens = number - (hundreds * 100L);
            if (tens > 0){
                if (sb.length()> 0){
                    sb.append(' ');
                }
                if (tens >= 20){
                    long digit = tens / 10L;
                    switch(digit){
                        case 2L -> {
                            sb.append("twenty");
                        }
                        case 3L -> {
                            sb.append("thirty");
                        }
                        case 4L -> {
                            sb.append("forty");
                        }
                        case 5L -> {
                            sb.append("fifty");
                        }
                        case 6L -> {
                            sb.append("sixty");
                        }
                        case 7L -> {
                            sb.append("seventy");
                        }
                        case 8L -> {
                            sb.append("eighty");
                        }
                        case 9L -> {
                            sb.append("ninety");
                        }
                        default-> {}
                    }
                    long unit = tens-(10L * digit);
                    if (unit > 0){
                        sb.append('-');
                        sb.append(convertUnderTen(unit));
                    }
                }
                else {
                    sb.append(convertUnderTwenty(number));
                }
            }            
            
            retValue = sb.toString();
        }
        
        return retValue;
    }
    
    private String convertUnderTwenty(long number) throws NumberToLetterException {
        assert(number > 0L && number < 20L);
        String retValue;
        
        switch(number){
            case 10L ->     {
                retValue = "ten";
            }
            case 11L ->     {
                retValue = "eleven";
            }
            case 12L ->     {
                retValue = "twelve";
            }
            case 13L ->     {
                retValue = "thirteen";
            }
            case 14L ->     {
                retValue = "fourteen";
            }
            case 15L ->     {
                retValue = "fifteen";
            }
            case 16L ->     {
                retValue = "sixteen";
            }
            case 17L ->     {
                retValue = "seventeen";
            }
            case 18L ->     {
                retValue = "eighteen";
            }
            case 19L ->     {
                retValue = "nineteen";
            }
            default -> {
                retValue = convertUnderTen(number);
            }
        }
        
        return retValue;
    }
    
    private String convertUnderTen(long number) throws NumberToLetterException {
        
        String retValue;
        
        switch(number){
            case 1L ->     {
                retValue = "one";
            }
            case 2L ->     {
                retValue = "two";
            }
            case 3L ->     {
                retValue = "three";
            }
            case 4L ->     {
                retValue = "four";
            }
            case 5L ->     {
                retValue = "five";
            }
            case 6L ->     {
                retValue = "six";
            }
            case 7L ->     {
                retValue = "seven";
            }
            case 8L ->     {
                retValue = "eight";
            }
            case 9L ->     {
                retValue = "nine";
            }
            default -> {
                throw new NumberToLetterException(NumberToLetterErrorCode.CONVERSION_ERROR, new RuntimeException("Invalid digit"));
            }
        }
        
        return retValue;
    }
    
    
}
