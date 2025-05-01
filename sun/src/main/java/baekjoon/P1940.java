package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] materials = new int[N];

        for (int i = 0; i < N; i++) {
            materials[i] = sc.nextInt();
        }

        Arrays.sort(materials);

        int count = 0;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = materials[left] + materials[right];

            if (sum < M) {
                left++;
            } else if (sum > M) {
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
