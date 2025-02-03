package inflearn.section11;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(countWays(n));
    }

    private static int countWays(int n) {
        if (n == 1) {
            return 1; // 계단이 1개일 때
        }
        if (n == 2) {
            return 2; // 계단이 2개일 때
        }

        int[] dp = new int[n + 1]; // DP 배열 생성
        dp[1] = 1; // 초기값
        dp[2] = 2; // 초기값

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 점화식 적용
        }

        return dp[n];
    }
}
