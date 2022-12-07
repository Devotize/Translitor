//script url link = https://script.google.com/macros/s/AKfycbwi_0PoxFRAyv3DZynvdcfiYiaUzrO3ktaM6BD2Wm1FjqhORXStNEAv20WN_OBUTWpbXw/exec

import interactors.TextTranslator;
import interactors.TextTranslitor;

public class Main {

    public static void main(String[] args) {
        String text = "Hello world!";
        //Translated text: Hallo Welt!
        String translatedText = TextTranslator.execute(text);
        System.out.println("Translated text: " + translatedText);
        TextTranslitor.execute(translatedText);
    }


}