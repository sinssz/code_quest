package inflearn.section08;

import java.util.Arrays;

// 선택 정렬
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr1 = {13, 5, 11, 7, 23, 15};
		System.out.println(Arrays.toString(selectionSort(arr1)));

		int[] arr2 = {64, 25, 12, 22, 11};
		System.out.println(Arrays.toString(selectionSort(arr2)));
	}

	private static int[] selectionSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		return array;
	}
}
