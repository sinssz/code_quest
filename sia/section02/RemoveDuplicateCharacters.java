package section02;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 중복 문자 제거
 */
public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println(solution(input));
	}

	private static String solution(String input) {
		LinkedHashSet<Character> uniqueCharacters = new LinkedHashSet<>();

		for (char c : input.toCharArray()) {
			uniqueCharacters.add(c);

		}

		StringBuilder builder = new StringBuilder();
		for (char c : uniqueCharacters) {
			builder.append(c);
		}

		return builder.toString();
	}

}
