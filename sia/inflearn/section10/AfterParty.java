package inflearn.section10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 결혼식
 */
public class AfterParty {

	public static int solution(List<Time> times) {
		int max = Integer.MIN_VALUE;

		int count = 0;
		for (Time time : times) {
			if (time.getState() == 'S') {
				count += 1;
			} else if (time.getState() == 'E') {
				count -=1;
			}
			max = Math.max(count, max);
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		List<Time> times = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();

			times.add(new Time(start, 'S'));
			times.add(new Time(end, 'E'));
		}

		times.sort(Time::compareTo);

		System.out.println(solution(times));

	}
}

class Time implements Comparable<Time> {
	private int hours;
	private char state;

	public Time(int hours, char state) {
		this.hours = hours;
		this.state = state;
	}

	@Override
	public int compareTo(Time o) {
		if (this.hours == o.hours) {
			return this.state - o.state;
		}
		return this.hours - o.hours;
	}

	public char getState() {
		return this.state;
	}
}
