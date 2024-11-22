package section04;

import java.util.Scanner;

/**
 * 연속 부분수열
 */
public class Subarray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		System.out.print(solution(n, m, numbers));

	}

	public static int solution(int n, int m, int[] numbers) {

		int answer = 0;
		int sum = 0;
		int start = 0;

		for (int end = 0; end < n; end++) {
			sum += numbers[end];

			while (sum > m) {
				sum -= numbers[start++];
			}

			if (sum == m) {
				answer += 1;
			}
		}

		return answer;
	}
}
