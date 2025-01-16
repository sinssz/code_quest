package section10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최대 수입 스케줄(PriorityQueue)
 */
public class MaxRevenue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		List<Lecture> lectures = new ArrayList<>();
		int available = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int price = scanner.nextInt();
			int days = scanner.nextInt();
			lectures.add(new Lecture(price, days));
			available = Math.max(days, available);
		}

		MaxRevenue maxRevenue = new MaxRevenue();
		System.out.println(maxRevenue.solution(lectures, available));
	}

	private int solution(List<Lecture> lectures, int days) {
		//정답
		int answer = 0;
		// 우선 순위 큐 (내림차순)
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

		// 날짜 내림차순 정렬
		lectures.sort(Lecture::compareTo);

		int index = 0;
		for (int i = days; i > 0; i--) {
			while (index < lectures.size()) {
				Lecture current = lectures.get(index);
				// 해당 날짜에 강연을 할 수 있는지 확인
				if (current.getDays() < i) {
					break;
				}

				// 해당 날짜에 강연을 할 수 있을 때
				priorityQueue.add(current.getPrice());
				index++;
			}

			// 해당 날짜에 할 수 있는 강연이 아예 없는 경우
			if (priorityQueue.isEmpty()) {
				continue;
			}

			answer += priorityQueue.poll();
		}

		return answer;

	}

}

class Lecture implements Comparable<Lecture> {
	private int price;
	private int days;

	public Lecture(int price, int days) {
		this.price = price;
		this.days = days;
	}

	@Override
	public int compareTo(Lecture o) {
		return o.days - this.days;
	}

	public int getDays() {
		return this.days;
	}

	public int getPrice() {
		return this.price;
	}
}
