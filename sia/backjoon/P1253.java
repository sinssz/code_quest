package backjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1253 좋다
 */
public class P1253 {

	private static void solution(int[] numbers) {
		Arrays.sort(numbers); // 투포인트는 알고리즘은 정렬이 필요
		int answer = 0;

		for (int i = 0; i < numbers.length; i++) {

			int start = 0;
			int end = numbers.length - 1;

			while (start < end) {
				int sum = numbers[start] + numbers[end];
				int goal = numbers[i];
				if (sum < goal) {
					start++;
					continue;
				}
				if (sum > goal) {
					end--;
					continue;
				}

				// 자기자신을 포함하여 좋은수를 만들 수는 없음
				if (start == i) {
					start++;
					continue;
				}
				if (end == i) {
					end--;
					continue;
				}

				// 좋은 수 발견
				answer++;
				break; // 해당 숫자는 더이상 탐색할 필요없음
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		solution(numbers);

	}
}
