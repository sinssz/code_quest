package inflearn.section09;

// 조합의 경우수(메모이제이션)
public class Memoization {
    static int[][] memo;

    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        memo = new int[n + 1][r + 1];

        System.out.println(dfs(n, r));
    }

    private static int dfs(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        if (memo[n][r] != 0) {
            return memo[n][r];
        }

        memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);

        return memo[n][r];
    }
}
