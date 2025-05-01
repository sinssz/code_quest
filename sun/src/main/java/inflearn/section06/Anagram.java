package inflearn.section06;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {
		String input1 = "AbaAeCe";
		String input2 = "baeeACA";

		System.out.println(solution(input1, input2));

		String input3 = "abaCC";
		String input4 = "Caaab";

		System.out.println(solution(input3, input4));
	}

	private static String solution(String input1, String input2) {
		char[] chars1 = input1.toCharArray();
		char[] chars2 = input2.toCharArray();

		Map<Character, Integer> map1 = new HashMap<>();

		for (char c : chars1) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		// Map<Character, Integer> map2 = new HashMap<>();
		// for (char c : chars2) {
		// 	map2.put(c, map2.getOrDefault(c, 0) + 1);
		// }
		//
		// return map1.equals(map2) ? "YES" : "NO";

		for (char c : chars2) {
			if (!map1.containsKey(c) || map1.get(c) == 0) {
				return "NO";
			}

			map1.put(c, map1.get(c) - 1);
		}

		return "YES";
	}
}
