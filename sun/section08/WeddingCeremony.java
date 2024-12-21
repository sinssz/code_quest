package section08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 결혼식
public class WeddingCeremony {

	public static void main(String[] args) {
		List<Time> times = new ArrayList<>();
		times.add(new Time(14, 18));
		times.add(new Time(12, 15));
		times.add(new Time(15, 20));
		times.add(new Time(20, 30));
		times.add(new Time(5, 14));

		System.out.println(maximumNumber(times));
	}

	private static int maximumNumber(List<Time> times) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Time time : times) {
			for (int i = time.getStart(); i < time.getEnd(); i++) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}

		int max = Integer.MIN_VALUE;
		for (Integer value : map.values()) {
			max = Math.max(max, value);
		}

		return max;
	}

	static class Time {

		private final int start;
		private final int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
	}
}
