import java.util.Arrays;

public class Exercise1 {

    private final static String REPLACE_WHITESPACE_REGEX = "\\s+";
    private final static String EMPTY_STRING = "";

    public static boolean isAnagram(String word1, String word2) {

        if (word1 == null || word2 == null) {
            throw new NullPointerException("isAnagram method can't be called with null parameters.");
        }

        String w1 = word1.replaceAll(REPLACE_WHITESPACE_REGEX, EMPTY_STRING);
        String w2 = word2.replaceAll(REPLACE_WHITESPACE_REGEX, EMPTY_STRING);

        if (w1.length() != w2.length()) {
            return false;
        } else {
            char[] w1Array = w1.toLowerCase().toCharArray();
            char[] w2Array = w2.toLowerCase().toCharArray();

            Arrays.sort(w1Array);
            Arrays.sort(w2Array);

            return Arrays.equals(w1Array, w2Array);
        }


    }
}
