package section06;

import java.util.Arrays;
import java.util.stream.IntStream;

// 두 배열 합치기
public class SumTwoArray {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 3, 6, 7, 9};

		System.out.println(Arrays.toString(solution(arr1, arr2)));
	}

	private static int[] solution(int[] arr1, int[] arr2) {
		return IntStream.concat(IntStream.of(arr1), IntStream.of(arr2))
			.sorted()
			.toArray();
	}
}
