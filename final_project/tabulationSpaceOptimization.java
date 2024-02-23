package final_project;

import java.util.Arrays;

public abstract class tabulationSpaceOptimization {
    public static String tabulationSpaceOptimizationSolution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String lcs = "";

        // Initializing 2 arrays of size m
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // If matching
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    lcs += str1.charAt(i - 1);
                }
                // Not matching
                else
                    curr[j] = Math.max(curr[j - 1], prev[j]);
            }
            prev = Arrays.copyOf(curr, m + 1);
        }

        return lcs;
    }
}
