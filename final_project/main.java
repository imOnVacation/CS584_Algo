package final_project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Initialize StringBuilder to store CSV data
        StringBuilder csvData = new StringBuilder();
        // Append CSV header
        csvData.append("Test Name,Algorithm,Time (nanoseconds),Memory Used (bytes)\n");

        runTest("Test 1 - Two Strings of equal length", generateSequences.generateEqualLengthStrings(), csvData);
        runTest("Test 2 - two strings with no common characters",
                generateSequences.generateCompletelyDifferentStrings(), csvData);
        runTest("Test 3 - one string that contains the other", generateSequences.generateOneStringContainsOther(),
                csvData);
        runTest("Test 4 - one empty string", generateSequences.generateOneEmptyString(), csvData);
        runTest("Test 5 - strings with repeated characters", generateSequences.generateRepeatedCharacters(), csvData);
        runTest("Test 6 - long strings", generateSequences.generateLongStrings(), csvData);
        runTest("Test 7 - strings containing special characters", generateSequences.generateSpecialCharacters(),
                csvData);
        runTest("Test 8 - edge case: two strings are the same", generateSequences.generateEdgeCases(), csvData);

        // Write CSV data to a file
        try {
            FileWriter csvWriter = new FileWriter("runtime_memory_data.csv");
            csvWriter.write(csvData.toString());
            csvWriter.close();
            System.out.println("CSV file has been created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }

    }

    public static void runTest(String testName, String[] testStrings, StringBuilder csvData) {
        System.out.println("\n ***** " + testName + " *****");
        System.out.println("String 1: " + testStrings[0]);
        System.out.println("String 2: " + testStrings[1]);

        String testNumber = testName.split("-")[0].trim(); // Extracting the test number

        measureAlgorithm("Tabulation", () -> tabulation.tabulationSolution(testStrings[0], testStrings[1]),
                testNumber, csvData);
        measureAlgorithm("Memoization", () -> memoization.memoizationSolution(testStrings[0], testStrings[1]),
                testNumber, csvData);
        measureAlgorithm("Tabulation Space Optimization",
                () -> memoization.memoizationSolution(testStrings[0], testStrings[1]),
                testNumber, csvData);
    }

    public static void measureAlgorithm(String algorithmName, Supplier<String> algorithmSupplier, String testName,
            StringBuilder csvData) {
        Runtime runtime = Runtime.getRuntime();
        System.gc(); // Run garbage collector to clean up memory
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();
        String result = algorithmSupplier.get();
        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(
                algorithmName + " Solution - Longest Common Subsequence: " + result + " - Length: " + result.length());
        System.out.println(algorithmName + " Solution - Time taken: " + ((double) (endTime - startTime)) / 1_000_000_000
                + " seconds");
        System.out.println(algorithmName + " Solution - Memory used: " + (endMemory - startMemory) + " bytes");
        // Append data to CSV StringBuilder
        csvData.append(testName).append(",").append(algorithmName).append(",")
                .append(((double) (endTime - startTime)) / 1_000_000_000).append(",")
                .append(endMemory - startMemory).append("\n");
    }
}