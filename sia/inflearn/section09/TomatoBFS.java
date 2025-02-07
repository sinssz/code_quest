package inflearn.section09;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 토마토 (BFS 활용)
 */
public class TomatoBFS {
	static int[][] tomatoes, answer;
	static LinkedList<Pointer> queue = new LinkedList<>();
	static int n, m;
	static int[] distanceX = {0, -1, 0, 1};
	static int[] distanceY = {-1, 0, 1, 0};

	static class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void BFS() {
		while (!queue.isEmpty()) {
			Pointer tomato = queue.poll();

			// 상, 하, 좌, 우 탐색
			for (int i = 0; i < distanceX.length; i++) {
				int nx = tomato.x + distanceX[i];
				int ny = tomato.y + distanceY[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || tomatoes[nx][ny] != 0) {
					continue;
				}
				// 범위 내에 있고, 익지 않은 토마토일 경우
				tomatoes[nx][ny] = 1; // 익히기
				answer[nx][ny] = answer[tomato.x][tomato.y] + 1; // 날짜 정보 기록
				queue.offer(new Pointer(nx, ny)); // 큐에 추가
			}

		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		n = scanner.nextInt();

		tomatoes = new int[n][m];
		answer = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tomatoes[i][j] = scanner.nextInt();

				if (tomatoes[i][j] == 1) {
					queue.offer(new Pointer(i, j));
				}
			}
		}

		BFS();

		boolean flag = true;
		int result = Integer.MIN_VALUE;

		// 익지 못한 토마토가 있는지 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomatoes[i][j] == 0) {
					flag = false;
				}
			}
		}

		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					result = Math.max(result, answer[i][j]);
				}
			}
			System.out.println(result);
		} else
			System.out.println(-1);
	}
}
