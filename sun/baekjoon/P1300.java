package baekjoon;

import java.util.Scanner;

public class P1300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int left = 1;
        int right = K;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count >= K) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

}
