package inflearn.section03;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class GreaterThanPrevious {

	public static void main(String[] args) { // main 메서드 선언 수정
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];

		for(int i=0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}

		List<Integer> answer = findGreaterThanPrevious(numbers);

		System.out.print(numbers[0]);

		for(Integer a : answer) {
			System.out.print(" ");
			System.out.print(a);
		}

		scanner.close(); // Scanner 닫기
	}

	public static List<Integer> findGreaterThanPrevious(int[] numbers) {
		List<Integer> answer = new ArrayList<>();

		int standard = numbers[0];
		for(int i =1; i < numbers.length; i++) {
			if (numbers[i] > standard) {
				answer.add(numbers[i]);
			}
			standard = numbers[i];
		}
		return answer;
	}
}