package inflearn.section06;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 응급실
 */
public class EmergencyRoom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int[] queue = new int[n];
		for (int i = 0; i < n; i++) {
			queue[i] = scanner.nextInt();
		}

		System.out.println(solution(queue, m));

	}

	public static int solution(int[] queue, int m) {
		int count = 0;

		PriorityQueue<Integer> emergency = new PriorityQueue<>(Comparator.reverseOrder());
		LinkedList<Integer> waiting = new LinkedList<>();

		for (int i =0; i < queue.length; i++) {
			emergency.offer(queue[i]);
			waiting.offer(i);
		}

		while(!emergency.isEmpty()) {

			// 환자를 뽑는다
			Integer p = waiting.getFirst();

			// 더 높은 위험도를 가진 환자가 있는 경우 -> 대기열 뒤로 이동
			if (emergency.peek() > queue[p]) {
				waiting.offer(waiting.pop());
				continue;
			}

			// 환자 치료를 하는 경우
			waiting.pop();
			emergency.poll();
			count++;

			// 치료한 환자가 m 번째 환자인 경우 중단
			if (p == m) {
				break;
			}
		}

		return count;
	}

}
