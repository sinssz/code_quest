package section06;

import java.util.Arrays;

// 두 배열 합치기
public class SumTwoArray {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 3, 6, 7, 9};

		System.out.println(Arrays.toString(solution(arr1, arr2)));
	}

	// private static int[] solution(int[] arr1, int[] arr2) {
	// 	return IntStream.concat(IntStream.of(arr1), IntStream.of(arr2))
	// 		.sorted()
	// 		.toArray();
	// }

	// 투 포인터 적용
	public static int[] solution(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] result = new int[n + m];

		int i = 0, j = 0, k = 0;

		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) {
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}

		while (i < n) {
			result[k++] = arr1[i++];
		}

		while (j < m) {
			result[k++] = arr2[j++];
		}

		return result;
	}
}
