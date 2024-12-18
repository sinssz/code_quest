package section08;

import java.util.Arrays;

public class SpecialSort {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, -3, -2, 5, 6, -6};
		System.out.println(Arrays.toString(specialSort(input)));
	}

	private static int[] specialSort(int[] input) {
		int n = input.length;

		for (int i = 0; i < n - 1; i++) {
			if (input[i] < 0) {
				continue;
			}

			for (int j = i; j < n; j++) {
				if (input[j] > 0) {
					continue;
				}

				int selected = input[j];

				for (int k = j; k > i; k--) {
					input[k] = input[k - 1];
				}

				input[i] = selected;
				break;
			}
		}

		return input;
	}
}
