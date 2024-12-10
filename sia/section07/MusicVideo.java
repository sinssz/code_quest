package section07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 뮤직비디오(결정알고리즘)
 */
public class MusicVideo {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int[] records = new int[n];

		for (int i = 0; i < records.length; i++) {
			records[i] = scanner.nextInt();
		}

		System.out.print(solution(records, m));

	}

	private static int solution(int[] records, int m) {

		int answer = 0;
		int start = Arrays.stream(records).max().getAsInt();
		int end = Arrays.stream(records).sum();

		while (start <= end) {
			int mid = (start + end) / 2;
			int video = countVideo(records, mid);

			if (video <= m) {
				end = mid - 1;
				answer = mid;
				continue;
			}

			start = mid +1;
		}

		return answer;
	}

	private static int countVideo(int[] records, int minutes) {
		int count = 1;
		int length = 0;

		for (int record : records) {
			if (length + record > minutes) {
				count ++;
				length = record;
			} else {
				length += record;
			}
		}

		return count;
	}

}
