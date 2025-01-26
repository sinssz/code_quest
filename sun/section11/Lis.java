package section11;

import java.util.Arrays;

public class Lis {

    public static void main(String[] args) {
        int[] a = {2, 7, 5, 8, 6, 4, 7, 12, 3};
        System.out.println(lis(a));

        int[] b = {5, 3, 7, 8, 6, 2, 9, 4};
        System.out.println(lis(b));
    }

    private static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
