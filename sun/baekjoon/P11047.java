package baekjoon;

import java.util.Scanner;

public class P11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        sc.close();

        int count = 0;

//        for (int i = N - 1; i >= 0; i--) {
//            while (true) {
//                int change = K / coins[i];
//                if (change == 0) {
//                    break;
//                }
//
//                count += change;
//                K = K % coins[i];
//            }
//        }

        // 큰 동전부터 사용하기 위해 뒤에서부터 탐색
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coins[i]) {
                count += K / coins[i]; // 해당 동전을 몇 개 사용할 수 있는지
                K %= coins[i]; // 남은 금액 갱신
            }
        }

        System.out.println(count);
    }
}
