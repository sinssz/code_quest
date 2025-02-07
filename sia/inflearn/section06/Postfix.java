package inflearn.section06;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();
		System.out.println(solution(input));
	}

	private static int solution(char[] input) {
		int answer = 0;
		Stack<Integer> numbers = new Stack<>();

		for (char c : input) {
			if (Character.isDigit(c)) {
				numbers.push(Character.getNumericValue(c));
				continue;
			}

			int right = numbers.pop();
			int left = numbers.pop();

			answer = operate(c, left, right);
			numbers.push(answer);
		}

		return answer;
	}

	private static int operate(char c, int left, int right) {
		if (c == '+') {
			return left + right;
		}

		if (c == '-') {
			return left - right;
		}

		if (c == '*') {
			return left * right;
		}

		return left / right;
	}
}
