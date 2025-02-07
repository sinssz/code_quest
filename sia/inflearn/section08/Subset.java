package inflearn.section08;

import java.util.Scanner;

/**
 * 부분 집합 구하기 (DFS)
 */
public class Subset {
	private static int[] checked;
	private static int limit;

	public Subset(int n) {
		this.checked = new int[n + 1];
		this.limit = n;
	}

	public void DFS(int n) {
		if (n > limit) {
			for (int i = 1; i < n; i++) {
				if (checked[i] > 0) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		} else {
			checked[n] = 1;
			DFS(n + 1);
			checked[n] = 0;
			DFS(n + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		Subset subset = new Subset(n);
		subset.DFS(1);
	}
}
