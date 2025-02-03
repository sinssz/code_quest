package inflearn.section08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 장난꾸러기 현수
public class NaughtyHyeonsu {

	public static void main(String[] args) {
		int[] heights = {120, 125, 152, 130, 135, 135, 143, 127, 160};
		printClassNumber(heights);

		int[] heights2 = {120, 130, 150, 150, 130, 150};
		printClassNumber(heights2);
	}

	private static void printClassNumber(int[] heights) {
		int[] sortedHeights = heights.clone();
		Arrays.sort(sortedHeights);

		List<Integer> result = new ArrayList<>();
		for (int i = 0, n = sortedHeights.length; i < n; i++) {
			if (heights[i] != sortedHeights[i]) {
				result.add(i + 1);
			}
		}

		System.out.println(result);
	}
}
