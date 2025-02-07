package inflearn.section11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 가장 높은 탑 쌓기
 */
public class Top {

	static List<Block> blocks;
	static int[] dy;
	static int n;

	private static int solution() {
		int answer = 0;
		blocks.sort(Block::compareTo); // 무게 오름차순 정렬

		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0 ; j--) {
				if (blocks.get(j).isShortWidthThan(blocks.get(i))) {
					if (dy[j] > max) {
						max = dy[j];
					}
				}
			}
			dy[i] = max + blocks.get(i).getHeight();
			answer = Math.max(dy[i] ,answer);
		}


		return answer;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n =  scanner.nextInt();
		dy = new int[n];

		blocks = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			blocks.add(new Block(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		}

		System.out.println(solution());
	}
}

class Block implements Comparable<Block> {
	private int width;
	private int height;
	private int weight;

	public Block(int width, int height, int weight) {
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	// 오름차순
	@Override
	public int compareTo(Block o) {
		return this.weight - o.weight;
	}

	public boolean isShortWidthThan(Block block) {
		return this.width < block.width;
	}

	public int getHeight() {
		return this.height;
	}
}
