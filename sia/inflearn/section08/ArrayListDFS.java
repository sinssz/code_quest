package inflearn.section08;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 경로 탐색 (인접리스트, ArrayList)
 */
public class ArrayListDFS {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;
	static int answer = 0;
	static int n, m;

	public static void DFS(int v) {
		if (v == n) {
			answer++;
		} else {
			for (int next : graph.get(v)) {
				if (ch[next] == 0) {
					ch[next] = 1;
					DFS(next);
					ch[next] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		ch = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			graph.get(a).add(b);
		}

		ch[1] = 1;
		DFS(1);

		System.out.print(answer);

	}
}
