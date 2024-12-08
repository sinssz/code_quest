package section07;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 장난꾸러기
 */
public class PositionSwitcher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] students = new int[n];

		for (int i = 0; i < n; i++) {
			students[i] = scanner.nextInt();
		}

		for (int index : solution(students)) {
			System.out.print(index + " ");
		}

	}

	public static List<Integer> solution(int[] students) {
		List<Integer> answer = new ArrayList<>();

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < students.length; i++) {
			priorityQueue.add(students[i]);
		}

		for (int i = 0; i < students.length; i++) {
			if (priorityQueue.poll() != students[i]) {
				answer.add(i + 1);
			}
		}

		return answer;
	}

}
