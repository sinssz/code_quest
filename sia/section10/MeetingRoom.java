package section10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeetingRoom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		List<Meeting> meetings = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			meetings.add(new Meeting(scanner.nextInt(), scanner.nextInt()));
		}

		// 종료 시간 오름차순 정렬 (종료 시간이 동일한 경우 시작시간 비교)
		meetings.sort(Meeting::compareTo); // 많은 회의를 구성하기 위해서는 종료 시간이 중요

		int answer = 0;
		Meeting current = new Meeting(0, 0);
		for (int i = 0; i < n; i++) {
			// 다음 회의가 가능한 경우
			if (current.canScheduleAfter(meetings.get(i))) {
				current = meetings.get(i);
				answer++;
			}
		}

		System.out.println(answer);
	}

}
class Meeting implements Comparable<Meeting> {
	private int start;
	private int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		int compare = this.end - o.end;
		return compare == 0 ? this.start - o.start : compare;
	}

	public boolean canScheduleAfter(Meeting next) {
		return next.start >= this.end;
	}
}