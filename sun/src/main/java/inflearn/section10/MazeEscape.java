package inflearn.section10;

// 미로탐색
public class MazeEscape {
    static int[][] maze;
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    static boolean[][] visited;

    public static void main(String[] args) {
        maze = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };

        visited = new boolean[7][7];

        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        // 도착
        if (x == 6 && y == 6) {
            count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 7 || ny >= 7) {
                continue;
            }

            if (!visited[nx][ny] && maze[nx][ny] == 0) {
                visited[nx][ny] = true;
                dfs(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
