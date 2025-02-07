package inflearn.section08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 그래프 최단거리(BFS)
 */
public class ArrayListBFS {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int n, m;
	static int[] ch;
	static LinkedList<Integer> queue = new LinkedList<>();

	static int[] answer;

	public static void BFS() {
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			int move = answer[poll];
			for (int next : graph.get(poll)) {
				if (ch[next] == 0) {
					answer[next] = move + 1;
					ch[next] = 1;
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			graph.get(a).add(b);
		}

		ch = new int[n + 1];
		answer = new int[n + 1];

		ch[1] = 1;
		queue.offer(1);
		BFS();

		for (int i = 2; i < n + 1; i++) {
			System.out.println(i + " : " + answer[i]);
		}
	}
}
