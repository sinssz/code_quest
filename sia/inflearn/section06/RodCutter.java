package inflearn.section06;

import java.util.Scanner;
import java.util.Stack;

public class RodCutter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] rod = scanner.nextLine().toCharArray();

		System.out.println(solution(rod));
	}

	private static int solution(char[] rod) {
		int answer = 0;
		Stack rodStack = new Stack();

		for (int right = 0; right < rod.length; right++) {

			while(rod[right] == '(') {
				rodStack.push(rod[right]);
				right++;
			}

			if (islaser(rod[right -1], rod[right])) {
				rodStack.pop();
				answer += rodStack.size();
				continue;
			}

			if (rod[right] == '(') {
				rodStack.push(rod[right]);
			} else {
				rodStack.pop();
				answer += 1;
			}
		}

		return answer;
	}

	private static boolean islaser(char left, char right) {
		if (left == '(' && right == ')') {
			return true;
		}
		return false;
	}
}
