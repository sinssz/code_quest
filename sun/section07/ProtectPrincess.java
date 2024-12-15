package section07;

import java.util.LinkedList;
import java.util.Queue;

// 공주 구하기
public class ProtectPrincess {

	public static void main(String[] args) {
		System.out.println(solution(8, 3));
	}

	private static int solution(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			for (int i = 1; i < k; i++) {
				queue.add(queue.poll());
			}
			queue.poll();
		}

		return queue.peek();
	}
}
