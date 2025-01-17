package section10;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 친구인가?
 */
public class Friends {
	static int[] checked;
	static int[][] graph;
	static LinkedList<Integer> search = new LinkedList<>();
	static int n;
	static int target;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		checked = new int[n+1];
		graph = new int[n+1][n+1];
		int m = scanner.nextInt();

		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			graph[a][b] = 1;
			graph[b][a] = 1;

		}

		search.add(scanner.nextInt());
		target = scanner.nextInt();

		System.out.println(solution() == true ? "YES" : "NO");

	}

	public static boolean solution() {

		while (!search.isEmpty()) {
			Integer poll = search.poll();

			// 선택된 친구가 아는사람 인지 확인
			if (graph[poll][target] == 1) {
				return true;
			}

			for (int i = 1; i < n + 1; i++) {
				// 탐색하지 않은 친구관계 & 선택된 친구의 친구들을 queue에 추가
				if (graph[poll][i] == 1 && checked[i] == 0) {
					checked[i] = 1;
					search.add(i);
				}

			}
		}
		return false;
	}

}
