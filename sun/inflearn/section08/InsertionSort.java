package inflearn.section08;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input = {11, 7, 5, 6, 10, 9};
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	private static int[] insertionSort(int[] input) {
		int n = input.length;

		for (int i = 1; i < n; i++) {
			int key = input[i];
			int j = i - 1;

			while (j >= 0 && input[j] > key) {
				input[j + 1] = input[j];
				j--;
			}

			input[j + 1] = key;
		}

		return input;
	}

}
