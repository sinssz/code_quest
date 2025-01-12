package section10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 씨름선수
 */
public class Ssireum {
	static int n;

	public static void solution(List<Player> players) {
		int answer = 0;

		// 키 순서대로 정렬
		players.sort(Player::compareTo);

		// 첫번째 player는 키가 가장 크므로 선출
		answer++;

		int max = players.get(0).getWeight();

		for (int i = 1; i < n; i++) {
			Player player = players.get(i);
			if (max < player.getWeight()) {
				answer++;
				max = player.getWeight();
			}
		}

		System.out.println(answer);

	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		List<Player> players = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			players.add(new Player(scanner.nextInt(), scanner.nextInt()));
		}
		solution(players);
	}
}
class Player implements Comparable<Player> {
	private int height;
	private int weight;

	public Player(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Player o) {
		return o.height - this.height;
	}

	public int getWeight() {
		return this.weight;
	}
}
