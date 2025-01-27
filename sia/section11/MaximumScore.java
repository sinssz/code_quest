package section11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 최대점수 구하기 (냅색 알고리즘)
 */
public class MaximumScore {

	static int[] scores;
	static int n;
	static int limit;
	static List<Problem> problems = new ArrayList<>();

	public static int solution() {

		for (Problem problem : problems) { // 각 문제 순회
			int time = problem.getTime();
			int score = problem.getScore();

			for (int i = limit; i >= time; i--) {
				scores[i] = Math.max(scores[i], scores[i - time] + score);
			}
		}

		return scores[limit];
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		limit = scanner.nextInt();
		scores = new int[limit + 1];
		for (int i = 0; i < n; i++) {
			problems.add(new Problem(scanner.nextInt(), scanner.nextInt()));
		}

		System.out.println(solution());
	}

	static class Problem {
		private int score;
		private int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}

		public int getScore() {
			return this.score;
		}

		public int getTime() {
			return this.time;
		}
	}
}
