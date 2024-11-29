package section06;

import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호
 */
public class ParenthesesValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("");
		String answer = solution(input) == true ? "YES" : "NO" ;
		System.out.println(answer);
	}

	private static boolean solution(String[] input) {
	
		Stack open = new Stack();

		for (String s : input) {
			if (s.equals("(")) {
				open.push(s);
				continue;
			}

			// 닫을 괄호가 없는 경우
			if (open.isEmpty()) {
				return false;
			}
			//정상적인 괄호
			open.pop();
		}

		// 남아있는 괄호가 있는 경우
		if (!open.isEmpty()) {
			return false;
		}

		return true;
	}
}
