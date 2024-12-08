package section06;

import java.util.HashMap;
import java.util.Map;

// 학급 회장(해쉬)
public class ClassPresident {

	public static void main(String[] args) {
		String ballotPaper = "BACBACCACCBDEDE";

		System.out.println(solution(ballotPaper));
	}

	private static String solution(String ballotPaper) {
		char[] papers = ballotPaper.toCharArray();

		Map<String, Integer> map = new HashMap<>();
		for (char c : papers) {
			map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
		}

		String winner = null;
		int maxVotes = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxVotes) {
				maxVotes = entry.getValue();
				winner = entry.getKey();
			}
		}

		return winner;
	}

}
