package final_project;

public class memoization {
    // Method to perform depth-first search with memoization for finding the LCS
    public static String dfs(String str1, String str2, int m, int n, String[][] dp) {
        // If either string becomes empty, return an empty string
        if (m == 0 || n == 0)
            return "";

        // If the value is already computed, return it from the dp table
        if (dp[m][n] != null)
            return dp[m][n];

        // If the characters at the current positions are equal,
        // include them in the subsequence
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            dp[m][n] = dfs(str1, str2, m - 1, n - 1, dp) + str1.charAt(m - 1);
        // Otherwise, explore both options of skipping a character from either string
        else {
            String up = dfs(str1, str2, m, n - 1, dp);
            String left = dfs(str1, str2, m - 1, n, dp);
            // Choose the longer common subsequence among the two
            dp[m][n] = (left.length() > up.length() ? left : up);
        }

        // Return the computed value
        return dp[m][n];
    }

    // Method to initialize and call the DFS with memoization
    public static String memoizationSolution(String str1, String str2) {
        // Get the lengths of the input strings
        int m = str1.length();
        int n = str2.length();
        // Create a 2D array to store the computed valeus
        String[][] dp = new String[m + 1][n + 1];
        // Call recursive function with memoization
        return dfs(str1, str2, m, n, dp);
    }
}
