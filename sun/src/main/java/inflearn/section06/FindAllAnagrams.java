package inflearn.section06;

import java.util.HashMap;
import java.util.Map;

// 모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)
public class FindAllAnagrams {

	public static void main(String[] args) {
		String s = "bacaAacba";
		String t = "abc";

		System.out.println(solution(s, t));
	}

	private static int solution(String s, String t) {
		int result = 0;

		Map<Character, Integer> pattern = new HashMap<>();

		for (char c : t.toCharArray()) {
			pattern.put(c, pattern.getOrDefault(c, 0) + 1);
		}

		System.out.println(pattern);

		char[] chars = s.toCharArray();
		Map<Character, Integer> content = new HashMap<>();

		int length = t.length() - 1;
		for (int i = 0; i < length; i++) {
			content.put(chars[i], content.getOrDefault(chars[i], 0) + 1);
		}

		int lt = 0;
		for (int rt = length; rt < chars.length; rt++) {
			content.put(chars[rt], content.getOrDefault(chars[rt], 0) + 1);

			if (content.equals(pattern)) {
				result++;
			}

			content.put(chars[lt], content.get(chars[lt]) - 1);
			if (content.get(chars[lt]) == 0) {
				content.remove(chars[lt]);
			}

			lt++;
		}

		return result;
	}
}
