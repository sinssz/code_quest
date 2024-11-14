import java.util.Scanner;

public class CrossCheck {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[][] grid = new int[n][n];

		for(int i =0; i < n; i++) {
			for(int j=0; j < n; j++) {
				grid[i][j] =  scanner.nextInt();
			}
		}

		System.out.print(solutions(grid, n));

	}


	public static int solutions(int[][] grid, int size) {

		int answer = Integer.MIN_VALUE;


		for(int i=0; i < size; i++) {
			int row=0;
			int column=0;

			for (int j=0; j < size; j++) {
				row += grid[i][j];
				column += grid[j][i];
			}

			answer = Math.max(answer, row);
			answer = Math.max(answer, column);
		}

		int left=0;
		int right=0;
		for(int i=0; i < size; i++) {

			left += grid[i][i];
			right += grid[i][size-1-i];

			answer = Math.max(answer, left);
			answer = Math.max(answer, right);
		}
		return answer;

	}
}