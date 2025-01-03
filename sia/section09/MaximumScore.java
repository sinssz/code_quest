package section09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 최대 점수 구하기(DFS)
 */
public class MaximumScore {
	static int n;
	static int limit;
	static List<Problem> problems;
	static int maximumScore = 0;

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

	public static void DFS(int i, int totalScore, int totalTime) {
		// 종료
		if (totalTime > limit) {
			return;
		}
		if (i == n) {
			if (maximumScore < totalScore) {
				maximumScore = totalScore;
			}
		} else {
			Problem problem = problems.get(i);
			// 현재 문제 포함
			DFS(i + 1, totalScore + problem.getScore(), totalTime + problem.getTime());
			// 현재 문제 미포함
			DFS(i + 1, totalScore, totalTime);
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		limit = scanner.nextInt();

		problems = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int score = scanner.nextInt();
			int time = scanner.nextInt();

			problems.add(new Problem(score, time));
		}

		DFS(0, 0, 0);

		System.out.println(maximumScore);
	}
}
