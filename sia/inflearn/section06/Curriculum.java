package inflearn.section06;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 교육과정 설계
 */
public class Curriculum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char[] required = scanner.nextLine().toCharArray();
		char[] plan = scanner.nextLine().toCharArray();

		String answer = solution(required, plan) ? "YES" : "NO";
		System.out.println(answer);

	}

	private static boolean solution(char[] required, char[] plan) {
		LinkedList<Character> curriculum = new LinkedList<>();

		for (char c : required) {
			curriculum.offer(c);
		}

		for (char c : plan) {
			// 고려대상이 아님
			if (!curriculum.contains(c)) {
				continue;
			}

			// 수업설계가 잘못됨
			if (curriculum.peek() != c) {
				return false;
			}

			// 아직 문제 없음
			curriculum.pop();
		}

		return curriculum.isEmpty();
	}
}
