package section08;

import java.util.Scanner;

/**
 * 재귀 함수
 */
public class RecursiveFunction {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		DFS(n);
	}

	private static void DFS(int n) {
		if (n == 0) {
			return;
		} else {
			DFS(n - 1);
			System.out.print(n + " ");
		}
	}

}
