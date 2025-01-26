package section11;

import java.util.Arrays;

public class CoinExchange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int m = 15;

        System.out.println(minCoins(coins, m));
    }

    private static int minCoins(int[] coins, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[m];
    }
}
