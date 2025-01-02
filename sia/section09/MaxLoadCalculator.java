package section09;

import java.util.Scanner;

/**
 * 바둑이 승차(DFS)
 */
public class MaxLoadCalculator {
	static int answer = 0;
	static int limit;
	static int n;
	static int[] weights;

	public static void DFS(int i, int sum) {
		if (i == n + 1) {
			if (sum < limit && sum > answer) {
				answer = sum;
			}
			return;
		}

		DFS(i + 1, sum + weights[i]);
		DFS(i + 1, sum);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		limit = scanner.nextInt();
		n = scanner.nextInt();

		weights = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			weights[i] = scanner.nextInt();
		}

		DFS(1, 0);

		System.out.println(answer);
	}
}
