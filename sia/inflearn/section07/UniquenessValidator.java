package inflearn.section07;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 중복확인
 */
public class UniquenessValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		System.out.print(solution(numbers));

	}

	private static String solution(int[] numbers) {
		Set<Integer> numberSet = new HashSet<>();

		for (int n : numbers) {
			numberSet.add(n);
		}

		return numberSet.size() != numbers.length ? "D" : "U";

	}
}
