package inflearn.section09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 동전교환
 */
public class Coin {
	static Integer[] coin;
	static int n;
	static int minimumCount = Integer.MAX_VALUE;
	static int goal;

	public static void DFS(int count, int sum) {
		//종료
		if (sum > goal || count > minimumCount) {
			return;
		}

		if (sum == goal) {
			minimumCount = count;
			return;
		}
		for (int i = 0; i < n; i++) {
			DFS(count + 1, sum + coin[i]);
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		coin = new Integer[n];

		for (int i = 0; i < n; i++) {
			coin[i] = scanner.nextInt();
		}

		// 큰 동전부터 탐색할 수 있도록 내림차순 정렬
		Arrays.sort(coin, Comparator.reverseOrder());

		goal = scanner.nextInt();

		DFS(0, 0);

		System.out.println(minimumCount);
	}
}
