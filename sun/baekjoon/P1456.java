package baekjoon;

import java.util.Scanner;

public class P1456 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int limit = (int) Math.sqrt(B);
        int[] primes = new int[limit + 1];

        for (int i = 2; i <= limit; i++) {
            primes[i] = i;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (primes[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= limit; j += i) {
                primes[j] = 0;
            }
        }

        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (primes[i] != 0) {
                long prime = (long) i * i;

                while (prime <= B) {
                    if (prime >= A) {
                        count++;
                    }

                    if (prime > B / i) {
                        break;
                    }

                    prime *= i;
                }

            }
        }

        System.out.println(count);

    }
}
