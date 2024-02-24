package final_project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Supplier;

public class Main {
        public static void main(String[] args) {
                // Initialize StringBuilder to store CSV data
                StringBuilder csvData = new StringBuilder();
                csvData.append("Test Name,Algorithm,Time (nanoseconds),Memory Used (bytes)\n");

                // Run tests and populate csvData StringBuilder
                runTest("Test 1 - Two Strings of equal length", generateSequences.generateEqualLengthStrings(),
                                csvData);
                runTest("Test 2 - Two strings with no common characters",
                                generateSequences.generateCompletelyDifferentStrings(), csvData);
                runTest("Test 3 - One string that contains the other",
                                generateSequences.generateOneStringContainsOther(),
                                csvData);
                runTest("Test 4 - One empty string", generateSequences.generateOneEmptyString(), csvData);
                runTest("Test 5 - Strings with repeated characters", generateSequences.generateRepeatedCharacters(),
                                csvData);
                runTest("Test 6 - Long strings", generateSequences.generateLongStrings(),
                                csvData);
                runTest("Test 7 - Strings containing special characters", generateSequences.generateSpecialCharacters(),
                                csvData);
                runTest("Test 8 - Two strings are the same", generateSequences.generateEdgeCases(), csvData);

                // Write CSV data to a file
                writeCSVFile(csvData);
        }

        // Method to run a test case
        public static void runTest(String testName, String[] testStrings, StringBuilder csvData) {
                System.out.println("\n ***** " + testName + " *****");
                System.out.println("String 1: " + testStrings[0]);
                System.out.println("String 2: " + testStrings[1]);

                // Extract the test number from the test name
                String testNumber = testName.split("-")[0].trim();

                // Measure performance of different algorithms for the current test case
                measureAlgorithm("Tabulation", () -> tabulation.tabulationSolution(testStrings[0], testStrings[1]),
                                testNumber, csvData);
                measureAlgorithm("Memoization", () -> memoization.memoizationSolution(testStrings[0], testStrings[1]),
                                testNumber, csvData);
                measureAlgorithm("Tabulation Space Optimization",
                                () -> tabulationSpaceOptimization.tabulationSpaceOptimizationSolution(testStrings[0],
                                                testStrings[1]),
                                testNumber, csvData);
        }

        // Method to measure the performance of an algorithm
        public static void measureAlgorithm(String algorithmName, Supplier<String> algorithmSupplier, String testName,
                        StringBuilder csvData) {
                Runtime runtime = Runtime.getRuntime();
                // Run garbage collector to clean up memory
                System.gc();
                long startMemory = runtime.totalMemory() - runtime.freeMemory();
                long startTime = System.nanoTime();
                String result = algorithmSupplier.get();
                long endTime = System.nanoTime();
                long endMemory = runtime.totalMemory() - runtime.freeMemory();

                // Print algorithm performance details to console
                System.out.println(
                                algorithmName + " Solution - Longest Common Subsequence: " + result + " - Length: "
                                                + result.length());
                System.out.println(algorithmName + " Solution - Time taken: "
                                + ((endTime - startTime)) + " nanoseconds");
                System.out.println(algorithmName + " Solution - Memory used: " + (endMemory - startMemory) + " bytes");

                // Append algorithm performance details to csvData StringBuilder
                csvData.append(testName).append(",").append(algorithmName).append(",")
                                .append(((endTime - startTime))).append(",")
                                .append(endMemory - startMemory).append("\n");
        }

        // Method to write CSV data to a file
        public static void writeCSVFile(StringBuilder csvData) {
                try {
                        FileWriter csvWriter = new FileWriter("runtime_memory_data.csv");
                        csvWriter.write(csvData.toString());
                        csvWriter.close();
                        System.out.println("CSV file has been created successfully!");
                } catch (IOException e) {
                        System.err.println("Error writing CSV file: " + e.getMessage());
                }
        }
}