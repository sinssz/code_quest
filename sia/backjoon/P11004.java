package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11004 k번째 수
 */
public class P11004 {

	private static void quickSort(int[] numbers, int start, int end) {
		if (start >= end) {
			return;
		}

		int part = partition(numbers, start, end);

		if (start < part) {
			quickSort(numbers, start, part - 1);
		}
		if (part < end) {
			quickSort(numbers, part, end);
		}

	}

	private static int partition(int[] numbers, int start, int end) {

		int pivot = (end + start) / 2;
		int pivotValue = numbers[pivot];

		while (start <= end) {
			// 왼쪽 탐색
			while (numbers[start] < pivotValue) { // 큰값 찾기
				start++;
			}

			// 오른쪽 탐색
			while (pivotValue < numbers[end]) { // 작은값 찾기
				end--;
			}

			if (start <= end) {
				swap(numbers, start, end);
				start++;
				end--;
			}
		}

		return start;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	private static void solution(int[] numbers, int k) {
		quickSort(numbers, 0, numbers.length - 1);
		System.out.println(numbers[k - 1]);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		solution(numbers, k);
	}
}
