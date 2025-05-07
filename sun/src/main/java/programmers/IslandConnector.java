package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class IslandConnector {

    public int solution(int n, int[][] costs) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getCost));
        pq.offer(new Edge(0, 0));

        int total = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.getTo();
            int cost = edge.getCost();

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            total += cost;

            for (Edge next : graph.get(node)) {
                if (!visited[next.getTo()]) {
                    pq.offer(next);
                }
            }
        }

        return total;
    }

    static class Edge {
        private final int to;
        private final int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int getTo() {
            return to;
        }

        public int getCost() {
            return cost;
        }
    }
}
