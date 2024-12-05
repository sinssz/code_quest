package section07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		for (int number : solution(numbers)) {
			System.out.print(number + " ");
		}
	}

	private static int[] solution(int[] numbers) {
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
		}
		return numbers;
	}
}
