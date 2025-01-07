package section09;

import java.util.Scanner;

/**
 * 합이 같은 부분집합(DFS : 아마존 인터뷰)
 */
public class EqualSubsetSum {

	static int[] numbers;
	static int n;
	static int total = 0;

	public boolean DFS(int index, int sum) {

		if (index == n) {
			return sum == total - sum;
		}
		// else
		return DFS(index + 1, sum + numbers[index]) || DFS(index + 1, sum);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
			total += numbers[i];
		}

		EqualSubsetSum equalSubsetSum = new EqualSubsetSum();
		boolean answer = equalSubsetSum.DFS(0, 0);

		if (answer)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
