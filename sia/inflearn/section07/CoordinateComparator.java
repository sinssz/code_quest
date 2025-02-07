package inflearn.section07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 좌표 정렬
 */
public class CoordinateComparator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[][] coordinate =  new int[n][2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				coordinate[i][j] = scanner.nextInt();
			}
		}

		solution(coordinate);

		for (int i = 0; i < coordinate.length; i++) {
			System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
		}
	}

	public static void solution(int[][] coordinates) {
		Arrays.sort(coordinates, Comparator
			.comparingInt((int[] point) -> point[0])   // 첫 번째 열 기준
			.thenComparingInt(point -> point[1]));
	}
}
