package section11;

import java.util.Scanner;

/**
 * 최대 부분 증가수열
 */
public class LIS {
	static int n;
	static int[] input;
	static int[] dy;

	private static int solution() {
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (input[j] < input[i]) {
					max = Math.max(max, dy[j]);
				}
			}
			dy[i] = max + 1;
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			answer = Math.max(dy[i], answer);
		}
		return answer;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		input = new int[n];
		dy = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextInt();
		}
		System.out.println(solution());

	}
}
