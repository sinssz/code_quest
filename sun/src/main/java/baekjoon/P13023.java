package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13023 {
    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!found) {
                dfs(i, 1);
            }
        }

        System.out.println(found ? 1 : 0);
    }

    private static void dfs(int node, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[node] = true;

        for (Integer i : graph.get(node)) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[node] = false;
    }
}
