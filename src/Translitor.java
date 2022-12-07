import java.io.IOException;

//script url link = https://script.google.com/macros/s/AKfycbwi_0PoxFRAyv3DZynvdcfiYiaUzrO3ktaM6BD2Wm1FjqhORXStNEAv20WN_OBUTWpbXw/exec

public class Translitor {

    public static void main(String[] args) throws IOException {
        String text = "Hello world!";
        //Translated text: Hallo Welt!
        System.out.println("Translated text: " + TextTranslator.execute(text));
    }


}