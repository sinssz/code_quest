package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 11003 최솟값 찾기
 */
public class P11003 {
	static Deque<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(tokenizer.nextToken());
		int window = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(br.readLine(), " ");
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(tokenizer.nextToken());
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) {
			// 윈도우 범위를 벗어난 값 제거
			if (!queue.isEmpty() && queue.getFirst() <= i - window) {
				queue.removeFirst();
			}

			// 현재 값보다 큰 값들을 제거 (우리가 찾을 것은 최소값이기 때문)
			while (!queue.isEmpty() && numbers[queue.getLast()] >= numbers[i]) {
				queue.removeLast();
			}

			// 현재 값의 인덱스를 큐에 추가
			queue.addLast(i);

			// 현재 위치에서 최소값 추가
			answer.append(numbers[queue.getFirst()]).append(" ");
		}

		System.out.println(answer);
	}
}
