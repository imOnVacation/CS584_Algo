package final_project;

public abstract class tabulationSpaceOptimization {
    // Method to find the LCS using tabulation with space optimization
    public static String tabulationSpaceOptimizationSolution(String str1, String str2) {
        // Get the lengths of input strings
        int m = str1.length();
        int n = str2.length();

        // Initializing the dp table with two rows
        String[] prevRow = new String[n + 1]; // Previous row
        String[] currRow = new String[n + 1]; // Current row

        // Initialize both rows with empty strings
        for (int i = 0; i <= n; i++) {
            prevRow[i] = "";
            currRow[i] = "";
        }

        // Fill up the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                // If the characters at current position are equal, include them in the sequence
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    currRow[j] = prevRow[j - 1] + str1.charAt(i - 1);
                // If the characters are not equal, choose the longer common subsequence
                else
                    currRow[j] = (prevRow[j].length() > currRow[j - 1].length()) ? prevRow[j] : currRow[j - 1];
            // Update the previous row to be the current row for the next iteration
            prevRow = currRow.clone();
        }

        // Return the LCS of the entire strings
        return currRow[n];
    }
}
