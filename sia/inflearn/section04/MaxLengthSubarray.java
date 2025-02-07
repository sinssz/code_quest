package inflearn.section04;

import java.util.Scanner;

/**
 * 최대 길이 연속 부분수열
 */
public class MaxLengthSubarray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextInt();
		}

		System.out.println(solution(input, k));
	}

	private static int solution(int[] input, int k) {
		int answer = 0;

		int change = 0;
		int start = 0;
		for (int end = 0; end < input.length; end++) {
			// 0을 만나면 1로 변경
			if (input[end] == 0) {
				change++;
			}

			// 변경 가능 횟수 초과 시, 윈도우의 시작점을 이동
			while (change > k) {
				if (input[start] == 0) {
					change--;
				}
				start++;
			}

			answer = Math.max(answer, end - start + 1);
		}
		return answer;
	}
}
