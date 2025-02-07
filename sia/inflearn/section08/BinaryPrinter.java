package inflearn.section08;

import java.util.Scanner;

/**
 * 이진수 출력
 */
public class BinaryPrinter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		DFS(n);
	}

	private static void DFS(int n) {
		if (n == 0) {
			return;
		}

		DFS(n / 2);
		System.out.print(n % 2);

	}
}
