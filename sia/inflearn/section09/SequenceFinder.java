package inflearn.section09;

import java.util.Scanner;

/**
 * 수열 추측하기
 */
public class SequenceFinder {
	static int[] combination;
	static int f;
	static int n;
	static int[] answer;
	static boolean stopSearch = false;

	public static boolean contains(int i) {
		for (int number : answer) {
			if (number == i) {
				return true;
			}
		}
		return false;
	}

	public static void combination(int n, int r) {
		int result = 1;

		for (int i = 1; i < n + 1; i++) {
			result *= i;
		}

		for (int i = 1; i < r + 1; i++) {
			result /= i;
		}

		for (int i = 1; i < n - r + 1; i++) {
			result /= i;
		}

		combination[r] = result;
	}

	public static void DFS(int count) {
		if (count == n) {
			int tmp = 0;
			for (int i = 0; i < n; i++) {
				tmp += answer[i] * combination[i];
			}
			if (tmp != f) {
				return;
			}

			for (int i = 0; i < n; i++) {
				System.out.print(answer[i] + " ");
			}
			stopSearch = true;

		} else {
			for (int i = 1; i < n + 1; i++) {
				if (stopSearch)
					break;

				if (contains(i)) {
					continue;
				}
				answer[count] = i;
				DFS(count + 1);
				answer[count] = 0;
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		f = scanner.nextInt();

		combination = new int[n];
		answer = new int[n];
		for (int i = 0; i < n; i++) {
			combination(n - 1, i);
		}

		DFS(0);
	}
}
