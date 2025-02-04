package baekjoon;

import java.util.Scanner;

public class P2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int left = 1;
        int right = 1;
        int sum = 1;

        while (right <= N) {
            if (sum < N) {
                right++;
                sum += right;
            } else if (sum > N) {
                sum -= left;
                left++;
            } else { // sum == N
                count++;
                right++;
                sum += right;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
