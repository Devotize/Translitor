package interactors;

import java.util.*;

public class TextTranslitor {

    private static Queue<Integer> uppercasePositions;

    private static void rememberUppercasePositions(String input) {
        char[] charArray = input.toCharArray();
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                positions.add(i);
            }
        }
        uppercasePositions = new LinkedList<>(positions);
    }

    public static String execute(String initialText) {
        return translite(initialText);
    }

    private static String translite(String input) {
        rememberUppercasePositions(input);
        StringBuilder sb = new StringBuilder();
        char[] charArray = input.toLowerCase().toCharArray();
        for (Integer i = 0; i < charArray.length; i++) {
            try {
                char symbol = charArray[i];
                String translited = relatives.get(String.valueOf(symbol));
                String result;
                result = Objects.requireNonNullElse(translited, String.valueOf(symbol));
                if (i.equals(uppercasePositions.peek())) {
                    result = result.substring(0, 1).toUpperCase() + result.substring(1);
                    uppercasePositions.poll();
                }
                sb.append(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static final Map<String, String> relatives;

    static {
        Map<String, String> aMap = new HashMap<>(Map.of());
        aMap.put("й", "iy");
        aMap.put("ц", "ts");
        aMap.put("у", "u");
        aMap.put("к", "k");
        aMap.put("е", "e");
        aMap.put("н", "n");
        aMap.put("г", "g");
        aMap.put("ш", "sh");
        aMap.put("щ", "sh'");
        aMap.put("з", "z");
        aMap.put("х", "h");
        aMap.put("ъ", "'");
        aMap.put("ф", "f");
        aMap.put("ы", "y");
        aMap.put("в", "v");
        aMap.put("а", "a");
        aMap.put("п", "p");
        aMap.put("р", "r");
        aMap.put("о", "o");
        aMap.put("л", "l");
        aMap.put("д", "d");
        aMap.put("ж", "j");
        aMap.put("э", "e");
        aMap.put("ё", "e");
        aMap.put("я", "ya");
        aMap.put("ч", "ch");
        aMap.put("с", "s");
        aMap.put("м", "m");
        aMap.put("и", "i");
        aMap.put("т", "t");
        aMap.put("ь", "'");
        aMap.put("б", "b");
        aMap.put("ю", "yu");
        relatives = Collections.unmodifiableMap(aMap);
    }

}



