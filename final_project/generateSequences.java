package final_project;

import java.util.Random;

public class generateSequences {
    private static int avgSize = 100;
    private static int largeSize = 100;

    // Randomly generate Characters String function
    public static String randomGenerateCharString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    // Randomly generate Speical String function
    public static String generateSpecialString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String specialCharacters = "!@#$%^&*()-_=+[]{};:'\",.<>/?\\|";
        int specialCharactersLength = specialCharacters.length();

        for (int i = 0; i < length; i++) {
            // Randomly select a special character from the list
            char c = specialCharacters.charAt(random.nextInt(specialCharactersLength));
            sb.append(c);
        }
        return sb.toString();
    }

    // Generates Two Strings of equal length
    public static String[] generateEqualLengthStrings() {
        String str1 = randomGenerateCharString(avgSize);
        String str2 = randomGenerateCharString(avgSize);
        return new String[] { str1, str2 };
    }

    // Generates two strings with no common characters
    public static String[] generateCompletelyDifferentStrings() {
        String str1 = randomGenerateCharString(avgSize);
        String str2 = generateSpecialString(avgSize);
        return new String[] { str1, str2 };
    }

    // Generates one string that contains the other
    public static String[] generateOneStringContainsOther() {
        String str1 = randomGenerateCharString(avgSize);
        String str2 = str1.substring(0, 51);
        return new String[] { str1, str2 };
    }

    // Generates one empty string
    public static String[] generateOneEmptyString() {
        String str1 = "";
        String str2 = randomGenerateCharString(avgSize);
        return new String[] { str1, str2 };
    }

    // Generates strings with repeated characters
    public static String[] generateRepeatedCharacters() {
        String str1 = "aaabbbcccdddeeefffGGGhhhiiijjjKKKlllmmmnnnooopppQQQrrrssstttUUUvvvwwwxxxyyyZZZ";
        String str2 = "abbbaaaabbbbcccddddeeefffGGGhhhiiijjjKKKlllmmmnnnooopppQQQrrrssstttUUUvvvwwwxxxyyyZZZ";
        return new String[] { str1, str2 };
    }

    // Generates long strings
    public static String[] generateLongStrings() {
        String str1 = randomGenerateCharString(largeSize);
        String str2 = randomGenerateCharString(largeSize);
        return new String[] { str1, str2 };
    }

    // Generates strings containing special characters
    public static String[] generateSpecialCharacters() {
        String str1 = "!@#$$%^&*()-_=+[]{};:'\",.<>/?\\|!@#$$%^&*()-_=+[]{};:'\",.<>/?\\|";
        String str2 = "!@#abbbaaaabbbbcccddddeeefffGGGhhhiiijjjKKKlllmmmnnnooopppQQQrrrssstttUUUvvvwwwxxxyyyZZZ!@#";
        return new String[] { str1, str2 };
    }

    // Generates two strings are the same
    public static String[] generateEdgeCases() {
        String str1 = randomGenerateCharString(avgSize);
        String str2 = str1;
        return new String[] { str1, str2 };
    }
}
