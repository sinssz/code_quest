package section10;

import java.util.LinkedList;
import java.util.Queue;

// 송아지 찾기
public class FindCalf {

    public static void main(String[] args) {
        int result = bfs(5, 14);
        System.out.println(result);

        result = bfs(8, 3);
        System.out.println(result);
    }

    public static int bfs(int start, int target) {
        int[] move = {-1, 1, 5};
        boolean[] visited = new boolean[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == target) {
                    return level;
                }

                for (int j = 0; j < 3; j++) {
                    int next = current + move[j];

                    if (next >= 0 && next <= 10000 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
