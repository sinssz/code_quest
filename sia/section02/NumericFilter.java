package section02;

import java.util.Scanner;

/**
 * 숫자만 추출
 */
public class NumericFilter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();
		System.out.println(solution(input));
	}

	private static int solution(char[] input) {
		StringBuilder builder = new StringBuilder();

		for(char c: input) {
			if(Character.isDigit(c)) {
				builder.append(c);
			}
		}

		return Integer.valueOf(builder.toString());
	}
}
