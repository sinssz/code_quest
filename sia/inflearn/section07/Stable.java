package inflearn.section07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 마구간 정하기
 */
public class Stable {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = scanner.nextInt();

		int[] stable = new int[n];

		for (int i = 0; i < n; i++) {
			stable[i] = scanner.nextInt();
		}

		System.out.println(solution(stable, c));

	}

	private static int solution(int[] stable, int c) {
		Arrays.sort(stable);

		int answer = 0;
		int left = 1;
		int right = stable[stable.length - 1];

		while (left <= right) {
			int mid = (right + left) / 2;
			if (count(stable, mid) >= c) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;

	}

	private static int count(int[] stable, int distance) {
		int count = 1;
		int before = stable[0]; // 첫번째 구역에 한마리 배치

		for (int i = 1; i < stable.length; i++) {
			if (stable[i] - before >= distance) {
				count++;
				before = stable[i];
			}
		}

		return count;
	}
}
