package baekjoon;

import java.util.Scanner;

public class P1747 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = N;
        while (true) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    }
}
