package final_project;

public abstract class tabulationSpaceOptimization {
    public static String tabulationSpaceOptimizationSolution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Initializing the dp table
        String[] prevRow = new String[n + 1];
        String[] currRow = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            prevRow[i] = "";
            currRow[i] = "";
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                // If matching
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    currRow[j] = prevRow[j - 1] + str1.charAt(i - 1);
                // Not matching
                else
                    currRow[j] = (prevRow[j].length() > currRow[j - 1].length()) ? prevRow[j] : currRow[j - 1];
            prevRow = currRow.clone();
        }

        return currRow[n];
    }
}
