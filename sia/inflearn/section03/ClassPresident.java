package inflearn.section03;

import java.util.Arrays;
import java.util.Scanner;

public class ClassPresident {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[][] studentClasses = new int[n][5];

		for (int i = 0; i < n; i++) {
			for (int j =0; j < 5; j++) {
				studentClasses[i][j] = scanner.nextInt();
			}
		}

		solutions(studentClasses);
	}

	private static void solutions(int[][] studentClasses) {

		int classPresident = 0;
		int max = 0;

		for (int student = 0; student < studentClasses.length; student++) {
			int friends = friendCount(studentClasses, student);
			if (max < friends) {
				max = friends;
				classPresident = student;
			}
		}
		System.out.println(classPresident + 1);

	}

	private static int friendCount(int[][] studentClasses, int index) {


		//같은 반이었던 친구인경우 1로 표시
		int[] friends = new int[studentClasses.length];

		for (int student = 0; student < studentClasses.length; student ++) {
			if (student == index) {
				continue;
			}
			for (int grade = 0; grade < 5; grade++) {
				if (studentClasses[student][grade] == studentClasses[index][grade]) {
					friends[student] = 1;
				}
			}
		}

		return (int) Arrays.stream(friends).sum();

	}
}
