package section08;

import java.util.Scanner;

/**
 * 팩토리얼
 */
public class Factorial {
	private static int DFS(int n) {
		if (n == 1) {
			return 1;
		}

		return n * DFS(n-1);

	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println(DFS(n));
	}


}
