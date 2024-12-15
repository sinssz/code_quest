package section07;

import java.util.Stack;

// 올바른 괄호
public class CorrectParentheses {

	public static void main(String[] args) {
		String a = "(())()";
		System.out.println(solution(a));

		String b = "(()()))";
		System.out.println(solution(b));

		String c = "(()(()))(()";
		System.out.println(solution(c));
	}

	private static String solution(String string) {
		Stack<Character> stack = new Stack<>();

		for (char c : string.toCharArray()) {
			if (c == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty()) {
					return "NO";
				}
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return "YES";
		}

		return "NO";
	}

}
