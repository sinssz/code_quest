package section08;

import java.util.Arrays;

public class LeastRecentlyUsed {

	public static void main(String[] args) {
		int cacheSize = 5;
		int[] works = {1, 2, 3, 2, 6, 2, 3, 5, 7};

		leastRecentlyUsed(cacheSize, works);
	}

	private static void leastRecentlyUsed(int cacheSize, int[] works) {
		int[] cache = new int[cacheSize];

		for (int work : works) {
			int hitIndex = -1;

			// 1. Cache Hit 여부 확인
			for (int i = 0; i < cacheSize; i++) {
				if (cache[i] == work) {
					hitIndex = i;
					break;
				}
			}

			// 2. Cache 갱신 처리
			if (hitIndex == -1) { // Cache Miss
				for (int i = cacheSize - 1; i > 0; i--) {
					cache[i] = cache[i - 1];
				}
			} else { // Cache Hit
				for (int i = hitIndex; i > 0; i--) {
					cache[i] = cache[i - 1];
				}
			}

			cache[0] = work;

			System.out.println(Arrays.toString(cache));
		}
	}
}
