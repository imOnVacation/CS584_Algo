package final_project;

public class Main {
    public static void main(String[] args) {
        runTest("Test 1 - Two Strings of equal length", generateSequences.generateEqualLengthStrings());
        runTest("Test 2 - two strings with no common characters",
                generateSequences.generateCompletelyDifferentStrings());
        runTest("Test 3 - one string that contains the other", generateSequences.generateOneStringContainsOther());
        runTest("Test 4 - one empty string", generateSequences.generateOneEmptyString());
        runTest("Test 5 - strings with repeated characters", generateSequences.generateRepeatedCharacters());
        runTest("Test 6 - long strings", generateSequences.generateLongStrings());
        runTest("Test 7 - strings containing special characters", generateSequences.generateSpecialCharacters());
        runTest("Test 8 - edge case: two strings are the same", generateSequences.generateEdgeCases());
    }

    public static void runTest(String testName, String[] testStrings) {
        System.out.println("\n ***** " + testName + " *****");
        System.out.println("String 1: " + testStrings[0]);
        System.out.println(
                "String 2: " + testStrings[1]);
        String tab_result = tabulation.tabulationSolution(testStrings[0], testStrings[1]);
        System.out.println("Tabulation Solution - Longest Common Subsequence: " + tab_result + " - Length: " +
                tab_result.length());
        String memo_result = memoization.memoizationSolution(testStrings[0], testStrings[1]);
        System.out.println("Memoization Solution - Longest Common Subsequence: " + memo_result + " - Length: "
                + memo_result.length());
    }

}
