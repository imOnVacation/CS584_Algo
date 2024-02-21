package final_project;

import java.util.Random;

public class generateSequences {

    public static void main(String[] args) {
        generateEqualLengthStrings();
        generateCompletelyDifferentStrings();
        generateOneStringContainsOther();
        generateOneEmptyString();
        generateRepeatedCharacters();
        generateLongStrings();
        generateSpecialCharacters();
        generateEdgeCases();
    }

    // Randomly generate String function
    public static String randomGenerateString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    // Generates Two Strings of equal length
    public static String[] generateEqualLengthStrings() {
        int length = 10;
        String str1 = randomGenerateString(length);
        String str2 = randomGenerateString(length);
        return new String[] { str1, str2 };
    }

    // Generates two strings with no common characters
    public static String[] generateCompletelyDifferentStrings() {
        String str1 = "abcdefghijklm";
        String str2 = "nopqrstuvwxyz";
        return new String[] { str1, str2 };
    }

    // Generates one string that contains the other
    public static String[] generateOneStringContainsOther() {
        String str1 = "abcdefg";
        String str2 = "abc";
        return new String[] { str1, str2 };
    }

    // Generates one empty string
    public static String[] generateOneEmptyString() {
        String str1 = "";
        String str2 = "abcdefg";
        return new String[] { str1, str2 };
    }

    // Generates strings with repeated characters
    public static String[] generateRepeatedCharacters() {
        String str1 = "aaabbb";
        String str2 = "abbba";
        return new String[] { str1, str2 };
    }

    // Generates long strings
    public static String[] generateLongStrings() {
        int length = 1000;
        String str1 = randomGenerateString(length);
        String str2 = randomGenerateString(length);
        return new String[] { str1, str2 };
    }

    // Generates strings containing special characters
    public static String[] generateSpecialCharacters() {
        String str1 = "hello, world!";
        String str2 = "world, hello!";
        return new String[] { str1, str2 };
    }

    // Generates edge cases - two strings are the same
    public static String[] generateEdgeCases() {
        String str1 = "aaaaaaa";
        String str2 = "aaaaaaa";
        return new String[] { str1, str2 };
    }
}
