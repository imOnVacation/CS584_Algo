package final_project;

public class tabulation {
    public static String tabulationSolution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String[][] dp = new String[m + 1][n + 1];

        // Initialize the dp table
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = "";

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                else
                    dp[i][j] = (dp[i - 1][j].length() > dp[i][j - 1].length()) ? dp[i - 1][j] : dp[i][j - 1];

        return dp[m][n];
    }
}