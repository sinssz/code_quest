package inflearn.section05;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * 모든 아나그램 찾기
 */
public class AnagramSubarray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char[] s = scanner.nextLine().toCharArray();
		char[] t = scanner.nextLine().toCharArray();

		System.out.println(solution(s, t));

	}

	private static int solution(char[] s, char[] t) {
		int answer = 0;
		Map<Character, Integer> targetMap = new HashMap<>();
		Map<Character, Integer> windowMap = new HashMap<>();

		for (char c : t) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		for (int index = 0; index < t.length -1; index++) {
			windowMap.put(s[index], windowMap.getOrDefault(s[index], 0) + 1);
		}

		int left = 0;
		for (int right = t.length - 1; right < s.length; right++) {
			// 글자 추가
			windowMap.put(s[right], windowMap.getOrDefault(s[right], 0) + 1);

			//아나그램 여부 확인
			if (targetMap.equals(windowMap)) {
				answer++;
			}

			//맨 앞글자 제거 또는 감소
			windowMap.put(s[left], windowMap.get(s[left]) - 1);
			if (windowMap.get(s[left]) == 0) {
				windowMap.remove(s[left]);
			}
			left++;

		}

		return answer;

	}

}
