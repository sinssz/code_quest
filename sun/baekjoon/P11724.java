package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724 {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[N + 1];
        int components = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                components++;
            }
        }

        System.out.println(components);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (Integer i : graph.get(node)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
