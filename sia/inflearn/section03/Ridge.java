package inflearn.section03;

import java.util.Scanner;

public class Ridge {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n  = scanner.nextInt();

		//위 아래 양옆을 0으로 감싸기
		int[][] grid = new int[n+2][n+2];

		// 입력값 배열로 만들기
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}

		System.out.println(solutions(grid));
	}

	public static int solutions(int[][] grid) {
		int answer = 0;

		for (int i = 1; i <= grid.length-1; i++) {
			for (int j = 1; j <= grid.length-1; j++) {
				int center = grid[i][j];

				// 상하좌우 중 하나라도 center 이상이면 봉우리 아님
				if (grid[i-1][j] >= center) continue; // 위
				if (grid[i+1][j] >= center) continue; // 아래
				if (grid[i][j-1] >= center) continue; // 왼쪽
				if (grid[i][j+1] >= center) continue; // 오른쪽

				// 모든 조건을 통과하면 봉우리
				answer += 1;
			}
		}

		return answer;
	}


}