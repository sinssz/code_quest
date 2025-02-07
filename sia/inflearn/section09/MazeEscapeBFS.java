package inflearn.section09;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 미로의 최단거리 통로(BFS)
 */
public class MazeEscapeBFS {
	static int[][] graph;
	static int[] distanceX = {0, -1, 0, 1};
	static int[] distanceY = {-1, 0, 1, 0};
	static LinkedList<Coordinate> search = new LinkedList<>();
	static int n = 7;

	static class Coordinate {
		private int x;
		private int y;
		private int count;

		public Coordinate(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		public boolean isNotAvailable() {
			if (this.x <= 0 || x > n) {
				return true;
			}

			if (this.y <= 0 || y > n) {
				return true;
			}

			if (graph[x][y] == 1) {
				return true;
			}

			return false;
		}

		public boolean isEnd() {
			return this.x == n && this.y == n;
		}

		public int getCount() {
			return this.count;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}
	public static void visit(int x, int y) {
		graph[x][y] = 1;
	}

	public static void BFS() {
		while (!search.isEmpty()) {
			Coordinate pop = search.pop();
			// 탐색 범위를 넘어갔으면 -> continue
			if (pop.isNotAvailable()) {
				continue;
			}

			// 종료 시점에 도달 -> 출력 후 종료
			if (pop.isEnd()) {
				System.out.println(pop.getCount());
				break;
			}
			// 방문 표시 -> 재탐색을 막음
			visit(pop.getX(), pop.getY());

			// 탐색 계속하도록 큐에 추가
			for (int i = 0; i < distanceX.length; i++) {
				search.offer(new Coordinate(
						pop.getX() + distanceX[i],
						pop.getY() + distanceY[i],
						pop.getCount() + 1
					)
				);
			}
		}
		// 큐가 비어있으면 탐색 실패 (갈 수 있는 방법 없음)
		if (search.isEmpty()) {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		graph = new int[n + 1][n + 1];
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				graph[i][j] = scanner.nextInt();
			}
		}

		search.offer(new Coordinate(1, 1, 0));
		BFS();
	}

}
