package interactors;

import java.util.*;

public class TextTranslitor {

    private static int[] getUppercasePositions(String input) {
        char[] charArray = input.toCharArray();
        List<Integer> uppercasePositions = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                uppercasePositions.add(i);
            }
        }
        return uppercasePositions.stream().mapToInt(Integer::intValue).toArray();
    }

    public static String execute(String initialText) {
        int[] uppercasePositions = getUppercasePositions(initialText);
        System.out.println(List.of(uppercasePositions));
        return "";
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



