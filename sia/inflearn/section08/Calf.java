package inflearn.section08;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Calf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		int e = scanner.nextInt();

		System.out.println(solution(s, e));
	}

	private static int solution(int s, int e) {
		// 방문한 노드
		Set<Integer> checked = new HashSet<>();

		// 점프 경우의 수
		int[] jumps = {1, -1, 5};

		// 검색이 필요한 노드
		LinkedList<Integer> tail = new LinkedList<>();
		int answer = 0;

		if (s != e) {
			tail.offer(s);
			checked.add(s);
		}

		while (!tail.isEmpty()) {
			answer++;
			int size = tail.size();

			for (int i = 0; i < size; i++) {
				int head = tail.pop();

				for (int step : jumps) {
					if (head + step == e) {
						return answer;
					}

					if (checked.contains(head + step)) {
						continue;
					}
					checked.add(head + step);
					tail.offer(head + step);
				}
			}
		}

		return answer;
	}

}
