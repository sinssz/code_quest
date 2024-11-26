package section03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 뒤집은 소수
 */
public class ReversiblePrime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] numbers = scanner.nextLine().split(" ");

		for(int prime : solution(numbers, n)) {
			System.out.print(prime +" ");
		}
	}

	private static List<Integer> solution(String[] numbers, int n) {
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int reverseInteger = reverseInteger(numbers[i]);
			if (isPrime(reverseInteger)) {
				answer.add(reverseInteger);
			}
		}
		return answer;
	}

	private static int reverseInteger(String number) {
		StringBuilder builder = new StringBuilder(number);
		builder.reverse();

		return Integer.valueOf(builder.toString());
	}

	private static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
