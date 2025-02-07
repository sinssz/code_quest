package inflearn.section09;

import java.util.Scanner;

public class PermutationWithRepetition {
	static int n;
	static int m;
	static int[] answer;

	public static void DFS(int count) {
		if (count == m) {
			for (int index = 0; index < answer.length; index++) {
				System.out.print(answer[index] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i < n + 1; i++) {
			answer[count] = i;
			DFS(count + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		answer = new int[m];
		DFS(0);
	}
}
