package inflearn.section04;

import java.util.Scanner;

/**
 * 최대 매출
 */
public class MaxRevenueFinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] revenue = new int[n];

		for (int i = 0; i < n; i++) {
			revenue[i] = scanner.nextInt();
		}

		System.out.print(solution(n, k, revenue));
	}

	private static int solution(int n, int k, int[] revenue) {
		int answer = 0;

		for (int i = 0; i < k; i++) {
			answer += revenue[i];
		}

		int sum = answer;
		for (int i = k; i < n; i++) {
			sum = sum + revenue[i] - revenue[i - k];
			if (sum > answer) {
				answer = sum;
			}
		}
		return answer;
	}
}
