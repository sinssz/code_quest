package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}; // 상 하
    static int[] dy = {0, 0, -1, 1}; // 좌 우
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = map[currentX][currentY] + 1;
                    }
                }
            }
        }

    }
}
