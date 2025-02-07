package inflearn.section04;

import java.util.Scanner;

public class SequentialSumFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;

		int end = n - 1; // 자기자신은 제외
		int sum = 0;

		for (int i = end; i > 0; i--) {
			sum += i;

			while (sum > n) {
				sum -= end--;
			}

			if (sum == n) {
				answer++;
			}
		}
		return answer;
	}
}
