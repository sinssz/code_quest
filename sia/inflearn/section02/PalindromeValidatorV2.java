package inflearn.section02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 유효한 팰린드롬
 */
public class PalindromeValidatorV2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toLowerCase().toCharArray();

		Map<Boolean, String> answerMap = new HashMap<>();
		answerMap.put(true, "YES");
		answerMap.put(false, "NO");
		String answer = answerMap.get(solution(input));
		System.out.println(answer);
		
	}

	private static boolean solution(char[] input) {

		int left = 0;
		int right = input.length - 1;

		while (left < right) {
			if (!Character.isAlphabetic(input[left])) {
				left++;
				continue;
			}
			if (!Character.isAlphabetic(input[right])) {
				right--;
				continue;
			}
			if (input[left] != input[right]) {
				return false;
			}

			left++;
			right--;
		}
		return true;

	}
}
