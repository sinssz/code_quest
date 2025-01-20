package section11;

import java.util.Scanner;

/**
 * 계단오르기
 */
public class Stairs {

	static int n;
	static int answer;

	private static void step(int steps) {
		if (steps > n) {
			return;
		}
		if (steps == n) {
			answer += 1;
			return;
		}

		// 경우의 수 2개
		step(steps + 1);
		step(steps + 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		step(0);
		System.out.println(answer);
	}
}
