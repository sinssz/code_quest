package inflearn.section11;

import java.util.Scanner;

/**
 * 동전교환 (냅색 알고리즘)
 */
public class Coin {
	static int n;
	static int[] coin;
	static int change;

	private static void solution(int[] dy) {
		for (int i : coin) {
			for (int j = i; j < change + 1; j++) {
				dy[j] = Math.min(dy[j], dy[j - i] + 1);
			}
		}

		System.out.println(dy[change]);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		coin = new int[n];

		for (int i = 0; i < n; i++) {
			coin[i] = scanner.nextInt();
		}

		change = scanner.nextInt();

		int[] dy = new int[change + 1];
		for (int i = 1; i < change + 1; i++) {
			dy[i] = Integer.MAX_VALUE;
		}

		solution(dy);
	}
}
