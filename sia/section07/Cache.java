package section07;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * LRU (캐시, 카카오 변형)
 */
public class Cache {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		int n = scanner.nextInt();

		int[] works = new int[n];

		for (int i = 0; i < n; i++) {
			works[i] = scanner.nextInt();
		}

		LinkedList<Integer> answer = solution(works, s);
		for (int i = s-1; i >= 0; i--) {
			System.out.print(answer.get(i) + " ");
		}

	}

	private static LinkedList<Integer> solution(int[] works, int s) {
		LinkedList<Integer> cache = new LinkedList<>();

		int i = 0;
		// 일단 작업 큐를 가득 채운다.
		while (cache.size() < s) {
			if (cache.contains(works[i])) {
				cache.remove((Integer) works[i]);
			}
			cache.add(works[i]);
			i++;
		}

		for (; i < works.length; i++) {
			if (cache.contains(works[i])) {
				cache.remove((Integer) works[i]);
				cache.add(works[i]);
				continue;
			}
			cache.pop();
			cache.add(works[i]);
		}
		return cache;
	}
}
