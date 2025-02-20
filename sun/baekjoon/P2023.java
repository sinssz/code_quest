package baekjoon;

import java.util.Scanner;

public class P2023 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        int[] firstPrimes = {2, 3, 5, 7};
        for (int firstPrime : firstPrimes) {
            dfs(1, firstPrime);
        }
    }

    private static void dfs(int index, int current) {
        if (index == N) {
            System.out.println(current);
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int next = (current * 10) + i;
            if (isPrimeNumber(next)) {
                dfs(index + 1, next);
            }
        }
    }

    private static boolean isPrimeNumber(int n) {
        if (n == 1 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
