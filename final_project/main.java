package final_project;

import java.util.function.Supplier;

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
        System.out.println("String 2: " + testStrings[1]);

        measureAlgorithm("Tabulation", () -> tabulation.tabulationSolution(testStrings[0], testStrings[1]));
        measureAlgorithm("Memoization", () -> memoization.memoizationSolution(testStrings[0], testStrings[1]));
    }

    public static void measureAlgorithm(String algorithmName, Supplier<String> algorithmSupplier) {
        Runtime runtime = Runtime.getRuntime();
        System.gc(); // Run garbage collector to clean up memory
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();
        String result = algorithmSupplier.get();
        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(
                algorithmName + " Solution - Longest Common Subsequence: " + result + " - Length: " + result.length());
        System.out.println(algorithmName + " Solution - Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println(algorithmName + " Solution - Memory used: " + (endMemory - startMemory) + " bytes");
    }
}