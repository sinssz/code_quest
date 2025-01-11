package section09;

import java.util.Arrays;

// 조합 구하기
public class CombinationCounter {
    static int N, M;
    static int[] combinations;
    static int count = 0;

    public static void main(String[] args) {
        N = 5;
        M = 3;
        combinations = new int[M];

        dfs(0, 1);
        System.out.println(count);
    }

    private static void dfs(int level, int start) {
        if (level == M) { // M개를 뽑은 경우
            System.out.println(Arrays.toString(combinations));
            count++;
            return;
        }

        // i가 뽑는 숫자
        for (int i = start; i <= N; i++) {
            combinations[level] = i;
            dfs(level + 1, i + 1);
        }
    }
}
