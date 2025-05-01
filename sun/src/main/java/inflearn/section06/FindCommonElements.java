package inflearn.section06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonElements {

	public static void main(String[] args) {
		int[] array1 = {1, 3, 9, 5, 2};
		int[] array2 = {3, 2, 5, 7, 8};

		System.out.println(Arrays.toString(solution(array1, array2)));
	}

	public static int[] solution(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int n = arr1.length;
		int m = arr2.length;

		int i = 0;
		int j = 0;
		List<Integer> result = new ArrayList<>();

		while (i < n && j < m) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}

		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
