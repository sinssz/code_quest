package section11;

import java.util.Scanner;

/**
 * 돌다리 건너기
 */
public class SteppingStones {
	static int n;
	static int answer;

	private static void step(int stones) {
		if (stones > n+1) {
			return;
		}

		if (stones == n+1) {
			answer++;
		}

		step(stones + 1);
		step(stones + 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		step(0);
		System.out.println(answer);
	}
}
