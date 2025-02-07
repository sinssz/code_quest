package inflearn.section10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 원더랜드(최소스패닝트리)
 */
public class Roads {

	static int[] root;
	static int answer = 0;
	static List<Road> roads;

	private static int findRoot(int v) {
		if (root[v] == v) {
			return v;
		}

		return root[v] = findRoot(root[v]);
	}

	private static boolean union(Road road) {
		int a = findRoot(road.getStart());
		int b = findRoot(road.getEnd());

		// 이미 연결 되어 있음
		if (a == b) {
			return false;
		}

		// 한쪽 방향으로 연결
		root[b] = a;
		return true;

	}

	private static void solution() {
		// 비용이 적게드는 도로부터 건설
		roads.sort(Road::compareTo);

		for (Road road : roads) {
			if (union(road)) {
				answer += road.getCost();
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int v = scanner.nextInt(); // 도시의 수
		int e = scanner.nextInt(); // 도로의 수(연결)

		// 자기 자신으로 초기화
		root = new int[v + 1];
		for (int i = 1; i < v + 1; i++) {
			root[i] = i;
		}

		roads = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			roads.add(new Road(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		}

		solution();

	}
}

class Road implements Comparable<Road> {

	private int start;
	private int end;
	private int cost;

	public Road(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Road o) {
		return this.cost - o.cost; // 오름차순
	}

	public int getStart() {
		return this.start;
	}

	public int getEnd() {
		return this.end;
	}

	public int getCost() {
		return this.cost;
	}
}
