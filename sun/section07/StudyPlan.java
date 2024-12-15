package section07;

import java.util.LinkedList;
import java.util.Queue;

// 교육과정 설계
public class StudyPlan {

	public static void main(String[] args) {
		String required = "CBA";
		// String plan = "CBDAGE";
		// String plan = "GEDCBA";
		String plan = "CBDGE";

		System.out.println(solution(required, plan));
	}

	private static String solution(String required, String plan) {
		Queue<Character> queue = new LinkedList<>();

		for (char c : required.toCharArray()) {
			queue.add(c);
		}

		for (char c : plan.toCharArray()) {
			if (queue.contains(c)) {
				if (queue.peek() == c) {
					queue.poll();
				} else {
					return "NO";
				}
			}
		}

		return queue.isEmpty() ? "YES" : "NO";
	}
}
