package inflearn.section06;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * 공주 구하기
 */
public class Josephus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		LinkedList<Integer> princeQueue = new LinkedList<>();

		for (int i = 1; i < n + 1; i++) {
			princeQueue.offer(i);
		}

		while (princeQueue.size() > 1) {
			// 1부터 k-1까지는 다시 뒤로
			for (int i = 1; i < k; i ++) {
				princeQueue.offer(princeQueue.pop());
			}
			// k번째 왕자 제거
			princeQueue.pop();
		}

		return princeQueue.pop();
	}
}
