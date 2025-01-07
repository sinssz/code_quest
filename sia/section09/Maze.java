package section09;

import java.util.Scanner;

/**
 * 미로 탐색(DFS)
 */
public class Maze {

	static int n = 7;
	static int[][] graph = new int[n + 1][n + 1];
	static int[] distanceX = {0, -1, 0, 1};
	static int[] distanceY = {-1, 0, 1, 0};
	static int count = 0;

	public static void DFS(int x, int y) {
		if (x < 1 || x > n) {
			return;
		}

		if (y < 1 || y > n) {
			return;
		}

		if (x == n && y == n) {
			count++;
			return;
		}

		if (graph[x][y] == 1) {
			return;
		}

		// 현재 위치를 재탐색 하지 못하도록 1로 변경
		graph[x][y] = 1;

		// 탐색
		for (int i = 0; i < distanceX.length; i++) {
			DFS(x + distanceX[i], y + distanceY[i]);
		}

		// 원래 값으로 복구 -> 1인 경우는 없음. 해당 로직 실행 전에 종료
		graph[x][y] = 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				graph[i][j] = scanner.nextInt();
			}
		}

		DFS(1, 1);
		System.out.println(count);
	}

}
