package inflearn.section09;

import java.util.Scanner;

/**
 * 순열 구하기
 */
public class Permutation {
	static int n;
	static int m;
	static int[] answer;
	static int[] numbers;

	public static boolean contains(int i) {
		for (int number : answer) {
			if (number == i) {
				return true;
			}
		}
		return false;

	}

	public static void DFS(int count) {
		if (count == m) {
			for (int number : answer) {
				System.out.print(number + " ");
			}
			System.out.println();
			return;
		}

		for (int i : numbers) {
			if (contains(i)) {
				continue;
			}

			answer[count] = i;
			DFS(count + 1);
			answer[count] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		answer = new int[m];

		DFS(0);

	}
}
