package section07;

import java.util.Scanner;

public class InsertionSort {
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

		for (int i = 1; i < numbers.length; i++) {
			int tmp = numbers[i];
			int j;

			// i보다 앞에 있는 숫자들 검열
			for (j = i - 1; j >= 0; j--) {
				if (numbers[j] > tmp) {
					numbers[j + 1] = numbers[j]; // 숫자를 한칸 밀기
				} else { // j보다 i가 더 큰 경우
					break;
				}
			}

			numbers[j + 1] = tmp;

		}
		return numbers;
	}
}
