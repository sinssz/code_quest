package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < M; i++) {
            int target = targets[i];
            boolean flag = false;
            int start = 0;
            int end = N - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (A[mid] > target) {
                    end = mid - 1;
                } else if (A[mid] < target) {
                    start = mid + 1;
                } else {
                    flag = true;
                    break;
                }
            }

            System.out.println(flag ? 1 : 0);
        }
    }
}
