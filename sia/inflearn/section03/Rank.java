package inflearn.section03;

import java.util.Scanner;


public class Rank{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();

		int[] students = new int[size];

		for(int i=0; i<size; i++) {
			students[i] = scanner.nextInt();
		}

		for(int x: calculateRank(students))  System.out.print(x + " ");

		scanner.close();

	}


	public static int[] calculateRank(int[]students) {

		int[] studentRanks = new int[students.length];

		for(int i=0; i < students.length; i++) {
			int rank = 1;

			for(int j=0; j < students.length; j++) {
				if(students[j] > students[i]) rank++;
			}
			studentRanks[i] = rank;
		}

		return studentRanks;
	}
}