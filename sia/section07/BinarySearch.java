package section07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이분 검색
 */
public class BinarySearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int[] numbers = new int[n];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}

		System.out.print(solution(numbers, m));
	}

	private static int solution(int[] numbers, int target) {

		Arrays.sort(numbers);

		int start = 0;
		int end = numbers.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int checkPoint = numbers[mid];

			if (checkPoint == target) {
				return mid + 1;
			}

			if (checkPoint < target)
				start = mid++;
			else {
				end = mid--;
			}
		}
		return -1;
	}
}
