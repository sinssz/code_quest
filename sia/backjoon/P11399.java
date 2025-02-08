package backjoon;

import java.util.Scanner;

/**
 * 11399 ATM
 */
public class P11399 {

	private static void solution(int[] waitingTime, int n) {

		for (int i = 1; i < n; i++) {
			int time = waitingTime[i];

			int j = i - 1;
			// time 값이 j 위치보다 작으면 한 칸씩 뒤로 밀어주기
			while (j >= 0 && waitingTime[j] > time) {
				waitingTime[j + 1] = waitingTime[j];
				j--;
			}

			// 적절한 위치에 time을 삽입 -> 0 이하 또는 time 값이 j 위치값보다 클때
			waitingTime[j + 1] = time;
		}

		int total = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += waitingTime[i];
			total += sum;
		}

		System.out.println(total);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] times = new int[n];
		for (int i = 0; i < n; i++) {
			times[i] = scanner.nextInt();
		}

		solution(times, n);

	}
}
