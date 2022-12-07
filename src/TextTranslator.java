import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TextTranslator {

    private static final String FROM_LANG = "en";

    private static final String TO_LANG = "ru";

    private static final String SCRIPT_URL = "https://script.google.com/macros/s/AKfycbwi_0PoxFRAyv3DZynvdcfiYiaUzrO3ktaM6BD2Wm1FjqhORXStNEAv20WN_OBUTWpbXw/exec";


    public static String execute(String sourceText) {
        try {
            return translate(sourceText);
        } catch (Exception e) {
            throw new RuntimeException("TranslateTextInteractor exception: " + e.getLocalizedMessage());
        }
    }

    private static String translate(String text) throws IOException {

        String urlStr = SCRIPT_URL +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + TextTranslator.TO_LANG +
                "&source=" + TextTranslator.FROM_LANG;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}
