package final_project;

public class tabulation {
    // Find the longest common subsequence between two strings using tabulation
    public static String tabulationSolution(String str1, String str2) {
        // Get the lengths of the input strings
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the dynamic programming value
        // dp[i][j] represents the longest common subsequence of substrings
        String[][] dp = new String[m + 1][n + 1];

        // Initialize the dp table
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = "";

        // Fill up the dp table using bottom-up approach
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                // If the characters at current positions are equal, include them in the
                // subsequence
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                // If the characters are not equal, choose the longer common subsequence
                else
                    dp[i][j] = (dp[i - 1][j].length() > dp[i][j - 1].length()) ? dp[i - 1][j] : dp[i][j - 1];

        // Return the LCS of the entire strings
        return dp[m][n];
    }
}