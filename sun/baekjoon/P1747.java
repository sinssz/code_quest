package baekjoon;

import java.util.Scanner;

public class P1747 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] isPrime = new boolean[1000001];

        // 1. 소수 판별 (에라토스테네스의 체)
        for (int i = 2; i <= 1000000; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 2. N 이상이면서 가장 작은 팰린드롬 소수 찾기
        int i = N;
        while (true) {
            if (isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    }
}
