package final_project;

public class Main {
    public static void main(String[] args) {
        String[] test1_strings = generateSequences.generateEqualLengthStrings();
        System.out.println("\n ***** Test 1 - Two Strings of equal length *****");
        System.out.println("String 1: " + test1_strings[0]);
        System.out.println("String 2: " + test1_strings[1]);

        String[] test2_strings = generateSequences.generateCompletelyDifferentStrings();
        System.out.println("\n ***** Test 2 - two strings with no common characters *****");
        System.out.println("String 1: " + test2_strings[0]);
        System.out.println("String 2: " + test2_strings[1]);

        String[] test3_strings = generateSequences.generateOneStringContainsOther();
        System.out.println("\n ***** Test 3 - one string that contains the other *****");
        System.out.println("String 3: " + test3_strings[0]);
        System.out.println("String 3: " + test3_strings[1]);

        String[] test4_strings = generateSequences.generateOneEmptyString();
        System.out.println("\n ***** Test 4 - one empty string *****");
        System.out.println("String 4: " + test4_strings[0]);
        System.out.println("String 4: " + test4_strings[1]);

        String[] test5_strings = generateSequences.generateRepeatedCharacters();
        System.out.println("\n ***** Test 5 - strings with repeated characters *****");
        System.out.println("String 5: " + test5_strings[0]);
        System.out.println("String 5: " + test5_strings[1]);

        String[] test6_strings = generateSequences.generateLongStrings();
        System.out.println("\n ***** Test 6 - long strings *****");
        System.out.println("String 6: " + test6_strings[0]);
        System.out.println("String 6: " + test6_strings[1]);

        String[] test7_strings = generateSequences.generateSpecialCharacters();
        System.out.println("\n ***** Test 7 - strings containing special characters *****");
        System.out.println("String 7: " + test7_strings[0]);
        System.out.println("String 7: " + test7_strings[1]);

        String[] test8_strings = generateSequences.generateEdgeCases();
        System.out.println("\n ***** Test 8 - edge case: two strings are the same *****");
        System.out.println("String 8: " + test8_strings[0]);
        System.out.println("String 8: " + test8_strings[1]);
    }
}
