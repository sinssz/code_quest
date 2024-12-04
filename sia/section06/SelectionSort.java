package section06;

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

		List<Integer> answer = solution(numbers);
		for (int i = 0 ; i < n; i++) {
			System.out.print(answer + " ");

		}
		System.out.println(solution(numbers));
	}

	private static List<Integer> solution(int[] numbers) {
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[j];

					numbers[j] = numbers[i];
					numbers[i] = temp;
				}
			}
			answer.add(numbers[i]);
		}

		return answer;

	}
}
