package inflearn.section10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 경로 탐색(인접리스트)
public class AdjacencyList {
    static int N, M;
    static int answer = 0;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
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

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
                visited[next] = false;
            }
        }
    }
}
