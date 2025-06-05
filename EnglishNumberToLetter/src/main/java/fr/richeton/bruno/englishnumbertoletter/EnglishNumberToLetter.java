package fr.richeton.bruno.englishnumbertoletter;

import fr.richeton.bruno.englishnumbertoletter.converter.EnglishNumberToLetterConverter;

/**
 *
 * @author Bruno RICHETON <bruno.richeton@free.fr>
 */
public class EnglishNumberToLetter {
    
    
    

    public static void main(String[] args) {
        
        final int argsCount = args.length;
        if (argsCount > 1){
            EnglishNumberToLetterConverter converter = new EnglishNumberToLetterConverter();
                                
            for (int i = 0; i < argsCount; i++){
                String val = args[i];
                StringBuilder message = new StringBuilder("   - Conversion ");
                message.append(val);
                message.append(" : ");
                try {
                    Long number = Long.decode(val);
                    
                    String letters = converter.convertToLetters(number);
                    message.append(letters);
                }
                catch (NumberFormatException nfe){
                    message.append("ERROR => Pas un nombre");
                }
                catch (Exception error){
                    message.append("ERROR => ");
                    message.append(error.getMessage());
                    
                    Throwable cause = error.getCause();
                    if (cause != null){
                        message.append(" ->");
                        message.append(cause.getMessage());
                    }
                }
                System.out.println(message.toString());
            } 
        }
        else {
            System.out.println("Aucun nombre à convertir");
        }
    }
}
