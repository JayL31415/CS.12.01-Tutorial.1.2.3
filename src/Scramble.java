import java.util.ArrayList;
import java.util.List;

public class Scramble {
    public static String scrambleWord(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A' && i < str.length() - 1 && str.charAt(i + 1) != 'A') {
                result.append(str.charAt(i + 1));
                result.append(str.charAt(i));
                i++;
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void scrambleOrRemove(List<String> wordList) {
        List<String> toRemove = new ArrayList<>();

        for (int i = 0; i < wordList.size(); i++) {
            String original = wordList.get(i);
            String scrambled = scrambleWord(original);
            if (scrambled.equals(original)) {
                toRemove.add(original);
            } else {
                wordList.set(i, scrambled);
            }
        }

        wordList.removeAll(toRemove);
    }
}