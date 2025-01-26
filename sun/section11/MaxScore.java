package section11;

import java.util.Arrays;

public class MaxScore {

    public static void main(String[] args) {
        int n = 5;
        int m = 20;
        int[] scores = {10, 25, 15, 6, 7};
        int[] times = {5, 12, 8, 3, 4};

        System.out.println(maxScore(n, m, scores, times));
    }

    private static int maxScore(int n, int m, int[] scores, int[] times) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= times[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - times[i]] + scores[i]);
            }
        }

        return dp[m];
    }
}
