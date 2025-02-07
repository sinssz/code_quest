package inflearn.section02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 회문 문자열
 */
public class PalindromeValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toLowerCase().toCharArray();

		Map<Boolean, String> answerMap = new HashMap<>();
		answerMap.put(true, "YES");
		answerMap.put(false, "NO");

		boolean answer = solution(input);
		System.out.println(answerMap.get(answer));
	}

	private static boolean solution(char[] input) {

		int end = input.length - 1;
		for (int index = 0; index < input.length; index++) {
			if (input[index] != input[end--]) {
				return false;
			}
		}
		return true;

	}
}
