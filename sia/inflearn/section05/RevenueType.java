package inflearn.section05;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 매출액의 종류
 */
public class RevenueType {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] revenue = new int[n];
		for (int i = 0; i < n; i++) {
			revenue[i] = scanner.nextInt();
		}

		for (int answer : solution(revenue, k)) {
			System.out.print(answer + " ");
		}
	}

	private static List<Integer> solution(int[] revenue, int k) {
		LinkedHashMap<Integer, Integer> revenueMap = new LinkedHashMap<>();
		List<Integer> answer = new ArrayList<>();

		for (int day = 0; day < k; day++) {
			revenueMap.put(revenue[day], revenueMap.getOrDefault(revenue[day], 0) + 1);
		}

		answer.add(revenueMap.size());

		int left = 0;
		for (int right = k; right < revenue.length; right++) {
			// 매출액 추가
			revenueMap.put(revenue[right], revenueMap.getOrDefault(revenue[right], 0) + 1);

			// 가장 오래된 매출액 제거
			revenueMap.put(revenue[left], revenueMap.get(revenue[left]) - 1);

			if (revenueMap.get(revenue[left]) < 1) {
				revenueMap.remove(revenue[left]);
			}

			// left pointer 증가 및 매출액 타입 계산
			left ++;
			answer.add(revenueMap.size());
		}

		return answer;
	}
}
