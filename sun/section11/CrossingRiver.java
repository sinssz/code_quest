package section11;

public class CrossingRiver {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(countWays(n));
    }

    private static int countWays(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n + 1];
    }
}
