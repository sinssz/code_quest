package inflearn.section08;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr1 = {13, 5, 11, 7, 23, 15};
		System.out.println(Arrays.toString(bubbleSort(arr1)));

		int[] numbers = {64, 34, 25, 12, 22, 11, 90};
		System.out.println(Arrays.toString(bubbleSort(numbers)));
	}

	private static int[] bubbleSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		return array;
	}
}
