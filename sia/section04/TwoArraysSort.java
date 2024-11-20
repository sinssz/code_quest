package section04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 두 배열 합치기
 */
public class TwoArraysSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] array1 = new int[n];
		for (int i = 0; i < n; i++) {
			array1[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();
		int[] array2 = new int[m];
		for (int i = 0; i < m; i++) {
			array2[i] = scanner.nextInt();
		}

		List<Integer> answer = solution(n, array1, m, array2);
		for(int a : answer) {
			System.out.print(a + " ");
		}
	}

	private static List<Integer> solution(int n, int[] array1, int m, int[] array2) {
		List<Integer> answer = new ArrayList<>();

		int array1Pointer = 0;
		int array2Pointer = 0;

		// 각각의 포인터들은 array를 넘어갈 수 없다.
		while (array1Pointer < n && array2Pointer < m) {
			if (array1[array1Pointer] < array2[array2Pointer]) {
				answer.add(array1[array1Pointer]);
				array1Pointer++;
				continue;
			}
			answer.add(array2[array2Pointer]);
			array2Pointer++;
		}

		// 한개의 array가 모두 처리된 경우 -> 나머지 array 값들을 answer에 추가해야 한다.
		while (array1Pointer < n) {
			answer.add(array1[array1Pointer]);
			array1Pointer++;
		}

		while (array2Pointer < m) {
			answer.add(array2[array2Pointer]);
			array2Pointer++;
		}

		return answer;
	}
}
