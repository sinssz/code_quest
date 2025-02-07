package inflearn.section09;

import java.util.LinkedList;
import java.util.Scanner;

public class IslandBFS {
	static int n;
	static int count = 0;
	static int[] distanceX = {-1, 0, 1, 0, 1, -1, 1, -1};
	static int[] distanceY = {0, -1, 0, 1, 1, -1, -1, 1};

	static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void exploreIsland(int[][] graph, LinkedList<Point> queue) {
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			graph[point.x][point.y] = 0;

			for (int i = 0; i < distanceX.length; i++) {
				int nx = point.x + distanceX[i];
				int ny = point.y + distanceY[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n || graph[nx][ny] == 0) {
					continue;
				}
				queue.offer(new Point(nx, ny));
			}

		}
	}

	public static void solution(int[][] graph) {
		LinkedList<Point> queue = new LinkedList<>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				// 섬을 발견한다.
				if (graph[i][j] == 1) {
					count++;
					queue.offer(new Point(i, j));
					exploreIsland(graph, queue);
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
