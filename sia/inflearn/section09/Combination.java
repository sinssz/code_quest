package inflearn.section09;

import java.util.Scanner;

/**
 * 조합 구하기
 */
public class Combination {
	static int n;
	static int m;
	static int[] answer;

	public static boolean contains(int i) {
		for (int number : answer) {
			if (number == i) {
				return true;
			}
		}

		return false;
	}

	public static void DFS(int count, int start) {
		if (count == m) {
			for (int member : answer) {
				System.out.print(member + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n + 1; i++) {
			if (contains(i)) {
				continue;
			}
			answer[count] = i;
			DFS(count + 1, start + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		answer = new int[m];

		DFS(0, 1);
	}
}
