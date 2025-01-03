package section09;

import java.util.Scanner;

/**
 * 동전교환
 */
public class Coin {
	static int[] coin;
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
		coin = new int[n];

		for (int i = 0; i < n; i++) {
			coin[i] = scanner.nextInt();
		}

		goal = scanner.nextInt();

		DFS(0, 0);

		System.out.println(minimumCount);
	}
}
