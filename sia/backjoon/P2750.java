package backjoon;

import java.util.Scanner;

/**
 * 2750 수 정렬하기
 */
public class P2750 {

	private static void solution(int[] numbers) {
		for (int target = numbers.length - 1; target >= 0 ; target--) {

			for (int left = 0; left < target; left++) {

				int right = left + 1;

				if (numbers[left] > numbers[right]) {
					int tmp = numbers[left];
					numbers[left] = numbers[right];
					numbers[right] = tmp;
				}
			}
		}


		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

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
