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
			int index = 0;
			for (int i = 0; i < cacheSize; i++) {
				if (cache[i] == work) {
					index = i;
					break;
				}
			}

			// index = 0 => Cache Miss | index != 0 => Cache Hit
			if (index == 0) {
				for (int i = cacheSize - 1; i > 0; i--) {
					cache[i] = cache[i - 1];
				}
			} else {
				for (int i = index; i > 0; i--) {
					cache[i] = cache[i - 1];
				}
			}

			cache[0] = work;

			System.out.println(Arrays.toString(cache));
		}
	}
}
