package final_project;

public class memoization {
    public static String dfs(String str1, String str2, int m, int n, String[][] dp) {
        if (m == 0 || n == 0)
            return "";
        if (dp[m][n] != null)
            return dp[m][n];
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            dp[m][n] = dfs(str1, str2, m - 1, n - 1, dp) + str1.charAt(m - 1);
        else {
            String left = dfs(str1, str2, m, n - 1, dp);
            String up = dfs(str1, str2, m - 1, n, dp);
            dp[m][n] = (left.length() > up.length() ? left : up);
        }
        return dp[m][n];
    }

    // Top-down DP
    public static String memoizationSolution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String[][] dp = new String[m + 1][n + 1];
        return dfs(str1, str2, m, n, dp);
    }
}
