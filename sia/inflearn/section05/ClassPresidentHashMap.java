package inflearn.section05;


import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 학급 회장(해쉬)
 */
public class ClassPresidentHashMap {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine(); // 버퍼 비우기
		String[] student = scanner.nextLine().split("");
		System.out.println(solution(student, n));
	}

	private static String solution(String[] student, int n) {
		Map<String, Long> voteMap = Arrays.stream(student)
			.collect(Collectors.groupingBy(vote -> vote, Collectors.counting()));

		return voteMap.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey)
			.orElseGet(() -> "");
	}
}
