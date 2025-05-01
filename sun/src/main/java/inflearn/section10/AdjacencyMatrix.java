package inflearn.section10;

import java.util.Scanner;

// 경로 탐색(인접행렬)
public class AdjacencyMatrix {
    static int N, M;
    static int answer = 0;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
        }

        visited = new boolean[N + 1];

        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int current) {
        if (current == N) {
            answer++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }
}
