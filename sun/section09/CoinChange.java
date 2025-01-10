package section09;

import java.util.Scanner;

// 동전교환
public class CoinChange {
    static int N;             // 동전 종류 개수
    static int M;             // 거슬러 줄 금액
    static int[] coins;       // 동전의 단위
    static int minCount = Integer.MAX_VALUE; // 최소 동전 개수 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        M = sc.nextInt();

        dfs(0, 0); // DFS 탐색 시작
        System.out.println(minCount); // 최소 동전 개수 출력
    }

    private static void dfs(int level, int sum) {
        // 가지치기: 금액 초과 시 종료
        if (sum > M) {
            return;
        }

        // 가지치기: 현재 레벨이 이미 최소 개수를 초과하면 종료
        if (level >= minCount) {
            return;
        }

        // 금액을 정확히 만들었을 때 최소 동전 개수 갱신
        if (sum == M) {
            minCount = Math.min(minCount, level);
            return;
        }

        // 각 동전을 선택하여 DFS 탐색
        for (int i = 0; i < N; i++) {
            dfs(level + 1, sum + coins[i]);
        }
    }
}
