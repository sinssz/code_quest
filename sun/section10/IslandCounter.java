package section10;

import java.util.Scanner;

public class IslandCounter {
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // 8방향
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int n, islandCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 섬의 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    islandCount++;
                    dfs(i, j, map);
                }
            }
        }

        System.out.println(islandCount);
    }

    private static void dfs(int x, int y, int[][] map) {
        map[x][y] = 0; // 방문 처리
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                dfs(nx, ny, map);
            }
        }
    }
}
