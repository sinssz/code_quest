package inflearn.section05;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * k번째 수
 */
public class KthCombinationSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] numbers = new int[n];
		for (int input = 0; input < n; input++) {
			numbers[input] = scanner.nextInt();
		}

		System.out.println(solution(numbers, k));

	}

	private static int solution(int[] numbers, int k) {
		TreeSet<Integer> sum =  new TreeSet<>(Comparator.reverseOrder());
		for (int first = 0; first < numbers.length; first++) {
			for (int second = first + 1; second < numbers.length; second++) {
				for (int third = second + 1; third < numbers.length; third++) {
					sum.add(numbers[first] + numbers[second] + numbers[third]);
				}
			}
		}

		return sum.stream()
			.skip(k-1)
			.findFirst()
			.orElseGet(() -> -1);
	}

}
