package inflearn.section09;

import java.util.Scanner;

/**
 * 조합수(메모이제이션)
 */
public class CombinationCalculator {

	static int[][] combinations;

	public static int DFS(int n, int r) {
		// 기존에 탐색이 진행됐는지 확인
		if (combinations[n][r] != 0) {
			return combinations[n][r];
		}

		if (r == 0 || n == r) {
			return 1;
		} else {
			return combinations[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int r = scanner.nextInt();

		combinations = new int[n + 1][r + 1];

		System.out.println(DFS(n, r));
	}

}
