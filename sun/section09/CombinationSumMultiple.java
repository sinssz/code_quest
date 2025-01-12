package section09;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationSumMultiple {
    static int N, M, K;
    static int[] numbers;
    static int[] combinations;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt(); // K개 뽑기

        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        M = sc.nextInt(); // 배수

        combinations = new int[K];

        dfs(0, 0, 0);
        System.out.println(count);
    }

    private static void dfs(int level, int start, int sum) {
        if (level == K) {
            System.out.println(sum + "," + Arrays.toString(combinations));
            if (sum % M == 0) {
                count++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            combinations[level] = numbers[i];
            dfs(level + 1, i + 1, sum + numbers[i]);
        }
    }
}
