package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1167 {
    static int V;
    static List<int[]>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());
                tree[node].add(new int[]{next, weight});
            }
        }

        // 1. BFS 실행 (임의의 노드에서 가장 먼 노드 찾기)
        int[] firstBFS = bfs(1);
        int farthestNode = firstBFS[0];

        // 2. 찾은 노드에서 다시 BFS 실행 → 트리의 지름 구하기
        int[] secondBFS = bfs(farthestNode);

        System.out.println(secondBFS[1]); // 트리의 지름 출력
    }

    static int[] bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            System.out.println(Arrays.toString(current));
            int node = current[0];
            int dist = current[1];

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = node;
            }

            for (int[] adj : tree[node]) {
                int nextNode = adj[0];
                int weight = adj[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new int[]{nextNode, dist + weight});
                }
            }
        }

        return new int[]{farthestNode, maxDist}; // 가장 먼 노드와 거리 반환
    }
}
