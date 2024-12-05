package section07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 선택 정렬
 */
public class SelectionSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		int[] answer = solution(numbers);
		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	private static int[] solution(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[j];

					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
		}

		return numbers;

	}
}
