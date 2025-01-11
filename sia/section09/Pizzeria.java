package section09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 파자 배달 거리
 */
public class Pizzeria {
	static int n;
	static int m;
	static int[] selected;
	static List<Point> houses = new ArrayList<>();
	static List<Point> pizzerias = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static int[][] memory;

	static class Point {
		private int x;
		private int y;

		public Point(int i, int j) {
			this.x = i;
			this.y = j;
		}

		public int distance(Point point) {
			return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
		}

	}

	public static void DFS(int level, int next) {
		if (level == m) {
			answer = Math.min(answer, calculator());
			return;
		}
		for (int i = next; i < pizzerias.size(); i++) {
			selected[level] = i;
			// 중복 선택 X , 새로운 피자집 만 선택 가능
			DFS(level + 1, i + 1);
		}
	}

	// 피자집과 집들의 거리 계산
	public static void initializeDistance() {
		memory = new int[houses.size()][pizzerias.size()];
		for (int i = 0; i < houses.size(); i++) {
			for (int j = 0; j < pizzerias.size(); j++) {
				memory[i][j] = houses.get(i).distance(pizzerias.get(j));
			}
		}
	}

	public static int calculator() {
		int sum = 0;
		for (int i = 0; i < houses.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j : selected) {
				min = Math.min(min, memory[i][j]);
			}
			sum += min;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		selected = new int[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int value = scanner.nextInt();
				if (value == 1) {
					houses.add(new Point(i , j));
				} else if (value == 2) {
					pizzerias.add(new Point(i, j));
				}
			}
		}

		initializeDistance();
		DFS(0, 0);
		System.out.println(answer);
	}

}
