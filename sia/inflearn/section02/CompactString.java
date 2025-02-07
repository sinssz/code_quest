package inflearn.section02;

import java.util.Scanner;

/**
 * 문자열 압축
 */
public class CompactString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();

		System.out.println(solution(input));
	}

	private static String solution(char[] input) {
		StringBuilder answer = new StringBuilder();

		int count = 1;
		char alphabet = input[0];
		for (int i = 1; i < input.length; i++) {
			if (alphabet == input[i]) {
				count++;
				continue;
			}
			compact(answer, alphabet, count);

			// 초기화
			alphabet = input[i];
			count = 1;
		}
		// 마지막 알파벳 처리
		compact(answer, alphabet, count);

		return answer.toString();

	}

	private static void compact(StringBuilder builder, char alphabet, int count) {
		builder.append(alphabet);
		if (count > 1) {
			builder.append(count);
		}
	}

}
