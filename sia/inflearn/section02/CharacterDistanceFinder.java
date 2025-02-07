package inflearn.section02;

import java.util.Scanner;

/**
 * 가장 짧은 문자거리
 */
public class CharacterDistanceFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] input = scanner.nextLine().toCharArray();
		char standard = input[input.length - 1];

		for (int distance : solution(input, standard)) {
			System.out.print(distance + " ");
		}
	}

	private static int[] solution(char[] input, char standard) {
		int length = input.length - 2; //검사해야할 문자열 길이
		int[] answer = new int[length];

		//왼쪽부터 검사
		int leftSeen = -1;
		for (int i = 0; i < length; i++) {
			if (input[i] == standard) {
				leftSeen = i;
			}
			answer[i] = leftSeen == -1 ? Integer.MAX_VALUE : i - leftSeen;
		}

		//오른쪽을 기준으로 다시 검사
		int rightSeen = -1;
		for (int i = length - 1; i > -1; i--) {
			if (input[i] == standard) {
				rightSeen = i;
			}
			if (rightSeen != -1) {
				answer[i] = Math.min(answer[i], rightSeen - i);
			}
		}

		return answer;
	}
}
