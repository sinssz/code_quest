package inflearn.section03;

import java.util.Arrays;
import java.util.Scanner;

public class MentorMentee {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int student = scanner.nextInt();
		int test = scanner.nextInt();

		int[][] rank = new int[test][student];
		for (int i = 0; i < test; i++) {
			for (int j = 0; j < student; j++) {
				rank[i][j] = scanner.nextInt();
			}
		}
		System.out.println(solutions(student, test, rank));

	}

	public static int solutions(int student, int test, int[][] rank) {

		int[][] mentorMentee = new int[student][student];

		for (int m = 0; m < test; m++) {
			for (int k = 0; k < student; k++) {
				for (int l=k; l < student; l++) {
					//k index 보다 뒤에있는 사람들은 모두 멘티가 될 수 없음
					int mentor = rank[m][l]-1;
					int mentee = rank[m][k]-1;
					mentorMentee[mentor][mentee] =1;
				}
			}
		}

		return (int) Arrays.stream(mentorMentee)
			.flatMapToInt(Arrays::stream)
			.filter(c -> c == 0) // 0인 값만 세기
			.count();
	}

}