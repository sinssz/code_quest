package inflearn.section09;

import java.util.Scanner;

/**
 * 섬나라 아일랜드(DFS)
 */
public class IslandDFS {
	static int n;
	static int count = 0;
	static int[] distanceX = {-1, 0, 1, 0, 1, -1, 1, -1};
	static int[] distanceY = {0, -1, 0, 1, 1, -1, -1, 1};

	public static void exploreIsland(int x, int y, int[][] graph) {
		// 탐색 완료 처리
		graph[x][y] = 0;

		// 상하좌우,대각선 탐색
		for (int i = 0; i < distanceX.length; i++) {

			int nx = x + distanceX[i];
			int ny = y + distanceY[i];

			// 탐색 범위를 벗어나면 재귀호출 X
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || graph[nx][ny] == 0) {
				continue;
			}
			// 섬 탐색
			exploreIsland(nx, ny, graph);
		}
	}

	public static void solution(int[][] graph) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1) {
					count++;
					exploreIsland(i, j, graph);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = scanner.nextInt();
			}
		}
		solution(graph);
		System.out.println(count);
	}
}
